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


}
