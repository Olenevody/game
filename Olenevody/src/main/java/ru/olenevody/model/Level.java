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
	@JoinColumn
	Game game;

	public static enum Type {
		game, bonus;
	}

}
