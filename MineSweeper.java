import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class MineSweeper {
    public static void main(String[] arsg) {
        Scanner inp = new Scanner(System.in);
        Random rand = new Random();
        int a, b, c ,d;
        System.out.print("Satir Boyutunu Giriniz :");
        a = inp.nextInt();
        System.out.print("Sutun Boyutunu Giriniz :");
        b = inp.nextInt();
        int count =0;
        int count2 =0;
        char top = 48;
        char[][] map = new char[a][b];
        char[][] mine = new char[a][b];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = '-';
                    //System.out.print(map[i][j] + " ");
                }
                //System.out.println();
            }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                mine[i][j] = '-';
                System.out.print(mine[i][j] + " ");
            }
            System.out.println();
        }

            int x,y;
            while(count != (a*b)/4){
                x = rand.nextInt(a);
                y = rand.nextInt(b);
                if (map[x][y] != '*'){
                    map[x][y] = '*';
                    count++;
                }
            }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                //System.out.print(map[i][j] + " ");
            }
            //System.out.println();
        }
        System.out.println("====================");

        while(count2!=(a*b)-((a*b)/4)) {
                System.out.print("Satir : ");
                c = inp.nextInt();
                System.out.print("Sutun : ");
                d = inp.nextInt();
                top = 48;
                if (c+1>a || d+1>b || c < 0 || d < 0) {
                    System.out.println("Diziniz disina ciktiniz!!");
                    continue;
                }
                if (map[c][d] == '*') {
                    System.out.println("Kaybettiniz!!");
                    for (int i = 0; i < map.length; i++) {
                        for (int j = 0; j < map[i].length; j++) {
                            System.out.print(map[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                }
                if (map[c][d] != '*') {
                    if(mine[c][d]=='-'){
                        count2++;
                    }
                    if (d-1>=0) {
                        if (map[c][d - 1] == '*') {
                            map[c][d] = top;
                            top++;
                        }
                    }
                    if(c+1<a && d-1>0){
                        if (map[c + 1][d - 1] == '*') {
                            mine[c][d] = top;
                            top++;
                        }
                        }
                    if(c+1<a){
                        if (map[c + 1][d] == '*') {
                            map[c][d] = top;
                            top++;
                        }
                    }
                    if(c-1>=0 && d+1<b) {
                        if (map[c - 1][d + 1] == '*') {
                            map[c][d] = top;
                            top++;
                        }
                    }
                    if(d+1<b) {
                        if (map[c][d + 1] == '*') {
                            map[c][d] = top;
                            top++;
                        }
                    }
                    if(c+1<a && d+1<b) {
                        if (map[c + 1][d + 1] == '*') {
                            map[c][d] = top;
                            top++;
                        }
                    }
                    if(c-1>=0 && d-1>=0) {
                        if (map[c - 1][d - 1] == '*') {
                            mine[c][d] = top;
                            top++;
                        }
                    }
                    if(c-1>=0) {
                        if (map[c - 1][d] == '*') {
                            map[c][d] = top;
                            top++;
                        }
                    }
                    if (map[c][d] < 0) {
                        map[c][d] = top;
                        top++;
                    }
                    mine[c][d] = top;
                    //top++;

                    if(count2==(a*b)-((a*b)/4)){
                        System.out.println("Kazandiniz!!");
                        for (int i = 0; i < map.length; i++) {
                            for (int j = 0; j < map[i].length; j++) {
                                if(map[i][j] == '*')
                                    mine[i][j]=map[i][j];
                            }
                        }
                        for (int i = 0; i < map.length; i++) {
                            for (int j = 0; j < map[i].length; j++) {
                                System.out.print(mine[i][j] + " ");
                            }
                            System.out.println();
                        }

                        break;
                    }
                }

                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[i].length; j++) {
                        System.out.print(mine[i][j] + " ");
                    }
                    System.out.println();
                }
            }
    }
}
