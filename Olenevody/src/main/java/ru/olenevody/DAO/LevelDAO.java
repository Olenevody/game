package ru.olenevody.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ru.olenevody.model.Code;
import ru.olenevody.model.Level;

@Controller
public class LevelDAO {

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

	public List<Level> getAll() {
		Session session = getCurrentSession();
		List<Level> gamesList = session.createQuery("from Level order by id").list();
		session.flush();
		session.close();
		return gamesList;
	}

	public Level getByID(int id) {
		Session session = getCurrentSession();
		Level level = (Level) session.get(Level.class, id);
		if (level == null) {
			level = new Level();
		}
		session.flush();
		session.close();
		return level;
	}

	public Level save(Level level) {
		Session session = getCurrentSession();
		session.save(level);
		session.flush();
		session.close();
		return level;
	}

	public Level update(Level level) {
		Session session = getCurrentSession();
		session.update(level);
		session.flush();
		session.close();
		return level;
	}

	public Level delete(Level level) {
		Session session = getCurrentSession();
		session.delete(level);
		session.flush();
		session.close();
		return level;
	}

	public int deleteById(String idList) {
		Session session = getCurrentSession();
		// TODO Понять почему не работает вариант с нормальной передачей
		// параметра
		Query query = session.createQuery("DELETE FROM Level WHERE id IN (" + idList + ")");
		// query.setString("idList", idList);
		int count = query.executeUpdate();
		session.flush();
		session.close();
		return count;
	}

	public List<Code> getCodes(Level level) {
		if (level.getId() == 0) {
			return new ArrayList<Code>();
		}
		Session session = getCurrentSession();
		Query query = session.createQuery("from Code where level:=level order by id");
		query.setParameter("level", level);
		List<Code> codesList = query.list();
		session.flush();
		session.close();
		return codesList;
	}

}