
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileOperations {
	static String FILEPATH="C:\\root";
	File rootDirectory=new File(FILEPATH);
	
	void listFiles() //method to list files
	{
		//String[] fileNames;
		//fileNames=rootDirectory.list();
		try {
			List<String> fileNames=Files.list(Paths.get(FILEPATH)).map(f->f.getFileName().toString()).collect(Collectors.toList()); //read and convert to list
			Collections.sort(fileNames); //sort file names
			if(!fileNames.isEmpty())
			{
				for(String fileName:fileNames)
				{
					System.out.println(fileName);
				}
			}
			else
			{
				System.out.println("Folder empty");
			}
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
	}
	
	void addFile() //method to add file
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name of the file");
		String newFileName=sc.nextLine();
		
		String[] fileNames;
		fileNames=rootDirectory.list();
		for(String fName:fileNames)
		{
			if(newFileName.equalsIgnoreCase(fName))
			{
				
				System.out.println("File Name already exists");
				return;
			}
		}
		File newFile=new File(FILEPATH+"\\"+newFileName);
		try {
		newFile.createNewFile();
		System.out.println("File added successfully");
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
	void deleteFile() //method to delete file
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name of the file to delete");
		String fileName=sc.nextLine();
		
		String[] list;
		list=rootDirectory.list();
		for(String fName:list)
		{
			if(fileName.equalsIgnoreCase(fName))
			{
				File file=new File(FILEPATH+"\\"+fileName);
				file.delete();
				System.out.println("File deleted");
				return;
			}
			else
			{
				continue;
			}
		}
		System.out.println("File Not Found");
	}
	
	void searchFile() //method to search for the file
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name of the file to search");
		String fileName=sc.nextLine();
		
		String[] list;
		list=rootDirectory.list();
		for(String fName:list)
		{
			if(fileName.equals(fName))
			{
				System.out.println("The file "+ fileName+" is present");
				return;
			}
			else
			{
				continue;
			}
		}
		System.out.println("File not found");
	}
	
}
