package com.example.service.bacsy;

import java.util.Date;
import java.util.List;

import com.example.model.Bacsy;
import com.example.model.Luong;

public interface BacsyService {
	public Bacsy addBacsy(Bacsy bacsy);
	public Bacsy updateBacsy(Bacsy bacsy);
	public boolean deleteBacsy(int id);
	public List<Bacsy> getAllBacsy();
	public List<Luong> tinhLuongBacsy(Date date);
	public List<Bacsy> findBacsyByName(String ten);
	public Bacsy findBacsyById(int id);
}
