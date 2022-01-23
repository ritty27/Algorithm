import java.io.*;
import java.util.StringTokenizer;

class TrieNode {
  TrieNode[] children = new TrieNode[26];
  boolean isEnd;
  boolean isHit;

  boolean hasChild(char c) {
    return children[c - 'A'] != null;
  }

  TrieNode getChild(char c) {
    return children[c - 'A'];
  }

  void clearHit() {
    isHit = false;
    for (int i = 0; i < children.length; i++) {
      TrieNode child = children[i];
      if (child != null) {
        child.clearHit();
      }
    }
  }

}

public class Main {

  static TrieNode root = new TrieNode();
  static char[][] map;
  static boolean[][] visited;
  static int sum;
  static String answer;
  static int count;
  static StringBuilder sb;

  static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
  static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
  static int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();

    int wordNum = Integer.parseInt(br.readLine());

    for (int i = 1; i <= wordNum; i++) {
      insertWord(br.readLine());
    }

    br.readLine();
    int testCase = Integer.parseInt(br.readLine());
    for (int caseNum = 0; caseNum < testCase; caseNum++) {
      map = new char[4][4];
      visited = new boolean[4][4];
      sum = 0;
      answer = "";
      count = 0;

      sb = new StringBuilder();

      for (int i = 0; i < 4; i++) {
        String input = br.readLine();
        for (int k = 0; k < 4; k++) {
          map[i][k] = input.charAt(k);
        }
      }
      for (int y = 0; y < 4; y++) {
        for (int x = 0; x < 4; x++) {
          if (root.hasChild(map[y][x])) {
            search(y, x, 1, root.getChild(map[y][x]));
          }
        }
      }
      output.append(sum).append(" ").append(answer).append(" ").append(count).append("\n");
      root.clearHit();
      br.readLine();
    }

    System.out.print(output.toString());
  }

  static void search(int y, int x, int length, TrieNode node) {
    // 1. 체크인
    visited[y][x] = true;
    sb.append(map[y][x]);
    // 2. 목적지 도달 확인
    if (node.isEnd && !node.isHit) {
      node.isHit = true;
      sum += score[length];
      count++;
      String word = sb.toString();
      if (compare(answer, word) > 0) {
        answer = word;
      }
    }
    // 3. 연결된 곳
    for (int i = 0; i < 8; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];
      // 4. 갈수있는가 -- map 안에 있는가, 방문하지 않았는가, node 자식이 있는가가
      if (0 > ny || 4 <= ny || 0 > nx || 4 <= nx) continue;
      if (visited[ny][nx]) continue;
      if (node.hasChild(map[ny][nx])) {
        // 5. 간다
        search(ny, nx, length + 1, node.getChild(map[ny][nx]));
      }
    }
    // 6. 체크아웃
    visited[y][x] = false;
    sb.deleteCharAt(length - 1);
  }

  static int compare(String str1, String str2) {
    int lengthCompare = Integer.compare(str2.length(), str1.length());
    if (lengthCompare == 0) {
      return str1.compareTo(str2);
    } else return lengthCompare;
  }

  static void insertWord(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      if (current.hasChild(word.charAt(i)) == false) {
        current.children[word.charAt(i) - 'A'] = new TrieNode();
      }
      current = current.getChild(word.charAt(i));
    }
    current.isEnd = true;
  }

}
