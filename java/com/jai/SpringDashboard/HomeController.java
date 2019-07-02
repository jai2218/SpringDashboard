package com.jai.SpringDashboard;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jai.SpringDashboard.beans.UserDetails;
import com.jai.SpringDashboard.dao.UserDetailsDao;
import com.jai.SpringDashboard.dao.UserRegistrationDao;
import com.jai.SpringDashboard.model.UserRegistrationDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	UserDetailsDao userDao;
	
	@Autowired
	UserRegistrationDao userRegDao;

	/* Simply selects the home view to render by returning its name. */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		// return "fatchUserDetails";
		return "index";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String showform(Model m) {
		m.addAttribute("command", new UserDetails());
		return "addUser";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") UserDetails user) {
		userDao.save(user);
		return "redirect:/viewUser";// will redirect to viewemp request mapping
	}

	/* It provides list of employees in model object */
	@RequestMapping("/viewUser")
	public String viewemp(Model m) {
		List<UserDetails> list = userDao.getUserDetails();
		m.addAttribute("list", list);
		return "viewUser";
	}

	@RequestMapping(value = "/editUser/{id}")
	public String edit(@PathVariable int id, Model m) {
		UserDetails user = userDao.getUserById(id);
		m.addAttribute("command", user);
		return "editUser";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("user") UserDetails user) {
		userDao.update(user);
		return "redirect:/viewUser";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		userDao.delete(id);
		return "redirect:/viewUser";
	}

	@RequestMapping(value = "/fatchUserDetails", method = RequestMethod.GET)
	public String showhome(Model m, Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		m.addAttribute("serverTime", formattedDate);

		m.addAttribute("command", new UserDetails());
		return "fatchUserDetails";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexhome(Model model) {
		model.addAttribute("command", new UserDetails());
		return "index";
	}

	@RequestMapping(value = "/form_component", method = RequestMethod.GET)
	public String formcomponent(Model model) {
		model.addAttribute("command", new UserDetails());
		return "form_component";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String formprofile(Model model) {
		model.addAttribute("command", new UserDetails());
		return "profile";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String formlogin(Model model) {
		model.addAttribute("command", new UserDetails());
		return "login";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("command", new UserRegistrationDTO());
		return "registration";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(@ModelAttribute("userRegistrationDTO") UserRegistrationDTO userRegistrationDTO) {
		userRegDao.registerUser(userRegistrationDTO);
		return "redirect:/login";// will redirect to login request mapping
	}

}
