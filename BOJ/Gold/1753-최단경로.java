import java.io.*;
import java.util.*;


class Node implements Comparable<Node> {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        int INF = 9999999;
        int[] ans, visited;
        int V, E, start;

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        List<Node>[] map = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            map[a].add(new Node(b, distance));
        }


        // 다익스트라
        visited = new int[V + 1];
        ans = new int[V + 1];
        Arrays.fill(ans, INF);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        ans[start] = 0;

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int wayPoint = curNode.end;

            if(visited[wayPoint] == 1) continue;
            visited[wayPoint] = 1;

            for (Node node : map[wayPoint]){
                if (ans[node.end] > ans[wayPoint] + node.weight) {
                    ans[node.end] = ans[wayPoint] + node.weight;
                    queue.add(new Node(node.end, ans[node.end]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (ans[i] != INF) sb.append(ans[i] + "\n");
            else sb.append("INF\n");
        }


        System.out.print(sb);
    }
}
