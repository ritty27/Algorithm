import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] tmp, array;
    static int n,m;
    static StringBuilder sb = new StringBuilder();
        public static void main(String[] args) throws IOException {

            //입력
            BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            array = new int[n];
            tmp = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(array);

            bfs(0,0);

            System.out.print(sb);


        }

        private static void bfs(int start, int depth){
            if(depth==m){
                for (int i = 0; i < m; i++) {
                    sb.append(tmp[i] + " ");
                }
                sb.append("\n");
                return;
            }

            for (int i = start; i < n; i++) {
                tmp[depth] = array[i];
                bfs(i, depth+1);
            }

        }

}
