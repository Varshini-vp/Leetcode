class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int sum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Slide the window
        for (int right = k; right < nums.length; right++) {

            sum += nums[right];
            sum -= nums[right - k];

            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}