class Solution:
    def minSteps(self, s: str, t: str) -> int:
        count_s = Counter(s)
        count_t = Counter(t)

        total_steps = sum((count_s - count_t).values())

        return total_steps