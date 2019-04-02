package com.onetomanyunidirectional;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long countryId;
	private String name;
	//@OneToMany(fetch = FetchType.LAZY)
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="COUNTRY_ID")
    private Set<State> states = new HashSet<State>();
	public Country() {}
	public Country(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<State> getStates() {
		return states;
	}
	public void setStates(Set<State> states) {
		this.states = states;
	}
		
}
