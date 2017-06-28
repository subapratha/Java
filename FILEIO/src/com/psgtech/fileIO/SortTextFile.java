package com.psgtech.fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

public class SortTextFile {
@SuppressWarnings({ "unused", "resource" })
public static void main(String[] args) {
	try {
		BufferedReader br =new  BufferedReader( new FileReader("C://users/admin/desktop"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("c://users/admin/desktop/2.txt"));
		ArrayList<String> list =new ArrayList<String>();
		Collections.sort(list);
		for (String line : list) {
			bw.write(line);
            
            bw.newLine();
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
