package ru.olenevody.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "levels")
public class Level {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	String name;

	@Enumerated(EnumType.STRING)
	Type type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "game")
	Game game;

	public Level() {
		super();
	}

	public Level(int id, String name, Type type, Game game) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.game = game;
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public static enum Type {
		game, bonus;
	}

}
