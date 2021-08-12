package com.lockedme.fileoperations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations {

	private static Scanner sc = new Scanner(System.in);

	public void listFiles(String filepath) {
		try {
			File folder = new File(filepath);
			File[] fileFolderList = folder.listFiles();
			ArrayList<String> fileNames = new ArrayList<String>();
			ArrayList<String> folderNames = new ArrayList<String>();
			for (File file : fileFolderList) {
				if (file.isFile()) {
					fileNames.add(file.getName());
				} else if (file.isDirectory()) {
					folderNames.add(file.getName());
				}
			}
			if (!folderNames.isEmpty()) {
				System.out.print("\nList of all folders:");
				for (String folderName : folderNames) {
					System.out.println(folderName);
				}
			} else
				System.out.println("\nNo directorys or folder present");

			if (!fileNames.isEmpty()) {
				System.out.println("\nList of all files:");
				for (String fileName : fileNames) {
					System.out.println(fileName);
				}
			} else
				System.out.print("\nNo Files present");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addFile(String filepath, String fileName) {
		try {
			File file = new File(filepath + "\\" + fileName + ".txt");

			// If file doesn't exists, then create it
			if (!file.exists()) {
				System.out.print("Do you wish to Add content to the File? If Yes enter 'Y' else 'N': ");
				String option = sc.nextLine().trim();
				if (option.toLowerCase().equals("y")) {
					List<String> lines = new ArrayList<>();
					sc = new Scanner(System.in);
					System.out.println("After Typing the content Press 1: ");
					while (sc.hasNext()) {
						String data = sc.nextLine();
						if (data.equals("1"))
							break;
						lines.add(data);
					}
					FileOutputStream fos = new FileOutputStream(file);
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
					for (String line : lines) {
						bw.write(line);
						bw.newLine();
					}
					bw.close();
					System.out.println("File created and data entered in the path " + file.getCanonicalPath());
				} else if (option.toLowerCase().equals("n")) {
					file.createNewFile();
					System.out.println("File created in the path " + file.getCanonicalPath());
				} else {
					System.out.println("Kindly enter the right option");
				}
			} else {
				System.out.println("File already exists, kindly enter a new filename.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deteleFile(String filepath, String fileName) {
		System.out.println("Delete");
	}

	public void searchFile(String filepath, String fileName) {

	}

}
