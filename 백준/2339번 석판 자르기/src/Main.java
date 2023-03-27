import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private static final int STONE = 1;
    private static final int GEM = 2;
    private int[][] slate = null;

    public static final void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        slate = new int[N][N];
        int gemCnt = 0;
        int stoneCnt = 0;
        for(int y = 0; y < N; y++){
            final String[] inputLine = br.readLine().split(" ");
            for(int x = 0; x < N; x++){
                final int num = Integer.parseInt(inputLine[x]);
                if(num == GEM){
                    gemCnt++;
                }else if(num == STONE){
                    stoneCnt++;
                }
                slate[y][x] = Integer.parseInt(inputLine[x]);
            }
        }

        int answer = 0;
        if(stoneCnt == 0 && gemCnt == 1){
            answer = 1;
        }else{
            answer += cut(0, N - 1, 0, N - 1, true);
            answer += cut(0, N - 1, 0, N - 1, false);
            if(answer == 0){
                answer = -1;
            }
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private final int cut(final int startY, final int endY, final int startX, final int endX, final boolean isHorizental){
        int result = 0;
        int gemCnt = 0;
        int stoneCnt = 0;
        for(int y = startY; y <= endY; y++){
            for(int x = startX; x <= endX; x++){
                if(slate[y][x] == GEM){
                    gemCnt++;
                }else if(slate[y][x] == STONE){
                    stoneCnt++;
                }
            }
        }

        if(gemCnt == 0){
            return 0;
        }else if(gemCnt >= 2 && stoneCnt == 0){
            return 0;
        }else if(gemCnt == 1 && stoneCnt >= 2){
            return 0;
        }else if(gemCnt == 1 && stoneCnt == 0){
            return 1;
        }

        if(isHorizental){
            for(int y = startY + 1; y <= endY - 1; y++){
                gemCnt = 0;
                stoneCnt = 0;
                for(int x = startX; x <= endX; x++){
                    if(slate[y][x] == GEM){
                        gemCnt++;
                    }else if(slate[y][x] == STONE){
                        stoneCnt++;
                    }
                }

                if(stoneCnt > 0 && gemCnt == 0){
                    final int up = cut(startY, y - 1, startX, endX, false);
                    final int down = cut(y + 1, endY, startX, endX, false);
                    if(up != 0 && down != 0){
                        result += up * down;
                    }
                }
            }
        }
        // 수직으로 자르기
        else{
            for(int x = startX + 1; x <= endX - 1; x++){
                gemCnt = 0;
                stoneCnt = 0;
                for(int y = startY; y <= endY; y++){
                    if(slate[y][x] == GEM){
                        gemCnt++;
                    }else if(slate[y][x] == STONE){
                        stoneCnt++;
                    }
                }

                if(stoneCnt > 0 && gemCnt == 0){
                    final int left = cut(startY, endY, startX, x - 1, true);
                    final int right = cut(startY, endY, x + 1, endX, true);
                    if(left != 0 && right != 0){
                        result += left * right;
                    }
                }
            }
        }
        return result;
    }
}