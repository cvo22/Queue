/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author Гамаюнов Иван
 */
// Класс Queue реализует структуру данных очередь.
public class Queue {

    // Внутренний класс Node представляет элемент очереди.
    private static class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    // Голова очереди.
    private Node head;

    // Хвост очереди.
    private Node tail;

    // Размер очереди.
    private int size;

    // Добавляет элемент в конец очереди.
    public void enqueue(Object data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Удаляет и возвращает первый элемент очереди.
    public Object dequeue() {
        if (head == null) {
            return null;
        }
        Object data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    // Возвращает первый элемент очереди без удаления.
    public Object peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    // Проверяет, пуста ли очередь.
    public boolean isEmpty() {
        return size == 0;
    }

    // Возвращает размер очереди.
    public int size() {
        return size;
    }

    // Очищает очередь.
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // Выводит очередь в консоль.
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Пример использования очереди.
    public static void main(String[] args) {
        Queue queue = new Queue();

        // Добавляем элементы в очередь.
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        // Выводим очередь в консоль.
        System.out.println("Очередь:");
        queue.print();

        // Удаляем и выводим первый элемент очереди.
        System.out.println("Удаленный элемент:");
        System.out.println(queue.dequeue());

        // Выводим очередь в консоль.
        System.out.println("Очередь после удаления первого элемента:");
        queue.print();

        // Проверяем, пуста ли очередь.
        System.out.println("Очередь пуста? " + queue.isEmpty());

        // Возвращаем первый элемент очереди без удаления.
        System.out.println("Первый элемент очереди:");
        System.out.println(queue.peek());

        // Возвращаем размер очереди.
        System.out.println("Размер очереди:");
        System.out.println(queue.size());

        // Очищаем очередь.
        queue.clear();

        // Проверяем, пуста ли очередь.
        System.out.println("Очередь пуста? " + queue.isEmpty());
    }
}
