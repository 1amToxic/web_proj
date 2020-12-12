package com.example.service.bacsy;

import java.util.List;

import com.example.model.Bacsy;

public interface BacsyService {
	public Bacsy addBacsy(Bacsy bacsy);
	public Bacsy updateBacsy(Bacsy bacsy);
	public boolean deleteBacsy(int id);
	public List<Bacsy> getAllBacsy();
}
