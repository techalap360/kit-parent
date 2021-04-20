package com.kit.api.impl;

import org.springframework.beans.factory.annotation.Value;

import com.kit.api.KITSessionManager;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Dec 28, 2020
 */
@Data
public abstract class AbstractSessionManager implements KITSessionManager {

	@Value("${default.business-id:900010}")
	private String defaultBusinessId;

//	@Override
//	public LoggedInUserDetails getLoggedInUserDetails() {
//		LoggedInUserDetails user = new LoggedInUserDetails();
//
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if(auth == null || !auth.isAuthenticated()) return null;
//
//		Object principal = auth.getPrincipal();
//		if(principal instanceof MyUserDetails) {
//			MyUserDetails mud = (MyUserDetails) principal;
//			user.setUsername(mud.getUsername());
//			user.setEmailAddress(mud.getEmailAddress());
//			user.setBusinessId(mud.getBusinessId());
//			Arrays.stream(mud.getRoles().split(",")).forEach(role -> user.getRoles().add(role));
//		}
//
//		Object details = auth.getDetails();
//		if (details instanceof WebAuthenticationDetails) {
//			String ip = ((WebAuthenticationDetails) details).getRemoteAddress();
//			if(StringUtils.isNotBlank(ip)) user.setIpAddress(ip);
//		}
//
//		return user;
//	}

	@Override
	public String getBusinessId() {
//		String businessId = defaultBusinessId;
//
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if(auth == null || !auth.isAuthenticated()) return businessId;
//
//		Object principal = auth.getPrincipal();
//		if(principal instanceof MyUserDetails) {
//			MyUserDetails mud = (MyUserDetails) principal;
//			businessId = mud.getBusinessId();
//		}

		return "900000";
	}
}
