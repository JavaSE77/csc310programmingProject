package edu.cs.ship.rs0699.csc310.programmingproject;

import java.util.ArrayList;

public class MergeSort {

	private int dataSet[];
	
	public MergeSort(int dataSet[]) {
		this.dataSet = dataSet;
	}
	
	public int[] mergeSort(int input[]) {

//		int[][] output = new int[dataSet.length][];
//		for(int i = 0; i < dataSet.length; i++) {
//			output[i][0] = i;
//		}
//		boolean unsorted = true;
//		int counter = 1;
//		ArrayList<Integer> temp = new ArrayList<Integer>();
//		while (unsorted) {
//		for(int i = 0; i < (dataSet.length);) {
//			
//			
//			
//		i = i + (counter* 2);	
//		}
//		}
		
//		The bare essence of merge sort is you compare the two elements side by side,
//		then compare the 4 elements side by side, ect. 
//		this is going to result on the first run comparing the first two elements
//		second run the first 4
//		first 8, or 2^n
		
		int[] placeHolder = new int[input.length];

			if(input.length > 1) {
				int[][] output = split(input);
				int left[] = mergeSort(output[0]);
				int right[] = mergeSort(output[1]);
				int[][] temp = {left, right};
				printDataSet(temp);
				placeHolder = merge(left, right);
				printDataSet(placeHolder);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				return input;
			}
		

		
		return placeHolder;
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
	public int[] merge(int first[], int second[]) {
		int indexFirst =0;
		int indexSecond =0;
		int[] output = new int[first.length + second.length];
		if(first.length == 0) {
			return second;
		}
		if(second.length == 0) {
			return first;
		}
		while (true) {
//			System.out.println("indexFirst:" + indexFirst + "indexSecond:" + indexSecond + " values: " + first[indexFirst]+" " + second[indexSecond]);
		
			//handle case if one finishes before the other
			if(indexFirst >= first.length) {
				for(int i = indexSecond; i < second.length; i++) {
					output[indexFirst + i] = (second[i]);
				}
			return output;
			}
			
			if(indexSecond >= second.length) {
				for(int i = indexFirst; i < first.length; i++) {
					output[i + indexSecond+1] = (first[i]);
				}
			return output;
			}
			
			//if the element in the first array is greater
			if(first[indexFirst] < second[indexSecond]) {
				output[indexFirst + indexSecond] = (first[indexFirst]);
				indexFirst++;
			} else if(first[indexFirst] > second[indexSecond]){
				output[indexFirst + indexSecond] = (second[indexSecond]);
				indexSecond++;
			} else if(first[indexFirst] == second[indexSecond]) {
				output[indexFirst + indexSecond]= (first[indexFirst]);
				output[indexFirst + indexSecond] = (second[indexSecond]);
				indexFirst++;
				indexSecond++;
			}

		}
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
	
	/**
	 * Print the current state of the dataset
	 * @deprecated
	 * */
	public void printDataSet(int[] input) {
		StringBuilder sb = new StringBuilder();
		sb.append("output:");
		for (int i = 0; i < input.length; i++) {
			sb.append(input[i] + "|");
		}
		System.out.println(sb.toString());
	}
	
}
