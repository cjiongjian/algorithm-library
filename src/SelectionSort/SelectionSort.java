package SelectionSort;

import Entity.Student;
import Generator.ArrayGenerator;
import Helper.SortingHelper;

import java.lang.reflect.InvocationTargetException;

public class SelectionSort {

    private SelectionSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        int minIndex;
        for (int i = 0; i < arr.length -1; i++){
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                if(arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

//        Integer[] arr = {2, 4, 6, 1, 3, 5, 7};
//        SelectionSort.sort(arr);
//        for (int e:arr) {
//            System.out.print(e + " ");
//        }
//        System.out.println();

//        Student[] students = {new Student("a", 99),
//                              new Student("b", 97),
//                              new Student("c", 90)};
//        SelectionSort.sort(students);
//        for (Student stu: students) {
//            System.out.print(stu + " ");
//        }
//        System.out.println();

        int[] dataSize = {10000, 100000};

        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort.SelectionSort", data);
        }


    }
}
