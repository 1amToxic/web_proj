package com.example.service.khamchua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Khamchua;
import com.example.repository.KhamchuaRepository;
@Service
public class KhamchuaServiceImpl implements KhamchuaService{
	@Autowired
	private KhamchuaRepository khamchuaRepo;
	@Override
	public Khamchua addKhamchua(Khamchua khamchua) {
		Khamchua _khamchua = this.khamchuaRepo.save(khamchua);
		return _khamchua;
	}

}
