package com.kit.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Zubayer Ahamed
 * @since Apr 20, 2021
 */
@Controller
@RequestMapping({"/","/home"})
public class HomeController {

	@GetMapping
	public String loadHomePage(Model model) {
		
		return "index";
	}
}
