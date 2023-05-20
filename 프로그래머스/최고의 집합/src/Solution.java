class Solution {
    public int[] solution(int n, int s) {
        final int[] answer = new int[n];
        
        if(n > s){
            return new int[]{-1};
        }
        
        for(int i = 0; i < n; i++){
            answer[i] = s / n;
        }
        
        for(int i = 0, j = n - 1; i < s % n; i++, j--){
            answer[j]++;
        }
        
        return answer;
    }
}