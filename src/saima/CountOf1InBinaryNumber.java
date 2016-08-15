package saima;

import java.util.Scanner;

/**
 * 输入
 * 输入仅一行，包含三个整数l,r,m，其中l,r表示这个数的十进制范围是l~r，m表示这个数的二进制表示中有m个1.
 * 输出
 * 输出一行，包含一个整数，表示有多少个符合要求的数
 * Created by liyajin on 16/8/13.
 */
public class CountOf1InBinaryNumber {

    public static void main(String[] args) {
        //system in
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        int m = in.nextInt();

        //遍历
        int result = 0;
        for (int i = l; i <= r; i++){
            //判断二进制表示中1的个数是否为m个
            int num = i;
            int numOf1 = 0;
            while(num != 0){
                num = num & (num - 1);
                numOf1 ++;
                if(numOf1 > m) break;
            }
            if(numOf1 == m) result++;
        }

        if(result == 0) System.out.println("-1");
        else System.out.println(result);
    }



}
