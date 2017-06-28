package com.psgtech.fileIO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.ObjectInputStream;
import java.util.*;
import java.util.stream.*;
@SuppressWarnings("unused")
public class SImplefileio {

	    
	    	public static void main(String[] args) throws Exception {
	    	File file =new File("c://users/admin/desktop/file1.txt");
	    	
	    	System.out.println("can the file be read: "+file.canRead());
	    	System.out.println("can the file be Executed:"+file.canExecute());
	    	System.out.println("can the file be written: "+file.canWrite());
	    	System.out.println("can the name of file be got: "+file.getName());
	    	System.out.println("absolute file path: "+file.getAbsolutePath());
	    	System.out.println("length of the file: "+file.length());
	    	System.out.println("usuable space: "+file.getUsableSpace());
	    	System.out.println("hashcode of the file: "+file.hashCode());
	    	System.out.println("path of the file: "+file.getPath());
	    	System.out.println("list roots: "+File.listRoots());;
	    	System.out.println("get free space: "+file.getFreeSpace());
	    	System.out.println("is file a directory: "+file.isDirectory());
	    	System.out.println("is this file hidden: "+file.isHidden());
	    	System.out.println("list file "+file.list());
	    	
	    	// list all the files form the directory
	    	File file1 =new File("c://users/admin/desktop/");
	    	String[] filelist= file1.list();
	    	 File[] files2 = file1.listFiles();
	    	for(String name :filelist)
	    	{
	    	System.out.println("list of files in the directory: "+name);	
	    	}
	    	for(File name1 :files2)
	    	{
	    	System.out.println("list of files in the directory: "+name1);	
	    	}
	    	String[] files = file1.list(new FilenameFilter() {
	             
	            @Override
	            public boolean accept(File dir, String name) {
	                if(name.toLowerCase().endsWith(".txt")){
	                    return true;
	                } else {
	                    return false;
	                }
	            }
	        });
	        for(String f:files){
	            System.out.println(f);
	        }
	    
	    	
	    	}
	    
	}
