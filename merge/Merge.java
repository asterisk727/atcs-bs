import java.util.Arrays;

// Written component at the bottom

public class Merge {
    private static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        System.out.println(
            "Split " + Arrays.toString(arr) +
            " into "+ Arrays.toString(left) +
            " and " + Arrays.toString(right)
        );

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        System.out.println(
            "Merging " + Arrays.toString(left) +
            " and " + Arrays.toString(right)
        );

        int[] result = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            }
            else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }

        System.out.println("Merged into " + Arrays.toString(result));

        return result;
    }

    public static void main(String[] args) {
        int[] dataset = {42, 17, 93, 58, 11, 27, 84, 66, 39, 5, 72};

        System.out.println(Arrays.toString(dataset));

        int[] sorted = mergeSort(dataset);
        System.out.println(Arrays.toString(sorted));
    }
}

/*
1. 
divide: into subarrays that are shorter, whcih is an easier problem to solve.
conquer: well... actually sort them

2.
always log(n) calls to mergeSort()
that produces log(n) calls to merge()
merge() needs up to n comparisons

worst case O(n*log(n))

3.
keeps defining new subarrays on the stack with every recursive call

4.
merge sort outperforms if the list is in reverse order which is O(n^2) for insertion sort
insertion sort outperforms if the list is already sorted lol (O(n) vs O(n*log(n)))
*/