package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Yta;
@Repository
public interface YtaRepository extends JpaRepository<Yta, Integer>{

}
