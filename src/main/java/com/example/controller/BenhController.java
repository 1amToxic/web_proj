package com.example.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Bacsy;
import com.example.model.BenhCountModel;
import com.example.service.benh.BenhService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/benhs")
public class BenhController {
	@Autowired
	private BenhService benhService;
	
	@GetMapping(value = "/count",produces = "application/json")
	public ResponseEntity<?> getBenhCount(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<BenhCountModel> listBenhCount;
		try {
			listBenhCount = this.benhService.getBenhCount(sdf.parse("2019-07-01"));
			if(listBenhCount != null) {
				return new ResponseEntity<>(listBenhCount,HttpStatus.OK);
			}else {
				return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
	} 
}
