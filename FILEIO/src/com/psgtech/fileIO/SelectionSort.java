package com.psgtech.fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SelectionSort {
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		try {
			FileReader f = new FileReader("C://users/admin/desktop/1.txt");
			BufferedReader br = new BufferedReader(f);
			String s = null;
			//sorting using selection sort using for loop
			int[] arr = { 1, 56, 34, 87, 23 };
			int[] arr2 = dodelectionsort(arr);
			 for(int i:arr2){
			System.out.println();
		            System.out.print(i);
		            System.out.print(", ");
		        }
			List<Integer> list = new ArrayList<Integer>();
			// sorting using collections
			while ((s = br.readLine()) != null) {
				int j = Integer.parseInt(s);
				list.add(j);
			}
			//System.out.println("b4" + list);
			Collections.sort(list);
			Iterator<Integer> it = list.iterator();
			while (it.hasNext()) {

				//System.out.println(it.next());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static int[] dodelectionsort(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length - 1; i++) {
             int index=i;
			for (int j = i+1; j < arr.length; j++) {
				int small;
				if (arr[j] < arr[index]) {
					index=j;
					small = arr[index];
					arr[index] = arr[i];
					arr[i] = small;

				}
			}
			
		}
		return arr;

	}
}
