package com.kit.api;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kit.model.entity.Xcodes;

/**
 * @author Zubayer Ahamed
 * @since Apr 20, 2021
 */
@Component
public interface XcodesService {

	public Xcodes save(Xcodes xcodes);

	public Xcodes findByCodeTypeAndXcodes(String codeType, String xcodes);

	public Xcodes findByCodeTypeAndXcodes(String codeType, String xcodes, boolean status);

	public List<Xcodes> getAll();

	public List<Xcodes> getAll(boolean status);

	public List<Xcodes> findAllByCodeType(String codeType);

	public List<Xcodes> findAllByCodeType(String codeType, boolean status);
}
