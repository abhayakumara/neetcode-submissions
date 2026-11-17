class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int startInd = -1, minLen = n + 1;
        int count = t.length();
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i=0, j=0;

        while(j < n) {
            char ch = s.charAt(j);
            if(map.containsKey(ch)) {
                if(map.get(ch) > 0) {
                    count--;
                }
                map.put(ch, map.get(ch) - 1);
            }

            while(count == 0) {
                //store the current answer
                if((j - i + 1) < minLen) {
                    startInd = i;
                    minLen = j-i+1;
                }

                //shrink the window from left
                char left = s.charAt(i);
                if(map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);
                    if(map.get(left) > 0) {
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return minLen == n+1 ? "" : s.substring(startInd, startInd + minLen);
    }
}
