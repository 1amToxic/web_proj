package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Doanhthu;

public interface DoanhthuRepository extends JpaRepository<Doanhthu, Integer>{
	@Query(value = "select ct.id,sum(t.dongia*ctd.sl) as doanhthu from tblchitietkhamchua as ct \r\n"
			+ "	inner join tbldonthuoc as dt on dt.mactk \r\n"
			+ "    inner join tblchitietdonthuoc as ctd on ctd.madt = dt.id\r\n"
			+ "    inner join tblthuoc as t on t.id = ctd.mat",nativeQuery = true)
	public Doanhthu getDoanhthu();
}
