package com.example.service.yta;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Luong;
import com.example.model.Yta;
import com.example.repository.LuongRepository;
import com.example.repository.YtaRepository;

@Service
public class YtaServiceImpl implements YtaService{
	@Autowired
	private YtaRepository ytaRepository;
	@Autowired
	private LuongRepository luongRepo;
	@Override
	public Yta addYta(Yta yta) {
		Yta _yta = this.ytaRepository.save(yta);		
		return _yta;
	}

	@Override
	public Yta updateYta(Yta yta) {
		Yta ytaExist = this.ytaRepository.findById(yta.getId()).orElse(null);
		if(ytaExist != null) {
			ytaExist = this.ytaRepository.saveAndFlush(yta);
		}
		return yta;
	}

	

	@Override
	public List<Yta> getAllYta() {
		List<Yta> listYta = this.ytaRepository.findAll();
		return listYta;
	}

	@Override
	public boolean deleteYta(int id) {
		boolean isDeleted = false;
		Yta _yta = this.ytaRepository.findById(id).orElse(null);
		if(_yta!=null) {
			this.ytaRepository.deleteById(id);
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public List<Luong> tinhLuongYta(Date date) {
		return luongRepo.tinhLuongYta(date);
	}


}

