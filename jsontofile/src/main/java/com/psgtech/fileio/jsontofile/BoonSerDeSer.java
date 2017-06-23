package com.psgtech.fileio.jsontofile;

import org.boon.Lists;
import org.boon.Maps;
import org.boon.core.Dates;
import org.boon.core.Value;
import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import static org.boon.Boon.puts;

@SuppressWarnings("unused")
public class BoonSerDeSer {
	// @SuppressWarnings({ "unchecked", "null" })
	@SuppressWarnings({ "rawtypes", "unchecked", "hiding" })
	public static void main(String args[]) {
		try {
			ObjectMapper mapper = JsonFactory.create();
			Map StudentMap;

			StudentMap = mapper.readValue(new FileInputStream("c://users/admin/desktop/output-2.json"), Map.class);
			
			// check if has at least one column
			if (StudentMap.size() < 1)
				return;
			String headers[] = new String[StudentMap.keySet().size()];
			int i = -1;
			for (Iterator<String> iterator = StudentMap.keySet().iterator(); iterator.hasNext();)
				headers[++i] = iterator.next();
			// print all headers
			for (i = 0; i < headers.length; i++) {
				System.out.print(i == 0 ? headers[i] : String.format("\t%s", headers[i]));
			}
			System.out.println();
			int index = -1;
			// determine size of data table
			int dataTableSize = StudentMap.values().size();
		    System.out.println(StudentMap);
			// print data table
			for (i = 0; i < dataTableSize; i++) {
			index = -1;
			for (String key : headers)
			System.out.print(++index == 0 ? StudentMap.getOrDefault(key, i): String.format("\t%s", StudentMap.getOrDefault(key, i)));
			System.out.println("table format");
			}
			// loop through all your data and print it to the file
			//FileWriter fos = new FileWriter("c:\\users/admin/desktop/tab-file.csv");
			//PrintWriter dos = new PrintWriter(fos);
			//dos.println("Heading1\tHeading2\tHeading3\t");
			StringBuilder sb = new StringBuilder();
			Iterator<Entry<String, Object>> iterator = StudentMap.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator.next();
				System.out.println("Key : " + entry.getKey() + " Value :" + entry.getValue());
				//dos.print(entry.getValue() + "\t");
				//dos.println();
				sb.append(entry.getKey() + "^ ");
				sb.append("\n");
				sb.append(' ');
				sb.append(entry.getValue() + "^ ");
				sb.append("\n");
				if (iterator.hasNext()) {
					sb.append(entry.getValue() + "^ ");
				}
				 sb.append('^').append(' ');
				 }

			
			//System.out.println("formatting Hash map : " + "\n" + sb);
			//dos.close();
			//fos.close();
			//System.out.println("end of  Hash map : " + "\n");
			//List<Value> list = new ArrayList<Value>(StudentMap.values());
			//System.out.println("list" + list);

			// The string builder used to construct the string
			/*StringBuilder commaSepValueBuilder = new StringBuilder();

			// Looping through the list
			for (int i1 = 0; i1 < list.size(); i1++) {
				// append the value into the builder
				commaSepValueBuilder.append(list.get(i1));

				// if the value is not the last element of the list
				// then append the comma(,) as well
				if (i1 != list.size() - 1) {
					commaSepValueBuilder.append("^ ");
				}
			}
			System.out.println("delimited: " + commaSepValueBuilder.toString());
*/			/*
			 * mapper.writeValue( new
			 * FileOutputStream("c:\\users/admin/desktop/file12.txt"),
			 * sb.toString());
			 */
			// Collections.sort((List<T>) list);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
