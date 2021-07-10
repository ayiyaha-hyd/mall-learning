package com.hyd.mall.tiny.service.impl;

import com.hyd.mall.tiny.common.api.CommonResult;
import com.hyd.mall.tiny.service.RedisService;
import com.hyd.mall.tiny.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {
	@Value("${redis.key.prefix.authCode}")
	private String redisKeyPrefixAuthCode;
	@Value("${redis.key.expire.authCode}")
	private Long authCodeExpireSeconds;
	@Autowired
	private RedisService redisService;

	/**
	 * 生成验证码
	 * @param telephone 手机号码
	 * @return
	 */
	@Override
	public CommonResult generateAuthCode(String telephone) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			sb.append(random.nextInt(10));
		}
		//验证码绑定手机号并存储到redis
		redisService.set(redisKeyPrefixAuthCode + telephone, sb.toString());
		redisService.expire(authCodeExpireSeconds + telephone, authCodeExpireSeconds);
		return CommonResult.success("获取验证码成功", sb.toString());
	}

	/**
	 * 对输入的验证码进行校验
	 * @param telephone 手机号码
	 * @param authCode 验证码
	 * @return
	 */
	@Override
	public CommonResult verifyAuthCode(String telephone, String authCode) {
		if (StringUtils.isEmpty(authCode)) {
			return CommonResult.failed("请输入验证码");
		}
		String realAuthCode = redisService.get(redisKeyPrefixAuthCode + telephone);
		boolean result = authCode.equals(realAuthCode);
		if (result) {
			return CommonResult.success("验证码校验成功", null);
		} else {
			return CommonResult.failed("验证码不正确");
		}
	}
}
