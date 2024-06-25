import java.util.Arrays;

public class MergeSort {

    private static void sort(int arr[], int l, int r){

        // base case
        if(l>=r) return;

        int mid = (l+r)/2;

        sort(arr, l, mid); // sort left part
        sort(arr,mid+1, r); // sort right part

        merge(arr, l, r, mid);

    }

    private static void merge(int arr[], int l, int r, int mid){

        int n = mid - l + 1; // length of left part subarray
        int m = r - mid; // len of right part

        int left[] = new int[n];
        int right[] = new int[m];

        // popualte left and right temp array
        for(int i=0; i<n; i++)
            left[i] = arr[l+i];

        for(int j=0; j<m; j++)
            right[j] = arr[mid+1+j];

//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        int i =0, j=0;
        int idx = l;

        while(i<n && j<m){

            if(left[i]<right[j])
                arr[idx++] = left[i++];

            else arr[idx++] = right[j++];
        }

        // fill remainig array
        while(i<n)
            arr[idx++] = left[i++];

        while(j<m) arr[idx++] = right[j++];

        return;
    }


    public static void main(String[] args) {

        int arr[] = new int[]{2, 12 ,4 ,9 ,6 ,1, 6}; // 0 3 6
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
