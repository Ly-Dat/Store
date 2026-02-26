import java.util.Scanner;

 class EIUSESOR {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        int N = sc.nextInt();
        String dataType = sc.next();
        if (dataType.equals("double")) {
            Double[] array = new Double[N];
            array = getArray(array);
            selectionSort(array);
            showResult(array);

        } else if (dataType.equals("float")) {
            Float[] array = new Float[N];
            array = getArray(array);
            selectionSort(array);
            showResult(array);
        } else if (dataType.equals("long")) {
            Long[] array = new Long[N];
            array = getArray(array);
            selectionSort(array);
            showResult(array);
        } else {
            Integer[] array = new Integer[N];
            array = getArray(array);
            selectionSort(array);
            showResult(array);
        }
        // Your code here
    }

    @SuppressWarnings("unchecked")
    private static <T extends Number> T[] getArray(T[] array) {
        Class<?> componentType = array.getClass().getComponentType();
        for (int i = 0; i < array.length; i++) {
            if (componentType == Integer.class)
                array[i] = (T) (Integer) sc.nextInt();
            else if (componentType == Long.class)
                array[i] = (T) (Long) sc.nextLong();
            else if (componentType == Double.class)
                array[i] = (T) (Double) sc.nextDouble();
            else
                array[i] = (T) (Float) sc.nextFloat();
        }
        return array;
    }

   

    public static <T extends Number> void showResult(T[] array) {
        StringBuilder sb = new StringBuilder();
        for (T t : array) {
            sb.append(t).append(" ");
        }
        System.out.println(sb.toString());
    }

    static <T extends Number & Comparable<T>> void selectionSort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            var currMinItem = array[i];
            int j = i + 1;
            int index = i;
            for (; j < array.length; j++) {
                if (currMinItem.compareTo(array[j]) > 0) {
                    currMinItem = array[j];
                    index = j;
                }
            }
            var temp = array[i];
            array[i] = currMinItem;
            array[index] = temp;
        }

    }
}