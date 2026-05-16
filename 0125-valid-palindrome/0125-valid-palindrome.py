class Solution:
    def isPalindrome(self, s: str) -> bool:
        newstr = ""

        for ch in s:
            if ch.isalnum():
                newstr += ch.lower()
            
        return newstr == newstr[::-1]