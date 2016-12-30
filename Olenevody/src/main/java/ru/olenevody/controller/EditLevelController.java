package ru.olenevody.controller;

import java.util.HashMap;
import java.util.List;
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

import ru.olenevody.DAO.LevelDAO;
import ru.olenevody.model.Code;
import ru.olenevody.model.Level;

@Controller
public class EditLevelController {

	@Autowired
	LevelDAO levelDAO;

	@RequestMapping(value = "/EditLevel/{id}", method = RequestMethod.GET)
	public String editLevel(@PathVariable String id, Model model) {
		Level level = levelDAO.getByID(Integer.parseInt(id));
		List<Code> codesList = levelDAO.getCodes(level);
		model.addAttribute("level", level);
		model.addAttribute("title", level.getId() == 0 ? "Создние задания" : "Редактирование задания");
		return "EditLevel";
	}

	@RequestMapping(value = "/SaveLevel", method = RequestMethod.POST)
	public String saveLevel(@ModelAttribute("level") Level level) {
		if (level.getId() == 0) {
			levelDAO.save(level);
		} else {
			levelDAO.update(level);
		}

		return "redirect: /Olenevody/EditGame";
	}

	@RequestMapping(value = "/DeleteLevel", method = RequestMethod.POST)
	public String deleteLevel(@RequestBody String games) {
		Map<String, String> map = new HashMap<>();
		String id = "";
		try {
			map = new ObjectMapper().readValue(games, new TypeReference<Map<String, String>>() {
			});
			id = map.get("id");
		} catch (Exception e) {
		}
		levelDAO.deleteById(id);
		return "redirect: /Olenevody/EditGame";
	}

}
