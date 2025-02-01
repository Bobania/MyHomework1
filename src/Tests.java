import lists.MyArrayList;
import lists.MyLinkedList;

import java.util.Comparator;
/**
 * Tests класс для тестирования MyArrayList и MyLinkedList
 */
public class Tests {
    public static void main(String[] args) {
        // Тестирование MyArrayList
        System.out.println("Тестирование MyArrayList:");
        MyArrayList<Integer> arrayList = new MyArrayList<>();

        // Добавление элементов
        arrayList.add(3);
        arrayList.add(8);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println("ArrayList: ");
        printList(arrayList);


        // Тестирование MyLinkedList
        System.out.println("\nТестирование MyLinkedList:");
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        linkedList.add(3);
        linkedList.add(8);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println("LinkedList: ");
        printLinkedList(linkedList);

    }


    private static void printList(MyArrayList<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    private static void printLinkedList(MyLinkedList<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}