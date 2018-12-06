import java.util.*;

public class GuessingGame {
	public static void main(String[] args) {
            int[] array = new int[2001];
            for (int i = 0; i < array.length; i++){
                  array[i] = i;
            }
		
		int secretNumber;
            secretNumber = (int) (Math.random() * 2000);
            
		int index = binarySearch(array, secretNumber, 0, array.length -1);
		System.out.println(index + " is correct. Congratulations!");
      }
      
      public static int binarySearch(int[] array, int value, int left, int right) {
        int guess;

		if (left > right) {
			return -1;
		}
		
		int middle = (left + right) / 2;
		if (array[middle] == value) {
			return middle;
		}
		else if (array[middle] > value) {
			int leftArray[] = new int[middle];
            System.out.println( array[middle] + " is greater than the secret number.");
			for (int i = left; i < middle; i ++) {
				leftArray[i] = array[i];
			}
			// search left subarray
			return binarySearch(array, value, left, middle - 1);
		}
		else {
		   System.out.println( array[middle] + "is smaller than the secret number.");
			int rightArrays[] = new int[right - middle];
			int rigthArrayIndex = 0;
			for (int i = middle + 1; i <= right; i ++) {
				rightArrays[rigthArrayIndex] = array[i];
				rigthArrayIndex ++;
			}
			// search right subarray
			return binarySearch(array, value, middle + 1, right);
		}
	}
}