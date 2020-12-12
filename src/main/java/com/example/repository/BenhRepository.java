package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Benh;
import com.example.model.BenhCountModel;

public interface BenhRepository extends JpaRepository<BenhCountModel, Integer>{
	@Query(value = "select k.id as id,k.ten as tenbenh,count(*) as sobenhnhan from (select tblbenh.id,tblbenh.ten from tblkhamchua\r\n"
			+ "	inner join tblchitietkhamchua on tblchitietkhamchua.makc = tblkhamchua.id\r\n"
			+ "    inner join tblbenh on tblbenh.id = tblchitietkhamchua.mab\r\n"
			+ "    where tblkhamchua.ngayvao >= ?1) as k group by k.id order by sobenhnhan DESC",nativeQuery = true)
	public List<BenhCountModel> getBenhCount(Date date);
}
