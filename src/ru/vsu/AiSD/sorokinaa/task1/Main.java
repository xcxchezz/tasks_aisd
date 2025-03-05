package ru.vsu.AiSD.sorokinaa.task1;

public class Main {
    public static void main(String[] args) {
        // Создаем очередь с начальной емкостью 3
        DynamicCircularQueue<Integer> queue = new DynamicCircularQueue<>(3);

        // Добавляем элементы
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Очередь после добавления 1, 2, 3: " + queue); // [1, 2, 3]

        // Добавляем еще один элемент (вызовет расширение массива)
        queue.enqueue(4);
        System.out.println("Очередь после добавления 4: " + queue); // [1, 2, 3, 4]

        // Удаляем элементы
        System.out.println("Удален элемент: " + queue.dequeue()); // 1
        System.out.println("Очередь после удаления: " + queue); // [2, 3, 4]

        // Получаем элемент из начала очереди без удаления
        System.out.println("Элемент в начале очереди: " + queue.peek()); // 2

        // Удаляем еще один элемент
        System.out.println("Удален элемент: " + queue.dequeue()); // 2
        System.out.println("Очередь после удаления: " + queue); // [3, 4]

        // Проверяем, пуста ли очередь
        System.out.println("Очередь пуста? " + queue.isEmpty()); // false

        // Удаляем оставшиеся элементы
        System.out.println("Удален элемент: " + queue.dequeue()); // 3
        System.out.println("Удален элемент: " + queue.dequeue()); // 4
        System.out.println("Очередь после удаления: " + queue); // []

        // Проверяем, пуста ли очередь
        System.out.println("Очередь пуста? " + queue.isEmpty()); // true

        // Попытка удалить из пустой очереди
        try {
            queue.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage()); // Ошибка: Queue is empty
        }
    }
}