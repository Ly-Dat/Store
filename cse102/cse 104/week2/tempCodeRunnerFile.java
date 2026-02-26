
import java.util.Arrays;
import java.util.Scanner;

public class Building_Pyramid_2 {

    static void find_layers(long[] arr_test, long[] arr) {
        int[] vt_layer = new int[arr_test.length];

        int layer = 0;
        int i=0;
        long sum_bricks=0;
        while (true) {
            layer++;
            sum_bricks += layer + (layer * (layer - 1) / 2);
            if(i==arr_test.length-1){
                break;
            }
            if(sum_bricks <arr_test[i]){
                continue;
            }
            else if (sum_bricks >arr_test[i]) {
                layer--;
                vt_layer[i]=layer;
                sum_bricks -= layer + (layer * (layer - 1) / 2);
                i++;
            }
            else{
                vt_layer[i]=layer;
                i++;
            }
            
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        long[] arr = new long[k];
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextLong();
        }
        long[] arr_test = arr;
        Arrays.sort(arr_test);
        find_layers(arr_test, arr);
    }
}
