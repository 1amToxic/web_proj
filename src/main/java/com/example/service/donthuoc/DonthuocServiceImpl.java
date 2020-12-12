package com.example.service.donthuoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Donthuoc;
import com.example.repository.DonthuocRepository;
@Service
public class DonthuocServiceImpl implements DonthuocService{
	@Autowired
	private DonthuocRepository donthuocRepo;
	@Override
	public Donthuoc addDonthuoc(Donthuoc donthuoc) {
		Donthuoc _donthuoc = this.donthuocRepo.save(donthuoc);
		return _donthuoc;
	}

}
