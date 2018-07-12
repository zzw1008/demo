package com.zzw.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:
 * Jwt配置
 * @version 1.0
 * @Author zzw
 * @Date: 2018/7/11 10:02
 */
public class JwtUtil {
	private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);
	private static String secret = "k9aWTF*65U^4ODzkIVyHgGVfRrSi0V4&TITrB4zzO#6wJGh*Sids4uAzmCN$ii7RJBGmQmOjEpJQ2Ce#^y&5UBjjRLB7*kfX$gd";
	private static final Algorithm algorithm;
	private static final JWTVerifier verifier;

	public JwtUtil() {
	}

	public static void setSecret(String secret) {
		secret = secret;
	}

	public static JWTCreator.Builder builder() {
		return JWT.create();
	}

	public static String sign(JWTCreator.Builder builder) {
		return builder.sign(algorithm);
	}

	public static DecodedJWT verify(String token) throws JWTVerificationException {
		return verifier.verify(token);
	}

	static {
		algorithm = Algorithm.HMAC256(secret);
		verifier = JWT.require(algorithm).build();
	}
}
