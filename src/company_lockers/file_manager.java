package company_lockers;
import java.util.*;
import java.io.*;

public class file_manager {
	
	public void welcomescreen() {
		System.out.println("Welcome to Company Locker's File Manager");
		System.out.println("Developer : Piyush Ranjan");
		System.out.println("\n Select from the following operations : ");
		
	}
	
	public void operationsdisp(int i) {
		System.out.println("Press 1 : Add/Create a file in the directory.");
		System.out.println("Press 2 : Delete/Remove a file from the directory.");
		System.out.println("Press 3 : Search/Find a file from the directory.");
		if(i>1) {
			System.out.println("Press 4 : Exit");
		}
		
	}
	
	public void addFile() {
		String strPath = "", strName = "";
           Scanner sc=new Scanner(System.in);
           
           System.out.println("Enter the file name:");
            strName = sc.nextLine();
            System.out.println("Enter the file path:");
            strPath = sc.nextLine();
            String ftotal=strPath+"\\"+strName;
            
            File file = new File(ftotal); //initialize File object and passing path as argument  
            boolean result;  
            try   
            {  
            result = file.createNewFile();  //creates a new file  
            if(result)      // test if successfully created a new file  
            {  
            System.out.println("file created "+file.getCanonicalPath()); //returns the path string  
            }  
            else  
            {  
            System.out.println("File already exist at location: "+file.getCanonicalPath());  
            }  
            }   
            catch (IOException e)   
            {  
            e.printStackTrace();    //prints exception if any  
            }         
            }  
           
        
    
		
	public void remFile() {
		String path;
		System.out.println("Enter the file path you want to delete");
		Scanner sc=new Scanner(System.in);
		path=sc.nextLine();
		File file= new File(path);

		if (file.delete()) {
			System.out.println("File deleted successfully");
		}
		else {
			System.out.println("Failed to delete the file");
		}
		
	}
	public void searchFile() {
		Scanner sc=new Scanner(System.in);
		String fpath;
		String fname;
		System.out.println("Enter file path.");
		fpath=sc.nextLine();
		System.out.println("Enter file name");
		fname=sc.nextLine();
		File directory = new File(fpath);
		  
        // store all names with same name
        // with/without extension
        String[] flist = directory.list();
        int flag = 0;
        if (flist == null) {
            System.out.println("Empty directory.");
        }
        else {
  
            // Linear search in the array
            for (int i = 0; i < flist.length; i++) {
                String filename = flist[i];
                if (filename.equalsIgnoreCase(fname)) {
                    System.out.println(filename + " found");
                    flag = 1;
                }
            }
        }
        if (flag == 0) {
            System.out.println("File Not Found");
        }
    }
		

	public static void main(String[] args) {
		file_manager ob=new file_manager();
		ob.welcomescreen();
		int i=1;
		
		while(i!=0) {
			
			ob.operationsdisp(i);
		int action;
		Scanner sc=new Scanner(System.in);
		action=sc.nextInt();
		if(action==1) {
			ob.addFile();
		}
		else if(action==2) {
			ob.remFile();
		}
		else if(action==3) {
			ob.searchFile();
		}
		else if(action==4) {
			System.exit(0);
		}
		else {
			System.out.println("Error : Wrong Input. \nPlease try again. \n");
		}
		i++;
		

	}

}
}
