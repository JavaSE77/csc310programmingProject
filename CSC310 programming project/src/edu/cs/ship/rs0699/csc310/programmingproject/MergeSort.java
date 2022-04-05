package edu.cs.ship.rs0699.csc310.programmingproject;

import java.util.ArrayList;

public class MergeSort {

	private int dataSet[];
	
	public MergeSort(int dataSet[]) {
		this.dataSet = dataSet;
	}
	
	public void mergeSort() {

		int[][] output = new int[dataSet.length][];
		for(int i = 0; i < dataSet.length; i++) {
			output[i][0] = i;
		}
		boolean unsorted = true;
		int counter = 1;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		while (unsorted) {
		for(int i = 0; i < (dataSet.length);) {
			
			
			
		i = i + (counter* 2);	
		}
		}
		
	}
	
	public int[][] split(int input[]) {
		int mid = input.length / 2;
		int[] left = new int[mid];
		int[] right = new int[input.length-mid];
		for(int i = 0; i < mid; i++) {
			left[i] = input[i];
		}
		for(int i = mid; i < input.length; i++) {
			right[i-mid] = input[i];
		}
		int[][] output = {left, right};
		return output;
	}
	
	
	/**
	 * @deprecated this is useless
	 * */
	public int[] splitAndSort(int input[]) {
		if(input[0] < input[1]) {
			int temp = input[0];
			input[0] = input[1];
			input[1] = temp;
		}
		return input;
	}
	
	
	/**
	 * Merges the input of two arrays into one array in
	 * sorted order. Two arrays must be sorted for this to work
	 * @param int first[], int second[]
	 * @return sorted input as one array
	 * */
	public ArrayList<Integer> merge(int first[], int second[]) {
		boolean flag = true;
		int indexFirst =0;
		int indexSecond =0;
		ArrayList<Integer> output = new ArrayList<Integer>();
		while (flag) {
			//if the element in the first array is greater
			if(first[indexFirst] < second[indexSecond]) {
				output.add(first[indexFirst]);
				indexFirst++;
			} else if(first[indexFirst] > second[indexSecond]){
				output.add(second[indexSecond]);
				indexSecond++;
			} else {
				output.add(first[indexFirst]);
				output.add(second[indexSecond]);
				indexFirst++;
				indexSecond++;
			}
			//handle case if one finishes before the other
			if(indexFirst >= first.length) {
				for(int i = indexSecond; i < second.length; i++) {
					output.add(second[i]);
				}
			flag = false;
			}
			if(indexSecond >= second.length) {
				for(int i = indexFirst; i < first.length; i++) {
					output.add(first[i]);
				}
			flag = false;
			}
		}
		return output;
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
	
	
	/**
	 * Print the current state of the dataset
	 * @deprecated
	 * */
	public void printDataSet(int[][] input) {
		int[] left = input[0];
		int[] right = input[1];
		StringBuilder sb = new StringBuilder();
		sb.append("Left:");
		for (int i = 0; i < left.length; i++) {
			sb.append(left[i] + "|");
		}	
		sb.append("Right:");
		for (int i = 0; i < right.length; i++) {
			sb.append(right[i] + "|");
		}
		System.out.println(sb.toString());
	}
	
}
