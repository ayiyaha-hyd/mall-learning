package com.hyd.mall.tiny.service;

import com.hyd.mall.tiny.common.api.CommonResult;

/**
 * 会员管理Service
 */
public interface UmsMemberService {
	/**
	 * 生成验证码
	 * @param telephone 手机号码
	 * @return
	 */
	CommonResult generateAuthCode(String telephone);

	/**
	 * 判断验证码和手机号码是否匹配
	 * @param telephone 手机号码
	 * @param authCode 验证码
	 * @return
	 */
	CommonResult verifyAuthCode(String telephone, String authCode);
}
