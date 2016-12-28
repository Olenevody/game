package ru.olenevody.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.olenevody.DAO.GameDAO;
import ru.olenevody.DAO.TeamDAO;
import ru.olenevody.DAO.UserDAO;
import ru.olenevody.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {

	@Autowired
	UserDAO userDAO;

	@Autowired
	TeamDAO teamDAO;

	@Autowired
	GameDAO gameDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		model.addAttribute("usersList", userDAO.getAll());
		model.addAttribute("userRolesList", userDAO.getRoles());
		model.addAttribute("teamsList", teamDAO.getAll());
		model.addAttribute("gamesList", gameDAO.getAll());

		model.addAttribute("editUser", new User());

		return "Main";

	}

}
