package com.lockedme.maindriver;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LockedMeDriver {

	private static Scanner scanner = new Scanner(System.in);
	private final static String FILEPATH=null;

	public static void main(String[] args) throws InputMismatchException, Exception {
		boolean quit = false;
		int choice;
		applicationDetails();
		printInstructions();
		while (!quit) {
			System.out.print("\nEnter an choice from the options: ");
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
		System.out.println("Disclaimer: Options are case insensitive");
	}
	
	private static void userInterfaceOptions() {
		boolean quit = false;
		while (!quit) {
			System.out.print("\nPlease enter your choice of operation: ");
			String option = scanner.next();
			scanner.nextLine();
			switch (option) {
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
		
	}

	private static void addFile() {
		System.out.println("ADD");
	}

	private static void deleteFile() {
		System.out.println("Delete");
	}

	private static void searchFile() {
		System.out.println("Search");
	}
}
