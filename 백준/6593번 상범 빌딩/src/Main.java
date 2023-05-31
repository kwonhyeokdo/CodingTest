import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String inputLine = br.readLine();
            if(("0 0 0").equals(inputLine)){
                break;
            }
            final String[] inputSplit = inputLine.split(" ");
            final int L = Integer.parseInt(inputSplit[0]);
            final int R = Integer.parseInt(inputSplit[1]);
            final int C = Integer.parseInt(inputSplit[2]);
            final char[][][] LRC = new char[L][R][C];
            final boolean[][][] visited = new boolean[L][R][C];
            final Queue<int[]> que = new LinkedList<>();
            final int[][] direct = {
                {1, -1, 0, 0, 0, 0},
                {0, 0, -1, 1, 0, 0},
                {0, 0, 0, 0, -1, 1}
            };

            int[] start = null;
            for(int l = 0; l < L; l++){
                for(int r = 0; r < R; r++){
                    final char[] line = br.readLine().toCharArray();
                    LRC[l][r] = line;
                    for(int c = 0; c < C; c++){
                        if(line[c] == 'S'){
                            start = new int[]{l, r, c};
                        }
                    }
                }
                br.readLine(); // 개행
            }

            que.add(start);
            visited[start[0]][start[1]][start[2]] = true;
            boolean findAnswer = false;
            int level = 0;
            while(!que.isEmpty() && !findAnswer){
                final int queSize = que.size();

                level++;
                for(int i = 0; i < queSize && !findAnswer; i++){
                    final int[] lrc = que.poll();

                    for(int j = 0; j < 6 && !findAnswer; j++){
                        final int l = lrc[0] + direct[0][j];
                        final int r = lrc[1] + direct[1][j];
                        final int c = lrc[2] + direct[2][j];
                        if(l < 0 || r < 0 || c < 0 || l >= L || r >= R || c >= C || LRC[l][r][c] == '#' || visited[l][r][c]){
                            continue;
                        }

                        if(LRC[l][r][c] == '.'){
                            if(!visited[l][r][c]){
                                que.add(new int[]{l, r, c});
                                visited[l][r][c] = true;
                            }
                        }else{
                            findAnswer = true;
                        }
                    }
                }
            }

            if(findAnswer){
                bw.write("Escaped in " + level + " minute(s).\n");
            }else{
                bw.write("Trapped!\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}