package ru.olenevody.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ru.olenevody.model.Game;

@Controller
public class GameDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	private Session getCurrentSession() {
		try {
			return this.sessionFactory.getCurrentSession();
		} catch (Exception e) {
			return this.sessionFactory.openSession();
		}
	}

	public List<Game> getAll() {
		Session session = getCurrentSession();
		List<Game> gamesList = session.createQuery("from Game order by num").list();
		session.flush();
		session.close();
		return gamesList;
	}

	public Game getByID(int id) {
		Session session = getCurrentSession();
		Game game = (Game) session.get(Game.class, id);
		if (game == null) {
			game = new Game();
		}
		return game;
	}

	public Game save(Game game) {
		Session session = getCurrentSession();
		session.save(game);
		session.flush();
		session.close();
		return game;
	}

	public Game update(Game game) {
		Session session = getCurrentSession();
		session.update(game);
		session.flush();
		session.close();
		return game;
	}

	public Game delete(Game game) {
		Session session = getCurrentSession();
		session.delete(game);
		session.flush();
		session.close();
		return game;
	}

}
