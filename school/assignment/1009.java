import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] array = new int[N][N];

    for (int i = 0; i < N; i++) {
      String[] str = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        array[i][j] = Integer.parseInt(str[j]);
      }
    }

    for (int k = 0; k < N; k++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          array[i][j] = Math.min(array[i][j], array[i][k] + array[k][j]);
        }
      }
    }
    
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(array[i][j] + " ");
      }
      System.out.println();
    }

  }
}
