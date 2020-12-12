package com.example.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Thuoc;
import com.example.service.thuoc.ThuocService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/thuocs")
public class ThuocController {
	@Autowired
	private ThuocService thuocService;
	@PostMapping(produces = "application/json")
	public ResponseEntity<?> addThuoc(@RequestBody Thuoc thuoc){
		Thuoc _thuoc = this.thuocService.addThuoc(thuoc);
		if(_thuoc != null) {
			return new ResponseEntity<>(_thuoc,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
	@PutMapping(produces = "application/json")
	public ResponseEntity<?> updateThuoc(@RequestBody Thuoc thuoc){
		Thuoc _thuoc = this.thuocService.updateThuoc(thuoc);
		if(_thuoc != null) {
			return new ResponseEntity<>(_thuoc,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteThuoc(@PathVariable int id){
		boolean isDeletedSuccess = this.thuocService.deleteThuoc(id);
		if(isDeletedSuccess == true) {
			return new ResponseEntity<>("delete successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}

	@GetMapping(produces = "application/json")
	public ResponseEntity<?> getAllThuoc(){
		List<Thuoc> listThuoc = this.thuocService.getAllThuoc();
		if(listThuoc != null) {
			return new ResponseEntity<>(listThuoc,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
}
