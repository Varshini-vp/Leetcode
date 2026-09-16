class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int sum = 0;
        int count = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        // Check first window
        if (sum >= threshold * k) {
            count++;
        }

        // Slide the window
        for (int right = k; right < arr.length; right++) {

            sum += arr[right];
            sum -= arr[right - k];

            if (sum >= threshold * k) {
                count++;
            }
        }

        return count;
    }
}