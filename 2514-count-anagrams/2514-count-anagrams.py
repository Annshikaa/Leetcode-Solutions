class Solution:
    def countAnagrams(self, s: str) -> int:

        MOD = 10 ** 9 + 7
        words = s.split()
        ans = 1

        for word in words:
            n = len(word)
            ways = factorial(n)
            freq = Counter(word)

            for count in freq.values():
                ways //= factorial(count)
            ans = (ans * ways) % MOD
        return ans

        