import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] target, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        target = new int[N];
        tmp = new int[N];

        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1){
            System.out.println(target[0]);
            return;
        }
        merge_sort(0,N);

        Arrays.stream(tmp).forEach(m-> sb.append(m + "\n"));
        System.out.println(sb);
    }

    private static void merge_sort(int start, int end) {
        if(start+1 == end) return;
        int mid = (start + end)/2;
        merge_sort(start, mid);
        merge_sort(mid, end);
        merge(start, end);
    }

    private static void merge(int start, int end) {
        int mid = (start + end)/2;
        int n = start, m = mid;
        for (int i = start; i < end; i++) {
            if(n == mid){
                tmp[i] = target[m++];
            }else if(m == end){
                tmp[i] = target[n++];
            }else if(target[n] <= target[m]){
                tmp[i] = target[n++];
            }else tmp[i] = target[m++];
        }
        for (int i = start; i < end; i++){
            target[i] = tmp[i];
        }
    }

}


