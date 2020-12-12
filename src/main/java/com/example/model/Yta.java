package com.example.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "tblyta")
public class Yta implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "trinhdo")
	private String trinhDo;
	@Column(name = "thamnien")
	private String thamNien;
	@Column(name = "cmt")
	private String cmt;
	@Column(name = "ten")
	private String ten;
	@Column(name = "ngaysinh")
	private Date ngaySinh;
	@Column(name = "diachi")
	private String diaChi;
	@Column(name = "sdt")
	private String sdt;
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getTrinhDo() {
		return trinhDo;
	}
	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}
	public String getThamNien() {
		return thamNien;
	}
	public void setThamNien(String thamNien) {
		this.thamNien = thamNien;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Chitietkham> getChitietkham() {
		return chitietkham;
	}
	public void setChitietkham(List<Chitietkham> chitietkham) {
		this.chitietkham.clear();
		this.chitietkham.addAll(chitietkham);
	}
	@JsonIgnore
	@OneToMany(mappedBy = "yta",cascade = CascadeType.ALL)
	private List<Chitietkham> chitietkham;
}
