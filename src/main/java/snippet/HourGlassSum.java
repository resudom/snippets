package snippet;

import java.io.*;
import java.util.*;

public class HourGlassSum {


    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        if(arr.length<3 || arr[0].length<3) return 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<=arr.length-3; i++){
            for(int j=0; j<=arr[0].length-3;j++){

                max = Math.max(max,calcSum(arr, i, j));
            }
        }
        return max;
    }

    static int calcSum(int[][] area, int y, int x){

        int sum = 0;
        for(int i=y; i<y+3; i++){
            for(int j=x; j<x+3; j++){

                sum+=area[i][j];
            }
        }
        sum-= (area[y+1][x] + area[y+1][x+2]);
        return sum;
    }


    private static final Scanner scanner = new Scanner("-1 -1 0 -9 -2 -2\n" +
            "-2 -1 -6 -8 -2 -5\n" +
            "-1 -1 -1 -2 -3 -4\n" +
            "-1 -9 -2 -4 -4 -5\n" +
            "-7 -3 -3 -2 -9 -9\n" +
            "-1 -3 -1 -2 -4 -5");

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }


}
 class Hourglass{

    int [][] area;
    int x;
    int y;
    int sum;

    Hourglass(int [][] area, int x, int y){

//        if(area.length<3 || area[0].length<3) throw new RuntimeException();
        this.area = area;
        this.x = x;
        this.y = y;
        this.sum = calcSum();
    }

    private int calcSum(){

        if(area.length<3 || area[0].length<3) return 0;
        int sum = 0;
        for(int i=y; i<y+3; i++){
            for(int j=x; j<x+3; j++){

                sum+=area[j][i];
            }
        }
        sum-= (area[y+1][x] + area[y+1][x+2]);
        return sum;
    }

 }
