import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] input_N_initATK = br.readLine().split(" ");
        final int N = Integer.parseInt(input_N_initATK[0]);
        final long initATK = Long.parseLong(input_N_initATK[1]);
        final long[][] tah = new long[N][3];
        for(int i = 0; i < N; i++){
            final String[] input_t_a_h = br.readLine().split(" ");
            tah[i][0] = Long.parseLong(input_t_a_h[0]);
            tah[i][1] = Long.parseLong(input_t_a_h[1]);
            tah[i][2] = Long.parseLong(input_t_a_h[2]);
        }

        long min = 1;
        long max = 1000000L * 1000000L * N;

        boolean isSafe = true;

        while(min + 1 < max){
            final long mid = (min + max) / 2;

            long hp = mid;
            long atk = initATK;
            for(int i = 0; i < N; i++){
                final long t = tah[i][0];
                final long a = tah[i][1];
                long h = tah[i][2];
                if(t == 1L){
                    final long hitMonster = h / atk + (h % atk != 0 ? 1 : 0);
                    final long hitHero = hp / t + (hp % t != 0 ? 1 : 0);
                    System.out.println("hitMonster: " + hitMonster + ", hitHero: " + hitHero);
                    if(hitHero >= hitMonster){
                        hp = 0;
                        break;
                    }else{
                        hp -= a * (hitHero - 1);
                    }
                }else{
                    atk += a;
                    hp = Math.min(mid, hp + h);
                }
            }

            System.out.println("min: " + min + ", max: " + max + ", mid: " + mid + ", hp: " + hp);

            if(hp > 0){
                max = mid;
            }else{
                min = mid;
                isSafe = false;
            }
        }

        if(isSafe){
            bw.write(String.valueOf(min));
        }else{
            bw.write(String.valueOf(max));
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}