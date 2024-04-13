package com.components.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.components.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>
{

}
