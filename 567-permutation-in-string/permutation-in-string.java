class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            count2[s2.charAt(i) - 'a']++;
        }
        if (matches(count1, count2)) {
            return true;
        }
        for (int right = s1.length(); right < s2.length(); right++) {

            count2[s2.charAt(right) - 'a']++;
            int left = right - s1.length();
            count2[s2.charAt(left) - 'a']--;
            if (matches(count1, count2)) {
                return true;
            }
        }

        return false;
    }

    public boolean matches(int[] a, int[] b) {

        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}