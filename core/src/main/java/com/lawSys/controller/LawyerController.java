package com.lawSys.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawSys.model.Lawyer;
import com.lawSys.model.Lotno;
import com.lawSys.repositorys.LawyerRepository;
import com.lawSys.repositorys.LotnoRepository;

@RestController
@RequestMapping(value = "/api/lawyer")
public class LawyerController {

	
	@Autowired
	LawyerRepository lawyerRepository;
	
	@GetMapping(value = "/list")
	public List<Lawyer> getAll(){
		return lawyerRepository.findAll(new Sort(Sort.Direction.DESC, "lawyerid"));
	}
	@PostMapping(value = "/save")
	public Lawyer saveData(@RequestBody Lawyer objdata) {
		//System.out.println(objdata.getVlotno());
		//System.out.println("testing1 save");
		try {
			lawyerRepository.save(objdata);
		}catch(DataIntegrityViolationException err) {
			System.out.println("Duplicate");
			objdata.setLawyerid(0);
		}
		return objdata;
	}
	
	@PutMapping(value = "/update")
	public Lawyer updateData(@RequestBody Lawyer objdata) {
		//System.out.println(objdata.getVlotno());
		//System.out.println("testing1 save");
		try {
			lawyerRepository.save(objdata);
		}catch(DataIntegrityViolationException err) {
			System.out.println("Duplicate");
			objdata.setLawyerid(0);
		}
		return objdata;
	}
	
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteData(@PathVariable int id){
		//System.out.println(id);
		lawyerRepository.deleteById(id);
	}
	
	
	
	
}
