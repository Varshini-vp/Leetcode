class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Long, Long> map = new HashMap<>();

        long prefix = 0;
        long ans = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            long x = nums[i];

            // Check for x - k
            Long p1 = map.get(x - k);

            if (p1 != null) {
                long sum = prefix + x - p1;
                ans = Math.max(ans, sum);
            }

            // Check for x + k
            Long p2 = map.get(x + k);

            if (p2 != null) {
                long sum = prefix + x - p2;
                ans = Math.max(ans, sum);
            }

            // Store the minimum prefix sum for x
            Long old = map.get(x);

            if (old == null) {
                map.put(x, prefix);
            } else {
                map.put(x, Math.min(old, prefix));
            }

            // Add current element to prefix sum
            prefix += x;
        }

        // If no good subarray exists
        if (ans == Long.MIN_VALUE) {
            return 0;
        }

        return ans;
    }
}