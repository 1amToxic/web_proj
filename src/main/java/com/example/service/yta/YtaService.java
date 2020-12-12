package com.example.service.yta;

import java.util.Date;
import java.util.List;

import com.example.model.Luong;
import com.example.model.Thuoc;
import com.example.model.Yta;

public interface YtaService {
	public Yta addYta(Yta yta);
	public Yta updateYta(Yta yta);
	public boolean deleteYta(int id);
	public List<Yta> getAllYta();
	public List<Luong> tinhLuongYta(Date date); 
}
