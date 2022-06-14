package com.project.sobsuza.repository;

import com.project.sobsuza.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
}
