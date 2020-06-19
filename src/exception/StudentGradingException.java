/*
Req 1 - Create a custom exception handler class called StudentGradingException 
that can (add this functionality in a package called exception)

Centralize capture of all exceptions
Logs exceptions in a text file.
Fixes at least one exception.
Demonstrate the usage of exception handler in a driver, throwing, logging and fixing the exception. 
Put this in a separate driver called Driver1. java.  (Put this in driver package)
*/
package exception;
import java.util.*;
import java.io.*;

import model.*;

public class StudentGradingException extends Exception {
	private int errorno;
	private String errormsg;
	
	static Scanner in = new Scanner(System.in);
	
	public StudentGradingException() {
		super();
		printmyproblem();
	}
	
	public StudentGradingException(String errormsg) {
		super();
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public StudentGradingException(int errorno) {
		super();
		this.errorno = errorno;
		printmyproblem();
	}
	
	public StudentGradingException(int errorno, String errormsg) {
		super();
		this.errorno = errorno;
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public int getErrorno() {
		return errorno;
	}
	
	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}
	
	public String getErrormsg() {
		return errormsg;
	}
	
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	public void printmyproblem() {
		System.out.println("StudentGradingException [errorno=" + errorno + ", errormsg=" + errormsg); 
	}

	public int fixProblemReadFromConsole(Student[] lab2, int i)
	{
		System.out.println("Enter SID and 5 scores separated by enter: ");
		int a = Integer.parseInt(in.nextLine());
		lab2[i].setSID(a);
		int scores[] = new int[5];
		for (int j = 0; j < 5; j++) {
			scores[j] = Integer.parseInt(in.nextLine());
		}
		lab2[i].setScores(scores);
		
		return a;
	}
	
	public void writeToFile()
	{
		try
		{
		BufferedWriter bw = new BufferedWriter(new FileWriter("/home/akamritakohli/Lab6/src/zero.txt", true));
		bw.append(errormsg);
		bw.close();
		bw.newLine();
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
		}
	}
}

