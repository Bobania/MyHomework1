package lists;


import interfaces.MyListInterface;

import java.util.Arrays;
import java.util.Comparator;
/**
 * MyArrayList динамический массив
 *
 * @param <T> тип элементов, которые будут храниться в списке
 */

public class MyArrayList<T> implements MyListInterface<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Конструктор, который создает пустой список с начальной емкостью
     */
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Добавляет элемент в конец списка
     *
     * @param element элемент, который нужно добавить
     */
    @Override
    public void add(T element) {
        checkCapacity();
        elements[size++] = element;
    }
    /**
     * Добавляет элемент по указанному индексу
     *
     * @param index индекс, по которому нужно добавить элемент
     * @param element элемент, который нужно добавить
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */

    public void add(int index, T element) {
        checkCapacity();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Получает элемент по индексу.
     *
     * @param index индекс элемента, который нужно получить
     * @return элемент, находящийся по указанному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы
     */
    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    /**
     * Удаляет элемент по индексу.
     *
     * @param index индекс элемента, который нужно удалить
     * @throws IndexOutOfBoundsException если индекс выходит за пределы
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
    }

    /**
     * Очищает список, удаляя все элементы
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * Сортирует элементы списка
     *
     * @param comparator компаратор, определяющий порядок сортировки
     */
    @Override
    public void sort(Comparator<? super T> comparator) {
        Arrays.sort((T[]) elements, 0, size, comparator);
    }

    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов в списке
     */
    @Override
    public int size(){
        return size;
    }

    /**
     * Проверяет, достаточно ли емкости для добавления нового элемента
     * Если емкость недостаточна, массив увеличивается вдвое
     */
    private void checkCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }
}
