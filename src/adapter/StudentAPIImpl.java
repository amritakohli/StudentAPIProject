package adapter;
import model.*;
import util.FileIO;
import exception.*;
import java.io.*;

public abstract class StudentAPIImpl implements StudentAPI {

	public void printStatistics()
	{
		String filename ="Report_6999.dat";
		StudentGrade sg;
		try
		{
			sg = FileIO.gradeReader(filename);
			sg.printStats();
		}
		catch(IOException e)
		{
			//throw new StudentGradingException(189, e.toString());
		}
		catch(Exception e)
		{
			//throw new StudentGradingException(498, e.toString());
		}
		
	}
	public void printScore(int SID)
	{
		String filename = "Report_"+SID+".dat";
		StudentGrade sg;
		try
		{
			sg = FileIO.gradeReader(filename);
			System.out.printf("Scores for " + SID + ": ");
			for(int i=0;i<5;i++)
			{
				System.out.printf(sg.getStu().getScores()[i]+" ");
			}
			System.out.println();
		}
		catch(IOException e)
		{
			
		}
		catch(StudentGradingException e)
		{
			System.out.println(e.toString());
		}
	}
	
}
