package com.psgtech.fileIO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 import com.psgtech.fileIO.Student;
//Student Class
 
 
//nameCompare Class to compare the names
 
class nameCompare implements Comparator<Student>
{
    @Override
    public int compare(Student s1, Student s2)
    {
        return s1.Name.compareTo(s2.Name);
    }
}
 
//marksCompare Class to compare the marks
 
class marksCompare implements Comparator<Student>
{
    @Override
    public int compare(Student s1, Student s2)
    {
        return Double.compare(s2.Marks , s1.Marks);
    }
}

public class Stu {
	 
	    public static void main(String[] args)throws IOException
	    {
	        //Creating BufferedReader object to read the input text file
	         
	        BufferedReader reader = new BufferedReader(new FileReader("C://users/admin/desktop/Studentdetails.txt"));
	         
	        //Creating ArrayList to hold Student objects
	         
	        ArrayList<Student> studentRecords = new ArrayList<Student>();
	         
	        //Reading Student records one by one
	         
	        String currentLine = reader.readLine();
	         
	        while (currentLine != null)
	        {
	            String[] studentDetail = currentLine.split(" ");
	            int rollNo =Integer.valueOf(studentDetail[0]);
	             
	            String name = studentDetail[1];
	             
	            Double marks = Double.valueOf(studentDetail[2]);
	         
	            String address= studentDetail[3];
	            
	            //Creating Student object for every student record and adding it to ArrayList
	             
	            studentRecords.add(new Student(rollNo, name, marks, address));
	             
	            currentLine = reader.readLine();
	        }
	         
	        //Sorting ArrayList studentRecords based on marks
	         
	        Collections.sort(studentRecords, new marksCompare());
	         
	        //Creating BufferedWriter object to write into output text file
	         
	        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\output.txt"));
	         
	        //Writing every studentRecords into output text file
	         
	        for (Student student : studentRecords) 
	        {
	            writer.write(student.Name);
	             
	            writer.write(" "+student.Marks);
	             
	            writer.newLine();
	        }
	         
	        //Closing the resources
	         
	        reader.close();
	         
	        writer.close();
	    }
	
}
