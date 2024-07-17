package com.example.load_apis.repository;

import com.example.load_apis.model.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoadRepository extends JpaRepository<Load,Integer> {

    List<Load> findByShipperId(String shipperId);

}
