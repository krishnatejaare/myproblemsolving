package datastructures;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class HorseTourOnChessboard {
    static class Node {
        int r;
        int c;

        Node(int row, int col){
            r = row;
            c = col;
        }
    }

    static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        // Write your code here.

        final int[] row = {2, 2, -2, -2, 1, 1, -1, -1};
        final int[] col = {1, -1, 1, -1, 2, -2, 2, -2};

        int[][] dist = new int[rows][cols];

        for(int[] temp : dist){
            Arrays.fill(temp, -1);
        }

        dist[start_row][start_col] = 0;
        Queue<Node> q = new LinkedList();

        q.add(new Node(start_row, start_col));

        while(!q.isEmpty()) {

            Node cur = q.remove();

            for(int i=0; i<8; i++) {

                int new_row = cur.r + row[i];
                int new_col = cur.c + col[i];

                if(new_row >= 0 && new_row < rows && new_col >= 0 && new_col < cols) {

                    if(dist[new_row][new_col] == -1) {
                        dist[new_row][new_col] = dist[cur.r][cur.c] + 1;
                        if(new_row==end_row && new_col==end_col) {
                            return dist[end_row][end_col];
                        }
                        q.add(new Node(new_row, new_col));
                    }

                }
            }
        }

        return -1;
    }

    public static void main(String[] args){

        int rows = 5;

        int cols = 5;

        int start_row = 0;

        int start_col =0 ;

        int end_row = 4;

        int end_col = 1;
        int res = find_minimum_number_of_moves(rows, cols, start_row, start_col, end_row, end_col);
        System.out.println(res);
    }
}
