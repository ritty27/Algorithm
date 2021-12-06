import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashSet<String> hashSet = new HashSet<>();

    String[] str = br.readLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int M = Integer.parseInt(str[1]);

    for (int i = 0; i < N; i++) {
      hashSet.add(br.readLine());
    }

    List<String> ans = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      String name = br.readLine();
      if (hashSet.contains(name)) {
        ans.add(name);
      }
    }
    Collections.sort(ans);

    sb.append(ans.size()).append("\n");

    for (int i = 0; i < ans.size(); i++) {
      sb.append(ans.get(i)).append("\n");
    }

    System.out.print(sb);
  }


}


