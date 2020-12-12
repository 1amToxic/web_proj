package com.example.service.chitietdonthuoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Chitietdonthuoc;
import com.example.repository.ChitietdonthuocRepository;

@Service
public class ChitietdonthuocServiceImpl implements ChitietdonthuocService{
	@Autowired
	private ChitietdonthuocRepository chitietRepo;
	@Override
	public Chitietdonthuoc addChitietdonthuoc(Chitietdonthuoc chitietdonthuoc) {
		Chitietdonthuoc _chitiet = this.chitietRepo.save(chitietdonthuoc);
		return _chitiet;
	}

}
