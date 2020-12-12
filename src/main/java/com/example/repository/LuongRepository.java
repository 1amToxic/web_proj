package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Luong;

public interface LuongRepository extends JpaRepository<Luong, Integer>{
	@Query(value = "select k.id as id,k.ten as ten,(7+count(*)*1)*1000000 as luong from (select tblbacsy.id,tblbacsy.ten from tblkhamchua\r\n"
			+ "	inner join tblchitietkhamchua on tblchitietkhamchua.makc = tblkhamchua.id\r\n"
			+ "    inner join tblbenh on tblbenh.id = tblchitietkhamchua.mab\r\n"
			+ "    inner join tblbacsy on tblchitietkhamchua.mabs = tblbacsy.id\r\n"
			+ "    where tblkhamchua.trangthai = 1 and tblkhamchua.ngayvao >= ?1) as k",nativeQuery = true)
	public List<Luong> tinhLuongBacsy(Date date);
	@Query(value = "select k.id as id,k.ten as ten,(50+count(*)*2)*100000 as luong from (select tblyta.id,tblyta.ten from tblkhamchua\r\n"
			+ "	inner join tblchitietkhamchua on tblchitietkhamchua.makc = tblkhamchua.id\r\n"
			+ "    inner join tblbenh on tblbenh.id = tblchitietkhamchua.mab\r\n"
			+ "    inner join tblyta on tblchitietkhamchua.manv = tblyta.id\r\n"
			+ "    where tblkhamchua.trangthai = 1 and tblkhamchua.ngayvao >= ?1) as k",nativeQuery = true)
	public List<Luong> tinhLuongYta(Date date);
}
