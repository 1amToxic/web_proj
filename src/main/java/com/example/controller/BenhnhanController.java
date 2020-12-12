package com.example.controller;

import java.util.List;

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

import com.example.model.Bacsy;
import com.example.model.Benhnhan;
import com.example.service.bacsy.BacsyService;
import com.example.service.benhnhan.BenhnhanService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/benhnhans")
public class BenhnhanController {
	@Autowired
	private BenhnhanService benhnhanService;
	@GetMapping(produces = "application/json")
	public ResponseEntity<?> getAllBacsy(){
		List<Benhnhan> _listBenhnhan = this.benhnhanService.getAllBenhnhan();
		if(_listBenhnhan != null) {
			return new ResponseEntity<>(_listBenhnhan,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
	@PostMapping(produces = "application/json")
	public ResponseEntity<?> addBenhnhan(@RequestBody Benhnhan benhnhan){
		Benhnhan _benhnhan = this.benhnhanService.addBenhnhan(benhnhan);
		if(_benhnhan != null) {
			return new ResponseEntity<>(_benhnhan,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
	@PutMapping(produces = "application/json")
	public ResponseEntity<?> updateBenhnhan(@RequestBody Benhnhan benhnhan){
		Benhnhan _benhnhan = this.benhnhanService.updateBenhnhan(benhnhan);
		if(_benhnhan != null) {
			return new ResponseEntity<>(_benhnhan,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteBenhnhan(@PathVariable int id){
		boolean isDeletedSuccess = this.benhnhanService.deleteBenhnhan(id);
		if(isDeletedSuccess == true) {
			return new ResponseEntity<>("delete successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
}
