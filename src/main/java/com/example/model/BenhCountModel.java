package com.example.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Entity
@Data
@NoArgsConstructor
@Table(name = "tblbenhcount")
public class BenhCountModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "tenbenh")
	private String tenBenh;
	@Column(name = "sobenhnhan")
	private int soBenhNhan;
	public String getTenBenh() {
		return tenBenh;
	}
	public void setTenBenh(String tenBenh) {
		this.tenBenh = tenBenh;
	}
	public int getSoBenhNhan() {
		return soBenhNhan;
	}
	public void setSoBenhNhan(int soBenhNhan) {
		this.soBenhNhan = soBenhNhan;
	}
	public BenhCountModel(String tenBenh, int soBenhNhan) {
		this.tenBenh = tenBenh;
		this.soBenhNhan = soBenhNhan;
	}
	
}
