package com.learing.forall.repo;

import org.springframework.data.repository.CrudRepository;

import com.learing.forall.domain.Student;

/**
 * DataSource Management for the Students at the University.
 *
 * Created by partha pratim pradhan
 */
public interface StudentRepository extends CrudRepository<Student, Integer>{

}
