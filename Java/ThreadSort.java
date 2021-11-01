//Created by: Andrew Eisenhour
//Created on: 11/10/2020
//This program divides an array of integers into fourths and uses four threads to counter sort
class ThreadSort {	//Implement counter sort with threads
	public static void main(String[] args) throws InterruptedException {	//main start
		int[] arr = makeArr();	//create the array to be sorted through
		int[] counter = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};	//final counter array
		int[] temp;	//temp array to receive each thread's array
		CounterThread thread1 = new CounterThread(arr, 0, arr.length/4);	//first thread covers the first fourth
		CounterThread thread2 = new CounterThread(arr, arr.length/4, arr.length/2);	//second thread covers the second fourth
		CounterThread thread3 = new CounterThread(arr, arr.length/2, (3*arr.length)/4);	//third thread covers the third fourth
		CounterThread thread4 = new CounterThread(arr, (3*arr.length)/4, arr.length);	//fourth thread covers the fourth fourth
		thread1.start();	//start thread1
		thread2.start();	//start thread2
		thread3.start();	//start thread3
		thread4.start();	//start thread4
		thread1.join();	//join thread1
		counter = thread1.getCount();	//get thread1's counter array, set counter equal to that
		thread2.join();	//join thread2
		temp = thread2.getCount();	//get thread2's counter array
		for (int i = 0; i<10; i++) {	//for each number
			counter[i]+=temp[i];	//increment the counter array by thread2's counter array
		}	//end for
		thread3.join();	//join thread3
		temp = thread3.getCount();	//get thread3's counter array
		for (int i = 0; i<10; i++) {	//for each number
			counter[i]+=temp[i];	//increment the counter array by thread3's counter array
		}	//end for
		thread4.join();	//join thread4
		temp = thread4.getCount();	//get thread4's counter array
		for (int i = 0; i<10; i++) {	//for each number
			counter[i]+=temp[i];	//increment the counter array by thread4's counter array
		}	//end for
		for (int i = 0; i<10; i++) {	//print sorted array
			for (int j = 0; j<counter[i]; j++) {	//print each number
				System.out.print(i + " ");	//print with a space
			}	//end for
			System.out.println("");	//print newline
		}	//end for
	}	//end main
	static int[] makeArr() {	//method to create random integer array
		int arr[] = new int[1000];	//create array of length 1000
		for (int i = 0; i<arr.length; i++) {	//for each spot of 1000
			arr[i] = (int)(Math.random()*10);	//assign random single-digit integer
		}	//end for
		return arr;	//return the random array
	}	//end makeArr
}	//end ThreadSearch class

class CounterThread extends Thread {	//class to define behavior for each thread
	int[] arr;	//the array to be sorted
	int start;	//the start index
	int stop;	//the stop index
	int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};	//counter array for each thread, starts at 0
	CounterThread(int[] arr, int start, int stop) {	//constructor for CounterThread
		this.arr = arr;	//receive the array
		this.start = start;	//receive the start index
		this.stop = stop;	//receive the stop index
	}	//end CounterThread constructor
	
	public void run() {	//what each thread does
		for (int i = start; i<stop; i++) {	//for each value in the range of start to stop
			count[arr[i]]++;	//increment the correct value of the counter array
		}	//end for
	}	//end run
	public int[] getCount() {	//getter method for counter array
		return count;	//return counter array
	}	//end getCount
}	//end CounterThread class
