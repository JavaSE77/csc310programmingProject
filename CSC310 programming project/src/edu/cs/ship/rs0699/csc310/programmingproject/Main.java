package edu.cs.ship.rs0699.csc310.programmingproject;

import java.util.ArrayList;

public class Main {

	public static void main(String args[]) {
		System.out.println("CSC 310 programming project. - Russell Stevens, Spring 2022");
		
		MergeSort mergesort = new MergeSort(null);
		int dataset[] = {4, 6, 3, 5, 6, 8, 14,6,7,0,8,8,8,7,5,55,6,77,7};
		
		mergesort.printDataSet(mergesort.split(dataset));

	}
	
	public static void testQuickSort() {
		
		int dataset[] = {4, 6, 3, 5, 6, 8, 14,6,7,0,8,8,8,7,5,55,6,77,7};
		QuickSort quicksort = new QuickSort(dataset);
		quicksort.printDataSet();
		quicksort.quickSort(0, dataset.length -1);
		dataset = quicksort.getDataSet();
		quicksort.printDataSet();
	}
	
	public static void testMergeFromMergeSort() {
		int[] first = {1,5,7};
		int[] second = {2,4,6};
		MergeSort mergesort = new MergeSort(null);
		ArrayList<Integer> output = mergesort.merge(first, second);
		mergesort.printDataSet(output);
		
	}
	
}
