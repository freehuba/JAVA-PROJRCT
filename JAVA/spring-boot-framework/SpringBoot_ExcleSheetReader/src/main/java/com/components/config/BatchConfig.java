package com.components.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.components.model.User;

@SuppressWarnings({ "removal" })
@Configuration
@ComponentScan(basePackages = "com.components")
@EnableBatchProcessing
public class BatchConfig 
{
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public FlatFileItemReader<User> reader()
	{
		FlatFileItemReader<User> reader = new FlatFileItemReader<User>();
		reader.setResource(new ClassPathResource("people-100000.csv"));
		reader.setLineMapper(getLineMapper());
		reader.setLinesToSkip(1);
		
		return reader;
	}

	
	public LineMapper<User> getLineMapper() 
	{
		DefaultLineMapper<User> lineMapper = new DefaultLineMapper<>();
		
		
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] {"Index","User Id","First Name","Sex"});
		lineTokenizer.setIncludedFields(new int[] {0 , 1, 2, 4});
		
		BeanWrapperFieldSetMapper<User> fieldSetter = new BeanWrapperFieldSetMapper<>();
		fieldSetter.setTargetType(User.class);
		
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetter);
				
		return lineMapper;
	}
	
	@Bean
	public UserItemProcesser processor()
	{
		return new UserItemProcesser();
	}
	
	@Bean
	public JdbcBatchItemWriter<User> writer()
	{
		JdbcBatchItemWriter<User> writer = new JdbcBatchItemWriter<>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		writer.setSql("INSERT INTO excelsheet_db.user (index, userid, firstname, sex) VALUES (:Index, :UserId, :FirstName, :Sex)");
		writer.setDataSource(this.dataSource);
		
		return writer;
	}
	
	@Bean
	public Job importUserJob()
	{
		return this.jobBuilderFactory.get("USER-IMPOET-JOB")
				.incrementer(new RunIdIncrementer())
				.flow(step1())
				.end()
				.build();
	}

	@SuppressWarnings({ "deprecation" })
	@Bean
	public Step step1() 
	{
		return this.stepBuilderFactory.get("step")
				.<User,User>chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
				
	}
	
	
	
	
}
