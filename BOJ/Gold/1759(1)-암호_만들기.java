import java.io.*;
import java.util.*;


public class Main {

  static StringBuilder sb = new StringBuilder();

  static char[] arr;
  static char[] temp;
  static int l, c;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    l = Integer.parseInt(st.nextToken());
    c =Integer.parseInt(st.nextToken());
    arr = new char[c];
    temp = new char[l];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < c; i++) {
      arr[i] = st.nextToken().charAt(0);
    }
    Arrays.sort(arr);

    func(0, 0);

    System.out.print(sb);
  }

  static void func(int at, int length) {
    if (length == l) {
      if (isAvailable()) {
        for (int i = 0; i < l; i++) {
          sb.append(temp[i]);
        }
        sb.append("\n");
      }
      return;
    }
    if (at == c)
      return;

    temp[length] = arr[at];
    func(at + 1, length+1);
    func(at + 1, length);
  }

  static boolean isAvailable() {
    int vowel = 0;
    for (int i = 0; i < l; i++) {
      char nowCheck = temp[i];
      if (nowCheck == 'a' || nowCheck == 'e' || nowCheck == 'i' || nowCheck == 'o' || nowCheck == 'u') {
        vowel += 1;
      }
    }
    if (vowel >= 1 && l - vowel >= 2)
      return true;
    return false;
  }
}
