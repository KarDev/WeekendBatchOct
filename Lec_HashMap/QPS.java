package Lec_HashMap;

import java.util.HashMap;

public class QPS {
	public static void main(String[] args) {
		int[] arr1 = { 30, 20, 40, 50, 70, 30, 20, 20, 50, 50 };

		int[] arr2 = { 50, 80, 30, 20, 20, 20, 20, 20, 20, 90, 50, 20 };

//		Inter(arr1, arr2);
		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		LongestConsSeq(arr);
	}

	public static void Inter(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr1.length; i++) {
//			map.put(arr1[i], 0);
//			if(map.containsKey(arr1[i])) {
//				int prev_freq = map.get(arr1[i]);
//				map.put(arr1[i],prev_freq+1);
//				
//			}else {
//				map.put(arr1[i], 1);
//			}
			int prev_freq = map.getOrDefault(arr1[i], 0);
			map.put(arr1[i], prev_freq + 1);

		}
		System.out.println(map);
		for (int i = 0; i < arr2.length; i++) {
			if (map.containsKey(arr2[i]) && map.get(arr2[i]) > 0) {
				System.out.println(arr2[i]);
				map.put(arr2[i], map.get(arr2[i]) - 1);
			}
		}
	}

	public static void LongestConsSeq(int[] arr1) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < arr1.length; i++) {
			if (map.containsKey(arr1[i] - 1)) {
				map.put(arr1[i], false);
			} else {
				map.put(arr1[i], true);
			}
			if (map.containsKey(arr1[i] + 1)) {
				map.put(arr1[i] + 1, false);
			}
		}
		System.out.println(map);
		for (int i : map.keySet()) {
			if (map.get(i)) {
//				System.out.println(i);
				int start = i;
				while(map.containsKey(start)) {
					System.out.print(start+" ");
					start++;
				}
				System.out.println();
			}
		}
	}
}
