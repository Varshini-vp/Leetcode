class Solution {
    public int maxVowels(String s, int k) {
        int max=0;
        int cnt=0;
        for(int i=0;i<k;i++){
            if (isVowel(s.charAt(i))){
            cnt++;
        }}
        max=cnt;
        for (int i=k;i<s.length();i++){
            if (isVowel(s.charAt(i-k))){
                cnt--;
            }
            if (isVowel(s.charAt(i))){
                cnt++;
            }
            max=Math.max(max,cnt);
        }
        return max;
    }
    public boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}