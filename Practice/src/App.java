import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= ans) ans++;
        }
        System.out.println(ans);
    }
}