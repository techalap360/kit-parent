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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kit.api.CodeTypeService;
import com.kit.api.XcodesService;
import com.kit.model.entity.CodeType;
import com.kit.model.entity.Xcodes;
import com.kit.model.enums.ResponseStatus;

/**
 * @author Zubayer Ahamed
 * @since Apr 20, 2021
 */
@Controller
@RequestMapping("/system/xcodes")
public class XcodesController extends KITAbstractController {

	@Autowired private CodeTypeService codeTypeService;
	@Autowired private XcodesService xcodesService;

	@GetMapping
	public String loadXcodesPage(@RequestParam(required = false) String codetype, Model model) {
		CodeType ct = codeTypeService.findByCodeType(codetype, true);
		if(ct == null) {
			model.addAttribute("codeTypeList", codeTypeService.getAll(true));
			model.addAttribute("codeTypePrompt", "Code");
			model.addAttribute("allowParent", true);
			model.addAttribute("xcodesList", xcodesService.getAll());
		}
		Xcodes xcodes = new Xcodes();
		if(ct != null) {
			xcodes.setCodeType(ct.getCodeType());
			model.addAttribute("codeTypePrompt", ct.getPrompt());
			model.addAttribute("allowParent", ct.isAllowParent());
			model.addAttribute("xcodesList", xcodesService.findAllByCodeType(codetype));
			if(ct.isAllowParent()) model.addAttribute("parentCodes", xcodesService.findAllByCodeType(codetype, true));
		}
		
		model.addAttribute("xcodes", xcodes);
		return "pages/system/xcodes/xcodes";
	}

	@GetMapping("/{xcode}")
	public String loadXcodesPage(@PathVariable String xcode, @RequestParam(required = false) String codetype, Model model) {
		Xcodes xc = xcodesService.findByCodeTypeAndXcodes(codetype, xcode);
		if(xc == null) return "redirect:/system/xcodes?codetype=" + codetype;

		CodeType ct = codeTypeService.findByCodeType(codetype, true);
		model.addAttribute("codeTypePrompt", ct.getPrompt());
		model.addAttribute("allowParent", ct.isAllowParent());
		model.addAttribute("xcodesList", xcodesService.findAllByCodeType(codetype));
		if(ct.isAllowParent()) model.addAttribute("parentCodes", xcodesService.findAllByCodeType(codetype, true));

		model.addAttribute("xcodes", xc);
		return "pages/system/xcodes/xcodes";
	}

	@PostMapping("/save")
	public @ResponseBody Map<String, Object> save(Xcodes xcodes, BindingResult bindingResult){
		
		xcodes = xcodesService.save(xcodes);
		if(xcodes == null) {
			responseHelper.setStatus(ResponseStatus.ERROR);
			return responseHelper.getResponse();
		}

		responseHelper.setStatus(ResponseStatus.SUCCESS);
		responseHelper.setRedirectUrl("/system/xcodes/" + xcodes.getXcode() + "?codetype=" + xcodes.getCodeType());
		return responseHelper.getResponse();
	}
}
