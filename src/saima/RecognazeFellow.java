package saima;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by liyajin on 16/8/13.
 */
public class RecognazeFellow {

    /**
     * 超时了
     * @param args
     */
//    public static void main(String[] args) {
//        //system in
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            int n = in.nextInt(); //共有n个人
//            int m = in.nextInt(); //接下来有m行表示m个关系
//
//            if (n == 0 && m == 0) return;
//
//            int[][] relation = new int[n + 1][n + 1];
//
//            //读入m行,并把关系记录到二维数组中
//            for (int i = 0; i < m; i++) {
//                int num1 = in.nextInt();
//                int num2 = in.nextInt();
//
//                if (num1 > num2) {
//                    int temp = num1;
//                    num1 = num2;
//                    num2 = temp;
//                }
//
//                relation[num1][num2] = 1;
//            }
//
//            Queue<Integer> queue = new LinkedList<>();
//            queue.add(1);
//
//            int result = 0;
//            while(!queue.isEmpty()){
//                int row = queue.poll();
//                for(int j = 1; j <= n; j++){
//                    if(relation[row][j] == 1){
//                        result ++;
//                        queue.add(j);
//                    }
//                }
//            }
//            System.out.println(result);
//
//        }
//    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        LinkedList<LinkedList<int[]>> group=new LinkedList<LinkedList<int[]>>();
        while(sc.hasNext()){
            int x1=sc.nextInt();
            int x2=sc.nextInt();
            if(x1==0 && x2==0){
                break;
            }
            else{
                LinkedList<int[]> list=new LinkedList<int[]>();
                for(int i=0;i<x2;i++){
                    int relation[]=new int[2];
                    relation[0]=sc.nextInt();
                    relation[1]=sc.nextInt();
                    list.add(relation);
                }
                group.add(list);
            }
        }
        Iterator<LinkedList<int[]>> it=group.iterator();
        while(it.hasNext()){

            int num=0;
            LinkedList<int[]> list=it.next();
            Iterator<int[]> it2=list.iterator();
            Queue<Integer> queue=new LinkedList<Integer>();
            queue.offer(1);
            int p;
            while(!queue.isEmpty() && it2.hasNext()){
                p=queue.poll();
                while(it2.hasNext()){
                    int[] relation=it2.next();
                    if(relation[0]==p || relation[1]==p){
                        int k=relation[0]==p?relation[1]:relation[0];
                        if(!queue.contains(k) && relation[0]!=relation[1]){
                            num++;
                            queue.offer(k);
                        }
                        it2.remove();
                    }
                }
                it2=list.iterator();
            }
            System.out.println(num);
        }
    }

}
