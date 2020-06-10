package com.learing.forall.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.learing.forall.domain.Staff;

/**
 * DataSource Management for the Staff at the University.
 *
 * Created by maryellenbowman
 */
public interface StaffRepository extends PagingAndSortingRepository<Staff,Integer> {
}
