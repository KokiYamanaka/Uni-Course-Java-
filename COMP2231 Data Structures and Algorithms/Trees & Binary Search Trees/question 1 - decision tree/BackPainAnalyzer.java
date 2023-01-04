////**************************************************************************************************************************************************************
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 4 - Question 1 - Decision Tree 
// BackPainAnalyzer.java - This program reads in a text file that contains decision tree questionaires.
// Questions are used to diagnose a patient's conditions.
// Afteron, questions will post to user and user will answer each questions with yes or no.
// Based on what user answered, the program will choose which node to go on. 
////*********************************************************************************************************

import java.io.*;

/**
 * BackPainAnaylyzer demonstrates the use of a binary decision tree to 
 * diagnose back pain.
 */
public class BackPainAnalyzer
{
	/**
	 *  Asks questions of the user to diagnose a medical problem.
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("So, you're having back pain.");

		DecisionTree expert = new DecisionTree("input.txt");
		expert.evaluate();
	}
}
