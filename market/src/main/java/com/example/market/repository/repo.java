package com.example.market.repository;
import com.example.market.entity.entity;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo extends JpaRepository<entity, Integer> {

    // Additional methods if needed
}
