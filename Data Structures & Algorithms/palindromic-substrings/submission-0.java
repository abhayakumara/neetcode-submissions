class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        for(int i=0; i<n; i++) {
            ans+=expand(s, i, i) + expand(s, i, i+1);
        }
        return ans;
    }

    private int expand(String s, int i, int j) {
        //expand from center if palindrome
        int n = s.length();
        int count = 0;
        while(i >=0 && j <n && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }

        return count;
    }
}
