package util;

import java.io.*; //importing java.io package for file input and output
import java.util.*; //importing java.util package for creating arrays, etc.

import exception.*;

import model.*;

public class FileIO {

	private static int counter;
	private static String header;
	
	// default constructor
	public FileIO() {
		counter = 0;
		header="";
	}
	
	//getters
	public static int getCounter()
	{
		return FileIO.counter;
	}

	public static String getHeader()
	{
		return FileIO.header;
	}
	
	// Reads the file and builds student array.
	public static Student[] readFile(String filename, Student[] stu) throws StudentGradingException {

		try{
			FileReader file = new FileReader(filename); // open the file
			BufferedReader buff = new BufferedReader(file);

			boolean eof = false;

			while (!eof) {
				String line = buff.readLine(); // reading a line

				if (line == null)
					eof = true;
				else {
					counter++;

					// if first line
					if (counter == 1) {
						header=line; // store header
					}

					// second line onwards
					if (counter > 1) {
						stu[counter-2] = new Student(); // creating new Student object
						StringTokenizer st = new StringTokenizer(line); // tokenize
																		// current
																		// line
						while (st.hasMoreTokens()) {
							stu[counter-2].setSID(Integer.parseInt(st.nextToken())); // converting
																				// from
																				// String
																				// to
																				// int

							int[] scores = new int[5]; // stores scores
							
							// populating scores array
							for (int j = 0; j < 5; j++) {
								scores[j] = Integer.parseInt(st.nextToken());
							}

							stu[counter-2].setScores(scores);
						}
					} // close if
					
					if(counter > 40)
						break; //don't read data for more than 40 students
				} // close else
			} // close while
			buff.close(); // close buffer
		}
		catch(NumberFormatException e)
			{
				throw new StudentGradingException(1, "NumberFormatException");
			}
		catch(Exception e)
		{
			throw new StudentGradingException(404, e.toString());
		}
		
		// Note: Number of students is counter-1
		return stu; // return the Student object
	}
	
	public static void gradeWriter(StudentGrade sg) throws StudentGradingException, IOException
	{ 	
		ObjectOutputStream oos = null;
		try
		{
			String filename = "Report_"+sg.getSID()+".dat";
			//creating new file
			oos = new ObjectOutputStream(new FileOutputStream(filename));
			System.out.println("Created file: " + filename);
			//writing object to file
			oos.writeObject(sg);
		}
		catch(IOException e)
		{
			if(oos!= null)
				oos.close();
			throw new StudentGradingException(102, e.toString());
		}
		if(oos!= null)
			oos.close(); //closing
	}
	
	
	public static StudentGrade gradeReader(String filename) throws StudentGradingException, IOException
	{
		ObjectInputStream ois;
		StudentGrade sg;
		try
		{
			ois = new ObjectInputStream(new FileInputStream(filename));
		}
		catch(FileNotFoundException e)
		{
			throw new StudentGradingException(123, e.toString());
		}
		catch(IOException e)
		{
			throw new StudentGradingException(456, e.toString());
		}
		
		try
		{
			//reading object from file
			sg = (StudentGrade)ois.readObject();
		}
		catch(ClassNotFoundException e)
		{
			ois.close();
			throw new StudentGradingException(592, e.toString());
		}
		ois.close(); // closing
		return sg;
	}
}
