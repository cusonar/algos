package algos;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SortTest {
	
	private int SIZE = 100;
	private int[] arr = new int[SIZE];
	private int[] sorted = new int[SIZE];
	
	@Before
	public void setup() {
		Random random = new Random(System.currentTimeMillis());
		for (int i=0; i<SIZE; ++i) {
			arr[i] = sorted[i] = random.nextInt(SIZE*2)-SIZE;
		}
		Arrays.sort(sorted);
	}
	
	public void print(int[] arr) {
		int n = arr.length;
		for (int i=0; i<n; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	@Test
	public void quickSortTest() {
		Sort.quickSort(arr, 0, SIZE-1);
		assertArrayEquals(sorted, arr);
	}
	
	@Test
	public void mergeSortTest() {
		Sort.mergeSort(arr);
		assertArrayEquals(sorted, arr);
	}
}
