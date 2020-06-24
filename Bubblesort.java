package sortingalgos;
public class Bubblesort {
	
	public static void main(String [] args) {
		int[][] tests = {
			      {},
			      {1},
			      {1, 2},
			      {2, 1},
			      {3, 5, 2, 4, 1, 9, 10, 12, 11, 8, 7, 6},
			    };

			    for (int[] raw : tests) {
			      PositionalList<Integer> data = new LinkedPositionalList<>();
			      for (int c : raw)
			        data.addLast(c);
			      System.out.println("Before: " + data);
			      bubbleSort(data);
			      System.out.println("After:  " + data);
			      System.out.println();
			    }	
	}
	//does a bubble sort with a positional linked list: net.datastructures 
	public static void bubbleSort(PositionalList<Integer> list) {
		while (list != null) {
			for (int i=0; i<list.size(); i++) {
				Position<Integer> marker = list.first();
				Position<Integer> pivot = list.after(marker);
				for (int j=0; j<list.size()-1; j++) {
					if (marker.getElement() > pivot.getElement()) {
						Position<Integer> temp = marker;
						marker = pivot;
						pivot = temp;
					}
					marker = pivot;
					pivot = list.after(pivot);
				}
			}
		}
	}

}
