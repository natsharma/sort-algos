package sortingalgos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Mergesort<K> {
	
	/**
	 * public static String[] mergeSortArray(String[] array) {
        String [] sorted = new String[array.length];
        if (array.length == 1) {
            sorted = array;
        } else {
            int mid = array.length/2;
            String[] left = null; 
            String[] right = null;
            if ((array.length % 2) == 0) {
                left = new String[array.length/2];
                right = new String[array.length/2];
            } else { 
                left = new String[array.length/2];
                right = new String[(array.length/2)+1];
            }
            int x=0;
            int y=0;
            for ( ; x < mid; x++) {
                left[x] = array[x];
            }
            for ( ; x < array.length; x++) {
                right[y++] = array[x];
            }
            left = mergeSortArray(left);
            right = mergeSortArray(right);
            sorted = merge(left,right);
        }
        System.out.println("Sorted List of Characters: ");
        for (String s : sorted){
        	System.out.println(s);
        }
        return sorted;
    }

    private static String[] merge(String[] left, String[] right) {
        String[] merged = new String[left.length+right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int midIndex = 0;
        int count = 0;
        while (leftIndex < left.length || rightIndex < right.length) {
            if (leftIndex == left.length) {
                merged[midIndex++] = right[rightIndex++];
            } else if (rightIndex == right.length) {
                merged[midIndex++] = left[leftIndex++];
            } else {  
                count = left[leftIndex].compareTo(right[rightIndex]);
                if (count > 0) {
                    merged[midIndex++] = right[rightIndex++];
                } else if (count < 0) {
                    merged[midIndex++] = left[leftIndex++];
                } else { 
                    merged[midIndex++] = left[leftIndex++];
                }
            }   
        }
        return merged;
    }
	 */
	
	
	public static String[] mergeSortArray(String[] arr) {
		String[] sorted = new String[arr.length];
		if (arr.length == 1) {
			sorted = arr;
		} else {
			int mid = arr.length/2;
			String[] left = null;
			String[] right = null;
			if((arr.length % 2) == 0) {
				left = new String[arr.length/2];
				right = new String[arr.length/2];
			} else {
				left = new String[arr.length/2];
				right = new String[arr.length/2 + 1];
			}
			int x=0;
			int y=0;
			for ( ; x<mid; x++) {left[x] = arr[x];}
			for ( ; y<arr.length; x++) {right[y++] = arr[x];}
			left = mergeSortArray(left);
			right = mergeSortArray(right);
			sorted = merge(left, right);
		}
		return sorted;
	}
	private static String[] merge(String[] left, String[] right) {
		String[] merged = new String[left.length + right.length];
		int leftIndex = 0;
		int rightIndex = 0;
		int midIndex = 0;
		int count = 0;
		while (leftIndex < left.length || rightIndex < right.length) {
			if (leftIndex == rightIndex) {
				merged[midIndex++] = right[rightIndex++];
			} else if (rightIndex == right.length) {
				merged[midIndex++] = left[leftIndex++];
			} else {
				count = left[leftIndex].compareTo(right[rightIndex]);
				if (count > 0) {
					merged[midIndex++] = right[rightIndex++];
				}
			}
		}
		return merged;
	}
	
	public static void main(String [] args) throws FileNotFoundException {
		
		HashMap<String, String> map = new HashMap<String, String>(); 
		String filename = "src/dsclasswork/janeeyre.txt";
		File file = new File(filename);
		Scanner sc = new Scanner(file);
		String buffarray[];
		while (sc.hasNext()){
			String line = sc.next();
			buffarray = line.replaceAll("[^a-zA-Z]", "").toLowerCase().split("\\s+");
			for (String word : buffarray){
				char c = word.charAt(word.length()-1);
				String s = Character.toString(c);
				if (!map.containsKey(word)){
					map.put(word, s);
				}
			}
		}
		ArrayList<String> keyArray = new ArrayList<String>();
		for (String key : map.keySet()){
			keyArray.add(map.get(key));
		}
		//print keys 
		for (String item : keyArray){
			System.out.println(item);
		}
		//convert ArrayList to Array
		String[] newKeyArray = new String[keyArray.size()];
		newKeyArray = keyArray.toArray(newKeyArray);
		mergeSortArray(newKeyArray);
	}

}
