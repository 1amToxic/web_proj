package com.example.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
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
import com.example.service.doanhthu.DoanhthuService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/doanhthu")
public class DoanhthuController {
	@Autowired
	private DoanhthuService doanhthuService;
	@GetMapping(produces = "application/json")
	public HashMap<String, Object> getDoanhthu(){
		HashMap<String, Object> mapDoanhThu = new HashMap<>();
		mapDoanhThu.put("value", doanhthuService.getDoanhThu());
		return mapDoanhThu;
	}
}
