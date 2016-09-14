package SortPackage;

import java.util.Arrays;
import java.util.Random;

public class ArrayStorage {
	private int[] array;
	private int compares;
	private int exchanges;
	private int heapsize;
	
	public ArrayStorage(int[] a) {
		array = a;
		compares = 0;
		exchanges = 0;
		heapsize = 0;
	}
	
	public ArrayStorage() {
		compares = 0;
		exchanges = 0;
		heapsize = 0;
		Random rand = new Random();
		int n = rand.nextInt(1000);
		n = n + 1000;
		array = new int[n];
		for (int i = 0; i <= n - 1; i++)
			array[i] = rand.nextInt(400);
	}
	
	public void increaseCompares() {
		compares++;
	}
	
	public void increaseExchanges() {
		exchanges++;
	}
	
	public int getCompares() {
		return compares;
	}

	public int getExchanges() {
		return exchanges;
	}
	
	public void print() {
		System.out.println("Array: " + Arrays.toString(array));
		if (compares == 0)
			System.out.println("Length: " + Integer.toString(array.length));
		if (compares != 0) {
			System.out.println("Compares: " + compares);
			System.out.println("Exchanges: " + exchanges);
		}
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = Arrays.copyOf(array, array.length);
	}
	
	public void nulify() {
		compares = 0;
		exchanges = 0;
		heapsize = 0;
	}
	
	public int getSize() {
		return heapsize;
	}
	
	public void setSize(int size) {
		heapsize = size;
	}
}
