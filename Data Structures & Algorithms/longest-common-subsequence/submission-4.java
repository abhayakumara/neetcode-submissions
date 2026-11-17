class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String t1, String t2) {
        dp = new Integer[t1.length() + 1][t2.length() + 1];
        return helperMemo(t1, 0, t2, 0);
    }

    private int helper(String t1, int i, String t2, int j) {
        if(i >= t1.length()) return 0;
        if(j >= t2.length()) return 0;

        if(t1.charAt(i) == t2.charAt(j)) {
            i++;
            j++;
            return 1 + helper(t1, i, t2, j);
        }

        return Math.max(helper(t1, i+1, t2, j), helper(t1, i, t2, j+1));
    }


    private int helperMemo(String t1, int i, String t2, int j) { 
        if(i >= t1.length()) return 0;
        if(j >= t2.length()) return 0;

        if(dp[i][j] != null) return dp[i][j];

        if(t1.charAt(i) == t2.charAt(j)) {
            i++;
            j++;
            // dp[i][j] = ;
            return 1 + helperMemo(t1, i, t2, j);
        }
        dp[i][j] = Math.max(helperMemo(t1, i+1, t2, j), helperMemo(t1, i, t2, j+1));
        return dp[i][j];
    }
}
