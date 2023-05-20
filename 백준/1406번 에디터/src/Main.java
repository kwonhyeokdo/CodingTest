import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class Main{
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    
    private final void solution() throws Exception{
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String initStr = br.readLine();
        final int N = Integer.parseInt(br.readLine());
        final char[][] commands = new char[N][2];
        for(int i = 0; i < N; i++){
            final String[] inputCommand = br.readLine().split(" ");
            for(int j = 0; j < inputCommand.length; j++){
                commands[i][j] = inputCommand[j].charAt(0);
            }
        }

        List<Character> strList = new LinkedList<>();
        for(int i = 0; i < initStr.length(); i++){
            strList.add(initStr.charAt(i));
        }

        ListIterator<Character> li = strList.listIterator();
        while(li.hasNext()){
            li.next();
        }

        for(char[] command : commands){
            if(command[0] == 'P'){
                li.add(command[1]);
            }else if(command[0] == 'L'){
                if(li.hasPrevious()){
                    li.previous();
                }
            }else if(command[0] == 'D'){
                if(li.hasNext()){
                    li.next();
                }
            }else if(li.hasPrevious()){
                li.previous();
                li.remove();
            }
        }

        StringBuffer sb = new StringBuffer();
        for(char c : strList){
            sb.append(c);
        }

        bw.write(sb.toString());
        
        bw.flush();
        bw.close();
        br.close();
    }
}