package com.lawSys.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lawSys.model.Lotno;

import java.lang.String;

public interface LotnoRepository extends JpaRepository<Lotno, Integer> {
	List<Lotno> findByVlotno(String vlotno);
	List<Lotno> findByVlotnoStartingWith(String vlotno);
	List<Lotno> findBylotnoid(int lotnoid);
}
