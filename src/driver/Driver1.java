/* Amrita Kohli Lab 6 */
package driver;

import model.*;
import util.*;
import exception.*;

public class Driver1 {

	public static void main(String[] args) throws StudentGradingException {

		Student lab2[] = new Student[40];
		
		try
		{
			FileIO.readFile("/home/akamritakohli/Lab6/src/forrty.txt", lab2);
		}
		catch(StudentGradingException e)
		{
			if(e.getErrormsg()=="NumberFormatException")
			{
				e.fixProblemReadFromConsole(lab2, FileIO.getCounter()-2);
			}
			e.writeToFile();
		}
		
		if(FileIO.getCounter() == 0)
		{
			System.out.println("No data");
			return;
		}
		
		if(FileIO.getCounter() == 1)
		{
			System.out.println("No student data");
			return;
		}
		System.out.printf(FileIO.getHeader() +"\n");
		for(int i=0; i<(FileIO.getCounter()-1); i++)
		{
			lab2[i].print();
		}
		
		Statistics statlab2 = new Statistics();

		statlab2.findlow(lab2);
		statlab2.findhigh(lab2);
		statlab2.findavg(lab2);

		// Print the data and statistics
		
		System.out.printf("Low Score: ");
		statlab2.printScores(statlab2.getLow());
		
		System.out.printf("High Score: ");
		statlab2.printScores(statlab2.getHigh());
		
		System.out.printf("Average: ");
		statlab2.printScores(statlab2.getAvg());
		
	}
}

/*Test runs:

Test case 1 (file has string instead of int)

StudentGradingException [errorno=1, errormsg=NumberFormatException
Enter SID and 5 scores separated by enter: 
1028
100
60
90
29
58
java.io.IOException: Stream closed
Stud Qu1 Qu2 Qu3 Qu4 Qu5
1234 52  7  100  78  34  
1028 100  60  90  29  58  
Low Score: 52  7  90  29  34  
High Score: 100  60  100  78  58  
Average: 76.0  33.0  95.0  53.0  46.0  

Test case 2 (file not found)
StudentGradingException [errorno=404, errormsg=java.io.FileNotFoundException: /home/akamritakohli/Lab6/src/forrty.txt (No such file or directory)
java.io.IOException: Stream closed
No data

*/