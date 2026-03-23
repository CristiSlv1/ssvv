import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input validation
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input for n");
            return;
        }

        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("n must be >= 1");
            return;
        }

        int[] arr = new int[n];

        readSequence(n, arr, sc);

        int[] result = computeMaxSeq(n, arr);

        printSequence(arr, result[0], result[1]);
    }

    static void readSequence(int n, int[] arr, Scanner sc) {
        for (int i = 0; i < n; i++) {
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input detected");
                System.exit(1);
            }
            arr[i] = sc.nextInt();
        }
    }

    static int[] computeMaxSeq(int n, int[] arr) {
        int maxLen = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            int len = computeASequence(i, n, arr);

            if (len > maxLen) {
                maxLen = len;
                start = i;
            }
        }

        return new int[]{start, maxLen};
    }

    static int computeASequence(int start, int n, int[] arr) {
        Set<Integer> distinct = new HashSet<>();
        int len = 0;

        for (int i = start; i < n; i++) {
            if (!distinct.contains(arr[i]) && distinct.size() == 3) {
                break;
            }

            distinct.add(arr[i]);
            len++;
        }

        return len;
    }

    static void printSequence(int[] arr, int start, int length) {
        System.out.println("Start: " + start);
        System.out.println("Length: " + length);

        for (int i = start; i < start + length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
