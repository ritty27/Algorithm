import java.io.*;
import java.util.*;

class Document {
  int docNum;
  int priority;

  public Document(int docNum, int priority) {
    this.docNum = docNum;
    this.priority = priority;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    StringBuilder sb = new StringBuilder();

    int testCase = Integer.parseInt(br.readLine());

    for (int testNum = 0; testNum < testCase; testNum++) {
      Queue<Document> queue = new LinkedList<>();
      PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());
      st = new StringTokenizer(br.readLine());
      int documentNumber = Integer.parseInt(st.nextToken());
      int targetNumber = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < documentNumber; i++) {
        int inputPriority = Integer.parseInt(st.nextToken());
        queue.add(new Document(i, inputPriority));
        priority.add(inputPriority);
      }

      int check = 0;
      while (!queue.isEmpty()) {
        Document poll = queue.poll();
        if(poll.priority == priority.peek()){
          check++;
          priority.poll();
          if (poll.docNum == targetNumber) {
            sb.append(check).append("\n");
            break;
          }
        } else queue.add(poll);
      }
    }
    System.out.print(sb);
  }
}
