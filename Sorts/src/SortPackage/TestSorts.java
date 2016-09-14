package SortPackage;
import java.util.Arrays;

public class TestSorts {

	public static void main(String[] args) {
		
		//System.out.println("Not sorted array: " + Arrays.toString(testArray1));
		//System.out.println("Insertion sorted array: " + Arrays.toString(SomeSorts.InsertionSort(testArray1)));
		//System.out.println("Selection sorted array: " + Arrays.toString(SomeSorts.SelectionSort(testArray1)));
		
		ArrayStorage a = new ArrayStorage();
		a.print();
		
		int[] testingArray = Arrays.copyOf(a.getArray(), a.getArray().length);
		
		System.out.println("Insertion sort: ");
		SomeSorts.InsertionSort(a);
		a.print();
		
		//System.out.println(Arrays.toString(testingArray));
		a.setArray(testingArray);
		a.nulify();
		
		System.out.println("Selection sort: ");
		SomeSorts.SelectionSort(a);
		a.print();
		
		a.setArray(testingArray);
		a.nulify();
		//a.print();
		
		System.out.println("Bubble sort: ");
		SomeSorts.BubbleSort(a);
		a.print();
		
		a.setArray(testingArray);
		a.nulify();
		
		System.out.println("Merge sort: ");
		SomeSorts.MergeSort(a);
		a.print();
		
		a.setArray(testingArray);
		a.nulify();
		
		System.out.println("Heap sort: ");
		SomeSorts.HeapSort(a);
		a.print();

	}

}
