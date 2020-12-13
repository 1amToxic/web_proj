package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Doanhthu;

public interface DoanhthuRepository extends JpaRepository<Doanhthu, Integer>{
	@Query(value = "select ((select sum(kc.tienkham) from tblkhamchua as kc) +\r\n"
			+ "(select sum(ct.sl*t.dongia) from	 tblchitietdonthuoc as ct\r\n"
			+ "	inner join tblthuoc as t on t.id = ct.mat)) as doanhthu",nativeQuery = true)
	public Doanhthu getDoanhthu();
}
