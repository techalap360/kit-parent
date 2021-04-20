package com.kit.bo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kit.api.CodeTypeService;
import com.kit.model.entity.CodeType;
import com.kit.model.enums.ResponseStatus;

/**
 * @author Zubayer Ahamed
 * @since Apr 18, 2021
 */
@Controller
@RequestMapping("/system/codetype")
public class CodeTypeController extends KITAbstractController {

	@Autowired private CodeTypeService codeTypeService;

	@GetMapping
	public String loadCodeTypePage(Model model) {
		model.addAttribute("codeType", new CodeType());
		model.addAttribute("codeTypes", codeTypeService.getAll());
		return "pages/system/codetype/codetype";
	}

	@GetMapping("/{codetype}")
	public String loadCodeTypePage(@PathVariable String codetype, Model model) {
		CodeType ct = codeTypeService.findByCodeType(codetype);
		if(ct == null) return "redirect:/system/codetype";

		model.addAttribute("codeType", ct);
		model.addAttribute("codeTypes", codeTypeService.getAll());
		return "pages/system/codetype/codetype";
	}

	@PostMapping("/save")
	public @ResponseBody Map<String, Object> save(CodeType codeType, BindingResult bindingResult){
		
		codeType.modifyCodeType();

		codeType = codeTypeService.save(codeType);
		if(codeType == null) {
			responseHelper.setStatus(ResponseStatus.ERROR);
			return responseHelper.getResponse();
		}

		responseHelper.setStatus(ResponseStatus.SUCCESS);
		responseHelper.setRedirectUrl("/system/codetype/" + codeType.getCodeType());
		return responseHelper.getResponse();
	}
}
