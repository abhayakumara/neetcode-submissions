class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int minCoins = helperMemo(coins, amount);
        return minCoins >= 1e9 ? -1 : minCoins;
    }

    private int helper(int[] coins, int amount) {
        if(amount == 0) return 0;

        int res = (int) 1e9;

        for(int coin : coins) {
            // valid coin to consider
            if(amount - coin >= 0) {
                res = Math.min(res, 1+helper(coins, amount-coin));
            }
        }
        return res;
    }

    private int helperMemo(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int res = (int) 1e9;

        for(int coin : coins) {
            // valid coin to consider
            if(amount - coin >= 0) {
                res = Math.min(res, 1+helperMemo(coins, amount-coin));
            }
        }
        memo.put(amount, res);
        return res;
    }
}
