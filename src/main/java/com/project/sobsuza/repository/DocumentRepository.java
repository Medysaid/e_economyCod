package com.project.sobsuza.repository;

import com.project.sobsuza.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository <Document,Integer>{

}
