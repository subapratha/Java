package com.psgtech.fileIO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

@SuppressWarnings("unused")
public class FunctionsInFile {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			FileReader f = new FileReader("c://users/admin/desktop/file1.txt");
			BufferedReader br= new BufferedReader(f);
			String line="", str="";
			int a=0, b=0;
			while ((line=br.readLine())!=null)
			{
				str+=line+"";
				b++;
			}
			System.out.println(str+"\n"+" has "+b+" lines totally");
			StringTokenizer st =new StringTokenizer(str) ;
			while(st.hasMoreTokens())
				{String s=st.nextToken();
				Object t=st.nextElement();
				
			a++;
			//System.out.println(s);
			System.out.println(t);
				}
			System.out.println("file has"+a+"words");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
