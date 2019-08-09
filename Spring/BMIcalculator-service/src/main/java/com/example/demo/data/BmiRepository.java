package com.example.demo.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.BmiEntity;


public interface BmiRepository extends JpaRepository<BmiEntity, Integer>{

	List<BmiEntity> findByEmail(String email);



}
