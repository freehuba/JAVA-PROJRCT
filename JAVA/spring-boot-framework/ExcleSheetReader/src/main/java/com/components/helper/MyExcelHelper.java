package com.components.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.components.model.User;

public class MyExcelHelper 
{
	//check that file is excel file or not
	public static boolean checkExcelFormat(MultipartFile file)
	{
		String contentType = file.getContentType();
		
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	//converts excel data to list of users
	public static List<User> convertExcelToListOfUser(InputStream is)
	{
		List<User> list = new ArrayList<>();
		
		try 
		{
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			
			XSSFSheet sheet = workbook.getSheet("data");
			
			int rowNumber=0;
			
			Iterator<Row> iterator = sheet.iterator();
			
			while(iterator.hasNext())
			{
				Row row = iterator.next();
				
				if(rowNumber==0)
				{
					rowNumber++;
					continue;
				}
				
				Iterator<Cell> cells = row.iterator();
				
				int cid=0;
				User user = new User();
				
				while(cells.hasNext())
				{
					Cell cell = cells.next();
					
					switch(cid)
					{
						case 0 : user.setA(cell.getStringCellValue());
							break;
							
						case 1 : user.setB(cell.getStringCellValue());
							break;	
						case 2 : user.setC(cell.getStringCellValue());
							break;
							
						case 3 : user.setD(cell.getStringCellValue());
							break;	
						case 4 : user.setE(cell.getStringCellValue());
							break;
							
						case 5 : user.setF(cell.getStringCellValue());
							break;	
						case 6 : user.setG(cell.getStringCellValue());
							break;
							
						case 7 : user.setH(cell.getStringCellValue());
							break;	
						case 8 : user.setI(cell.getStringCellValue());
							break;
							
						case 9 : user.setJ(cell.getStringCellValue());
							break;	
						case 10 : user.setK(cell.getStringCellValue());
							break;
							
						case 11 : user.setL(cell.getStringCellValue());
							break;	
						case 12 : user.setM(cell.getStringCellValue());
							break;
							
						case 13 : user.setN(cell.getStringCellValue());
							break;	
						default :
							break;
					}
					
					cid++;
				}
				
				list.add(user);
				
			}
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return list;
	}
}
