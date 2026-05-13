class Solution {
    public int calc( int a, int b, String op){
        if(op.equals("+")) return a + b;
        if(op.equals("-")) return a - b;
        if(op.equals("*")) return a * b;
        return a/b;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String t: tokens) {
            if(t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(calc(b, a, t));

            }
            else {
                stack.push(Integer.parseInt(t));
            }

        } 
        return stack.peek();
        
   }
}