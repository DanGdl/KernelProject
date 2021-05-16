package com.foxminded.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	public static <T> List<T> filterNonNullToList(Stream<T> stream) {
		if (stream == null) {
			return new ArrayList<>(0);
		}
		return stream.filter(e -> e != null).collect(Collectors.toList());
	}

	public static <T> Stream<T> filterNonNull(Stream<T> stream) {
		if (stream == null) {
			return new ArrayList<T>(0).stream();
		}
		return stream.filter(e -> e != null);
	}

	public static <T> List<T> filterNonNullToList(List<T> list) {
		if (list == null) {
			return new ArrayList<>(0);
		}
		return list.stream().filter(e -> e != null).collect(Collectors.toList());
	}

	public static <T> Stream<T> filterNonNull(List<T> list) {
		if (list == null)
			return new ArrayList<T>(0).stream();
		return list.stream().filter(e -> e != null);
	}

	public static <T> List<T> filterNonNullToList(Iterable<T> iterable) {
		final List<T> entities = new LinkedList<T>();
		iterable.forEach(e -> entities.add(e));
		return entities;
	}
}
