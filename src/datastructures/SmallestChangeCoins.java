package datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SmallestChangeCoins {
    public int change(int[]coins,int sum){
        if(sum==0)return 0;
        int min=Integer.MAX_VALUE;
        for(int coin:coins){
            if(sum-coin>=0){
                int c=change(coins,sum-coin);
                if(min > c+1) min=c+1;
            }
        }
        return min;

    }
    Queue<Integer> rq = new LinkedList<>();
    Queue<Integer> cq = new LinkedList<>();
    int R = 0;
    int C = 0;
    int nodes_in_next_layer = 0;
    int nodes_left_in_layer = 1;
    int moveCount = 0;

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
        R = numRows;
        C = numColumns;
        boolean[][]visited =new boolean[numRows][numColumns];
        int[][] grid = lot.stream().map(  u  ->  u.stream().mapToInt(i->i).toArray()  ).toArray(int[][]::new);
        int result = solve(0,0,grid,visited);
        System.out.println(result);
        return result;

    }

    int solve(int row, int col, int[][] grid, boolean[][] visited) {
        rq.add(row);
        cq.add(col);
        boolean reached_end = false;
        visited[row][col] = true;
        while(rq.size() > 0) {
            int r = rq.poll();
            int c = cq.poll();
            if (grid[r][c] == 9) {
                reached_end = true;
                break;
            }
            explore_neighbours(r, c, visited, grid);
            nodes_left_in_layer--;
            if (nodes_left_in_layer == 0) {
                nodes_left_in_layer = nodes_in_next_layer;
                nodes_in_next_layer = 0;
                moveCount++;
            }

        }

        if (reached_end) {
            return moveCount;
        }
        return -1;
    }

    void explore_neighbours(int row, int col, boolean[][]visited, int[][]grid) {
        int[]dr = {-1, 1, 0, 0};
        int[]dc = {0, 0, 1, -1};
        for(int i=0;i<4;i++) {
            int rr = row + dr[i];
            int cc = col + dc[i];
            if(rr < 0 || cc < 0) continue;
            if(rr >= R || cc >= C) continue;
            if (grid[rr][cc] != 0 && visited[rr][cc] == false) {
                rq.add(rr);
                cq.add(cc);
                visited[rr][cc] = true;
                nodes_in_next_layer++;
            }

        }
    }
    public static void main (String args[])
    {
        SmallestChangeCoins s=new SmallestChangeCoins();
        //int[]coins={25,10,5,1};
        int[]coins={1,2,3};
        int target=5;
        int resu=s.change(coins,target);
        System.out.println(resu);
        List<List<Integer>>result=new ArrayList<List<Integer>>();
        List<Integer>r = new ArrayList<>();
        r.add(1);
        r.add(1);
        r.add(1);
        result.add(r);
        List<Integer>ra = new ArrayList<>();
        ra.add(0);
        ra.add(9);
        ra.add(1);
        result.add(ra);
        List<Integer>raa = new ArrayList<>();
        raa.add(1);
        raa.add(1);
        raa.add(1);
        result.add(raa);
        //List<List<Integer>> lot = [[1,0,0],[1,0,0],[1,9,1]];
        s.removeObstacle(3,3, result);

    }
}
