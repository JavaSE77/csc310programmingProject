package edu.cs.ship.rs0699.csc310.programmingproject;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

	public static void main(String args[]) {
		System.out.println("CSC 310 programming project. - Russell Stevens, Spring 2022");
		
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
	public static void testMergeFromMergeSortSplit() {
		MergeSort mergesort = new MergeSort(null);
		int dataset[] = {4, 6, 3, 5, 6, 8, 14,6,7,0,8,8,8,7,5,55,6,77,7};
		
		mergesort.printDataSet(mergesort.split(dataset));

		
	}
}
