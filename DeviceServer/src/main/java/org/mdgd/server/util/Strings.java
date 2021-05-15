package org.mdgd.server.util;

public class Strings {

	public static <T> boolean isEmpty(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		}
		return false;
	}
}
