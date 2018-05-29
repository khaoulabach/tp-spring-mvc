package com.eheio.hello.Model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="consultation")
public class Consultation {
	@Id
	@Column(name="id")
	@GeneratedValue  
	private Integer id; 
	@Column(name="obeservation")
	private String obeservation;
	@Column(name="date")
	private Date date;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_medcin")
	private Personne m;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_patient")
	private Personne p;
	@ManyToMany
	@JoinTable(
			name="con_maldie",
			joinColumns=@JoinColumn(name="id_maladie", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="id_consultation", referencedColumnName="id"))
	private List<Maladie> maladieList;
	public Integer getId() {
		return id;
	}

	public String getObeservation() {
		return obeservation;
	}

	public Date getDate() {
		return date;
	}

	public Personne getM() {
		return m;
	}

	public Personne getP() {
		return p;
	}

	public List<Maladie> getMaladieList() {
		return maladieList;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setObeservation(String obeservation) {
		this.obeservation = obeservation;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setM(Personne m) {
		this.m = m;
	}

	public void setP(Personne p) {
		this.p = p;
	}

	public void setMaladieList(List<Maladie> maladieList) {
		this.maladieList = maladieList;
	}
}
