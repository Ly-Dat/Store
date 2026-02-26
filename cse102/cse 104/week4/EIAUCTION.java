import java.util.Scanner;

public class EIAUCTION{
    public static void main(String[] args) {
        // tìm vị trí mặt xúc xắc nút lớn nhất xuất hiện 1 lần
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] point_xx = new int[7];
        // xúc xắc
        int[] each_point = new int[T+1];
        for(int i=1; i<=T; i++){
            int point = sc.nextInt();
            each_point[i]=point;
            point_xx[point]+=1;
        }
        int vt=0;
        for(int i = 6; i>=1; i--){
            if(point_xx[i]==1){
                vt=i;
                break;
            }
        }
        for(int i=1; i<=T; i++){
            if(vt==each_point[i]){
                vt=i;
                break;
            }
        }
        if(vt==0){
            System.out.println("none");
        }
        else{
            System.out.println(vt);
        }
    }
}
