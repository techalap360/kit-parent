package com.kit.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.kit.model.entity.pk.XcodesPK;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Apr 18, 2021
 */

@Data
@Entity
@Table(name = "XCODES")
@IdClass(XcodesPK.class)
@EqualsAndHashCode(callSuper = true)
public class Xcodes extends AbstractModel {

	private static final long serialVersionUID = 6653824735976916420L;

	@Id
	@Basic(optional = false)
	@Column(name = "business_id", length = 6)
	@Size(max = 6, message = "Business ID maximum 6 character allowed")
	private String businessId;

	@Id
	@Basic(optional = false)
	@Column(name = "code_type", length = 20)
	@Size(max = 20, message = "Code type maximum 20 character allowed")
	private String codeType;

	@Id
	@Basic(optional = false)
	@Column(name = "xcode", length = 20)
	@Size(max = 50, message = "Code maximum 20 character allowed")
	private String xcode;

	@Size(max = 255, message = "Description maximum 255 character allowed")
	@Column(name = "description", length = 255)
	private String description;

	@Column(name = "parent_code_type", length = 20)
	@Size(max = 20, message = "Parent code maximum 20 character allowed")
	private String parentCodeType;

	@Column(name = "parent_code", length = 20)
	@Size(max = 50, message = "Parent code maximum 20 character allowed")
	private String parentCode;

	@Column(name = "sequence")
	private int sequence = 9999;
}
