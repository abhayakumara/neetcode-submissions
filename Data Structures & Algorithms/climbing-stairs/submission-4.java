class Solution {
    public int climbStairs(int n) {
        if(n <=2) return n;
        int ans = 0;
        int first = 1, sec = 2;

        for(int i=3; i<=n; i++) {
            ans = first + sec;
            first = sec;
            sec = ans;
        }
        return ans;
    }
}
