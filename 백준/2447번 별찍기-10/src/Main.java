import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private char[][] starArr = null;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private final void solution() throws Exception{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        starArr = new char[N][N];

        star(0, N, 0, N, true);
        
        for(int y = 0; y < N; y++){
            for(int x = 0; x < N; x++){
                bw.write(starArr[y][x]);
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private final void star(final int startY, final int endY, final int startX, final int endX, final boolean isDraw) throws Exception{
        if(endY - startY == 3){
            for(int y = startY; y < endY; y++){
                for(int x = startX; x < endX; x++){
                    if((y == startY + 1 && x == startX + 1) || !isDraw){
                        starArr[y][x] = ' ';
                    }else{
                        starArr[y][x] = '*';
                    }
                }
            }
            return;
        }

        final int divide = (endY - startY) / 3;

        int y = startY;
        for(int i = 0; i < 3; i++){
            int x = startX;
            for(int j = 0; j < 3; j++){
                if((i == 1 && j == 1) || !isDraw){
                    star(x, x + divide, y, y + divide, false);
                }else{
                    star(x, x + divide, y, y + divide, true);
                }
                x += divide;
            }
            y += divide;
        }
    }
}
