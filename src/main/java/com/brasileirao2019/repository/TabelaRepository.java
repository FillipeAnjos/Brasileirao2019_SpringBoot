package com.brasileirao2019.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.brasileirao2019.models.Tabela;

public interface TabelaRepository extends JpaRepository<Tabela, String>{
	Tabela findById(long id);
	Tabela findByPosicao(Integer posicao);
	
	@Transactional(readOnly = false)
	@Modifying
	@Query("update Tabela t set t.posicao = :posi where t.id = :id")
	int updateTabelaPosicao(@Param("posi") Integer posi, @Param("id") Long id);
}
