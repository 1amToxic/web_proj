package com.example.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.logging.Log;
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
import com.example.model.Luong;
import com.example.model.Thuoc;
import com.example.service.bacsy.BacsyService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bacsys")
public class BacsyController {
	@Autowired
	private BacsyService bacsyService;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<?> getAllBacsy(){
		List<Bacsy> _listBacsy = this.bacsyService.getAllBacsy();
		if(_listBacsy != null) {
			return new ResponseEntity<>(_listBacsy,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
	@PostMapping(produces = "application/json")
	public ResponseEntity<?> addBacsy(@RequestBody Bacsy bacsy){
		Bacsy _bacsy = this.bacsyService.addBacsy(bacsy);
		if(_bacsy != null) {
			return new ResponseEntity<>(_bacsy,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
	@PutMapping(produces = "application/json")
	public ResponseEntity<?> updateBacsy(@RequestBody Bacsy bacsy){
		Bacsy _bacsy = this.bacsyService.updateBacsy(bacsy);
		if(_bacsy != null) {
			return new ResponseEntity<>(_bacsy,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteBacsy(@PathVariable int id){
		boolean isDeletedSuccess = this.bacsyService.deleteBacsy(id);
		if(isDeletedSuccess == true) {
			return new ResponseEntity<>("delete successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
	@GetMapping(value = "/salary",produces = "application/json")
	public ResponseEntity<?> tinhLuongBacsy(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			List<Luong> listLuong = bacsyService.tinhLuongBacsy(sdf.parse("2020-07-01"));
			if(listLuong != null) {
				System.out.print(listLuong.get(0).toString());
				return new ResponseEntity<>(listLuong,HttpStatus.OK);
			}else {
				return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
	}
	@GetMapping(value = "/search",produces = "application/json")
	public ResponseEntity<?> searchByName(@RequestParam String ten){
		List<Bacsy> listSearch = this.bacsyService.findBacsyByName(ten);
		if(listSearch!=null) {
			return new ResponseEntity<>(listSearch,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
	@GetMapping(value = "/{id}",produces = "application/json")
	public ResponseEntity<?> findById(@PathVariable int id){
		Bacsy _bacsy = this.bacsyService.findBacsyById(id);
		if(_bacsy!=null) {
			return new ResponseEntity<>(_bacsy,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
}
