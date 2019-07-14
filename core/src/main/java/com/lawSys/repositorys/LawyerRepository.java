package com.lawSys.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lawSys.model.Lawyer;
import com.lawSys.model.Lotno;

public interface LawyerRepository extends JpaRepository<Lawyer, Integer> {

}
