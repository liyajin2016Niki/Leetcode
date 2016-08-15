package saima;

import java.util.Scanner;

/**
 * Created by liyajin on 16/8/13.
 */
public class LatticeGame {

    public static void main(String[] args) {
        //system in
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //共有n个格子
        int m = in.nextInt(); //进行m次操作

        int[] weight = new int[n+1];

        //读入每个格子的权重
        for(int i = 1; i <= n; i++){
            weight[i] = in.nextInt();
        }

        //进行每一次操作
        for(int i = 0; i < m; i++){
            int type = in.nextInt();
            int para1 = in.nextInt();
            int para2 = in.nextInt();

            switch (type){
                case 1:
                    weight[para1] = para2;
                    System.out.println();
                    break;
                case 2:
                    int result = 0;
                    for(int j = para1; j <= para2; j++) result += weight[j];
                    System.out.println(result);
                    break;
                case 3:
                    int max = 0;
                    for(int j = para1; j <= para2; j++) max = (weight[j] > max) ? weight[j] : max;
                    System.out.println(max);
                    break;
            }
        }

    }



}
