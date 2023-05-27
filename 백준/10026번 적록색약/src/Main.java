import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        final int N = Integer.parseInt(br.readLine());
        final int[][] intBoard = new int[N][N];
        final char[][] charBoard1 = new char[N][N];
        final char[][] charBoard2 = new char[N][N];
        int n = 0;
        for(int i = 0; i < N; i++){
            final String inputLine = br.readLine();
            for(int j = 0; j < N; j++){
                intBoard[i][j] = n++;
                final char c = inputLine.charAt(j);
                charBoard1[i][j] = c;
                charBoard2[i][j] = (c == 'G' ? 'R' : c);
            }
        }

        final Graph graph1 = new Graph(n);
        final Graph graph2 = new Graph(n);
        for(int y = 0; y < N; y++){
            for(int x = 0; x < N; x++){
                final char c1 = charBoard1[y][x];
                final char c2 = charBoard2[y][x];
                final int u = intBoard[y][x];
                
                if(y - 1 >= 0){
                    final int v = intBoard[y - 1][x];
                    if(charBoard1[y - 1][x] == c1){
                        graph1.add(u, v);
                    }
                    if(charBoard2[y - 1][x] == c2){
                        graph2.add(u, v);
                    }
                }
                if(y + 1 < N){
                    final int v = intBoard[y + 1][x];
                    if(charBoard1[y + 1][x] == c1){
                        graph1.add(u, v);
                    }
                    if(charBoard2[y + 1][x] == c2){
                        graph2.add(u, v);
                    }
                }
                if(x - 1 >= 0){
                    final int v = intBoard[y][x - 1];
                    if(charBoard1[y][x - 1] == c1){
                        graph1.add(u, v);
                    }
                    if(charBoard2[y][x - 1] == c2){
                        graph2.add(u, v);
                    }
                }
                if(x + 1 < N){
                    final int v = intBoard[y][x + 1];
                    if(charBoard1[y][x + 1] == c1){
                        graph1.add(u, v);
                    }
                    if(charBoard2[y][x + 1] == c2){
                        graph2.add(u, v);
                    }
                }
            }
        }

        bw.write(graph1.dfsAll() + " " + graph2.dfsAll());

        bw.flush();
        bw.close();
        br.close();
    }

    private final class Graph{
        private final List<List<Integer>> adj = new ArrayList<>();
        private boolean[] isVisited = null;

        protected Graph(final int n){
            for(int i = 0; i < n; i++){
                adj.add(new ArrayList<>());
            }
            isVisited = new boolean[n];
        }

        private final void add(final int u, final int v){
            adj.get(u).add(v);
        }

        private final int dfsAll(){
            int compontent = 0;

            for(int i = 0; i < adj.size(); i++){
                if(!isVisited[i]){
                    compontent++;
                    dfs(i);
                }
            }

            return compontent;
        }

        private final void dfs(int n){
            isVisited[n] = true;
            for(final int next : adj.get(n)){
                if(!isVisited[next]){
                    dfs(next);
                }
            }
        }
    }
}