class Solution {
    public String longestPalindrome(String s) {
        // start index and max len
        int startInd = 0, maxLen = -1;
        int n = s.length();

        for(int i=0; i<n; i++) {
            //expand should return startIndex and len
            int[] odd = expand(s, i, i);
            int[] even = expand(s, i, i + 1);

            if(odd[1] > maxLen) {
                maxLen = odd[1];
                startInd = odd[0];
            }

            if(even[1] > maxLen) {
                maxLen = even[1];
                startInd = even[0];
            }
        }
        return s.substring(startInd, startInd + maxLen);
    }

    private int[] expand(String s, int i, int j) {
        //expand from center if palindrome
        int n = s.length();
        while(i >=0 && j <n && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        return new int[]{i+1, j - i -1};
    }
}
