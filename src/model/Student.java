package model;
import java.io.*;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private int SID;

	private int scores[] = new int[5];

	// default constructor
	public Student() {
		SID = 0;
		scores = null;
	}

	// getters
	public int getSID() {
		return SID;
	}

	public int[] getScores() {
		return scores;
	}

	// setters
	public void setSID(int SID) {
		this.SID = SID;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}

	// print method for instance variables
	public void print() {
		System.out.printf(SID + " ");

		for (int i = 0; i < 5; i++) {
			System.out.printf(scores[i] + "  ");
		}

		System.out.printf("\n");
	}
}