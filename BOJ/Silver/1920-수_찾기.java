import java.io.*;
import java.util.*;


public class Main {


  public static void main(String[] args) throws IOException {

    StringBuffer sb = new StringBuffer();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;


    int N = Integer.parseInt(br.readLine());
    Set<String> set = new HashSet<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      set.add(st.nextToken());
    }

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      if (set.contains(st.nextToken())) {
        sb.append(1 + "\n");
      } else {
        sb.append(0 + "\n");
      }
    }

    System.out.print(sb);
  }


}


