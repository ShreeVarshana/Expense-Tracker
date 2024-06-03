package com.example.market.service;

import com.example.market.entity.entity;
import com.example.market.repository.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class service {

    @Autowired
    private repo repository;

    // Method to retrieve all entities
    public List<entity> getAll() {
        return (List<entity>) repository.findAll();
    }

    // Method to calculate total amount from entiti

    // Method to delete an entity by ID
    public void deleteById(String id) {
        Optional<entity> entityOptional = repository.findById(Integer.valueOf(id));
        if (entityOptional.isPresent()) {
            repository.delete(entityOptional.get());
        } else {
            throw new EntityNotFoundException("Entity not found with ID: " + id);
        }
    }

    // Method to retrieve an entity by ID
    public entity get(Integer id) {
        Optional<entity> result = repository.findById(id);
        return result.orElse(null); // Return null if entity is not found
    }

    // Method to save an entity
    public void save(entity entity) {
        repository.save(entity);
    }

    // Method to delete an entity by ID
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
