import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] tictactoeBoard = new int[3][3];
        System.out.print("Player 1 is 1, and player 2 is 2\nRows and columns are numbered from 0 to 2\n");
        printBoard(tictactoeBoard);
        int x=0;
        while(true){
            x++;
            tictactoeBoard=play(tictactoeBoard,false);
            if (x==9){
                System.out.print("It's a tie");
                break;
            }
            printBoard(tictactoeBoard);
            if(checkWinner(tictactoeBoard)==true){
                System.out.print("PLAYER 1 WINS!!!");
                break;
            }
            x++;
            tictactoeBoard=play(tictactoeBoard,true);
            printBoard(tictactoeBoard);
            if(checkWinner(tictactoeBoard)==true){
                System.out.print("PLAYER 2 WINS!!!");
                break;
            }
            if (x==9){
                System.out.print("It's a tie");
                break;
            }
        }
    }

    static int[][] play(int[][] tictactoeBoard, boolean playerNumber){
        Scanner scanner = new Scanner(System.in);
        int row=3, column=3;
        boolean trial = true;
        while (trial){
            try{
                System.out.print("Enter the row number from 0 to 2:");
                row = scanner.nextInt();
                System.out.print("Enter the column number from 0 to 2:");
                column = scanner.nextInt();
            }
            catch (Exception e){
                System.out.print("Please enter integers between 0 and 2\n");
                scanner.next();
                continue;
            }
            if (row>2 || row<0 || column>2 || column<0 || tictactoeBoard[row][column]!=0){
                System.out.print("Please enter a valid position\n");
            }
            else {
                trial=false;
            }
        }
        if (playerNumber==false){
            tictactoeBoard[row][column]=1;
        }
        if (playerNumber==true){
            tictactoeBoard[row][column]=2;
        }
        return tictactoeBoard;
    }

    static boolean checkWinner(int[][] p){
        boolean result=false;
        for (int i=0;i<3;i++){
            if(p[i][0]==p[i][1] && p[i][1]==p[i][2] && p[i][2]!=0 || p[0][i]==p[1][i] && p[1][i]==p[2][i] && p[2][i]!=0){
                result=true;
            }
        }
        if (p[0][0]==p[1][1]  && p[1][1]==p[2][2] && p[2][2]!=0 || p[0][2]==p[1][1] && p[1][1]==p[2][0] && p[2][0]!=0){
            result=true;
        }
        return result;
    }

    static void printBoard(int[][] tictactoeBoard){
        System.out.println(Arrays.toString(tictactoeBoard[0]));
        System.out.println(Arrays.toString(tictactoeBoard[1]));
        System.out.println(Arrays.toString(tictactoeBoard[2]));
    }
}
