package br.com.springcurso.Util;

import org.apache.commons.codec.digest.DigestUtils;

public class HashUtil {
	
	public static String getSecurehash(String text) {
		String hash = DigestUtils.sha256Hex(text);
		return hash;
	}

}
