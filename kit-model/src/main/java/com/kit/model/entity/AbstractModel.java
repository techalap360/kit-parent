package com.kit.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Apr 18, 2021
 */
@Data
@MappedSuperclass
public class AbstractModel implements Serializable {

	private static final long serialVersionUID = 5230916530157800767L;

	@Column(name = "status")
	private boolean status = true;
}
