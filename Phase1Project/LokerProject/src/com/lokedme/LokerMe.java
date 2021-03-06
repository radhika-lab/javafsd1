package com.lokedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LokerMe {

	static final String folderpath = "D:\\JavaProjects";

	public static void main(String[] args) {
		int procced = 1;
		do {

			Scanner obj = new Scanner(System.in);
			int ch;
            
			//Menu
			displayMenu();
			System.out.println(" Enter your choice");
			ch = Integer.parseInt(obj.nextLine());

			switch (ch) {
			case 1:
				getAllFiles();
				break;
			case 2:
				createFiles();
				break;
			case 3:
				deleteFile();
				break;
			case 4:
				searchFile();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
			
		} while (procced > 0);
	}
	
    //Display Menu
	public static void displayMenu() {
		System.out.println("************************************");
		System.out.println("\t\tLoked me");
		System.out.println("************************************");
		System.out.println(" 1. Display all files");
		System.out.println(" 2. Add a File");
		System.out.println(" 3. Delete a File");
		System.out.println(" 4. Search a File");
		System.out.println(" 5. Exit");
		System.out.println("####################################");

	}

	public static void getAllFiles() {

		List<String> fileNames = FileManager.getAllFiles(folderpath);

		//Loop
		for (String f : fileNames)
			System.out.println(f);
	}
    
	//Add and crete files
	public static void createFiles() {
		
		//taking input from users
		Scanner obj = new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String> content = new ArrayList<String>();

		System.out.println("Enter file name");
		fileName = obj.nextLine();

		System.out.println("Enter how many lines in the file");
		linesCount = Integer.parseInt(obj.nextLine());

		for (int i = 1; i <= linesCount; i++) {
			System.out.println("Enter line" + ":");
			content.add(obj.nextLine());

		}

		boolean isSaved = FileManager.createFiles(folderpath, fileName, content);

		if (isSaved)
			System.out.println("File and data saved sucessfully");
		else
			System.out.println("Some error occureed");

	}
	
    //delete file
	public static void deleteFile() {
		String fileName;
		
		//taking input from users
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter File name to be deleted");
		fileName = obj.nextLine();

		boolean isDeleted = FileManager.deleteFile(folderpath, fileName);

		if (isDeleted)
			System.out.println("File deleted sucessfully");
		else
			System.out.println("Either File not there or some access issue");

	}

	//search file
	public static void searchFile() {
		String fileName;
		
		//taking input from users
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter File name to be searched");
		fileName = obj.nextLine();

		boolean isFound = FileManager.searchFile(folderpath, fileName);

		if (isFound)
			System.out.println("File is present in the folder");
		else
			System.out.println("file is not present in the folder");

	}

}
