package com.kit.model.entity.pk;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Apr 18, 2021
 */
@Data
public class XcodesPK implements Serializable {

	private static final long serialVersionUID = 5627802973999841517L;

	private String businessId;
	private String codeType;
	private String xcode;
}
