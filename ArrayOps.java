public class ArrayOps {
    public static void main(String[] args) {
        // System.out.println(findMissingInt(new int[] {0}));
        // System.out.println(secondMaxValue(new int[] {1,-2,3,-4,5}));
        // System.out.println(containsTheSameElements(new int[] {1,2,3,-4,5}, new int[] {1,3,-4,5}));
        System.out.println(isSorted(new int[] {1, 3, 2}));
    }
    
    //finds the missing paramater in the given
    //array and returns it
    public static int findMissingInt (int [] array) {

        int[] arr = new int[array.length + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (indexOf(array, arr[i]) == -1) {
                return arr[i];
            }
        }

        return -1;
    }

    //returns the index of n in the given array
    //if n is not in array, returns -1
    public static int indexOf(int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }

    //returns the second max value in the
    //given array
    public static int secondMaxValue(int [] array) {

        int maxValue = maxValue(array), secondMax = Integer.MIN_VALUE;
        boolean isMax = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != maxValue) {
                secondMax = Math.max(secondMax, array[i]);
            }
            else {
                if (isMax) {
                    secondMax = Math.max(secondMax, array[i]);
                }
                isMax = true;
            }
        }

        return secondMax;
    }

    //returns the max value of the
    //given array
    public static int maxValue(int[] array) {
        
        int maxValue = array[0];

        for (int i = 1; i < array.length; i++) {
            maxValue = Math.max(maxValue, array[i]);
        }

        return maxValue;
    }

    //return if every number in array1 is in array2 and the other way arround
    public static boolean containsTheSameElements(int [] array1, int [] array2) {
        
        return isFirstInTheSecond(array1, array2) && isFirstInTheSecond(array2, array1);
    }

    public static boolean isFirstInTheSecond(int [] array1, int [] array2) {

        for (int i = 0; i < array1.length; i++) {
            if (indexOf(array2, array1[i]) == -1) {
                return false;
            }
        }

        return true;

    }

    //returns if the given array is sorted from
    //min to max or from max to min
    public static boolean isSorted(int [] array) {
        
        boolean up = false, down = false;
        int first = array[0];

        for (int i = 1; i < array.length; i++) {
            
            if (up) {
                if (first > array[i]) {
                    return false;
                }
            }

            if (down) {
                if (first < array[i]) {
                    return false;
                }
            }            

            if (array[i] > first) {
                up = true;
            }
            if (first > array[i]) {
                down = true;
            }

            first = array[i];
        }

        return true;
    }

}
