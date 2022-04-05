package edu.cs.ship.rs0699.csc310.programmingproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class HeapSort {

	private ArrayList<Integer> dataSet = new ArrayList<Integer>();
	
	public HeapSort(ArrayList<Integer> dataSet) {
		this.dataSet = dataSet;
	}
	
	
	public ArrayList<Integer> heapSort() {
		ArrayList<Integer> output = new ArrayList<Integer>();		
		
		while(dataSet.size() > 0) {
			int max = findMaxElementIndex(dataSet);
			output.add(0, dataSet.get(max));
			dataSet.remove(max);
		}
		return output;
	}
	
	
	public int findMaxElementIndex(ArrayList<Integer> input) {
		
		int max = Integer.MIN_VALUE;
		int index = -1;
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i) > max) {
				max = input.get(i);
				index = i;
			}
		}

		return index;
	}
	
	public int findMaxElementIndex(int[] input) {
		
		int max = Integer.MIN_VALUE;
		int index = -1;
		for (int i = 0; i < input.length; i++) {
			if (input[i] > max) {
				max = input[i];
				index = i;
			}
		}

		return index;
	}
	
	/**
	 * Print the current state of the dataset
	 * @deprecated
	 * */
	public void printDataSet(ArrayList<Integer> array) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.size(); i++) {
			sb.append(array.get(i) + "|");
		}
		System.out.println(sb.toString());
	}
}
