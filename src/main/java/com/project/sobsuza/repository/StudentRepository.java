package com.project.sobsuza.repository;

import com.project.sobsuza.model.Student;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
}
