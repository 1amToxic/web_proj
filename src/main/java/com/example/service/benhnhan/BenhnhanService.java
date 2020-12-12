package com.example.service.benhnhan;

import java.util.List;

import com.example.model.Benhnhan;

public interface BenhnhanService {
	public Benhnhan addBenhnhan(Benhnhan benhnhan);
	public Benhnhan updateBenhnhan(Benhnhan benhnhan);
	public boolean deleteBenhnhan(int id);
	public List<Benhnhan> getAllBenhnhan();
}
