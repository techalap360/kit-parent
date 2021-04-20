package com.kit.api.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Zubayer Ahamed
 * @since Apr 19, 2021
 */
@Component
public class AbstractService {

	protected static final String ERROR = "Error is {}, {}";

	@PersistenceContext protected EntityManager em;
	@Autowired protected JdbcTemplate jdbcTemplate;

	public String getBusinessId() {
		return "900000";
	}
}
