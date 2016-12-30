package ru.olenevody.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "codes")
public class Code {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "level")
	Level level;

	int num;
	String code;

	@Enumerated(EnumType.STRING)
	KO ko;

	public static enum KO {

		KO_null("null"), KO_1("1"), KO_1_plus("1+"), KO_2("2"), KO_2_plus("2+"), KO_3("3"), KO_3_plus("3+");

		String name;

		private KO(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}

	}

}
