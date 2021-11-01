//Created by: Andrew Eisenhour
//Created on: 11/3/2020
//This program divides an array of integers into fourths and uses four threads to search for all matches of a search value, outputting the indexes of each match
class ThreadSearch {	//Search for all matches using 4 threads
	public static void main(String[] args) {	//main start
		int search = 1;	//the value to be searched for
		int[] arr = makeArr();	//create the array to be sorted through
		SearchThread thread1 = new SearchThread(arr, search, 0, arr.length/4);	//first thread covers the first fourth
		SearchThread thread2 = new SearchThread(arr, search, arr.length/4, arr.length/2);	//second thread covers the second fourth
		SearchThread thread3 = new SearchThread(arr, search, arr.length/2, (3*arr.length)/4);	//third thread covers the third fourth
		SearchThread thread4 = new SearchThread(arr, search, (3*arr.length)/4, arr.length);	//fourth thread covers the fourth fourth
		thread1.start();	//start thread1
		thread2.start();	//start thread2
		thread3.start();	//start thread3
		thread4.start();	//start thread4
	}	//end main
	static int[] makeArr() {	//method to create random integer array
		int arr[] = new int[1000];	//create array of length 1000
		for (int i = 0; i<arr.length; i++) {	//for each spot of 1000
			arr[i] = (int)(Math.random()*10);	//assign random single-digit integer
		}	//end for
		return arr;	//return the random array
	}	//end makeArr
}	//end ThreadSearch class

class SearchThread extends Thread {	//class to define behavior for each thread
	int[] arr;	//the array to be searched
	int search;	//the value to be searched for
	int start;	//the start index
	int stop;	//the stop index
	SearchThread(int[] arr, int search, int start, int stop) {	//constructor for SearchThread
		this.arr = arr;	//receive the array
		this.search = search;	//receive the search value
		this.start = start;	//receive the start index
		this.stop = stop;	//receive the stop index
	}	//end SearchThread constructor
	public void run() {	//what each thread does
		for (int i = start; i<stop; i++) {	//for each value in the range of start to stop
			if (arr[i]==search) {	//if the current value matches the search value
				System.out.println(i);	//print out the index of the current value
			}	//end if
		}	//end for
	}	//end run
}	//end SearchThread class
