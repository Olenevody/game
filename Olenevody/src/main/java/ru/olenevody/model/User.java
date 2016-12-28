package ru.olenevody.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	String name;
	String email;

	@Enumerated(EnumType.STRING)
	Role role;

	@Type(type = "date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	Date date;

	public User() {
		super();
		role = Role.user;
	}

	public User(int id, String name, String email, Role role, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.date = date;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static enum Role {
		admin, moderator, user;
	}

}
