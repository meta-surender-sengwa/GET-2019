package ds.virtualcommandprompt;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Surender
 * This class represents directory in file system
 */
public class Directory {

	final private String name;
	final private Directory parent;
	final private String dateTime;
	
	private HashMap<String, Directory> subDirectories = new HashMap<String, Directory>();

	/**
	 * Constructor
	 * @param name is the name of directory
	 * @param parent object of Directory representing parent directory
	 */
	public Directory(String name, Directory parent) {
		this.name = name;
		this.parent = parent;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.dateTime = formatter.format(new Date());
	}

	public String getDateTime() {
		return dateTime;
	}

	public Directory getParent() {
		return parent;
	}

	public String getName() {
		return name;
	}

	/**
	 * Method to return the Collection containing all sub directories of current directory
	 * @return Collection containing all sub directory of current directory
	 */
	public Collection<Directory> getSubDirectories() {
		return subDirectories.values();
	}

	/**
	 * Method to add new sub directory to current directory
	 * @param name is the name of sub directory
	 * @return true if directory is added else return false
	 */
	public boolean addSubDirectory(String name) {
		Directory subDirectory = new Directory(name, this);
		subDirectories.put(name, subDirectory);
		return true;
	}

	/**
	 * Method to change the current directory to given sub directory
	 * @param nameOfSubDirectory is the name of sub directory
	 * @return the object of sub directory
	 * @throws Exception if given sub directory is not available
	 */
	public Directory changeCurrentDirectory(String nameOfSubDirectory) throws Exception {

		for (Directory subDirectory : subDirectories.values()) {
			if (subDirectory.getName().equalsIgnoreCase(nameOfSubDirectory)) {
				return subDirectory;
			}
		}
		
		try {
			throw new Exception("Directory not available");
		} catch (Exception ex) {
			throw ex;
		}

	}

	/**
	 * Method to change the current directory to its parent directory
	 * @return the object of parent directory
	 * @throws Exception
	 */
	public Directory goBackToParentDirectory() throws Exception {

		try {
			if (this.parent == null) {
				throw new Exception("Directory not available");
			}
			return this.parent;
			
		} catch (Exception ex) {
			throw ex;
		}

	}

	/**
	 * Method to find and return all the sub directory of current directory
	 * @return an array of String containing name date and time of creation of all sub directory of current directory
	 */
	public String[] getDetailListOfSubDirectory() {

		int totalDirectories = subDirectories.size();
		String[] listOfSubDirectory = new String[totalDirectories + 1];
		int directoryIndex = 0;
		
		for (Directory directory : subDirectories.values()) {
			listOfSubDirectory[directoryIndex] = directory.getDateTime() + " " + directory.getName();
			directoryIndex++;
		}
		
		listOfSubDirectory[directoryIndex] = totalDirectories + " Folders";
		return listOfSubDirectory;
	}

	/**
	 * Method to find and return the path from root to current directory
	 * @return a String containing the path form root to current directory
	 */
	public String getDirectoryPath() {

		String directoryPath = "";
		
		if (this.parent == null) {
			directoryPath = this.getName() + ":>";
			return directoryPath;
		}
		
		directoryPath = "\\" + this.getName() + ">";
		Directory parentDirectory = this.getParent();
		
		while (parentDirectory.parent != null) {
			directoryPath = "\\" + parentDirectory.getName() + directoryPath;
			parentDirectory = parentDirectory.parent;
		}
		
		directoryPath = parentDirectory.getName() + ":" + directoryPath;

		return directoryPath;
	}

	/**
	 * Method to find path from current directory to given start directory
	 * @param startDirectory is an object of directory till path need to find
	 * @return String containing path from current directory to given start directory
	 */
	private String getDirectoryPath(Directory startDirectory) {

		String directoryPath = "";
		
		if (this.getName().equalsIgnoreCase(startDirectory.getName())) {
			directoryPath = ".\\" + this.getName();
			return directoryPath;
		}
		
		directoryPath = "\\" + this.getName();
		Directory parentDirectory = this.getParent();
		
		while (!parentDirectory.getName().equalsIgnoreCase(startDirectory.getName())) {
			directoryPath = "\\" + parentDirectory.getName() + directoryPath;
			parentDirectory = parentDirectory.parent;
		}
		
		directoryPath = "." + directoryPath;

		return directoryPath;
	}

	/**
	 * Method to find given directory in current directory and its sub directories Recursively
	 * @param directoryName is the name of directory to find
	 * @return the path of all matched directories form current directory
	 */
	public String[] findDirectory(String directoryName) {

		ArrayList<String> foundDirectoriesPath = new ArrayList<String>();
		
		foundDirectoriesPath = findDirectoryInSubDirectories(foundDirectoriesPath, this, this, directoryName);
		
		Object[] objArr = foundDirectoriesPath.toArray();
		String[] directoriesPath = Arrays.copyOf(objArr, objArr.length, String[].class);
		return directoriesPath;
	}

	/**
	 * Method to find given directory in all sub directory of given current directory
	 * @param foundDirectoriesPath ArrayList containing path of found directories till now
	 * @param startDirectory object of directory till the path need to find
	 * @param currentDirectory object of current directory which sub directories need to be check
	 * @param directoryName name of directory which need to be find
	 * @return path of all found directories from start directory
	 */
	private ArrayList<String> findDirectoryInSubDirectories(ArrayList<String> foundDirectoriesPath,
			Directory startDirectory, Directory currentDirectory, String directoryName) {

		for (Directory directory : currentDirectory.subDirectories.values()) {

			if (directory.getName().equalsIgnoreCase(directoryName)) {
				foundDirectoriesPath.add(directory.getDirectoryPath(startDirectory));
			}
			
			findDirectoryInSubDirectories(foundDirectoriesPath, startDirectory, directory, directoryName);
		}

		return foundDirectoriesPath;
	}
}
