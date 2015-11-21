package com.jcin.cms.common;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jcin.cms.modules.syst.domain.User;

/**
 * <p>
 * User: Zhang Kaitao
 * <p>
 * Date: 14-1-28
 * <p>
 * Version: 1.0
 */
public class PasswordHelper {

	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	private static String algorithmName = "md5";
	private static int hashIterations = 1;

	public void setRandomNumberGenerator(
			RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}

	public static String encryptPassword(String password) {
		byte[] salt = password.substring(0, 6).getBytes();

		String newPassword = new SimpleHash(algorithmName, password,
				ByteSource.Util.bytes(salt), hashIterations).toHex();
		return newPassword;
	}

	public static boolean validatePassword(String plainPassword, String password) {
		byte[] salt = plainPassword.substring(0, 6).getBytes();

		String newPassword = new SimpleHash(algorithmName, plainPassword,
				ByteSource.Util.bytes(salt), hashIterations).toHex();
		if (newPassword.equals(password)) {
			return true;
		}
		return false;
	}
}