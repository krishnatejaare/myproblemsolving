//package datastructures;
//
//
//public class Robot {
//    class XY
//    {
//        int x;
//        int y;
//    };
//    public static void main(String args[]) {
//
//
//
//
//            int grid[8][8] = {
//            {1,1,1,1,1,1,1,1},
//            {1,0,0,0,1,1,1,1},
//            {1,1,0,0,1,1,1,1},
//            {1,1,0,0,1,1,1,1},
//            {1,1,1,2,0,1,0,0},
//            {1,1,1,1,1,1,1,1},
//            {1,1,1,1,1,1,1,1},
//            {1,1,1,1,1,1,1,1}
//        };
//
//
//            int rows = 8;
//            int cols = 8;
//
//            int distance[rows][cols];
//
//            for(int m = 0;m<rows;m++)
//            {
//                for(int n =0;n<cols;n++)
//                {
//                    distance[m][n] = -1;
//                }
//            }
//
//            queue<XY> iterator;
//
//
//            XY xy;
//            xy.x = 0;
//            xy.y = 0;
//            distance[0][0] = 0;
//            iterator.push(xy);
//
//            while(!iterator.empty())
//            {
//                xy = iterator.front();
//                iterator.pop();
//                //printf("popped %d+%d\n",xy.x ,xy.y);
//                for(int p = -1;p<2;p++)
//                {
//                    for(int q = -1;q<2;q++)
//                    {
//                        if(p == q)continue;
//                        int i = xy.x + p;
//                        int j = xy.y + q;
//
//                        if(i<0)i=0;
//                        if(j<0)j=0;
//                        if(i>rows-1)i=rows-1;
//                        if(j>cols-1)j=cols-1;
//
//                        if(i== xy.x && j == xy.y)continue;
//
//                        //              printf("i,j = %d,%d\n",i,j);
//
//                        if(distance[i][j] == -1)
//                        {
//                            //                 printf("******\n");
//                            if(grid[i][j] != 0)
//                            {
//                                //                 printf("assigned distance %d to %d+%d\n",distance[xy.x][xy.y] + 1,i,i);
//                                distance[i][j] = distance[xy.x][xy.y] + 1;
//                                XY xyn;
//                                xyn.x = i;
//                                xyn.y = j;
//                                iterator.push(xyn);
//                                //                    printf("pushed %d+%d\n",xyn.x,xyn.y);
//                            }
//                        }
//
//                    }
//                }
//            }
//
//            for(int x = 0;x<rows;x++)
//            {
//                for(int y =0;y<cols;y++)
//                {
//                    System.out.println("%d ",distance[x][y]);
//                }
//                System.out.println("\n");
//            }
//            return 0;
//        }
//    }
//}
