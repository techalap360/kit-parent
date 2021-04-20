package com.kit.api.impl;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.api.CodeTypeService;
import com.kit.api.repository.CodeTypeRepository;
import com.kit.model.entity.CodeType;

/**
 * @author Zubayer Ahamed
 * @since Apr 19, 2021
 */
@Service
public class CodeTypeServiceImpl extends AbstractService implements CodeTypeService {

	@Autowired private CodeTypeRepository codeTypeRepository;

	@Override
	@Transactional
	public CodeType save(CodeType codeType) {
		if(codeType == null) return null;
		codeType.modifyCodeType();
		codeType.setBusinessId(getBusinessId());
		return codeTypeRepository.save(codeType);
	}

	

	@Override
	public CodeType findByCodeType(String codeType) {
		if(StringUtils.isBlank(codeType)) return null;
		StringBuilder sql = new StringBuilder("SELECT c FROM CodeType c WHERE c.codeType=:cdtp AND c.businessId=:bsid");
		List<CodeType> list = em.createQuery(sql.toString(), CodeType.class)
								.setParameter("cdtp", codeType)
								.setParameter("bsid", getBusinessId())
								.getResultList();
		if(list == null) return null;
		return list.stream().findFirst().orElse(null);
	}

	@Override
	public CodeType findByCodeType(String codeType, boolean status) {
		if(StringUtils.isBlank(codeType)) return null;
		StringBuilder sql = new StringBuilder("SELECT c FROM CodeType c WHERE c.codeType=:cdtp AND c.businessId=:bsid AND c.status=:stat");
		List<CodeType> list = em.createQuery(sql.toString(), CodeType.class)
								.setParameter("cdtp", codeType)
								.setParameter("bsid", getBusinessId())
								.setParameter("stat", status)
								.getResultList();
		if(list == null) return null;
		return list.stream().findFirst().orElse(null);
	} 

	@Override
	public List<CodeType> getAll() {
		StringBuilder sql = new StringBuilder("SELECT c FROM CodeType c WHERE c.businessId=:bsid");
		List<CodeType> list = em.createQuery(sql.toString(), CodeType.class)
								.setParameter("bsid", getBusinessId())
								.getResultList();
		if(list == null) return Collections.emptyList();
		return list;
	}

	@Override
	public List<CodeType> getAll(boolean status) {
		StringBuilder sql = new StringBuilder("SELECT c FROM CodeType c WHERE c.businessId=:bsid AND c.status=:stat");
		List<CodeType> list = em.createQuery(sql.toString(), CodeType.class)
								.setParameter("bsid", getBusinessId())
								.setParameter("stat", status)
								.getResultList();
		if(list == null) return Collections.emptyList();
		return list;
	}

	
}
