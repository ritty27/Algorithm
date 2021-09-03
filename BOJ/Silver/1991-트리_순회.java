import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Map<String, List<String>> map = new HashMap<>();

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        //입력
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            List<String> list = new ArrayList<>();

            list.add(str[1]);
            list.add(str[2]);
            map.put(str[0], list);
        }

        preOrder("A");
        sb.append("\n");
        inOrder("A");
        sb.append("\n");
        postOrder("A");

        System.out.println(sb);

    }

    private static void preOrder(String now){
        if(now.equals(".")) return;

        sb.append(now);
        preOrder(map.get(now).get(0));
        preOrder(map.get(now).get(1));
    }
    private static void inOrder(String now){
        if(now.equals(".")) return;

        inOrder(map.get(now).get(0));
        sb.append(now);
        inOrder(map.get(now).get(1));
    }
    private static void postOrder(String now){
        if(now.equals(".")) return;

        postOrder(map.get(now).get(0));
        postOrder(map.get(now).get(1));
        sb.append(now);
    }


}
