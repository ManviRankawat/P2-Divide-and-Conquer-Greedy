import java.util.ArrayList;
import java.util.Random;

public class p2 {
    public static int findMax(ArrayList<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            int prev = (mid + arr.size() - 1) % arr.size();
            int next = (mid + 1) % arr.size();

            if (arr.get(mid) > arr.get(prev) && arr.get(mid) > arr.get(next)) {
                return arr.get(mid);
            } else if (arr.get(mid) < arr.get(right)) {
                right = mid;
            } else if (arr.get(mid) > arr.get(right)) {
                left = mid + 1;
            }
        }

        return arr.get(left);
    }

    public static void main(String[] args) {
        Random random = new Random();
        int maxArraySize = 1000000; // Maximum array size

        // Loop to test different array sizes
        for (int size = 10; size <= maxArraySize; size *= 10) {
            ArrayList<Integer> shiftedArray = new ArrayList<>();
            
            // Generate a sorted and circularly shifted array of the specified size
            for (int i = 1; i <= size; i++) {
                shiftedArray.add(i);
            }
            int shiftAmount = random.nextInt(size);
            for (int i = 0; i < shiftAmount; i++) {
                int first = shiftedArray.remove(0);
                shiftedArray.add(first);
            }

            // Record the start time in nanoseconds
            long startTime = System.nanoTime();

            int maximum = findMax(shiftedArray);

            // Record the end time in nanoseconds
            long endTime = System.nanoTime();

            // Calculate and display the runtime in microseconds
            long runtime = (endTime - startTime) / 1000; // Convert nanoseconds to microseconds
            System.out.println("Array size: " + size + ", Runtime: " + runtime + " microseconds");
        }
    }
}
