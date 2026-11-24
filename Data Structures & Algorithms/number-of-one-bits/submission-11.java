class Solution {
    // public int hammingWeight(int n) {
    //     int ans = 0;
    //     while(n > 0) {
    //         ans+=n%2;
    //         n/=2;
    //     }
    //     return ans;
    // }

    public int hammingWeight(int n) {
        int ans = 0;
        for(int i=0; i<32; i++) {
            ans+=((1 << i) & n) != 0 ? 1 : 0;
        }
        return ans;
    }
}
