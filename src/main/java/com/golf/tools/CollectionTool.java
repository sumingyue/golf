package com.golf.tools;

import java.util.List;

public class CollectionTool {

	public static <T> List<T> fixList(List<T> lists, int size, boolean isFixed) {
		if (isFixed) {
			return fixedList(lists, size);
		} else {
			return fixList(lists, size);
		}
	}

	private static <T> List<T> fixList(List<T> lists, int size) {
		int len = lists.size();
		if (len < size) {
			return lists;
		} else {
			return lists.subList(0, size);
		}
	}

	private static <T> List<T> fixedList(List<T> lists, int size) {
		int len = lists.size();

		if (len < size) {
			int t = size - len;

			if (len >= 1) {
				for (int i = 0; i < t; i++) {
					lists.add(lists.get(0));
				}
			}
			return lists;
		} else if (len == size) {
			return lists;
		} else {
			return lists.subList(0, size);
		}
	}
}
