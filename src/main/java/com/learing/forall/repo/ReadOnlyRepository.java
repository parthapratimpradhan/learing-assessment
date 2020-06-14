package com.learing.forall.repo;


import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * Interface for declaring Read-Only Query Repositories.
 *
 * Created by maryellenbowman
 */
@NoRepositoryBean
public interface ReadOnlyRepository<T, ID extends Serializable> extends Repository<T,ID > {


    Optional<T> findById(ID id);

    Iterable<T> findAll();

    Iterable<T> findAllById(Iterable<ID> iterable);

    Iterable<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);

    long count();

    boolean existsById(ID id);
}