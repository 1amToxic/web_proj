package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.ThongtinBenhnhan;

public interface ThongtinBNRepository extends JpaRepository<ThongtinBenhnhan, Integer>{
	@Query(value = "select k.id as id,k.ten,k.cmt,k.trangthai,k.solankham from (select bn.id,bn.ten,bn.cmt,kc.trangthai,count(ct.id) as solankham from tblbenhnhan as bn\r\n"
			+ "	inner join tblchitietkhamchua as ct on ct.mabn = bn.id\r\n"
			+ "    inner join tblkhamchua as kc on ct.makc = kc.id group by ct.id) as k",nativeQuery = true)
	public List<ThongtinBenhnhan> getAllThongTin();
}
