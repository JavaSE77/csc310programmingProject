package edu.cs.ship.rs0699.csc310.programmingproject;

public class Main {

	public static void main(String args[]) {
		System.out.println("CSC 310 programming project. - Russell Stevens, Spring 2022");
		
		int dataset[] = {4, 6, 3, 5, 6, 8, 14,6,7,0,8,8,8,7,5,55,6,77,7};
		QuickSort quicksort = new QuickSort(dataset);
		quicksort.printDataSet();
		quicksort.quickSort(0, dataset.length -1);
		dataset = quicksort.getDataSet();
		quicksort.printDataSet();
	}
	
	
	
}
