package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Khamchua;
import com.example.service.khamchua.KhamchuaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/khamchuas")
public class KhamchuaController {
	@Autowired
	private KhamchuaService khamchuaService;
	@PostMapping(produces = "application/json")
	public ResponseEntity<?> addKhamchua(@RequestBody Khamchua khamchua){
		Khamchua _khamchua = this.khamchuaService.addKhamchua(khamchua);
		if(_khamchua!=null) {
			return new ResponseEntity<>(_khamchua,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
		}
	}
}
