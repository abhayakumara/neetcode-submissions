class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int numDecodings(String s) {
        memo.put(s.length(), 1);
        return dfsMemo(0, s);
    }

    private int dfs(int i, String s) {
        if (i == s.length())
            return 1;
        if (s.charAt(i) == '0')
            return 0;

        int res = dfs(i + 1, s);

        if (i < s.length() - 1) {
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                res += dfs(i + 2, s);
            }
        }
        return res;
    }

    private int dfsMemo(int i, String s) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        if (s.charAt(i) == '0')
            return 0;

        int res = dfsMemo(i + 1, s);
        if (i + 1 < s.length()
            && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
            res += dfsMemo(i + 2, s);
        }
        memo.put(i, res);
        return res;
    }
}
