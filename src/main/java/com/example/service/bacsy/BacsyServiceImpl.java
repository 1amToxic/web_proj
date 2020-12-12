package com.example.service.bacsy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Bacsy;
import com.example.model.Luong;
import com.example.repository.BacsyRepository;
import com.example.repository.ChitietkhamRepository;
import com.example.repository.LuongRepository;
@Service
public class BacsyServiceImpl implements BacsyService{
	@Autowired
	private BacsyRepository bacsyRepository;
	@Autowired
	private LuongRepository luongRepo;
	@Override
	public Bacsy addBacsy(Bacsy bacsy) {
		Bacsy _bacsy =  this.bacsyRepository.save(bacsy);
		return _bacsy;
	}

	@Override
	public Bacsy updateBacsy(Bacsy bacsy) {
		Bacsy bacsyExist = this.bacsyRepository.findById(bacsy.getId()).orElse(null);
		if(bacsyExist != null) {
			bacsyExist = this.bacsyRepository.saveAndFlush(bacsy);
		}
		return bacsy;
	}

	@Override
	public boolean deleteBacsy(int id) {
		boolean isDeleted = false;
		Bacsy _bacsy = this.bacsyRepository.findById(id).orElse(null);
		if(_bacsy != null) {
			this.bacsyRepository.deleteById(id);
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public List<Bacsy> getAllBacsy() {
		List<Bacsy> listBacsy = this.bacsyRepository.findAll();
		return listBacsy;
	}

	@Override
	public List<Luong> tinhLuongBacsy(Date date) {
		return luongRepo.tinhLuongBacsy(date);
	}


}
