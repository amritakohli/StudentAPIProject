/* Amrita Kohli Lab 6 */
package driver;
import adapter.*;
import exception.*;
import model.*;
import util.*;
import java.io.*;
import java.util.*;

public class Driver3 {

	/**
	 * @param args
	 */
		
		public static void main(String[] args) throws StudentGradingException{
			Student [] lab = new Student[15];
			Statistics stat = new Statistics();
			String filename = "//home//akamritakohli//Lab6//src//StuData.txt";
			SAPI api = new SAPI();
			
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
				catch(IOException e)
				{
					
				}
				catch(StudentGradingException e)
				{
					e.writeToFile();
				}
			}

			api.printStatistics();
			//boundary cases
			api.printScore(6999);
			api.printScore(1234); 
			
			api.printScore(1947); //somewhere in the middle
		}

	}
/* Test run

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

Highest: 100  100  100  90  80  

Lowest: 0  0  0  0  0  

Average: 46.0  47.0  63.0  70.0  49.0  
Scores for 6999: 0 98 89 78 20 
Scores for 1234: 52 7 100 78 34 
Scores for 1947: 45 40 88 78 55 

 */

