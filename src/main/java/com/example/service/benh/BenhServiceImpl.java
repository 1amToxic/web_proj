package com.example.service.benh;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.BenhCountModel;
import com.example.repository.BenhRepository;

@Service
public class BenhServiceImpl implements BenhService{
	@Autowired
	private BenhRepository benhRepo;
	@Override
	public List<BenhCountModel> getBenhCount(Date date) {
		return benhRepo.getBenhCount(date);
	}

}
