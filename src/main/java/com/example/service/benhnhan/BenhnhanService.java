package com.example.service.benhnhan;

import java.util.List;

import com.example.model.Benhnhan;
import com.example.model.ThongtinBenhnhan;

public interface BenhnhanService {
	public Benhnhan addBenhnhan(Benhnhan benhnhan);
	public Benhnhan updateBenhnhan(Benhnhan benhnhan);
	public boolean deleteBenhnhan(int id);
	public List<Benhnhan> getAllBenhnhan();
	public List<ThongtinBenhnhan> getAllThongTin();
	public List<Benhnhan> findBenhnhanByTen(String name);
	public Benhnhan findBenhnhanById(int id);
}
