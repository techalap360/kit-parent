package com.kit.bo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Zubayer Ahamed
 * @since Apr 18, 2021
 */
@Controller
@RequestMapping({"/","/dashboard"})
public class DashboardController extends KITAbstractController {

	@GetMapping
	public String loadDashboard(Model model) {
		return "pages/dashboard/dashboard";
	}
}
