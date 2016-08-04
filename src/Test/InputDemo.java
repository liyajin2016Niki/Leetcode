package Test;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by liyajin on 16/8/2.
 */
public class InputDemo {


        public static void main(String[] args) {
            Set<String> set = new HashSet<>();
            Scanner in = new Scanner(System.in);
            while(in.hasNextLine()){
                String line = in.nextLine();
                if(line.equals("")) break;
                String[] array = line.split(" ");
                for (String s: array) {
                    set.add(s);
                }
            }
            System.out.println(set.size());

        }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        //input
//        int m = in.nextInt();
//        int n = in.nextInt();
//        if(m < 4 || n < 4){
//            System.out.println(0);
//            return;
//        }
//        int[][] data = new int[m][n];
//        for(int i = 0; i < m; i++){
//            String str = in.nextLine();
//            String[] strArr = str.split(" ");
//            for(int j = 0; j < strArr.length; j++){
//                data[i][j] = Integer.parseInt(strArr[j]);
//            }
//        }
//
//        int globalMin = Integer.MAX_VALUE;
//        int partMin = Integer.MAX_VALUE;
//
//        for(int a = 1; a < n - 2; a++){
//            for(int b = a + 1; b < n - 1; b++){
//                for()
//            }
//        }
//
//    }
}
