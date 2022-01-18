import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    int[] array = new int[N+1];
    for (int i = 0; i < N; i++) {
      array[i] = Integer.parseInt(st.nextToken());
    }
    int low = 0, high = 0, sum = array[0], ans = 100002;
    while (high != N){
      if(sum >= S){
        ans = Math.min(ans, high - low + 1);
        sum -= array[low++];
      }else {
        sum += array[++high];
      }
    }

    if(ans == 100002) {
      System.out.print(0);
      return;
    }
    System.out.print(ans);
  }
}
