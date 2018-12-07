package com.allen;

/**
 * 功能:
 *
 * @date: 2018-10-24 14:52
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
public class Circle {
    public static void main(String[] args) {
        printCircle();
        System.out.println("\n\n");
        printLove();
        
    }
    
    static void printCircle(){
        int r = 30;
        for (int y = 0; y <= 2 * r; y += 2) {
            long x = Math.round(r - Math.sqrt(2 * r * y - y * y));
            long longLength = 2 * (r - x);
            for (int i = 0; i <= x; i++) {
                System.out.print(' ');
            }
            System.out.print('*');
            for (int j = 0; j <= longLength; j++) {
                System.out.print(' ');
            }
            System.out.println('*');
        }
    }
    
    static void printLove(){
        for(float y = (float) 1.5;y>-1.5;y -=0.1)  {
            for(float x= (float) -1.5;x<1.5;x+= 0.05){
                float a = x*x+y*y-1;
                float love=(a*a*a-x*x*y*y*y);
                if(love<=0.0)  {
                    System.out.print("^");
                }
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
