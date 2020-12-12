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
@Table(name = "tbldonthuoc")
public class Donthuoc implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@JsonIgnore
	@OneToMany(mappedBy = "donthuoc",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Chitietdonthuoc> chitietdonthuoc;
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "mactk", referencedColumnName = "id")
    private Chitietkham chitietkham;

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

	public Chitietkham getChitietkham() {
		return chitietkham;
	}

	public void setChitietkham(Chitietkham chitietkham) {
		this.chitietkham = chitietkham;
	}
	
	
}
