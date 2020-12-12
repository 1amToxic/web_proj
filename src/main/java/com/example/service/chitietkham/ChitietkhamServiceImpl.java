package com.example.service.chitietkham;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Chitietkham;
import com.example.repository.ChitietkhamRepository;

@Service
public class ChitietkhamServiceImpl implements ChitietkhamService{
	@Autowired
	private ChitietkhamRepository chitietRepo;
	@Override
	public Chitietkham addChitietkham(Chitietkham chitietkham) {
		Chitietkham _chitiet = this.chitietRepo.save(chitietkham);
		return _chitiet;
	}

}
