package ru.olenevody.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.olenevody.DAO.UserDAO;
import ru.olenevody.model.User;

@Controller
public class UserController {

	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/Save-json-user", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> saveJsonUser(@RequestBody User user) {
		User savedUser = userDAO.save(user);
		return new ResponseEntity<String>(savedUser != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/Update-json-user", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> updateJsonUser(@RequestBody User user) {
		User savedUser = userDAO.update(user);
		return new ResponseEntity<String>(savedUser != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/Delete-json-user", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> removeJsonUser(@RequestBody User user) {
		User savedUser = userDAO.delete(user);
		return new ResponseEntity<String>(savedUser != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/UpdateUser", method = RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("editUser") User user) {
		userDAO.update(user);
		return new ModelAndView("redirect: /Olenevody/");
	}
}
