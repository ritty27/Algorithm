import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

  static int[] list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    list = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      list[i] = Integer.parseInt(st.nextToken());
    }

    int start = 0;
    int end = 0;

    long ans = 0;

    Set<Integer> temp = new HashSet<>();

    while (start < N) {
      if(end == N) {
        ans += temp.size();
        temp.remove(list[start]);
        start++;
      } else if(!temp.contains(list[end])){
        temp.add(list[end]);
        end++;
      } else {
        ans += temp.size();
        temp.remove(list[start]);
        start++;
      }
  }
    System.out.print(ans);


  }
}
