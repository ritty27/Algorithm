import java.io.*;
import java.util.*;


class Top {
  private int index;
  private int height;

  public int index() {
    return index;
  }

  public int height() {
    return height;
  }

  public Top(int index, int height) {
    this.index = index;
    this.height = height;
  }

}

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int topNum = Integer.parseInt(br.readLine());

    Stack<Top> topStack = new Stack<>();
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < topNum; i++) {
      int nowHeight = Integer.parseInt(st.nextToken());

      while (!topStack.isEmpty()) {
        Top peek = topStack.peek();
        if (peek.height() >= nowHeight) {
          sb.append(peek.index() + " ");
          break;
        } else {
          topStack.pop();
        }
      }
      if (topStack.isEmpty()) sb.append(0 + " ");
      topStack.push(new Top(i + 1, nowHeight));

    }

    System.out.print(sb);
  }
}
