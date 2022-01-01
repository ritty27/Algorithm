import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static boolean[] set = new boolean[21];
  static StringBuffer sb = new StringBuffer();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++) {
      String readLine = br.readLine();

      if (readLine.equals("all") || readLine.equals("empty")) {
        calculate(readLine, 0);
      } else {
        String[] str = readLine.split(" ");
        calculate(str[0], Integer.parseInt(str[1]));
      }
    }
    System.out.print(sb);
  }

  static void calculate(String type, int number) {
    if (type.equals("add")) {
      set[number] = true;
    } else if (type.equals("remove")) {
      set[number] = false;
    } else if (type.equals("check")) {
      sb.append((set[number] ? 1 : 0) + "\n");
    } else if (type.equals("toggle")) {
      set[number] = !set[number];
    } else if (type.equals("all")) {
      for (int i = 0; i < 21; i++) {
        set[i] = true;
      }
    } else if (type.equals("empty")) {
      for (int i = 0; i < 21; i++) {
        set[i] = false;
      }
    }
  }

}


