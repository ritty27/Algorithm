import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N, ans;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        //입력
        N = Integer.parseInt(br.readLine());

        array = new int[N];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(array);

        //시간 합
        for (int i = 0; i < N; i++) {
            ans += array[i] * (array.length - i);
        }

        System.out.println(ans);


    }

}
