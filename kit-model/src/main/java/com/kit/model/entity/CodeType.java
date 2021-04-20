package com.kit.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;

import com.kit.model.entity.pk.CodeTypePK;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Apr 18, 2021
 */
@Data
@Entity
@Table(name = "CODE_TYPE")
@IdClass(CodeTypePK.class)
@EqualsAndHashCode(callSuper = true)
public class CodeType extends AbstractModel {

	private static final long serialVersionUID = 6653824735976916420L;

	@Id
	@Basic(optional = false)
	@Column(name = "business_id", length = 6)
	@Size(max = 6, message = "Business ID maximum 6 character allowed")
	private String businessId;

	@Id
	@Basic(optional = false)
	@Column(name = "code_type", length = 20)
	@Size(max = 20, message = "Code Type maximum 20 character allowed")
	private String codeType;

	@Size(max = 20, message = "Prompt maximum 20 character allowed")
	@Column(name = "prompt", length = 20)
	private String prompt;

	@Column(name = "allow_parent")
	private boolean allowParent;

	@Column(name = "dashboard_menu")
	private boolean dashboardMenu;

	public void modifyCodeType() {
		if(StringUtils.isBlank(this.prompt)) return;
		if(StringUtils.isNotBlank(this.codeType)) return;

		String val = prompt.toUpperCase().trim();
		val = val.replace(" ", "_");
		this.codeType = val;
	}
}
