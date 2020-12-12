package com.example.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.example.model.Luong;
import com.example.model.Yta;
import com.example.repository.YtaRepository;
import com.example.service.yta.YtaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ytas")
public class YtaController {
	@Autowired
	private YtaService ytaService;
	@GetMapping(produces = "application/json")
	public ResponseEntity<?> getAllYta(){
		List<Yta> _listyta = this.ytaService.getAllYta();
		if(_listyta != null) {
			return new ResponseEntity<>(_listyta,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
	@PostMapping(produces = "application/json")
	public ResponseEntity<?> addyta(@RequestBody Yta yta){
		Yta _yta = this.ytaService.addYta(yta);
		if(_yta != null) {
			return new ResponseEntity<>(_yta,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
	@PutMapping(produces = "application/json")
	public ResponseEntity<?> updateyta(@RequestBody Yta yta){
		Yta _yta = this.ytaService.updateYta(yta);
		if(_yta != null) {
			return new ResponseEntity<>(_yta,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteyta(@PathVariable int id){
		boolean isDeletedSuccess = this.ytaService.deleteYta(id);
		if(isDeletedSuccess == true) {
			return new ResponseEntity<>("delete successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
	@GetMapping(value = "/salary",produces = "application/json")
	public ResponseEntity<?> tinhLuongYta(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			List<Luong> listLuong = ytaService.tinhLuongYta(sdf.parse("2020-07-01"));
			if(listLuong != null) {
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
		List<Yta> listSearch = this.ytaService.findYtaByName(ten);
		if(listSearch!=null) {
			return new ResponseEntity<>(listSearch,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
	@GetMapping(value = "/{id}",produces = "application/json")
	public ResponseEntity<?> findById(@PathVariable int id){
		Yta _yta = this.ytaService.findYtaById(id);
		if(_yta!=null) {
			return new ResponseEntity<>(_yta,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
}
