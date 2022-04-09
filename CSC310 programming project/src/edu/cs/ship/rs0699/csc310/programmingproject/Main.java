package edu.cs.ship.rs0699.csc310.programmingproject;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

	public static void main(String args[]) {
		System.out.println("CSC 310 programming project. - Russell Stevens, Spring 2022");
		
		FileHandler fh = new FileHandler(
				"C:\\Users\\Russell\\git\\csc310NumberGenerator\\CSC310 Random Generator\\SmallSamples\\SmallSample1.txt");

		ArrayList<Integer> dataSet = fh.readFile();
		int[] output = convertArrayToInt(dataSet);
		
//		HeapSort heapSort = new HeapSort(dataSet);
//		ArrayList<Integer> test = heapSort.heapSort();
//		System.out.println(dataSet.size() + "|" + test.size());
//		heapSort.printDataSet(test);
//		printArray(test);
		
//		QuickSort quickSort = new QuickSort(output);
//		quickSort.quickSort(0, output.length-1);
//		int[] test = quickSort.getDataSet();
//		printArray(test);

		
		MergeSort mergeSort = new MergeSort(output);
		mergeSort.mergeSort(output);
		int[] test = mergeSort.getDataSet();
		
		printArray(test);

		
	}
	
	public static void printArray(int dataset[]) {
		for (int i = 0; i < dataset.length; i++) {
			System.out.println(dataset[i]);
		}
	}
	
	public static void printArrayList(ArrayList<Integer> dataset) {
		for (int i = 0; i < dataset.size(); i++) {
			System.out.println(dataset.get(i));
		}
	}
	
	public static int[] convertArrayToInt(ArrayList<Integer> dataSet) {
		int[] output = new int[dataSet.size()];
		
		for(int i = 0; i < dataSet.size(); i++) {
			
			output[i] = dataSet.get(i);
			
		}
		
		return output;
		
	}
	
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
		int[] output = mergesort.merge(first, second);
		mergesort.printDataSet(output);
		
	}
	public static void testMergeFromMergeSortSplit() {
		MergeSort mergesort = new MergeSort(null);
		int dataset[] = {4, 6, 3, 5, 6, 8, 14,6,7,0,8,8,8,7,5,55,6,77,7};
		
		mergesort.printDataSet(mergesort.split(dataset));

		
	}
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
