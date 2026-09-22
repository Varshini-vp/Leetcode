class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
         int left = 1;
    int right = 0;

    for (int num : nums) {
        right = Math.max(right, num);
    }

    int answer = right;

    while (left <= right) {

        int mid = left + (right - left) / 2;

        long groups = 0;

        for (int num : nums) {
            groups += (num + mid - 1) / mid;

            if (groups > threshold) {
                break;
            }
        }

        if (groups <= threshold) {
            answer = mid;
            right = mid - 1;       // ⭐ THIS WAS MISSING
        } else {
            left = mid + 1;
        }
    }

    return answer;
   
    }
}