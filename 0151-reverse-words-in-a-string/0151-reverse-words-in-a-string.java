class Solution {
    public String reverseWords(String s) {
        String sentence = "";
        String word = "";

        for (int i = 0; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) != ' ') {
                word += s.charAt(i);
            } else if (word.length() > 0 && sentence.length() > 0) {
                sentence = word + ' ' + sentence;
                word = "";
            } else if (word.length() > 0) {
                sentence = word;
                word = "";
            }
        }

        return sentence;
    }
}