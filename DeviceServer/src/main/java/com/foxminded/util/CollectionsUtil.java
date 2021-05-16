package com.foxminded.util;

import java.util.Collections;
import java.util.List;

public class CollectionsUtil {

	public static <T> boolean isEmpty(List<T> entities) {
		if (entities == null || entities.isEmpty()) {
			return true;
		}
		return false;
	}

	public static <T> boolean isEmptyWithoutNull(List<T> entities) {
		if (entities == null || entities.isEmpty()) {
			return true;
		}
		entities.removeAll(Collections.singletonList(null));
		if (entities.isEmpty()) {
			return true;
		}
		return false;
	}
}
