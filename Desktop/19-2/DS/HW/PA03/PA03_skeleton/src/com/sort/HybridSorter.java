package com.sort;


public class HybridSorter<K extends Comparable<? super K>> {
	InsertionSorter<K> insertionSort = new InsertionSorter<K>();
	private final int RUN = 32;

	/**
	 * Sorts the elements in given array from `left` to `right in lexicographic order
	 * using the hybrid sorting algorithm.
	 */

	public Pair<K, ?> search(Pair<K, ?>[] array, int k, String sortType) {
		// Fill your code to sort the elements in `array`.
		// TODO(DJ) : We could pre-assume that arr is already sorted.

		return array[k];
	}

	public void sort(Pair<K, ?>[] array, int left, int right, String sortType) {
		if (right - left + 1 <= this.RUN) { // Run QuickSort
			insertionSort.sort(array, left, right, sortType);

		} else { // Run InsertionSort (size <= this.RUN) // :=32
			int l = left;
			int r = right;

			if (sortType.equals("keys")) {
				K pivot = array[(l + r) / 2].getKey();

				while (l <= r){
					while (array[l].getKey().compareTo(pivot) < 0) l++;
					while (array[r].getKey().compareTo(pivot) > 0) r--;

					if (l <= r) {
						this.swap(array, l, r);
						l++;
						r--;
					}
				}

			} else { // sortType.equals("values")
				int pivot = array[(l + r) / 2].getValue();

				while (l <= r){
					while (array[l].getValue() < pivot) l++;
					while (array[r].getValue() > pivot) r--;

					if (l <= r) {
						this.swap(array, l, r);
						l++;
						r--;
					}
				}
			}

			if (l < right) sort(array, l, right, sortType);
			if (left < r) sort(array, left, r, sortType);
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

//	public void sort(Pair<K, ?>[] array, int left, int right, String sortType) {
//		// Fill your code to sort the elements in `array`.
//		// TODO(DJ) : Quick + InsertionSort
//		int pivot = findpivot(array, left, right);
//		DSutil.swap(array, pivot, right);
//		// k will be first position in right subarray
//		int k = partition(array, left-1, right, array[right]);
//		DSutil.swap(array, k, right);
//		if ((k-left) > 1) sort(array, left, k-1, sortType);
//		if ((right-left) > 1) sort(array, k+1, right, sortType);
//
//
//
//	}

	/*
	// Hint: Maybe you need to create the helper methods such as partitioning.
	public int partition(Pair<K, ?>[] array, int left, int right, Pair<K, ?> pivot) {
		do {
			while (array[++left].compareTo(pivot) < 0);
			while ((right != 0) && array[--right].compareTo(pivot) > 0);
			DSutil.swap(array, left, right);
		} while (left < right);

		return left;
	}

	 */
	// TODO : partitioning
	// TODO : comparing
}
