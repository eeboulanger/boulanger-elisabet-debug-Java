package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount;
	private static int rashCount;
	private static int pupilCount;
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader
				("symptoms.txt"));
		String line = reader.readLine();

		int tempHeadCount = 0;
		int tempRashCount=0;
		int tempPupilCount=0;

		while (line != null) {

			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				tempHeadCount++;
				System.out.println("number of headaches: " + tempHeadCount);
			}
			else if (line.equals("rash")) {
				tempRashCount++;
			}
			else if (line.contains("dialated pupils")) {
				tempPupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}


		headacheCount =tempHeadCount;
		rashCount =tempRashCount;
		pupilCount =tempPupilCount;
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
