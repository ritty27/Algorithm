import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int target = Integer.parseInt(st.nextToken());

    List<Integer> list = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }

    for (int i = 0; i < n; i++) {
      if (target == list.get(i)) {
        System.out.print(1);
        return;
      }
    }

    Collections.sort(list);
    int left = 0;
    int right = n - 1;
    while (left < right) {
      int nowWeight = list.get(left) + list.get(right);
      if (nowWeight == target) {
        System.out.print(1);
        return;
      } else if (nowWeight > target) {
        right--;
      } else {
        if (left < list.indexOf(target - nowWeight) && list.indexOf(target - nowWeight) < right) {
          System.out.print(1);
          return;
        }
        left++;
      }
    }
    System.out.print(0);
  }

}

