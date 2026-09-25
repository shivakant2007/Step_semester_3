public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        String s = text.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        String s = text.toLowerCase();
        return isPalindromeRecursiveHelper(s, 0, s.length() - 1);
    }

    private static boolean isPalindromeRecursiveHelper(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return isPalindromeRecursiveHelper(s, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        String s = text.toLowerCase();
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
        String reversed = new String(arr);
        return s.equals(reversed);
    }

    public static void main(String[] args) {
        String[] testWords = {"racecar", "hello"};

        for (String word : testWords) {
            System.out.println("Testing: " + word);
            boolean iter = isPalindromeIterative(word);
            boolean recur = isPalindromeRecursive(word);
            boolean arrRev = isPalindromeArrayReversal(word);

            System.out.println("  Iterative:        " + iter);
            System.out.println("  Recursive:        " + recur);
            System.out.println("  Array Reversal:   " + arrRev);
            System.out.println("  All agree: " + (iter == recur && recur == arrRev));
            System.out.println();
        }
    }
}
