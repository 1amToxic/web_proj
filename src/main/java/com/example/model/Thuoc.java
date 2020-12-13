package com.example.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblthuoc")
public class Thuoc implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "ten")
	private String ten;
	@Column(name = "dongia")
	private int donGia;
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Chitietdonthuoc> getChitietdonthuoc() {
		return chitietdonthuoc;
	}
	public void setChitietdonthuoc(List<Chitietdonthuoc> chitietdonthuoc) {
		this.chitietdonthuoc = chitietdonthuoc;
	}
	@JsonIgnore
	@OneToMany(mappedBy = "thuoc",cascade = CascadeType.ALL)
	private List<Chitietdonthuoc> chitietdonthuoc;
	
}
