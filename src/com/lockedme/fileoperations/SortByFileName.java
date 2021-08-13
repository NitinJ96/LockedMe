package com.lockedme.fileoperations;

import java.util.Comparator;

public class SortByFileName implements Comparator<String>{

	@Override
	public int compare(String fileName1, String FileName2) {
		// TODO Auto-generated method stub
		return fileName1.compareTo(FileName2);
	}

}
