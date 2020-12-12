package com.example.model;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblchitietdonthuoc")
public class Chitietdonthuoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "sl")
	private int sl;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "madt", referencedColumnName = "id")
    private Donthuoc donthuoc;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "mat", referencedColumnName = "id")
    private Thuoc thuoc;
}
