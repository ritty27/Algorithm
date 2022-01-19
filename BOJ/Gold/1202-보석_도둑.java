import java.io.*;
import java.util.*;


class Jewel implements Comparable<Jewel> {

  int weight;
  int value;

  public Jewel(int weight, int value) {
    this.weight = weight;
    this.value = value;
  }

  @Override
  public int compareTo(Jewel o) {
    return o.value - value;
  }
}

public class Main {


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Jewel[] jewelries = new Jewel[N];
    PriorityQueue<Jewel> pq = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      jewelries[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    Arrays.sort(jewelries, new Comparator<Jewel>() {
      @Override
      public int compare(Jewel o1, Jewel o2) {
        return o1.weight - o2.weight;
      }
    });

    List<Integer> bags = new ArrayList<>();

    for (int i = 0; i < K; i++) {
      bags.add(Integer.parseInt(br.readLine()));
    }

    Collections.sort(bags);

    long ans = 0;
    int jewelNum = 0;
    for (int i = 0; i < K; i++) {
      int capacity = bags.get(i);
      while (jewelNum < N && capacity >= jewelries[jewelNum].weight) {
        pq.add(jewelries[jewelNum++]);
      }
      if (!pq.isEmpty()) ans += pq.poll().value;

    }
    System.out.print(ans);
  }

}
