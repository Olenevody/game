package ru.olenevody.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ru.olenevody.model.Team;

@Controller
public class TeamDAO {

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

	public List<Team> getAll() {
		Session session = getCurrentSession();
		List<Team> teamsList = session.createQuery("from Team order by name").list();
		session.flush();
		session.close();
		return teamsList;
	}

	public Team save(Team team) {
		Session session = getCurrentSession();
		session.save(team);
		session.flush();
		session.close();
		return team;
	}

	public Team update(Team team) {
		Session session = getCurrentSession();
		session.update(team);
		session.flush();
		session.close();
		return team;
	}

	public Team delete(Team team) {
		Session session = getCurrentSession();
		session.delete(team);
		session.flush();
		session.close();
		return team;
	}

}
