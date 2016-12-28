package ru.olenevody.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "games_desc")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	String num;
	String name;

	@Type(type = "date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "dd.MM.yyyy")
	Date date;

	String legend;
	String location;
	String author;

	public Game() {
		super();
	}

	public Game(int id, String num, String name, Date date, String legend, String location, String author) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.date = date;
		this.legend = legend;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
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

	public String getLegend() {
		return legend;
	}

	public void setLegend(String legend) {
		this.legend = legend;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
