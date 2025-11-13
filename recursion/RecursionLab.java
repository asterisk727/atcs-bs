public class RecursionLab {
    public static int sumDigits(int n) {
        if (n == 0) {
            return 0; // base case 
        }
        else {
            return n % 10 + sumDigits(n / 10); // recursive step
        }
    }

    public static String reverseString(String s) {
        if (s.length() <= 1) {
            return s; // base case: 0 or 1 length, nothing to reverse
        }
        return s.substring(s.length() - 1) + reverseString(s.substring(0, s.length() - 1)); // recursive step: reverse two chars and recurse the remainder string
    }

    public static int countPaths(int row, int col, int n) {
        if (row == (n - 1) || col == (n - 1)) {
            return 1; // "base case"; reached the edges with only 1 path
        }
        return countPaths(row + 1, col, n) + countPaths(row, col + 1, n); // recursive step: get paths from adjacent tiles
    }

    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1; // "base case": target not found
        }

        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return mid; // base case: done searching
        }
        if (arr[mid] > target) {
            return binarySearchRecursive(arr, target, low, mid - 1); // recurse to smaller range with larger elements
        }
        if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, high); // recurse to smaller range with smaller elements
        }
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true; // edge case: if odd length, middle char doesn't matter, always palindromic
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindrome(s.substring(1, s.length() - 1)); // recursive step: check palindromity for substring
        }
        return false; // atp we know its not a palindrome
    }

    public static void main(String[] args) {
        System.out.println("sumDigits(12345): " + sumDigits(12345));
        System.out.println("sumDigits(222): " + sumDigits(222));
        System.out.println("sumDigits(98765): " + sumDigits(98765));

        
        System.out.println("reverseString(\"abc\"): " + reverseString("abc"));
        System.out.println("reverseString(\"apple\"): " + reverseString("apple"));
        System.out.println("reverseString(\"aba\"): " + reverseString("aba"));

        System.out.println("countPaths(0, 0, 2): " + countPaths(0, 0, 2));
        System.out.println("countPaths(0, 0, 3): " + countPaths(0, 0, 3));
        System.out.println("countPaths(0, 0, 4): " + countPaths(0, 0, 4));

        int[] nums = {1, 3, 5, 7, 9, 11};
        System.out.println("binarySearchRecursive(nums, 7, 0, 5): " + binarySearchRecursive(nums, 7, 0, 5));
        System.out.println("binarySearchRecursive(nums, 1, 0, 5): " + binarySearchRecursive(nums, 1, 0, 5));
        System.out.println("binarySearchRecursive(nums, 10, 0, 5): " + binarySearchRecursive(nums, 10, 0, 5));

        System.out.println("isPalindrome(\"aboba\"): " + isPalindrome("aboba"));
        System.out.println("isPalindrome(\"abba\"): " + isPalindrome("abba"));
        System.out.println("isPalindrome(\"banana\"): " + isPalindrome("banana"));
    }
}
