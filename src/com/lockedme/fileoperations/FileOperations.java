package com.lockedme.fileoperations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileOperations {

	private static Scanner sc = new Scanner(System.in);

	/**
	* Method list the files or folders from the specified path 
	* in ascending order
	*
	* @param filePath is base location of the files  
	*/
	public void listFiles(String filePath) {
		try {
			File folder = new File(filePath);
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
				Collections.sort(folderNames,new SortByFileName());
				System.out.println("\nList of all folders:");
				folderNames.forEach(System.out::println);
			} else
				System.out.println("\nNo directorys or folder present");

			if (!fileNames.isEmpty()) {
				Collections.sort(fileNames,new SortByFileName());
				System.out.println("\nList of all files:");
				fileNames.forEach(System.out::println);
			} else
				System.out.print("\nNo Files present");
		} catch (NullPointerException e) {
			System.out.println("Enter a valid directory path");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	* Method adds a file in the specified path 
	* either with or without the content
	*
	* @param filePath is base location of the files  
	* @param fileName is name of the file to be created
	*/
	public void addFile(String filePath, String fileName) {
		try {
			File file = new File(filePath);
			if (file.exists()&&file.isDirectory()) {
				file = new File(filePath+ "\\" + fileName + ".txt");
				if(!file.exists()) {
					System.out.print("Do you wish to Add content to the File? If Yes enter 'Y' else 'N': ");
					String option = sc.nextLine().trim();
					if (option.toLowerCase().equals("y")) {
						List<String> lines = new ArrayList<>();
						sc = new Scanner(System.in);
						System.out.println("After entering the data, type 'END': ");
						while (sc.hasNext()) {
							String data = sc.nextLine();
							if (data.equalsIgnoreCase("end"))
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
						System.out.println("Invalid option");
					}
				}else {
					System.out.println("File already exists");
				}
			} else {
				System.out.println("Invalid Directory path.");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("The system cannot find the path specified");
		}catch (IOException e) {
			System.out.println("The system cannot find the path specified");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	* Method deletes a file from the specified path 
	* with or without content
	*
	* @param  filePath is base location of the files  
	* @param  fileName is name of the file to be deleted
	*/
	public void deteleFile(String filePath, String fileName) {
		try {
			int check = options(filePath, fileName, "search");
			if(check==1) {
				System.out.println(fileName+".txt deleted");
			}else if(check==0) {
				System.out.println("File not Found in the directory");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("The system cannot find the path specified");
		}catch (NullPointerException e) {
			System.out.println("The system cannot find the path specified");
		}
	}

	/**
	* Method searches for a file in the specified path 
	*
	* @param filePath is base location of the files  
	* @param fileName is name of the file to be searched
	*/
	public void searchFile(String filePath, String fileName) {
		try {
			int check = options(filePath, fileName, "search");
			if(check==1) {
				System.out.println(fileName+".txt is found in the directory");
			}else if(check==0){
				System.out.println("File not Found in the directory");
			}
		} catch (FileNotFoundException e) {
			System.out.println("The system cannot find the path specified");
		}catch (NullPointerException e) {
			System.out.println("The system cannot find the path specified");
		}
	}
	
	/**
	* Method returns a boolean value - either 'true' or 'false'
	* based on the specific conditions
	*
	* @param filePath is base location of the files  
	* @param fileName is name of the file to be created
	* @param option determines the mode of operation - either 'deletion' or 'searching'
	*/
	private int options(String filePath, String fileName, String option) throws FileNotFoundException, NullPointerException {
		int flag = 0;
		try {
			File folder = new File(filePath);
			if(folder.exists()&&folder.isDirectory()) {
				File[] fileFolderList = folder.listFiles();
				for (File file : fileFolderList) {
					if (file.isFile()&&file.getName().equals(fileName+".txt")&&option.equals("search")) {
						flag = 1;
						break;
					}
					if(file.isFile()&&file.getName().equals(fileName+".txt")&&option.equals("delete")) {
						file.delete();
						flag=1;
						break;
					}
				}
			}else {
				flag = 2;
				System.out.println("Invalid Directory");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
