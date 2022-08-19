package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ExameEntity;

@Repository
public interface ExameRepository extends JpaRepository<ExameEntity, Integer> {

}
