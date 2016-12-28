package ru.olenevody.DAO;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ru.olenevody.model.User;

@Controller
public class UserDAO {

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

	public List<User> getAll() {
		Session session = getCurrentSession();
		List<User> usersList = session.createQuery("from User order by id").list();
		session.flush();
		session.close();
		return usersList;
	}

	public User save(User user) {
		Session session = getCurrentSession();
		session.save(user);
		session.flush();
		session.close();
		return user;
	}

	public User update(User user) {
		Session session = getCurrentSession();
		session.update(user);
		session.flush();
		session.close();
		return user;
	}

	public User delete(User user) {
		Session session = getCurrentSession();
		session.delete(user);
		session.flush();
		session.close();
		return user;
	}

	public List<User.Role> getRoles() {
		return Arrays.asList(User.Role.values());
	}

}
