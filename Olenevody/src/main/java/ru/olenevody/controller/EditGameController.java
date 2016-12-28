package ru.olenevody.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.olenevody.DAO.GameDAO;
import ru.olenevody.model.Game;

@Controller
public class EditGameController {

	@Autowired
	GameDAO gameDAO;

	@RequestMapping(value = "/EditGame/{id}", method = RequestMethod.GET)
	public String EditGame(@PathVariable String id, Model model) {
		Game game = gameDAO.getByID(Integer.parseInt(id));
		model.addAttribute("game", game);
		model.addAttribute("title", game.getId() == 0 ? "Создние игры" : "Редактирование игры");
		return "EditGame";

	}

}
