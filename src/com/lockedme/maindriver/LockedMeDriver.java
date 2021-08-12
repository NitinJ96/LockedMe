package com.lockedme.maindriver;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.lockedme.fileoperations.FileOperations;

public class LockedMeDriver {

	private static Scanner scanner = new Scanner(System.in);
	private static String filepath=null;
	private static FileOperations fileOperations = new FileOperations();

	public static void main(String[] args) throws InputMismatchException, Exception {
		boolean quit = false;
		int choice;
		applicationDetails();
		printInstructions();
		while (!quit) {
			System.out.print("\nEnter a choice from the options: ");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
				case 1:
					listFiles();
					break;
				case 2:
					fileOperationInstructions();
					userInterfaceOptions();
					break;
				case 3:
					quit = true;
					break;
				default:
					System.out.println("Kindly enter from the options specified");
					break;
			}
		}
		scanner.close();
		System.out.println("-----------------------Thanks for using the Application--------------------------");
	}

	private static void applicationDetails() {
		System.out.println();
		System.out.println("***************************************************************************************");
		System.out.println("------------------------------------------LockedMe-------------------------------------");
		System.out.println("------------------------------------Developed by - Nitin J-----------------------------");
		System.out.println("***************************************************************************************");
	}

	private static void printInstructions() {
		System.out.println("\n------------------------------------Main Context--------------------------------------");
		System.out.println("Press:");
		System.out.println("\t 1 - To list the current files names in ascending order");
		System.out.println("\t 2 - To view the options for File operations");
		System.out.println("\t 3 - To quit the application");
	}

	private static void fileOperationInstructions() {
		System.out.println("\nEnter:");
		System.out.println("\t A - To 'add' file to the existing directory/folder");
		System.out.println("\t B - To 'delete' a file form the existing directory/folder");
		System.out.println("\t C - To 'search' a file form the existing directory/folder");
		System.out.println("\t D - To return to the main context");
		System.out.println("Note: Options are case insensitive");
	}
	
	private static void userInterfaceOptions() {
		boolean quit = false;
		while (!quit) {
			System.out.print("\nPlease enter your choice of operation: ");
			String option = scanner.nextLine();
			switch (option.toLowerCase()) {
				case "a":
					addFile();
					break;
				case "b":
					deleteFile();
					break;
				case "c":
					searchFile();
					break;
				case "d":
					quit=true;
					printInstructions();
					break;
			}
		}
	}

	private static void listFiles() {
		filepath = changeFilePath();
		fileOperations.listFiles(filepath);
	}

	private static void addFile() {
		filepath = changeFilePath();
		System.out.print("\nEnter the name of the file to be added: ");
		String fileName = scanner.nextLine();
		fileOperations.addFile(filepath, fileName);
		
	}

	private static void deleteFile() {
		filepath = changeFilePath();
		System.out.print("\nEnter the name of the file to be deleted: ");
		String fileName = scanner.nextLine();
		fileOperations.deteleFile(filepath, fileName);
	}

	private static void searchFile() {
		filepath = changeFilePath();
		System.out.print("\nEnter the name of the file to be searched: ");
		String fileName = scanner.nextLine();
		fileOperations.searchFile(filepath, fileName);
	}
	
	private static String changeFilePath() {
		if(filepath!=null) {
			System.out.print("\nTo change your Filepath/Directiry path, Enter 'Y', else 'N': ");
			String option = scanner.nextLine().trim();
			switch(option.toLowerCase()) {
				case "y":
					System.out.print("\nEnter the new Filepath/Directiry path: ");
					filepath = scanner.nextLine();
					break;
				case "n":
					break;
				default:
					System.out.println("Enter the proper option");
					break;
			}
		}else {
			System.out.print("\nEnter the Filepath/Directiry path: ");
			filepath = scanner.nextLine();
		}
		return filepath;
	}
}
