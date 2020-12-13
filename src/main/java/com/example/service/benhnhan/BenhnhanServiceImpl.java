package com.example.service.benhnhan;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Bacsy;
import com.example.model.Benhnhan;
import com.example.model.ThongtinBenhnhan;
import com.example.repository.BenhnhanRepository;
import com.example.repository.ThongtinBNRepository;

@Service
public class BenhnhanServiceImpl implements BenhnhanService{
	@Autowired
	private BenhnhanRepository benhnhanRepository;
	@Autowired
	private ThongtinBNRepository thongtinRepo;
	@Override
	public Benhnhan addBenhnhan(Benhnhan benhnhan) {
		Benhnhan _benhnhan = this.benhnhanRepository.save(benhnhan);
		return _benhnhan;
	}

	@Override
	public Benhnhan updateBenhnhan(Benhnhan benhnhan) {
		Benhnhan benhnhanExist = this.benhnhanRepository.findById(benhnhan.getId()).orElse(null);
		if(benhnhanExist != null) {
			benhnhanExist = this.benhnhanRepository.saveAndFlush(benhnhan);
		}
		return benhnhan;
	}

	@Override
	public boolean deleteBenhnhan(int id) {
		boolean isDeleted = false;
		Benhnhan _benhnhan = this.benhnhanRepository.findById(id).orElse(null);
		if(_benhnhan != null) {
			this.benhnhanRepository.deleteById(id);
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public List<Benhnhan> getAllBenhnhan() {
		List<Benhnhan> listBenhnhan = this.benhnhanRepository.findAll();
		return listBenhnhan;
	}

	@Override
	public List<ThongtinBenhnhan> getAllThongTin() {
		return thongtinRepo.getAllThongTin();
	}

	@Override
	public List<Benhnhan> findBenhnhanByTen(String name) {
		return this.benhnhanRepository.searchBenhnhanTheoTen(name);
	}

	@Override
	public Benhnhan findBenhnhanById(int id) {
		return this.benhnhanRepository.findById(id).orElse(null);
	}

}
