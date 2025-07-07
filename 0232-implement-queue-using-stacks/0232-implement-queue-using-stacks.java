class MyQueue {
    Stack<Integer> a,b;
    public MyQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }
    
    public void push(int x) {
        a.add(x);
    }
    
    public int pop() {
        if(b.isEmpty()){
            while(!a.isEmpty()){
                b.add(a.pop());
            }
        }
        return b.pop();
    }
    
    public int peek() {
        if(b.isEmpty()){
            while(!a.isEmpty()){
                b.add(a.pop());
            }
        }
        return b.peek();
    }
    
    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */