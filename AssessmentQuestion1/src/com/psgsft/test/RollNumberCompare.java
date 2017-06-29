package com.psgsft.test;

import java.util.Comparator;
import com.psgsft.test.StudentDetails;

public class RollNumberCompare implements Comparator<StudentDetails>{

	//rollNumberCompare Class to compare the names

			    @Override
			    public int compare(StudentDetails s1, StudentDetails s2)
			    {
			        return s1.rollNo.compareTo(s2.rollNo);
			    }

			


}
