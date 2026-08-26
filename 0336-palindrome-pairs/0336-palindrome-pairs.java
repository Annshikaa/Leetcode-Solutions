class Solution {
    final static int N = 26;
    static class Trie {
        Trie[] child;
        Integer index;

        Trie(){
            this.child = new Trie[N];
        }
    }

    private boolean isPalindrome(char[] ch, Map<Integer, Boolean> memo, int i, int j){
        if(i >= j) return true;
        int val = 1000 * i + j;
        if(memo.containsKey(val)) return memo.get(val);

        while(i < j){
            if(ch[i] != ch[j]) {
                memo.put(val, false);
                return false;
            }
            i++; j--;
        }
        memo.put(val, true);
        return true;
    }

    private void insert(Trie normal, Trie reverse, char[] ch, int index){
        int len = ch.length;
        
        for(int i=0; i<len; i++){
            int val1 = ch[i] - 'a', val2 = ch[len-i-1] - 'a';
            
            if(normal.child[val1] == null) normal.child[val1] = new Trie();
            if(reverse.child[val2] == null) reverse.child[val2] = new Trie();

            normal = normal.child[val1];
            reverse = reverse.child[val2];
        }

        normal.index = index;
        reverse.index = index;
    }

    private void match(Trie normal, Trie reverse, char[] ch, int index, List<List<Integer>> l1){
        int len = ch.length;
        Map<Integer, Boolean> memo = new HashMap<>(); 

        if(normal.index != null){
            if(isPalindrome(ch, memo, 0, len-1)){
                l1.add(Arrays.asList(normal.index, index));
                l1.add(Arrays.asList(index, normal.index));
            }
        }
        
        for(int i=0; i<len; i++){
            int val = ch[i] - 'a';
            if(reverse.child[val] == null) break;
            reverse = reverse.child[val];
            if(reverse.index != null && isPalindrome(ch, memo, i+1, len-1)) 
                l1.add(Arrays.asList(index, reverse.index));
        }
        
        for(int i=len-1; i>=0; i--){
            int val = ch[i] - 'a';
            if(normal.child[val] == null) break;
            normal = normal.child[val];
            if(normal.index != null && isPalindrome(ch, memo, 0, i-1)) 
                l1.add(Arrays.asList(normal.index, index));
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Trie normal = new Trie(), reverse = new Trie();
        
        int len = words.length;
        Integer[] sort = new Integer[len];
        for(int i=0; i<len; i++) sort[i] = i;

        Arrays.sort(sort, (a, b) -> Integer.compare(words[a].length(), words[b].length()));

        List<List<Integer>> l1 = new ArrayList<>();
        for(int i=0; i<len; i++){
            char[] ch = words[sort[i]].toCharArray();
            match(normal, reverse, ch, sort[i], l1);
            insert(normal, reverse, ch, sort[i]);
        } 
        return l1;
    }
}