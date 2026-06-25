class Solution {
    public int maxRepOpt1(String text) {
        int n = text.length();
        int[] totalCount = new int[26]; // har char ka total count

        for (char ch : text.toCharArray()) {
            totalCount[ch - 'a']++;
        }

        int ans = 0;

        // har character ke liye window check karenge
        for (char target = 'a'; target <= 'z'; target++) {
            if (totalCount[target - 'a'] == 0) continue; // agar wo char hai hi nahi

            int start = 0, countTarget = 0, extra = 0;

            for (int end = 0; end < n; end++) {
                if (text.charAt(end) == target) {
                    countTarget++;
                } else {
                    extra++;
                }

                // window me 1 se jyada "different char" nahi hona chahiye
                while (extra > 1) {
                    if (text.charAt(start) != target) extra--;
                    else countTarget--;
                    start++;
                }

                // current window ka length calculate karo
                int windowLen = end - start + 1;
                // agar is char ka total aur zyada hai, ek extra swap kar sakte ho
                ans = Math.max(ans, Math.min(windowLen, totalCount[target - 'a']));
            }
        }

        return ans;
    }
}