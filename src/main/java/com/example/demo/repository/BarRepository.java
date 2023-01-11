package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Bar;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "bar", path = "bar")
public interface BarRepository extends PagingAndSortingRepository<Bar, Long>, CrudRepository<Bar, Long> {
    List<Bar> findByName(@Param("name") String name);
}
