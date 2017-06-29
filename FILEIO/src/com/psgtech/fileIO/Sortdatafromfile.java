package com.psgtech.fileIO;

import java.io.FileReader;
import java.io.FileWriter;
//import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;


import java.io.IOException;
import java.util.ArrayList;

public class Sortdatafromfile {

	@SuppressWarnings({ "unused" })
	public static void main(String[] args) {
		BufferedReader reader = null;

		BufferedWriter writer = null;

		// Create an ArrayList object to hold the lines of input file

		ArrayList<String> lines = new ArrayList<String>();

		try {
			// Creating BufferedReader object to read the input file

			reader = new BufferedReader(new FileReader("C://users/admin/desktop/1.txt"));

			// Reading all the lines of input file one by one and adding them
			// into ArrayList

			String currentLine = reader.readLine();
			


			// Sorting the ArrayList
			/*int[] arr2 = dodelectionsort(arr);
			System.out.print("Sorting Array using Selection Sort Technique..\n" + arr2);
			System.out.print("Now the Array after Sorting is :\n");
			for (i = 0; i < arr2.length; i++) {
				System.out.print(arr2[i] + "  ");
			}
*/
			// Creating BufferedWriter object to write into output file

			writer = new BufferedWriter(new FileWriter("C://users/admin/desktop/output.txt"));

			// Writing sorted lines into output file
			
			
				
				 // writer.write((int) lnarr[i]);
				  
				  writer.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Closing the resources

			try {
				if (reader != null) {
					reader.close();
				}

				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unused")
	private static int[] dodelectionsort(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				int small;
				if (arr[j] < arr[index]) {
					index = j;
					small = arr[index];
					arr[index] = arr[i];
					arr[i] = small;

				}
			}

		}
		return arr;

	}

}