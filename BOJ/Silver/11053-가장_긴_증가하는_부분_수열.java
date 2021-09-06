import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, max;
    static int[] array, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        //입력
        N = Integer.parseInt(br.readLine());
        array = new int[N];
        tmp = new int[N];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(str[i]);
        }

        //계산
        for (int i = 0; i < N; i++) {
            tmp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (array[i] > array[j]) {
                    tmp[i] = Math.max(tmp[j] + 1, tmp[i]);
                }
            }
        }

        Arrays.sort(tmp);
        System.out.print(tmp[tmp.length-1]);
    }

}
