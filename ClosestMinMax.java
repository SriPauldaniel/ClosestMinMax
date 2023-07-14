import java.util.Scanner;

public class ClosestMinMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findClosest(arr, n));
        sc.close();
    }

    public static int findClosest(int[] arr,int n) {
        int min = arr[0],max = arr[0];
        for(int i=1;i<n;i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
            if(min > arr[i]) {
                min = arr[i];
            }
        }
        int recentMax = -1,recentMin = -1,len = n;
        for(int i=0;i<n;i++) {
            if(arr[i] == min) {
                recentMin = i;
                if(recentMax >= 0) {
                    len = Math.min(len,i-recentMax+1);
                }
            }
            if(arr[i] == max) {
                recentMax = i;
                if(recentMin >= 0) {
                    len = Math.min(len,i-recentMin+1);
                }
            }
        }
        return len;
    }
}