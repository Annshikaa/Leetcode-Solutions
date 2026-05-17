class Solution:
    def maximumSwap(self, num: int) -> int:
        digits = list(str(num))
        max_num = num

        for i in range(len(digits)):
            for j in range(i + 1, len(digits)):
                digits[i], digits[j] = digits[j], digits[i]

                curr = int("".join(digits))

                max_num = max(max_num, curr)

                digits[i], digits[j] = digits[j] , digits[i]
        return max_num