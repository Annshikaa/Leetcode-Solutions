class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        buy = prices[0]
        max_profit = 0

        for i in range(n):
            if buy > prices[i]:
                buy = prices[i]
            elif prices[i] - buy > max_profit:
                max_profit = prices[i] - buy
        return max_profit