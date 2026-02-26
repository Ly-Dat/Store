
public class mergeSort {
    static int[] tempArray;
    public static void main(String[] args) {
        tempArray = new int[5];
    }

    public void merge(int[] arr,int left,int midle,int right){
        int i=left; int j =midle; int k=left;
        while(i<midle || j<right){
            if(i<midle && j<right && arr[i]<=arr[j] || j==right){
                tempArray[k++]=arr[i++];
            }
            else{
                tempArray[k++]=arr[j++];
            } 
        }
    }
}
