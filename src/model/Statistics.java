package model;

import util.FileIO;
import java.io.*;

public class Statistics implements Serializable {

	private static final long serialVersionUID = 1L;

	int[] lowscores = new int[5];

	int[] highscores = new int[5];

	float[] avgscores = new float[5];

	// default constructor
	public Statistics() {

	}

	// getters
	public int[] getLow() {
		return lowscores;
	}

	public int[] getHigh() {
		return highscores;
	}

	public float[] getAvg() {
		return avgscores;
	}

	/*
	 * This method will find the lowest score and store it in an array names
	 * lowscores.
	 */
	public void findlow(Student[] a) {

		int temp[] = a[0].getScores();
		int min;
		int track[];
		for (int i = 0; i < 5; i++) {
			min = temp[i]; // assuming the Quiz i score of the first student is
							// min

			// comparing with all other students' Quiz i scores
			for (int j = 0; j < (FileIO.getCounter() - 1); j++) {
				track = a[j].getScores(); // tracks the scores for the jth
											// student
				if (min > track[i])
					min = track[i]; // comparing Quiz i score of jth student
									// with assumed min and adjusting min if
									// needed
			}
			this.lowscores[i] = min; // stores the min of Quiz i among
								// students
		}
	}

	/*
	 * This method will find the highest score and store it in an array names
	 * highscores.
	 */
	public void findhigh(Student[] a) {

		int temp[] = a[0].getScores();
		int max;
		int track[];
		for (int i = 0; i < 5; i++) {
			max = temp[i]; // assuming the Quiz i score of the first student is
							// max

			// comparing with all other students' Quiz i scores
			for (int j = 0; j < FileIO.getCounter() - 1; j++) {
				track = a[j].getScores(); // tracks the scores for the jth
											// student
				if (max < track[i])
					max = track[i]; // comparing Quiz i score of jth student
									// with assumed max and adjusting max if
									// needed
			}
			this.highscores[i] = max; // stores the max of Quiz i among
									// students
		}

	}

	public void findavg(Student[] a) {

		/*
		 * This method will find avg score for each quiz and store it in an
		 * array names avgscores.
		 */
		int total;
		int track[];
		int temp[] = a[0].getScores();
		for (int i = 0; i < 5; i++) {
			total = 0; // initializing total to be 0 for each new Quiz

			for (int j = 0; j < FileIO.getCounter() - 1; j++) {
				track = a[j].getScores(); // tracks the scores for the jth
											// student
				//System.out.printf(track[i] + " ");
				total += track[i]; // adding Quiz i score of jth student to
									// total
			}
			this.avgscores[i] = (float) (total / (FileIO.getCounter() - 1));
			
			// stores the avg of Quiz i among students
		}
		//printScores(avgscores);
	}

	// prints scores int array passed as parameter
	public void printScores(int[] scores) {
		for (int i = 0; i < 5; i++) {
			System.out.printf(scores[i] + "  ");
		}

		System.out.printf("\n");
	}

	// prints scores float array passed as parameter
	public void printScores(float[] scores) {
		for (int i = 0; i < 5; i++) {
			System.out.printf(scores[i] + "  ");
		}

		System.out.printf("\n");
	}
}
