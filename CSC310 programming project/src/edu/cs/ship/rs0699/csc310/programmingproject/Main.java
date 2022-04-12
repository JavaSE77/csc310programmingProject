package edu.cs.ship.rs0699.csc310.programmingproject;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
	
	/*
	 * If you want this program to run, 
	 * please change this line to the location of your sample files
	 * */
	static String sampleLocation = "C:\\Users\\Russell\\git\\csc310NumberGenerator\\CSC310 Random Generator\\";

	public static void main(String args[]) {
		System.out.println("CSC 310 programming project. - Russell Stevens, Spring 2022");
		
		FileHandler outputFile = new FileHandler(
				"results.txt");
		outputFile.appendLine("Sort type,Sample type," + "run time" + "," + "run number");

		//run the small samples
		runMergeSortSmallSamples("SmallSample", outputFile);		
		//run the small samples
		runQuickSortSmallSamples("SmallSample", outputFile);		
		//run the small samples
		runHeapSortSmallSamples("SmallSample", outputFile);


		//run the medium samples
		runMergeSortSmallSamples("MediumSample", outputFile);		
		//run the medium samples
		runQuickSortSmallSamples("MediumSample", outputFile);		
		//run the medium samples
		runHeapSortSmallSamples("MediumSample", outputFile);
		

		//run the large samples
		runMergeSortSmallSamples("LargeSample", outputFile);		
		//run the large samples
		runQuickSortSmallSamples("LargeSample", outputFile);		
		//run the large samples
		runHeapSortSmallSamples("LargeSample", outputFile);
		
		
	}

	/**
	 * Run Merge sort
	 * @param String sample, FileHanlder outputFile
	 * */
	public static void runQuickSortSmallSamples(String sample, FileHandler outputFile) {
		for (int i = 1; i < 31; i++) {
			FileHandler input = new FileHandler(
					sampleLocation + sample + "s" 
					+ "\\" + sample + i + ".txt");

			ArrayList<Integer> dataSet = input.readFile();
			int[] output = convertArrayToInt(dataSet);
			
			
			
			QuickSort sortFunction = new QuickSort(output);
			long time = System.nanoTime();
			sortFunction.quickSort(0, output.length-1);
			int[] test = sortFunction.getDataSet();
			long runTime = System.nanoTime() - time;
			//the way we are getting our timing data is simple, take time before running, take time after.
			
			printArray(test);
			outputFile.appendLine("Quick sort,"+sample +"," + runTime + "," + i);
		}
	}
	/**
	 * Run Merge sort
	 * @param String sample, FileHanlder outputFile
	 * */	
	public static void runHeapSortSmallSamples(String sample, FileHandler outputFile) {
		for (int i = 1; i < 31; i++) {
			FileHandler input = new FileHandler(
					sampleLocation + sample+ "s"
					+ "\\" + sample + i + ".txt");

			ArrayList<Integer> dataSet = input.readFile();
			
			
			
			HeapSort sortFunction = new HeapSort(dataSet);
			long time = System.nanoTime();
			ArrayList<Integer> test = sortFunction.heapSort();
			long runTime = System.nanoTime() - time;
			//the way we are getting our timing data is simple, take time before running, take time after.
			
			printArrayList(test);
			outputFile.appendLine("Heap sort,"+sample +"," + runTime + "," + i);
		}
	}
	
	/**
	 * Run Merge sort
	 * @param String sample, FileHanlder outputFile
	 * */
	public static void runMergeSortSmallSamples(String sample, FileHandler outputFile) {
		for (int i = 1; i < 31; i++) {
			FileHandler input = new FileHandler(
					sampleLocation + sample+ "s"
					+ "\\" + sample + i + ".txt");

			ArrayList<Integer> dataSet = input.readFile();
			int[] output = convertArrayToInt(dataSet);
			
			
			
			MergeSort mergeSort = new MergeSort(output);
			long time = System.nanoTime();
			mergeSort.mergeSort(output);
			long runTime = System.nanoTime() - time;
			//the way we are getting our timing data is simple, take time before running, take time after.
			int[] test = mergeSort.getDataSet();
			
			printArray(test);
			outputFile.appendLine("Merge sort,"+sample +"," + runTime + "," + i);
		}
	}
	
	/**
	 * Print Array to standard out
	 * @param List[] dataset
	 * */
	public static void printArray(int dataset[]) {
		for (int i = 0; i < dataset.length; i++) {
			System.out.println(dataset[i]);
		}
	}
	
	/**
	 * Print Arraylist to standard out
	 * @param ArrayList<int> dataset
	 * */
	public static void printArrayList(ArrayList<Integer> dataset) {
		for (int i = 0; i < dataset.size(); i++) {
			System.out.println(dataset.get(i));
		}
	}
	
	//tests for writing this program
	
	/**@deprecated
	 * */
	public static int[] convertArrayToInt(ArrayList<Integer> dataSet) {
		int[] output = new int[dataSet.size()];
		
		for(int i = 0; i < dataSet.size(); i++) {
			
			output[i] = dataSet.get(i);
			
		}
		
		return output;
		
	}
	/**@deprecated
	 * */
	public static void testMergeSortWorking() {
		
		int dataSet[] = {1,5,7,2,8,3,4,6,12,0};
		
		MergeSort mergesort = new MergeSort(dataSet);

		
		int output[] = mergesort.mergeSort(dataSet);
		System.out.println("Final product:");
		mergesort.printDataSet(output);
		
		int left[] = {1,5};
		int right[] = {2,6,8};
		mergesort.printDataSet(mergesort.merge(left, right));
		
	}
	/**@deprecated
	 * */
	public static void testQuickSort() {
		
		int dataset[] = {4, 6, 3, 5, 6, 8, 14,6,7,0,8,8,8,7,5,55,6,77,7};
		QuickSort quicksort = new QuickSort(dataset);
		quicksort.printDataSet();
		quicksort.quickSort(0, dataset.length -1);
		dataset = quicksort.getDataSet();
		quicksort.printDataSet();
	}
	/**@deprecated
	 * */
	public static void testMergeFromMergeSort() {
		int[] first = {1,5,7};
		int[] second = {2,4,6};
		MergeSort mergesort = new MergeSort(null);
		int[] output = mergesort.merge(first, second);
		mergesort.printDataSet(output);
		
	}
	/**@deprecated
	 * */
	public static void testMergeFromMergeSortSplit() {
		MergeSort mergesort = new MergeSort(null);
		int dataset[] = {4, 6, 3, 5, 6, 8, 14,6,7,0,8,8,8,7,5,55,6,77,7};
		
		mergesort.printDataSet(mergesort.split(dataset));

		
	}
	/**@deprecated
	 * */
	public static void testHeapSort() {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(4);
		input.add(1);
		input.add(5);
		input.add(24);
		input.add(345);
		input.add(3);
		input.add(7);
		input.add(9);
		input.add(2);
		HeapSort heapSort = new HeapSort(input);
		heapSort.printDataSet(heapSort.heapSort());
	}
	
}
