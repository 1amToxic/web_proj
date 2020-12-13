package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Khamchua;
import com.example.model.ThongtinBenhnhan;

public interface ThongtinBNRepository extends JpaRepository<ThongtinBenhnhan, Integer>{
	@Query(value = "select distinct kc.id,bn.ten,b.ten as tenbenh,(select count(*) from tblchitietkhamchua as ct where ct.makc = kc.id) as solankham,kc.trangthai from\r\n"
			+ "(((\r\n"
			+ "tblbenhnhan as bn\r\n"
			+ "inner join tblkhamchua as kc on kc.mabn = bn.id)\r\n"
			+ "inner join tblchitietkhamchua as ct on ct.makc = kc.id)\r\n"
			+ "inner join tblbenh as b on b.id = ct.mab\r\n"
			+ ")where bn.id = ?1",nativeQuery =  true)
	public List<ThongtinBenhnhan> getAllKhamChuaByBenhnhan(int id);
}
