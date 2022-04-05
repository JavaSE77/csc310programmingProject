package edu.cs.ship.rs0699.csc310.programmingproject;

public class QuickSort {

	private int dataSet[];
	
	public QuickSort(int dataSet[]) {
		this.dataSet = dataSet;
	}
	
	/**
	 * Sorts the provided dataset using the quick sort algorithm
	 * to get the sorted array, use the getter function. 
	 * This method is designed this way to be able to calculate 
	 * just how much time is spent running this algorithm, not the overhead
	 * @param int low, int high - two ints to bound the portion of the array we are working in
	 * */
	public void quickSort(int low, int high) {
		//I spent an hour trying to figure out why this never terminates.
		//turns out I never checked to see if low and high had converged on the end of the array...
		if(low < high) {
			int index = partition(low, high);
			quickSort(low, index -1);
			quickSort(index +1, high);
		}
	}
	
	/**
	 * @Returns the dataset held by the quicksort algorithm.
	 * this is designed to avoid calculating overhead into our timing
	 * */
	public int[] getDataSet() {
		return this.dataSet;
	}
	
	
	/**
	 * calculate the max and min values of the array
	 * @return array of ints, first element is min, second element is max
	 * @deprecated
	 * */
	private int[] getMinMax() {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < dataSet.length; i++) {
			if(dataSet[i] > max) {
				max = dataSet[i];
			}
			
			if(dataSet[i] < min) {
				min = dataSet[i];
			}
		}
		int output[] = {min, max};
		return output;
	}
	
	/**
	 * partition the dataset around a pivot value
	 * @param int low, int high - two ints to bound the portion of the array we are working in
	 * @return the position in the array to pivot arround
	 * */
	private int partition(int low, int high) {
		int pivot = dataSet[high];
		int pos = low-1;
		for(int i = low; i < high; i++) {
			if(dataSet[i] < pivot) {
				pos++;
				int temp = dataSet[i];
				dataSet[i] = dataSet[pos];
				dataSet[pos] = temp;
			}
		}

		int temp = dataSet[pos+1];
		dataSet[pos+1] = dataSet[high];
		dataSet[high] = temp;
		return pos +1;
	}
	
	
	/**
	 * Print the current state of the dataset
	 * @deprecated
	 * */
	public void printDataSet() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dataSet.length; i++) {
			sb.append(dataSet[i] + "|");
		}
		System.out.println(sb.toString());
	}
	
}
