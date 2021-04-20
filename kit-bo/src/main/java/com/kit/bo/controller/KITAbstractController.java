package com.kit.bo.controller;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.kit.api.CodeTypeService;
import com.kit.api.KITSessionManager;
import com.kit.model.ResponseHelper;
import com.kit.model.entity.CodeType;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Zubayer Ahamed
 * @since Apr 18, 2021
 */
@Slf4j
@Component
public class KITAbstractController {

	protected static final String ERROR = "Error is : {}, {}"; 
	protected static final SimpleDateFormat SDF = new SimpleDateFormat("E, dd-MMM-yyyy");

	@Autowired protected Environment env;
	@Autowired protected Validator validator;
	@Autowired protected ApplicationContext appContext;
	@Autowired protected ResponseHelper responseHelper;
	@Autowired protected KITSessionManager sessionManager;
	@Autowired protected CodeTypeService codeTypeService;

	@ModelAttribute("brandName")
	protected String brandName() {
		return "SHOPWISE";
	}

	@ModelAttribute("copyrightText")
	protected String copyRightText() {
		return "Powered by <a href=\"http://karigorit.com/\" target=\"_blank\">KIT</a> &copy; Copyright";
	}

	@ModelAttribute("codeTypesMenu")
	protected List<CodeType> dashboardCodeTypes(){
		List<CodeType> list = codeTypeService.getAll(true);
		list = list.stream().filter(f -> f.isDashboardMenu()).collect(Collectors.toList());
		list.sort(Comparator.comparing(CodeType::getPrompt));
		return list;
	}
}
