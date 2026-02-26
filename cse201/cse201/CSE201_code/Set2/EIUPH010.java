import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

class EIUPH010 {
    static Scanner sc = new Scanner(System.in);
    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }
        Arrays.sort(arr1);
        progress(arr1);
        maxFrequency();
    }

    static void progress(int[] arr1) {
        int temp = arr1[0];
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (temp == arr1[i]) {
                count += 1;
                treeMap.put(arr1[i], count);
            } else if (temp != arr1[i]) {
                temp = arr1[i];
                count = 1;
            }
        }
    }

    static void maxFrequency() {
        int maxFrequency = 0;
        for (Integer key : treeMap.keySet()) {
            if (maxFrequency < treeMap.get(key)) {
                maxFrequency = treeMap.get(key);
            }
        }
        for (Integer key : treeMap.keySet()) {
            if (maxFrequency == treeMap.get(key)) {
                System.out.println(key + " " + treeMap.get(key));
                break;
            }
        }
    }
}
