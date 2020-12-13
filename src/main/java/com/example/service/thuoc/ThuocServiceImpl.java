package com.example.service.thuoc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Thuoc;
import com.example.repository.ThuocRepository;

@Service
public class ThuocServiceImpl implements ThuocService{
	@Autowired
	private ThuocRepository thuocRepository;
	@Override
	public Thuoc addThuoc(Thuoc thuoc) {
		Thuoc thuocAdd = this.thuocRepository.save(thuoc);
		return thuocAdd;
	}

	@Override
	public Thuoc updateThuoc(Thuoc thuoc) {
		Thuoc thuocExist = this.thuocRepository.findById(thuoc.getId()).orElse(null);
		if(thuocExist != null) {
			thuocExist = thuocRepository.saveAndFlush(thuoc);
		}
		return thuocExist;
	}

	@Override
	public boolean deleteThuoc(int id) {
		boolean isDeleted = false;
		Thuoc thuoc = this.thuocRepository.findById(id).orElse(null);
		if(thuoc !=null) {
			this.thuocRepository.deleteById(id);
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public List<Thuoc> getAllThuoc() {
		List<Thuoc> listThuoc = this.thuocRepository.findAll();
		return listThuoc;
	}

	@Override
	public List<Thuoc> findThuocByTen(String ten) {
		return this.thuocRepository.searchThuocTheoTen(ten);
	}

	@Override
	public Thuoc findThuocById(int id) {
		return this.thuocRepository.findById(id).orElse(null);
	}

}
