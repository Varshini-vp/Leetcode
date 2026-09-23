class Solution {
    public int[] frequencySort(int[] nums) {

        // Step 1: Count frequency of each number
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Store unique numbers
        Integer[] elements = new Integer[freq.size()];

        int index = 0;

        for (int num : freq.keySet()) {
            elements[index++] = num;
        }

        // Step 3: Sort
        Arrays.sort(elements, (a, b) -> {

            // Lower frequency first
            if (freq.get(a) != freq.get(b)) {
                return freq.get(a) - freq.get(b);
            }

            // Same frequency -> larger number first
            return b - a;
        });

        // Step 4: Build the answer
        int[] result = new int[nums.length];
        index = 0;

        for (int num : elements) {

            int count = freq.get(num);

            while (count > 0) {
                result[index++] = num;
                count--;
            }
        }

        return result;
    }
}