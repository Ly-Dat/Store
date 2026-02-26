import java.util.Random;
import java.util.Scanner;

public class bt3 {

    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();
    public static int[] input(){
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i =0; i<n; i++) a[i]=rd.nextInt(10);
        return a;
    }
    public static void output(int[] a){
        for(int i:a) System.out.print(i+" ");
    }

    // hàm add thêm số vô
    public static int[] add(int[] a, int x, int k){
        int[] newa= new int[a.length+1];
        for(int i=0; i<k; i++) newa[i]=a[i];
        newa[k] = x;
        for(int j=k+1; j<newa.length; j++) 
            newa[j]=a[j-1];
        return newa;
    }

    // hàm delete số
    public static int[] delete(int[] a, int k){
        int[] newa= new int[a.length-1];
        for(int i=0; i<k; i++) newa[i]=a[i];
        for(int j=k; j<newa.length; j++) 
            newa[j]=a[j+1];
        return newa;
    }

    // tìm số nhỏ gần nhất
    public static int min_close(int[] a, int x){
        int max =0;
        int min =Integer.MAX_VALUE;
        for(int i:a){
            if(i==x) return x;
            else{
                if(i<x && max<i) max=i;
                if(i>x && min>i) min=i;
            }
        }
        if(x-max>min-x) return min;
        return max;
    }

    // tèo tìm mắc nhất
    public static int max_gift(int[] a, int x){
        int max =0;
        for(int i:a){
            if(i==x) return x;
            else{
                if(i<x && max<i) max=i;
            }
        }
        return max;
    }

    // tèo tìm 2 món quà mắc nhất
    public static void twomax_gift(int[] a, int x){
        int max1 =0;
        int max2 =0;
        int count=0;
        int min =Integer.MAX_VALUE;
        for(int i:a){
            if(i==x/2) count++;
            else{
                if(i<(double)x/2 && max2<i){
                    if(max1<i) 
                        max1=i;
                    else
                        max2=i;
                } 
                if(i>(double)x/2 && min>i) min=i;
            }
            if(count==2) break;
        }
        if(count==2) 
            System.out.printf("2 món quà là: %d và %d",x/2,x/2);
        else{
            if(min+max1<=x) 
                System.out.printf("2 món quà là: %d và %d",max1,min);
            else
                System.out.printf("2 món quà là: %d và %d",max2,max1);
        }
       
    }

    //sắp xếp chẵn trc lẻ sau
    public static int[] sort_C_L(int[]a){
        for(int i=0;i<a.length;i++){
            for(int j=i+1; j<a.length; j++){
                if(a[i]%2==1 && a[j]%2==0){
                    int t = a[i];
                    a[i]=a[j];
                    a[j]=t;
                }
            }
        }
        return a;
    }

    // sắp xếp chẵn trc tăng, lẻ sau giảm
    public static int[] sort_CU_LD(int[]a){
        a = sort_C_L(a);
        int k=0;
        for(int i=0; i<a.length; i++){
            if(a[i]%2==1){
                k=i;
                break;
            }
            if(a[a.length-1-i]%2==0){
                k=a.length-i;
                break;
            }
        }
        for(int i=0; i<k; i++){
            for(int j=i+1; j<k; j++)
                if(a[i]>a[j]){
                    int t=a[i];
                    a[i]=a[j];
                    a[j]=t;
                }
        }
        for(int i=k; i<a.length; i++){
            for(int j=i+1; j<a.length; j++)
                if(a[i]<a[j]){
                    int t=a[i];
                    a[i]=a[j];
                    a[j]=t;
                }
        }
        return a;
            
    }
    
    public static int[] sort_C_L_TG(int[]a){
        for(int i=0;i<a.length;i++){
            for(int j=i+1; j<a.length; j++){
                if((a[i]%2==1 && a[j]%2==0)
                ||(a[i]%2==0 && a[j]%2 == 0 && a[i]>a[j])
                ||(a[i]%2==1 && a[j]%2 ==1 && a[i]<a[j])){
                    int t = a[i];
                    a[i]=a[j];
                    a[j]=t;
                }
            }
        }
        return a;
    }
    // xóa các phần tử trùng nhau
    public static boolean findx(int[] a, int x){
        for(int i:a){
            if(i==x)
                return true;
        }
        return false;
    }
    public static int[] delete_same(int[] a){
        int[] newa= new int[0];
        for(int i:a){
            if(!findx(newa, i))
                newa = add(newa, i, newa.length);
        }
        return newa;
    }

    // cách 2
    public static boolean find_x(int[] a, int x, int k){
        for(int i=0;i<k;i++)
            if(a[i]==x)
                return true;
        return false;
    }
    public static int[] only_one(int[] a){
        for(int i=0; i<a.length; i++)
            if(find_x(a, a[i], i)){
                a=delete(a, i);
                i--;
            }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = input();
        output(arr);
        System.out.println();
        // tìm số nhỏ gần nhất
        int x = sc.nextInt();
        System.out.println(min_close(arr, x));        
        
        // int k = sc.nextInt();
        // tèo mua 1 quà
        // System.out.println(max_gift(arr, k));
        // tèo mua 2 quà
        // twomax_gift(arr, k);
        // sắp xếp chẵn lẻ
        // arr=sort_C_L(arr);
        // output(arr);
        // sắp xếp chẵn tăng lẻ giảm
        // arr=sort_C_L_TG(arr);
        // output(arr);

        // xóa số trùng
        // arr=delete_same(arr);
        // arr=only_one(arr);
        // output(arr);

        //

    }
}
