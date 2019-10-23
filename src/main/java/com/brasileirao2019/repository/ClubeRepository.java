package com.brasileirao2019.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.brasileirao2019.models.Clube;

public interface ClubeRepository extends JpaRepository<Clube, String>{
	Clube findById(long id);
	Clube findByPosicao(Integer posicao);
	
	@Transactional(readOnly = false)
	@Modifying
	@Query("update Clube c set c.posicao = :posi where c.id = :id")
	int updateClubePosicao(@Param("posi") Integer posi, @Param("id") Long id);
}
