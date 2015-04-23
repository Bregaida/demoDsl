package br.com.bdmstyle.client;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Security {

	public static String hmacDigest(String msg,String keyString) {
		String algo = "HmacMD5";

		String digest = null;
		try {
			SecretKeySpec key = new SecretKeySpec(
					(keyString).getBytes("UTF-8"), algo);
			Mac mac = Mac.getInstance(algo);
			mac.init(key);

			byte[] bytes = mac.doFinal(msg.getBytes("ASCII"));

			StringBuffer hash = new StringBuffer();
			for (int i = 0; i < bytes.length; i++) {
				String hex = Integer.toHexString(0xFF & bytes[i]);
				if (hex.length() == 1) {
					hash.append('0');
				}
				hash.append(hex);
			}
			digest = hash.toString();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return digest;
	}
}
