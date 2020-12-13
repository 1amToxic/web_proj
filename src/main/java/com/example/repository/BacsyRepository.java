package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Bacsy;

@Repository
public interface BacsyRepository extends JpaRepository<Bacsy, Integer>{
	@Query(value = "select * from tblbacsy as b where b.ten like %?1%", nativeQuery = true)
	public List<Bacsy> searchBacsyTheoTen(String ten);
}
