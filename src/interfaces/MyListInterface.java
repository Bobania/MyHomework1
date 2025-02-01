package interfaces;
import java.util.Comparator;

/**
 * MyListInterface интерфейс для работы со списками
 *
 * @param <T> тип элементов в списке
 */
public interface MyListInterface<T> {
    /**
     * Добавляет элемент в конец списка
     *
     * @param element элемент, который нужно добавить
     */
    void add(T element);

    /**
     * Добавляет элемент по индексу
     *
     * @param index индекс, по которому нужно добавить элемент
     * @param element элемент, который нужно добавить
     */
    void add(int index, T element);

    /**
     * Получает элемент по индексу
     *
     * @param index индекс элемента, который нужно получить
     * @return элемент, находящийся по указанному индексу
     */
    T get(int index);

    /**
     * Удаляет элемент по индексу
     *
     * @param index индекс элемента, который нужно удалить
     */
    void remove(int index);

    /**
     * Удаляет все элементы в списке
     */
    void clear();

    /**
     * Сортирует элементы списка в порядке возрастания
     */
    void sort(Comparator<? super T> comparator);

    /**
     * Возвращает количество элементов в списке
     */
    int size();



}
