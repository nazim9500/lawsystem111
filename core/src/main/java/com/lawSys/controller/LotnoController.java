package com.lawSys.controller;

import java.util.Calendar;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawSys.Utility;
import com.lawSys.model.Lotno;
import com.lawSys.repositorys.LotnoRepository;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

@RestController
@RequestMapping(value = "/api/lotno")
public class LotnoController {

	@Autowired
	LotnoRepository lotnoRepository;
	
	@GetMapping(value = "/list")
	public List<Lotno> getAll(){
		return lotnoRepository.findAll(new Sort(Sort.Direction.DESC, "lotnoid"));
	}

	@PostMapping(value = "/save")
	public Lotno saveData(@RequestBody Lotno objdata) {
		//System.out.println(objdata.getVlotno());
		//System.out.println("testing1 save");
		objdata.setLdate(Calendar.getInstance().getTime());
		try {
			lotnoRepository.save(objdata);
		}catch(DataIntegrityViolationException err) {
			System.out.println("Duplicate");
			objdata.setLotnoid(0);
		}
		return objdata;
	}
	
	@PutMapping(value = "/update")
	public Lotno updateData(@RequestBody Lotno objdata) {
		//System.out.println(objdata.getVlotno());
		//System.out.println("testing2 update");
		objdata.setLdate(Calendar.getInstance().getTime());
		try {
			lotnoRepository.save(objdata);
		}catch(DataIntegrityViolationException err) {
			System.out.println("Duplicate");
			objdata.setLotnoid(0);
		}
		return objdata;
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteData(@PathVariable int id){
		//System.out.println(id);
		lotnoRepository.deleteById(id);
	}
	/*
	@GetMapping(value="/find/{findvalue}")
	public List<Lotno> findByLastName(@PathVariable String findvalue) {
		List<Lotno> customers = lotnoRepository.findByVlotnoStartingWith(findvalue);
		return customers;
	}*/
	
	@GetMapping(value="/find/{findvalue}")
	public List<Lotno> findBylotnoid(@PathVariable int findvalue) {
		List<Lotno> data = lotnoRepository.findBylotnoid(findvalue);
		return data;
	}
}
