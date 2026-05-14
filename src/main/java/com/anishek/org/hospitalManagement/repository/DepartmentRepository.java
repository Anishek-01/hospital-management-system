package com.anishek.org.hospitalManagement.repository;

import com.anishek.org.hospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}