public class test {
    public static void main(String[] args) {
        //insersort
        for(int i=1; i<n; i++){
            int t = arr[i];
            for(int j=i-1; j>=0; j--){
                if(arr[j]>t){
                    arr[j+1]=arr[j];
                }
                else{
                    arr[j+1]=t;
                    break;
                }
            }
        }

        //insertion sort
        for(int i=1; i<n; i++){
            int t = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>t){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=t;
        }

        //selection sort
        for(int i=0; i<n-1; i++){
            int minindex = i;
            for(int j=i+1; j<n; j++){
                if(arr[j]<arr[i]){
                    minindex=j;
                }
            }
            swap(arr, i, minindex);
        }

        //bubble sort
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n-i; j++){
                if(arr[j]>arr[i]){
                    swap(arr, i, j);
                }
            }
            
        }
    }
}
