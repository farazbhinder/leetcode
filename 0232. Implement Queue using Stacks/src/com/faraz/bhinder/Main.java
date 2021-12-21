package com.faraz.bhinder;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }
}

class MyQueue {

    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        while (pushStack.size() > 0) {
            popStack.push(pushStack.pop());
        }
        int firstInQueue = popStack.pop();
        while (popStack.size() > 0) {
            pushStack.push(popStack.pop());
        }
        return firstInQueue;
    }

    public int peek() {
        while (pushStack.size() > 0) {
            popStack.push(pushStack.pop());
        }
        int firstInQueue = popStack.peek();
        while (popStack.size() > 0) {
            pushStack.push(popStack.pop());
        }
        return firstInQueue;
    }

    public boolean empty() {
        return pushStack.empty();
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