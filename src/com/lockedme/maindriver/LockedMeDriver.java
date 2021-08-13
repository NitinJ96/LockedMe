package com.lockedme.maindriver;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.lockedme.fileoperations.FileOperations;

public class LockedMeDriver {

	private static Scanner scanner = new Scanner(System.in);
	private static String filePath = null;
	private static FileOperations fileOperations = new FileOperations();

	public static void main(String[] args) {
		boolean quit = false;
		int choice = 0;
		applicationDetails();
		printInstructions();
		while (!quit) {
			try {
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
				case 4:
					printInstructions();
					break;
				default:
					System.out.println("Invalid Option: kindly enter the choice from the options specified");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid option: kindly enter an 'integer' choice as mentioned from the options.");
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Exception Occured, Try Again");
			}
		}
		scanner.close();
		System.out.println("-----------------------Thanks for using the Application--------------------------");
	}

	/**
	* Method displays the application details
	*/
	private static void applicationDetails() {
		System.out.println();
		System.out.println("***************************************************************************************");
		System.out.println("--------------------------------------LockedMe Pvt Ltd---------------------------------");
		System.out.println("------------------------------------Developed by - Nitin J-----------------------------");
		System.out.println("***************************************************************************************");
	}

	/**
	* Method displays the main menu details
	*/
	private static void printInstructions() {
		System.out.println("\n------------------------------------Main Context--------------------------------------");
		System.out.println("Press:");
		System.out.println("\t 1 - To list the current files/folder names in ascending order");
		System.out.println("\t 2 - To view the options for File operations");
		System.out.println("\t 3 - To quit the application");
		System.out.println("\t 4 - To view the main instructions");
	}

	/**
	* Method displays the sub menu details
	*/
	private static void fileOperationInstructions() {
		System.out.println("\nEnter:");
		System.out.println("\t A - To 'add' file to the existing directory/folder");
		System.out.println("\t B - To 'delete' a file form the existing directory/folder");
		System.out.println("\t C - To 'search' a file form the existing directory/folder");
		System.out.println("\t D - To return to the main context");
		System.out.println("\t E - To view the instructions");
		System.out.println("Note: Options are case insensitive");
	}

	/**
	* Method is used to navigate through the sub menu
	*/
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
				quit = true;
				printInstructions();
				break;
			case "e":
				fileOperationInstructions();
				break;
			default:
				System.out.println("Invalid Option: kindly enter the choice of operation from the options specified");
				break;
			}
		}
	}

	/**
	* Method calls the listFiles of FileOperation class
	*/
	private static void listFiles() {
		filePath = changeFilePath();
		fileOperations.listFiles(filePath);
	}

	/**
	* Method calls the addFile of FileOperation class
	*/
	private static void addFile() {
		filePath = changeFilePath();
		System.out.print("Enter the name of the file to be added: ");
		String fileName = scanner.nextLine();
		fileOperations.addFile(filePath, fileName);

	}

	/**
	* Method calls the deleteFiles of FileOperation class
	*/
	private static void deleteFile() {
		filePath = changeFilePath();
		System.out.print("Enter the name of the file to be deleted: ");
		String fileName = scanner.nextLine();
		fileOperations.deteleFile(filePath, fileName);
	}
	
	/**
	* Method calls the searchFile of FileOperation class
	*/
	private static void searchFile() {
		filePath = changeFilePath();
		System.out.print("Enter the name of the file to be searched: ");
		String fileName = scanner.nextLine();
		fileOperations.searchFile(filePath, fileName);
	}

	/**
	* Method used for providing or changing the filePath
	*/
	private static String changeFilePath() {
		if (filePath != null) {
			System.out.print("To change your Filepath/Directiry path, Enter 'Y', else 'N': ");
			String option = scanner.nextLine().trim();
			switch (option.toLowerCase()) {
			case "y":
				System.out.print("Enter the new Filepath/Directiry path: ");
				filePath = scanner.nextLine();
				break;
			case "n":
				break;
			default:
				System.out.println("Invalid Option, using "+filePath);
				break;
			}
		} else {
			System.out.print("Enter the Filepath/Directiry path: ");
			filePath = scanner.nextLine();
		}
		return filePath;
	}
}
