package effectiveJava.chap5;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/6/9
 */
public class MyStack<E> {
    private Stack<E> stack;

    public MyStack() {
        stack = new Stack<E>();
    }

    public void push(E e) {
        stack.push(e);
    }

    public E pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void pushAll(Iterable<? extends E> src) {// 通配符类型
        for (E e : src) {
            push(e);
        }
    }

    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }


    public static void main(String[] args) {
        MyStack<Number> myStack = new MyStack<Number>();
        Iterable<Integer> integers = Arrays.asList(1, 2, 3, 4);
        myStack.pushAll(integers);
    }
}
