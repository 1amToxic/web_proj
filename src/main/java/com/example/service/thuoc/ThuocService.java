package com.example.service.thuoc;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Thuoc;

public interface ThuocService {

	public Thuoc addThuoc(Thuoc thuoc);
	public Thuoc updateThuoc(Thuoc thuoc);
	public boolean deleteThuoc(int id);
	public List<Thuoc> getAllThuoc();
	public List<Thuoc> findThuocByTen(String ten);
}
