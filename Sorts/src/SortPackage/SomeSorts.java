package SortPackage;

public class SomeSorts {
	public static void InsertionSort(ArrayStorage as) {
		int[] array = as.getArray();
		int key, i;
		for (int j = 1; j <= array.length - 1; j++) {
			key = array[j];
			i = j - 1;
			as.increaseCompares();
			while ((i >= 0) && (array[i] > key)) {
				array[i + 1] = array[i];
				as.increaseExchanges();
				as.increaseCompares();
				i--;
			}
			array[i + 1] = key;
			as.increaseExchanges();
		}
		as.setArray(array);
	}
	
	public static void SelectionSort(ArrayStorage as) {
		int[] array = as.getArray();
		int key, i, temp;
		for (int j = 0; j <= array.length - 1; j++) {
			key = j;
			i = j + 1;
			while (i <= array.length - 1) {
				if (array[i] < array[key])
					key = i;
				as.increaseCompares();
				i++;
			}
			temp = array[j];
			array[j] = array[key];
			array[key] = temp;
			as.increaseExchanges();
		}
		as.setArray(array);
	}
	
	public static void BubbleSort(ArrayStorage as) {
		int[] array = as.getArray();
		int temp;
		for (int i = 0; i <= array.length - 2; i++)
			for (int j = array.length - 1; j > i; j--) {
				as.increaseCompares();
				if (array[j] < array[j - 1]) {
					as.increaseExchanges();
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		as.setArray(array);
	}
	
	private static void Merge(ArrayStorage as, int p, int q, int r) {
		int[] array = as.getArray();
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];
		
		for (int i = 0; i <= n1 - 1; i++) {
			L[i] = array[p + i];
			//as.increaseExchanges();
		}
		for (int j = 0; j <= n2 - 1; j++) {
			R[j] = array[q + j + 1];
			//as.increaseExchanges();
		}
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		
		for (int k = p; k <= r; k++) {
			as.increaseCompares();
			if (L[i] <= R[j]) {
				
				as.increaseExchanges();
				array[k] = L[i];
				i++;
			}
			else {
				array[k] = R[j];
				as.increaseExchanges();
				j++;
			}
		}
		as.setArray(array);
	}
	
	private static void MergeSortArray(ArrayStorage as, int p, int r) {
		//System.out.println(p + " " + r);
		int q = 0;
		if (p < r){
			q = (p + r) / 2;
			MergeSortArray(as, p, q);
			MergeSortArray(as, q + 1, r);
			Merge(as, p, q, r);
		}
	}
	
	public static void MergeSort(ArrayStorage as) {
		int[] array = as.getArray();
		int p = 0;
		int r = array.length - 1;
		MergeSortArray(as, p, r);
	}
	
	private static int Left(int i) {
		return 2 * (i + 1) - 1;
	}
	
	private static int Right(int i) {
		return 2 * (i + 1);
	}
	
	public static void MaxHeapify(ArrayStorage as, int i) {
		int[] array = as.getArray();
		int l = Left(i);
		int r = Right(i);
		int temp;
		int largest;
		if ((l <= as.getSize() - 1) && (array[l] > array[i])) {
			largest = l;
			as.increaseCompares();
		}
		else {
			largest = i;
			as.increaseCompares();
		}
		if ((r <= as.getSize() - 1) && (array[r] > array[largest])) {
			largest = r;
			as.increaseCompares();
		}
		if (largest != i) {
			as.increaseExchanges();
			temp = array[largest];
			array[largest] = array[i];
			array[i] = temp;
			as.setArray(array);
			MaxHeapify(as, largest);
		}
	}
	
	public static void BuildMaxHeap(ArrayStorage as) {
		as.setSize(as.getArray().length);
		for (int i = as.getArray().length / 2; i >= 0; i--)
			MaxHeapify(as, i);
	}
	
	public static void HeapSort(ArrayStorage as) {
		BuildMaxHeap(as);
		int temp;
		for (int i = as.getArray().length - 1; i >= 1; i--) {
			int[] array = as.getArray();
			as.increaseExchanges();
			temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			as.setArray(array);
			as.setSize(as.getSize() - 1);
			MaxHeapify(as, 0);
			}
		
	}
}
