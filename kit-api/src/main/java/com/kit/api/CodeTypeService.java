package com.kit.api;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kit.model.entity.CodeType;

/**
 * @author Zubayer Ahamed
 * @since Apr 19, 2021
 */
@Component
public interface CodeTypeService {

	public CodeType save(CodeType codeType);
	public CodeType findByCodeType(String codeType);
	public CodeType findByCodeType(String codeType, boolean status);
	public List<CodeType> getAll();
	public List<CodeType> getAll(boolean status);
}
