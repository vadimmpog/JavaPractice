
public class Test {

    public boolean isSort(int[] arr){
        boolean x = true;
        for(int i = 1; i< arr.length;i++){
            if(arr[i]<arr[i-1]){
                x = false;
            }
        }
        return x;
    }

}
