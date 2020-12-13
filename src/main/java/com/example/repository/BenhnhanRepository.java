package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Benhnhan;

@Repository
public interface BenhnhanRepository extends JpaRepository<Benhnhan, Integer>{
	@Query(value = "select * from tblbenhnhan where ten like %?1%", nativeQuery = true)
	public List<Benhnhan> searchBenhnhanTheoTen(String ten);
}
