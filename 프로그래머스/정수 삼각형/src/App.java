public class App {
    public static void main(String[] args) throws Exception {
        int[][] triangle = {
            {7},
            {3, 8},
            {8, 1, 0},
            {2, 7, 4, 4},
            {4, 5, 2, 6, 5}
        };
        System.out.println(new Solution().solution(triangle));
    }
}
