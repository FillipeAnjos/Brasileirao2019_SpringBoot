package com.brasileirao2019.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brasileirao2019.models.Clube;

public interface ClubeRepository extends JpaRepository<Clube, String>{
	
	Clube findById(long id);

	@Query("select c from Clube c")
	Collection<Clube> burcarClube();
	
}
