/*Req 3 - Implement abstract class and Interface (add this functionality in a package called adapter)

Create an API (A programming interface) to 

Print student statistics
Print score for a given student id
You should create an Interface called StudentAPI in which two methods 
are declared for functionality (Req 3 - 1 and 2) stated above.

You should create a class StudentAPIImpl that would implement StudentAPI. 
Using methods from other classes, (Student.java, Statistics.java, StudentGrade.java, FileIO.java) 
implement the two methods in StudentAPI.

Create a driver demonstrating the usage of the API. Put this in a separate driver called Driver3. java.  
(Put this in driver package)
 */
package adapter;
import model.*;

public interface StudentAPI {

	public void printStatistics();
	public void printScore(int SID);
	
}
