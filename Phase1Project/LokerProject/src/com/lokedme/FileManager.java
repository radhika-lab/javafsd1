package com.lokedme;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
   
   public static List<String> getAllFiles(String folderpath)
   {
	   File f1=new File(folderpath);
	   
	   File[] listofFiles = f1.listFiles();
	   List<String> fileNames= new ArrayList<String>();
	   
	   for(File f:listofFiles)
		   fileNames.add(f.getName());
	   
	   return fileNames;
	   
	   
   }
   /**
    * 
    * @param folderpath
    * @param createFiles
    * @param content
    * @return boolean
    */
public static boolean createFiles(String folderpath,String fileName,List<String>content)
{
	try {
		
		File f1=new File(folderpath,fileName);
		FileWriter fw= new FileWriter(f1);
		
		for(String s:content)
		{
			fw.write(s+"\n");
		}
		fw.close();
		return true;
		
	}
	catch(Exception ex){
		
	}
	return false;
		
	
	
}
/**
 * 
 * @param folderpath
 * @param delete file
 * @return boolean
 */

public static boolean deleteFile(String folderpath,String filename)
{
	File file=new File(folderpath+"\\"+filename);
	
	try {
		if(file.delete())
			return true;
		else
			return false;
		
	}
	catch(Exception ex){
		return false;
	}

}

/**
 * 
 * @param folderpath
 * @param search file
 * @return boolean
 */
public static boolean searchFile(String folderpath,String filename)
{
File file=new File(folderpath+"\\"+filename);
	
	try {
		if(file.exists())
			return true;
		else
			return false;
		
	}
	catch(Exception ex){
		return false;
	}
	
}










}
