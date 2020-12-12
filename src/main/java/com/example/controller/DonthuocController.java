package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Donthuoc;
import com.example.model.Khamchua;
import com.example.service.donthuoc.DonthuocService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/donthuocs")
public class DonthuocController {
	@Autowired
	private DonthuocService donthuocService;
	@PostMapping(produces = "application/json")
	public ResponseEntity<?> addKhamchua(@RequestBody Donthuoc donthuoc){
		Donthuoc _donthuoc = this.donthuocService.addDonthuoc(donthuoc);
		if(_donthuoc!=null) {
			return new ResponseEntity<>(_donthuoc,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
}
