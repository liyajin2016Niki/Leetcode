package saima;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by liyajin on 16/8/13.
 */
public class YuderTest {

    public static void main(String[] args) {
        //system in
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();

        int length = line1.length();
        int sameNum = 0;

        for(int i = 0; i < length; i++){
            Character c1 = line1.charAt(i);
            Character c2 = line2.charAt(i);
            if(Character.isDigit(c1) || Character.isLetter(c1)){
                if(c2 == '1') sameNum++;
            }else{
                if(c2 == '0') sameNum++;
            }
        }

        float result = ((float)sameNum / length) * 100;
        DecimalFormat df = new DecimalFormat("0.00");
        String answer = df.format(result);
        System.out.println(answer + "%");

    }



}
