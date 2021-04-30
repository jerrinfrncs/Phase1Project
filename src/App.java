import java.util.Scanner;


public class App {
	FileOperations fp=new FileOperations();
	void welcomeScreen()
	{
		System.out.println("-------------------Application Name: LockedMe.com------------------");
		System.out.println("------------------Developer Name: Jerrin Joe Francis---------------");
	}
	void primaryMenu()
	{	
		Scanner sc=new Scanner(System.in);
		int option;
		do{
			System.out.println("Enter 1 to list file");
			System.out.println("Enter 2 to add, delete or search for files");
			System.out.println("Enter 3 to exit");
			option=sc.nextInt();
			switch(option)
			{
				case 1:
					fp.listFiles();
					break;
				case 2:
					secondaryMenu();
					break;
				case 3:
					System.out.println("Exiting application");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid a choice");
					break;
			}
		}while(option!=3);
	}

	void secondaryMenu()
	{
		Scanner sc=new Scanner(System.in);
		int option;
		do {
			System.out.println("Enter 1 to add file");
			System.out.println("Enter 2 to delete a file");
			System.out.println("Enter 3 to search a file");
			System.out.println("Enter 4 to go back to previous menu");
			option=sc.nextInt();
			switch(option)
			{
				case 1:
					fp.addFile();
					break;
				case 2:
					fp.deleteFile();
					break;
				case 3:
					fp.searchFile();
					break;
				case 4:
					break;
				default:
					System.out.println("Invalid choice");
					break;
			}
		}while(option!=4);
		primaryMenu();
	}
	public static void main(String args[])
	{
		App app=new App();
		app.welcomeScreen();
		app.primaryMenu();

	}
}
