package com.kit.api.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.api.XcodesService;
import com.kit.api.repository.XcodesRepository;
import com.kit.model.entity.Xcodes;

/**
 * @author Zubayer Ahamed
 * @since Apr 20, 2021
 */
@Service
public class XcodesServiceImpl extends AbstractService implements XcodesService {

	@Autowired private XcodesRepository xcodesRepository;

	@Override
	@Transactional
	public Xcodes save(Xcodes xcodes) {
		if(xcodes == null) return null;
		xcodes.setBusinessId(getBusinessId());
		return xcodesRepository.save(xcodes);
	}

	@Override
	public Xcodes findByCodeTypeAndXcodes(String codeType, String xcodes) {
		StringBuilder sql = new StringBuilder("SELECT x FROM Xcodes x WHERE x.codeType=:ct AND x.xcode=:xc AND x.businessId=:bsid");
		List<Xcodes> list = em.createQuery(sql.toString(), Xcodes.class)
								.setParameter("ct", codeType)
								.setParameter("xc", xcodes)
								.setParameter("bsid", getBusinessId())
								.getResultList();
		if(list == null) return null;
		return list.stream().findFirst().orElse(null);
	}

	@Override
	public Xcodes findByCodeTypeAndXcodes(String codeType, String xcodes, boolean status) {
		StringBuilder sql = new StringBuilder("SELECT x FROM Xcodes x WHERE x.codeType=:ct AND x.xcode=:xc AND x.businessId=:bsid AND x.status=:stat");
		List<Xcodes> list = em.createQuery(sql.toString(), Xcodes.class)
								.setParameter("ct", codeType)
								.setParameter("xc", xcodes)
								.setParameter("bsid", getBusinessId())
								.setParameter("stat", status)
								.getResultList();
		if(list == null) return null;
		return list.stream().findFirst().orElse(null);
	}

	@Override
	public List<Xcodes> getAll() {
		StringBuilder sql = new StringBuilder("SELECT x FROM Xcodes x WHERE x.businessId=:bsid");
		List<Xcodes> list = em.createQuery(sql.toString(), Xcodes.class)
								.setParameter("bsid", getBusinessId())
								.getResultList();
		if(list == null) return Collections.emptyList();
		return list;
	}

	@Override
	public List<Xcodes> getAll(boolean status) {
		StringBuilder sql = new StringBuilder("SELECT x FROM Xcodes x WHERE x.businessId=:bsid AND x.status=:stat");
		List<Xcodes> list = em.createQuery(sql.toString(), Xcodes.class)
								.setParameter("bsid", getBusinessId())
								.setParameter("stat", status)
								.getResultList();
		if(list == null) return Collections.emptyList();
		return list;
	}

	@Override
	public List<Xcodes> findAllByCodeType(String codeType) {
		StringBuilder sql = new StringBuilder("SELECT x FROM Xcodes x WHERE x.codeType=:ct AND x.businessId=:bsid");
		List<Xcodes> list = em.createQuery(sql.toString(), Xcodes.class)
				.setParameter("ct", codeType)
				.setParameter("bsid", getBusinessId())
				.getResultList();
		if(list == null) return Collections.emptyList();
		list.sort(Comparator.comparing(Xcodes::getSequence).thenComparing(Xcodes::getXcode));
		return list;
	}

	@Override
	public List<Xcodes> findAllByCodeType(String codeType, boolean status) {
		StringBuilder sql = new StringBuilder("SELECT x FROM Xcodes x WHERE x.codeType=:ct AND x.businessId=:bsid AND x.status=:stat");
		List<Xcodes> list = em.createQuery(sql.toString(), Xcodes.class)
				.setParameter("ct", codeType)
				.setParameter("bsid", getBusinessId())
				.setParameter("stat", status)
				.getResultList();
		if(list == null) return Collections.emptyList();
		list.sort(Comparator.comparing(Xcodes::getSequence).thenComparing(Xcodes::getXcode));
		return list;
	}

	
}
