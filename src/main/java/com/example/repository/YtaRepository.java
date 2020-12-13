package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Bacsy;
import com.example.model.Yta;
@Repository
public interface YtaRepository extends JpaRepository<Yta, Integer>{
	@Query(value = "select * from tblyta where ten like %?1%", nativeQuery = true)
	public List<Yta> searchYtaTheoTen(String ten);
}
