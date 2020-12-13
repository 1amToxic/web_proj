package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblkhamchua")
public class Khamchua implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "ngayvao")
	private Date ngayVao;
	@Column(name = "ngayra")
	private Date ngayRa;
	@Column(name = "tongtien")
	private int tongTien;
	@Column(name = "trangthai")
	private int trangThai;
	@Column(name = "tienkham")
	private long tienKham;
	@JsonIgnore
	@OneToMany(mappedBy = "khamchua",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Chitietkham> chitietkham;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "mabn", referencedColumnName = "id")
    private Benhnhan benhnhan;
}
