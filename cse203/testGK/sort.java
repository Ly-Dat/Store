import java.util.Scanner;
class sort {
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        String dataType = sc.next();
        if (dataType.equals("double")) {
            Double[] array = new Double[N];
            for(int i=0; i<N; i++){
                array[i]=sc.nextDouble();
            }
            bubbleSort(array);
            for(Double m : array){
                sb.append(m+" ");
            }
        }
        else if (dataType.equals("int")) {
            Integer[] array = new Integer[N];
            for(int i=0; i<N; i++){
                array[i]=sc.nextInt();
            }
            bubbleSort(array);
            for(Integer m : array){
                sb.append(m+" ");
            }
        }
        else if (dataType.equals("long")) {
            Long[] array = new Long[N];
            for(int i=0; i<N; i++){
                array[i]=sc.nextLong();
            }
            bubbleSort(array);
            for(Long m : array){
                sb.append(m+" ");
            }
        }
        else{
            Float[] array = new Float[N];
            for(int i=0; i<N; i++){
                array[i]=sc.nextFloat();
            }
            bubbleSort(array);
            for(Float m : array){
                sb.append(m+" ");
            }
        }
        System.out.println(sb); 
    }

    static <T extends Number & Comparable<T>> void bubbleSort(T[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int minIndex = i;
            for(int j=i+1; j<array.length; j++){
                if(array[j].compareTo(array[minIndex])<0){
                    minIndex=j;
                }
            }
            T t = array[i];
            array[i] = array[minIndex];
            array[minIndex]=t;
        }
    }
}
