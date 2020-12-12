package com.example.service.doanhthu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.DoanhthuRepository;

@Service
public class DoanhthuServiceImpl implements DoanhthuService{
	@Autowired
	private DoanhthuRepository doanhthuRepo;

	@Override
	public long getDoanhThu() {
		return doanhthuRepo.getDoanhthu().getDoanhthu();
	}
	
}
