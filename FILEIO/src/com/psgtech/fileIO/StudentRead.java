package com.psgtech.fileIO;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.psgtech.fileIO.Student;;
public class StudentRead {
@SuppressWarnings("resource")
public static void main(String[] args) {
	try {
		FileInputStream in = new FileInputStream("c://users/admin/desktop\fos.txt");
		ObjectInputStream oos =new ObjectInputStream(in);
		while(true)
		{
			try {
			Student s = (Student) oos.readObject();
			System.out.println(s.getName()+s.getRollNo()+s.getMarks()+s.address);
		} catch (EOFException e) {
			// TODO: handle exception
			e.printStackTrace();
			break;
		}
			
			
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
