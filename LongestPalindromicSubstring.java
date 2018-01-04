class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String t1 = helper(s, i, i);
            String t2 = helper(s, i, i + 1);
            if (t1.length() > res.length()) {
                res = t1;
            }
            if (t2.length() > res.length()) {
                res = t2;
            }
        }
        return res;
    }
    
    private String helper(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
