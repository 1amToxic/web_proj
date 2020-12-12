package com.example.service.benh;

import java.util.Date;
import java.util.List;

import com.example.model.BenhCountModel;

public interface BenhService {
	public List<BenhCountModel> getBenhCount(Date date);
}
