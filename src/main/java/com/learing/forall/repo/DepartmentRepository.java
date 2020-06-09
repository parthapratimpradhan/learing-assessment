package com.learing.forall.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learing.forall.domain.Department;

/**
 * DataSource Management for the Departments at the University.
 *
 * Created by partha pratim pradhan
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
