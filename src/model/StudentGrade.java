package model;

import java.io.*;

public class StudentGrade implements Serializable {

	private static final long serialVersionUID = 1L;
	private Student stu;
	private Statistics stat;
	private Student[] student;

	public StudentGrade(Student stu, Statistics stat, Student[] student) {
		this.stu = stu;
		this.stat = stat;
		this.student = student;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public Statistics getStat() {
		return stat;
	}

	public void setStat(Statistics stat) {
		this.stat = stat;
	}

	public Student[] getStudent() {
		return student;
	}

	public void setStudent(Student[] student) {
		this.student = student;
	}
	
	public int getSID()
	{
		return stu.getSID();
	}
	
	public void printHighest()
	{
		System.out.printf("\nHighest: ");
		stat.findhigh(student);
		stat.printScores(stat.getHigh());
	}
	
	public void printLowest()
	{
		System.out.printf("\nLowest: ");
		stat.findhigh(student);
		stat.printScores(stat.getLow());
	}
	
	public void printAvg()
	{
		System.out.printf("\nAverage: ");
		stat.findavg(student);
		stat.printScores(stat.getAvg());
	}
	
	public void printStats()
	{
		printHighest();
		printLowest();
		printAvg();
	}
	
	public void printScores()
	{
		for(int i=0;i<5;i++)
		{
			System.out.printf(stu.getScores()[i]+" ");
		}
	}

	public void printAllScores()
	{
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<5;j++)
			{
			System.out.printf(student[i].getScores()[j]+"\t");
			}
			System.out.println();
		}
	}
}