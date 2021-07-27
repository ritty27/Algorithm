import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static int[] arr;
    public static int[] temp = new int[6];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int size = Integer.parseInt(str[0]);


        while (size != 0) {
            arr = new int[size];

            for (int i = 1; i <= size; i++) {
                arr[i - 1] = Integer.parseInt(str[i]);
//                System.out.println("arr [" + i +  " ] = " + arr[i-1]);
            }

            func(0, 0, size);
            sb.append("\n");

            str = br.readLine().split(" ");
            size = Integer.parseInt(str[0]);
        }

        System.out.println(sb);
    }


    static void func(int at, int depth, int size) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(temp[i] + " ");
            }
            sb.append("\n");
            return;
        }
        if (at == size) {
            return;
        }

        temp[depth] = arr[at];
        func(at + 1, depth + 1, size);
        func(at + 1, depth, size);
    }
}

