package com.sort;

public class InsertionSorter<K extends Comparable<? super K>> {

	/**
	 * Sorts the elements in given array from `left` to `right` in lexicograph order using insertion sort algorithm.
	 */
	
	public void sort(Pair<K, ?>[] array, int left, int right, String sortType) {
		// Fill your code to sort the elements in `array`.
		if (sortType.equals("keys")){
			for (int i = left + 1; i < right + 1; i++){
				for (int j = i; (j > left) && (array[j].getKey().compareTo(array[j-1].getKey()) < 0); j--) {
					this.swap(array, j, j - 1);
				}
			}
		} else { // sortType.equals("values")
			for (int i = left + 1; i < right + 1; i++){
				for (int j = i; (j > left) && (array[j].getValue() < array[j-1].getValue()); j--) {
					this.swap(array, j, j - 1);
				}
			}
		}
	}

	private void swap(Pair<K,?>[] array, int op1, int op2) {
		Pair<K, ?> tmp = array[op1];
		array[op1] = array[op2];
		array[op2] = tmp;
	}

//	private void swapKeys(Pair<K,?>[] array, int op1, int op2) {
//		K tmp = array[op1].getKey();
//		array[op1].setKey(array[op2].getKey());
//		array[op2].setKey(tmp);
//	}
//
//	private void swapValues(Pair<K,?>[] array, int op1, int op2) {
//		int tmp = array[op1].getValue();
//		array[op1].setValue(array[op2].getValue());
//		array[op2].setValue(tmp);
//	}
	// Hint: Maybe you need to create the helper methods.


	

}