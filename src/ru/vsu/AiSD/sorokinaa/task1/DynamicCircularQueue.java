package ru.vsu.AiSD.sorokinaa.task1;

public class DynamicCircularQueue<T> {
    private T[] queue;
    private int capacity;
    private int front;
    private int rear;
    private int size;

    // Конструктор с заданной начальной емкостью
    @SuppressWarnings("unchecked")
    public DynamicCircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Конструктор по умолчанию с емкостью 10
    public DynamicCircularQueue() {
        this(10);
    }

    // Добавление элемента в очередь
    public void enqueue(T item) {
        if (isFull()) {
            resize();
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    // Удаление элемента из очереди
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }
        T item = queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    // Проверка, пуста ли очередь
    public boolean isEmpty() {
        return size == 0;
    }

    // Проверка, заполнена ли очередь
    public boolean isFull() {
        return size == capacity;
    }

    // Увеличение размера внутреннего массива в два раза
    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = capacity * 2;
        T[] newQueue = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % capacity];
        }
        queue = newQueue;
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
    }


    public int size() {
        return size;
    }

    // Получение элемента в начале очереди без его удаления
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }
        return queue[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(queue[(front + i) % capacity]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
