package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Bacsy;

@Repository
public interface BacsyRepository extends JpaRepository<Bacsy, Integer>{
	public List<Bacsy> findByTen(String ten);
}
