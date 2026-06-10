package ForExame.Ex2025_1Epoca;

import ForExame.Ex2024_2Epoca.Stack;
import Serie07.ex1e2.LinkedStack;
import Serie07.ex3.ArrayQueue;
import Serie07.ex3.Queue;

public class EX2_Fila {

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayQueue<>();
        q.enqueue(1);
        q.enqueue(5);
        q.enqueue(7);
        q.enqueue(0);
        q.enqueue(6);
        for (Integer integer : q) {
            System.out.print(integer + " ");
        }

        System.out.println();

        ArrayQueue<Integer> newList = (ArrayQueue<Integer>) inverter(q);
        for (Integer integer : newList) {
            System.out.print(integer + " ");
        }

        System.out.println();
    }

    public static <E> Queue<E> inverter(Queue<E> q) {
        if (q == null)
            return null;

        LinkedStack<E> l = new LinkedStack<>();
        for (E e : q)
            l.push(e);

        ArrayQueue<E> newQueue = new ArrayQueue<>();
        for (E e : l)
            newQueue.enqueue(e);

        return newQueue;

    }
}
