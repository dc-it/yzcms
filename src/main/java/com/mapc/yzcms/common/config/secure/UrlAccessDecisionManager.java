package com.mapc.yzcms.common.config.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * api映射地址访问决定管理器
 *
 * @author duchao
 */
@Component
public class UrlAccessDecisionManager extends UnanimousBased {

	@Autowired
	public UrlAccessDecisionManager(UrlMatchVoter urlMatchVoter) {
		super(List.of(urlMatchVoter));
	}
}
