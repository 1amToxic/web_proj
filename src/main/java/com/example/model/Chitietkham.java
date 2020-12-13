package com.example.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblchitietkhamchua")
public class Chitietkham implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "makc", referencedColumnName = "id")
    private Khamchua khamchua;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "manv", referencedColumnName = "id")
    private Yta yta;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "mabs", referencedColumnName = "id")
    private Bacsy bacsy;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "mab", referencedColumnName = "id")
    private Benh benh;
	
	@OneToOne(mappedBy = "chitietkham",orphanRemoval = true,cascade = CascadeType.ALL)
    private Donthuoc donthuoc;
	
	@Column(name = "ngaykham")
	private Date ngayKham;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Khamchua getKhamchua() {
		return khamchua;
	}

	public void setKhamchua(Khamchua khamchua) {
		this.khamchua = khamchua;
	}

	public Yta getYta() {
		return yta;
	}

	public void setYta(Yta yta) {
		this.yta = yta;
	}

	public Bacsy getBacsy() {
		return bacsy;
	}

	public void setBacsy(Bacsy bacsy) {
		this.bacsy = bacsy;
	}

	public Benh getBenh() {
		return benh;
	}

	public void setBenh(Benh benh) {
		this.benh = benh;
	}

	public Donthuoc getDonthuoc() {
		return donthuoc;
	}

	public void setDonthuoc(Donthuoc donthuoc) {
		this.donthuoc = donthuoc;
	}

	public Date getNgayKham() {
		return ngayKham;
	}

	public void setNgayKham(Date ngayKham) {
		this.ngayKham = ngayKham;
	}
	
}
