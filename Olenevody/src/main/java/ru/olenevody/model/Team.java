package ru.olenevody.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "catalog_teams")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	String name;

	@Type(type = "date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	Date date;

	String email;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "league")
	League league;

	public Team() {
		super();
	}

	public Team(int id, String name, Date date, League league) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.league = league;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

}
