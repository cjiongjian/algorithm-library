package Helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SortingHelper {

    private SortingHelper(){}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr){

        for (int i = 1; i < arr.length; i++){
            if(arr[i - 1].compareTo(arr[i]) > 0){
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] data) {

        try {
            Class sortClass = Class.forName(sortName);
            Method sortMethod = sortClass.getMethod("sort", Comparable[].class);
            Object[] params = new Object[]{data};

            long startTime = System.nanoTime();
            sortMethod.invoke(null, params);
            long endTime = System.nanoTime();

            if(!SortingHelper.isSorted(data)){
                throw new RuntimeException(sortName + " failed");
            }
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println(sortName + ": n = " + data.length + ", runs : " + time + " s");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
