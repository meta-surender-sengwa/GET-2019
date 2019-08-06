package ds.virtualcommandprompt;

import java.util.Scanner;

/**
 * @author Surender
 * This class creates a virtual command prompt - user interface
 */
public class VirtualCommandPrompt {

	public static void main(String[] args) {

		Directory currentDirectory = new Directory("Root", null);
		
		Scanner userInput = new Scanner(System.in);
		boolean exit = false;
		
		System.out.println("::::::::: Metacube VCP :::::::::");
		
		while (!exit) {
			
			System.out.print(currentDirectory.getDirectoryPath());
			String dirName = "";
			
			String command = userInput.nextLine();
			String commands[] = command.split(" ");
			
			if (commands.length > 2) {
			} else if (commands.length == 1) {
				command = commands[0];
			} else {
				dirName = commands[1];
				command = commands[0];
			}

			switch (command) {
			
			case ("ls"): {
				for (String dir : currentDirectory.getDetailListOfSubDirectory()) {
					System.out.println(dir);
				}
				break;
			}
			
			case ("exit"): {
				exit = true;
				System.out.println("Thank You");
				break;
			}
			
			case ("tree"): {
				Directory directory = currentDirectory;
				while(directory.getParent() != null){
					directory = directory.getParent();
				}
				VirtualCommandPrompt.printDirectoryTree(directory,0,true);
				System.out.println();
				break;
			}
			
			case ("bk"): {
				try {
					currentDirectory = currentDirectory.goBackToParentDirectory();
				} catch (Exception ex) {
					System.out.println("You are on root directory!!!");
				}
				break;
			}
			
			case ("mkdir"): {
				if(dirName.equalsIgnoreCase("")) {
					System.out.println("Invalid directory name!!!");
					break;
				}
				currentDirectory.addSubDirectory(dirName);
				break;
			}
			
			case ("cd"): {
				if(dirName.equals("")) {
					System.out.println("Invalid directory name!!!");
					break;
				}
				try {
					currentDirectory = currentDirectory.changeCurrentDirectory(dirName);
				} catch (Exception ex) {
					System.out.println("Directory not available!!!");
				}
				break;
			}
			
			case ("find"): {
				String foundDirectories[] = currentDirectory.findDirectory(dirName);
				if(foundDirectories.length == 0){
					System.out.println("No directory found!!!");
				}
				for (String path : foundDirectories) {
					System.out.println(path);
				}
				break;
			}
			
			default: {
				System.out.println("Invalid Command!!!");
			}
			}
		}
	}
	
	/**
	 * This method print the tree structure of directories
	 * @param startDIrectory current object of root directory
	 * @param dirLevel level of current directory
	 * @param isParentLast boolean is true if parent of current directory is last directory in its parent
	 */
	private static void printDirectoryTree(Directory startDirectory,int dirLevel,boolean isParentLast) {

		int totalSubDir = startDirectory.getSubDirectories().size();
		
		for(Directory directory : startDirectory.getSubDirectories()) {
			int directoryLevel = dirLevel;
			
			if(totalSubDir > 0) {
				if(directoryLevel == 0) {
					//System.out.print("\n");
					if(totalSubDir >1) {
						System.out.print("\u251c\u2500\u2500\u2500\u2500\u2500\u2500\u2500" + directory.getName());
						totalSubDir--;
						VirtualCommandPrompt.printDirectoryTree(directory, dirLevel + 1, false);
						System.out.print("\n");
					} else {
						System.out.print("\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500" + directory.getName());
						VirtualCommandPrompt.printDirectoryTree(directory, dirLevel + 1, true);
					}
				} else {
					System.out.print("\n");
					if(directoryLevel-1 == 0 || !isParentLast ){
						System.out.print("\u2502");
					}
					
					while(directoryLevel != 0) {

						if(!isParentLast &&  directoryLevel >0 && directoryLevel <= dirLevel-1){
							System.out.print("\u2502");
						}
						System.out.print("\t");
						directoryLevel--;
					}

					if(totalSubDir >1) {
						System.out.print("\u251c\u2500\u2500\u2500\u2500\u2500\u2500\u2500" + directory.getName());
						totalSubDir--;
						VirtualCommandPrompt.printDirectoryTree(directory, dirLevel + 1, false);
					} else {
						System.out.print("\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500" + directory.getName());
						VirtualCommandPrompt.printDirectoryTree(directory, dirLevel + 1, true);
					}
				}
			}
		}
	}
}
