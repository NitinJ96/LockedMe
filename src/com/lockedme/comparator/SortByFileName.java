package com.lockedme.comparator;

import java.util.Comparator;

public class SortByFileName implements Comparator<String>{

	@Override
	public int compare(String fileName1, String fileName2) {
		// TODO Auto-generated method stub
		return fileName1.compareTo(fileName2);
	}
}
