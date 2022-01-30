import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class Count {
  int zeroCount;
  int oneCount;

  public Count(int zeroCount, int oneCount) {
    this.zeroCount = zeroCount;
    this.oneCount = oneCount;
  }
}

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int num = Integer.parseInt(br.readLine());
    List<Integer> list = new ArrayList<>();
    int max = 0;
    for (int i = 0; i < num; i++) {
      int temp = Integer.parseInt(br.readLine());
      max = Math.max(temp, max);
      list.add(temp);
    }


    Count[] fibonacci = new Count[max + 2];
    fibonacci[0] = new Count(1, 0);
    fibonacci[1] = new Count(0, 1);

    for (int i = 2; i <= max; i++) {
      Count one = fibonacci[i - 2];
      Count two = fibonacci[i - 1];
      fibonacci[i] = new Count(one.zeroCount + two.zeroCount, one.oneCount + two.oneCount);
    }

    for (int i = 0; i < num; i++) {
      Count now = fibonacci[list.get(i)];
      sb.append(now.zeroCount + " " + now.oneCount + "\n");
    }
    System.out.print(sb.toString().trim());
  }
}
