package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Donthuoc;
import com.example.model.Thuoc;


@Repository
public interface ThuocRepository extends JpaRepository<Thuoc, Integer>{
	public List<Thuoc> findByTen(String ten);
}
