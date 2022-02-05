import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    Set<String> set = new HashSet<>();

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      String execute = st.nextToken();
      if (execute.equals("enter")) {
        set.add(name);
      } else {
        set.remove(name);
      }
    }

    List<String> list = new ArrayList<>(set);
    Collections.sort(list, Collections.reverseOrder());

    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i) + "\n");
    }
    System.out.print(sb.toString());
  }
}

