package com.lmig.gfc.wimp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 300, nullable = false)
	private String title;
	
	@Column(nullable = true)
	private Date releaseDate;
	
	@Column(nullable = true)
	private Long budget;
	
	@Column(nullable = false, length = 500)
	private String distributor;

	public Movie(String title, Date releaseDate, Long budget, String distributor) {
		super();
		this.title = title;
		this.releaseDate = releaseDate;
		this.budget = budget;
		this.distributor = distributor;
	}
	

}
