package algos;

public class Sort {
	
	public static void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		if (left >= right) return;
		int i=left, j=right;
		int pivot = arr[left];
		
		while (i < j) {
			while (pivot < arr[j]) --j;
			while (i < j && pivot >= arr[i]) ++i;
			swap(arr, i, j);
		}
		arr[left] = arr[i];
		arr[i] = pivot;
		
		quickSort(arr, left, i-1);
		quickSort(arr, i+1, right);
	}
	
	public static void mergeSort(int[] arr) {
		int n = arr.length;
		if (n < 2) return;
		int mid = n / 2;
		
		int[] half1 = new int[mid];
		int[] half2 = new int[n-mid];
		
		for (int i=0; i<mid; ++i) {
			half1[i] = arr[i];
		}
		for (int i=mid; i<n; ++i) {
			half2[i-mid] = arr[i];
		}
		
		mergeSort(half1);
		mergeSort(half2);
		
		merge(arr, half1, half2);
	}

	private static void merge(int[] arr, int[] half1, int[] half2) {
		int len1 = half1.length, len2 = half2.length;
		int idx1 = 0, idx2 = 0, idx = 0;
		while (idx1 < len1 && idx2 < len2) {
			if (half1[idx1] < half2[idx2]) {
				arr[idx] = half1[idx1];
				idx1++;
			} else {
				arr[idx] = half2[idx2];
				idx2++;
			}
			idx++;
		}
		
		if (idx1 == len1) {
			while (idx2 < len2) {
				arr[idx] = half2[idx2];
				idx2++;
				idx++;
			}
		}
		
		if (idx2 == len2) {
			while (idx1 < len1) {
				arr[idx] = half1[idx1];
				idx1++;
				idx++;
			}
		}
	}
	
}
