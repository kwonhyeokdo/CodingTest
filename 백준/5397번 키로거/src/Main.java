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

        final int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            final String inputString = br.readLine();
            final List<Character> charList = new LinkedList<>();
            final ListIterator<Character> li = charList.listIterator();
            for(int j = 0; j < inputString.length(); j++){
                final char c = inputString.charAt(j);
                
                switch(c){
                    case '<':
                        if(li.hasPrevious()){
                            li.previous();
                        }
                        break;
                    case '>':
                        if(li.hasNext()){
                            li.next();
                        }
                        break;
                    case '-':
                        if(li.hasPrevious()){
                            li.previous();
                            li.remove();;
                        }
                        break;
                    default:
                        li.add(c);
                        break;
                }
            }
            final StringBuffer sb = new StringBuffer();
            for(final char c : charList){
                sb.append(c);
            }
            sb.append('\n');

            bw.write(sb.toString());
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}