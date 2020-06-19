/* Amrita Kohli Lab 6 */
package driver;

import java.util.ArrayList;

import exception.*;
import util.*;
import model.*;
import java.io.*;

public class Driver2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws StudentGradingException, IOException {
		Student [] lab = new Student[40];
		Statistics stat = new Statistics();
		String filename = "//home//akamritakohli//Lab6//src//StuData.txt";
		
		try
		{
			lab = FileIO.readFile(filename, lab);
		}
		catch(StudentGradingException e)
		{
			e.writeToFile();
		}
		
		ArrayList<StudentGrade> grades = new ArrayList<StudentGrade>();
		for(Student stu: lab)
		{
			if(stu == null)
				break;
			grades.add(new StudentGrade(stu, stat, lab));
		}
		for(StudentGrade sg: grades)
		{
			try
			{
				FileIO.gradeWriter(sg);
				FileIO.gradeReader("Report_"+sg.getSID()+".dat");
			}
			catch(StudentGradingException e)
			{
				e.writeToFile();
			}
		}
	}
}

/*Test run (all the files were indeed created)
Created file: Report_1234.dat
Created file: Report_2134.dat
Created file: Report_3124.dat
Created file: Report_4532.dat
Created file: Report_5678.dat
Created file: Report_6134.dat
Created file: Report_7874.dat
Created file: Report_8026.dat
Created file: Report_9893.dat
Created file: Report_1947.dat
Created file: Report_2877.dat
Created file: Report_3189.dat
Created file: Report_4602.dat
Created file: Report_5405.dat
Created file: Report_6999.dat
*/
