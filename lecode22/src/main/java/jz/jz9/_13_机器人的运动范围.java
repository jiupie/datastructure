package jz.jz9;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * @author 南顾北衫
 * @date 2023/3/24
 */
public class _13_机器人的运动范围 {
    public static void main(String[] args) {
        _13_机器人的运动范围 v = new _13_机器人的运动范围();
        v.movingCount(20, 30, 18);
        System.out.println(v.num);
    }

    public int movingCount(int m, int n, int k) {
        //32
        //个位：x/1%10
        //十位：x/10%10
        //深度优先

//        boolean[][] visited = new boolean[m][n];
//        dfs(m, n, 0, 0, k, visited);
        bfs(m, n, k);
        return num;
    }

    private int num;

    //深度优先
    public void dfs(int m, int n, int tempM, int tempN, int k, boolean[][] visited) {
        if (tempM >= m || tempN >= n || sum(tempM, tempN) > k) {
            return;
        }
        if (visited[tempM][tempN]) {
            return;
        }
        visited[tempM][tempN] = true;
        num++;
        //m = 2, n = 3 k=1
        //1,0 2,0
        dfs(m, n, tempM + 1, tempN, k, visited);
        dfs(m, n, tempM, tempN + 1, k, visited);
    }

    public int sum(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }

    //广度优先
    public void bfs(int m, int n, int k) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{0, 0});

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            Integer tempM = poll[0];
            Integer tempN = poll[1];
            if (tempM >= m || tempN >= n || sum(tempM, tempN) > k) {

            } else {
                num++;
                if (tempM + 1 < m && !visited[tempM + 1][tempN]) {
                    queue.add(new Integer[]{tempM + 1, tempN});
                    visited[tempM + 1][tempN] = true;
                }
                if (tempN + 1 < n && !visited[tempM][tempN + 1]) {
                    queue.add(new Integer[]{tempM, tempN + 1});
                    visited[tempM][tempN + 1] = true;
                }
            }
        }
    }
}
