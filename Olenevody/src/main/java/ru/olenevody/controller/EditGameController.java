package ru.olenevody.controller;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.olenevody.DAO.GameDAO;
import ru.olenevody.model.Game;

@Controller
public class EditGameController {

	@Autowired
	GameDAO gameDAO;

	@RequestMapping(value = "/EditGame/{id}", method = RequestMethod.GET)
	public String editGame(@PathVariable String id, Model model) {
		Game game = gameDAO.getByID(Integer.parseInt(id));
		model.addAttribute("game", game);
		model.addAttribute("title", game.getId() == 0 ? "Создние игры" : "Редактирование игры");
		return "EditGame";
	}

	@RequestMapping(value = "/SaveGame", method = RequestMethod.POST)
	public String saveGame(@ModelAttribute("game") Game game) {
		if (game.getId() == 0) {
			gameDAO.save(game);
		} else {
			gameDAO.update(game);
		}

		return "redirect: /Olenevody/";
	}

	@RequestMapping(value = "/DeleteGame", method = RequestMethod.POST)
	public String deleteGame(@RequestBody String games) {
		Map<String, String> map = new HashMap<>();
		String id = "";
		try {
			map = new ObjectMapper().readValue(games, new TypeReference<Map<String, String>>() {
			});
			id = map.get("id");
		} catch (Exception e) {
		}
		gameDAO.deleteById(id);
		return "redirect: /Olenevody/";
	}

}
