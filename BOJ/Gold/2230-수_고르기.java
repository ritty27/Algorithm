import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] array = new int[N];
    for (int i = 0; i < N; i++) {
      array[i] = Integer.parseInt(br.readLine());
    }

    int ans = 2000000001;
    int left = 0;
    int right = 0;

    Arrays.sort(array);

    while (right < N) {
      if (array[right] - array[left] < M) {
        right++;
        continue;
      }
      if (array[right] - array[left] == M) {
        ans = M;
        break;
      }
      ans = Math.min(ans, array[right] - array[left]);
      left++;
    }

    System.out.print(ans);
  }

}
