package com.project.sobsuza.repository;


import com.project.sobsuza.model.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupervisorRepository extends JpaRepository <Supervisor,Integer>{
}
