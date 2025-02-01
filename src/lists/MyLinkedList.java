package lists;

import interfaces.MyListInterface;

import java.util.Arrays;
import java.util.Comparator;
/**
 * MyLinkedList двусвязный список
 *
 * @param <T> тип элементов, которые будут храниться в списке
 */

public class MyLinkedList<T> implements MyListInterface<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Внутренний класс, представляющий узел списка
     *
     * @param <T> тип данных, хранящихся в узле
     */
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    /**
     * Конструктор, который создает пустой двусвязный список
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Добавляет элемент в конец списка
     *
     * @param element элемент, который нужно добавить
     */
    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (tail == null) { // Список пуст
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Добавляет элемент по индексу
     *
     * @param index индекс, по которому нужно добавить элемент
     * @param element элемент, который нужно добавить
     * @throws IndexOutOfBoundsException если индекс выходит за пределы
     */
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> newNode = new Node<>(element);
        if (index == 0) { // Добавление в начало
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        } else if (index == size) { // Добавление в конец
            add(element);
            return;
        } else { // Добавление в середину
            Node<T> current = getNodeAt(index);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    /**
     * Получает элемент по индексу
     *
     * @param index индекс элемента, который нужно получить
     * @return элемент, находящийся по указанному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return getNodeAt(index).data;
    }

    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index индекс элемента, который нужно удалить
     * @throws IndexOutOfBoundsException если индекс выходит за пределы
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> toRemove = getNodeAt(index);
        if (toRemove.prev != null) {
            toRemove.prev.next = toRemove.next;
        } else { // Удаление первого элемента
            head = toRemove.next;
        }
        if (toRemove.next != null) {
            toRemove.next.prev = toRemove.prev;
        } else { // Удаление последнего элемента
            tail = toRemove.prev;
        }
        size--;
    }

    /**
     * Очищает список, удаляя все элементы
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Сортирует элементы списка
     *
     * @param comparator компаратор, определяющий порядок сортировки
     */
    @Override
    public void sort(Comparator<? super T> comparator) {
        if (size < 2) return; // Нечего сортировать
        Object[] array = new Object[size];
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        Arrays.sort(array);
        current = head;
        for (Object element : array) {
            current.data = (T) element;
            current = current.next;
        }
    }


    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов в списке
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Получает узел по указанному индексу.
     *
     * @param index индекс узла, который нужно получить
     * @return узел, находящийся по указанному индексу
     */
    private Node<T> getNodeAt(int index) {
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }
}