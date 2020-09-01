/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;
import chessPiece.*;
import java.util.*;
/**
 *
 * @author Acer
 */
public class ChessState {
    
    public void gameResult(int winner){
        if (winner == 1)
            System.out.println("And the winner is White");
        else
            System.out.println("And the winner is Black");
    }
    
    public ChessState(){
        board = new int[8][8];
        moves = new Vector(200);
        playerToMove = 1;
        

        board[0][0] = -4;board[0][1] = -2;board[0][2] = -3;board[0][3] = -5;
        board[0][4] = -6;board[0][5] = -3;board[0][6] = -2;board[0][7] = -4;

        board[1][0] = -1;board[1][1] = -1;board[1][2] = -1;board[1][3] = -1;
        board[1][4] = -1;board[1][5] = -1;board[1][6] = -1;board[1][7] = -1;

        board[2][0] = 0;board[2][1] = 0;board[2][2] = 0;board[2][3] = 0;
        board[2][4] = 0;board[2][5] = 0;board[2][6] = 0;board[2][7] = 0;

        board[3][0] = 0;board[3][1] = 0;board[3][2] = 0;board[3][3] = 0;
        board[3][4] = 0;board[3][5] = 0;board[3][6] = 0;board[3][7] = 0;

        for (int i=4;  i< 8; i++){
            for(int j=0; j< 8; j++)
                board[i][j] = -board[7 - i][j];
        }
    }
    
    private void showPiece(int pieceCode){
        if (pieceCode < 0)
            System.out.print("B");
        else if (pieceCode > 0)
            System.out.print("W");
        
        switch (pieceCode) {
            case 0:
                System.out.print("-");
                break;

            case 1:
            case -1:
                System.out.print("P");
                break;
        
            case 2:
            case -2:
                System.out.print("N");
                break;
            case 3:
            case -3:
                System.out.print("B");
                break;
            case 4:
            case -4:
                System.out.print("R");
                break;
            case 5:
            case -5:
                System.out.print("Q");
                break;
            case 6:
            case -6:
                System.out.print("K");
                break;
            }
        System.out.print("\t");
    }
    
    public int makeValidMovesList(){
        
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (playerToMove*board[i][j] > 0){
                    switch (board[i][j]){
                        case 1:
                        case -1:
                            Pawn.calculatePossibleMoves(board,i,j,moves);
                            break;

                        case 2:
                        case -2:
                            Knight.calculatePossibleMoves(board,i,j,moves);
                            break;

                        case 3:
                        case -3:
                            Bishop.calculatePossibleMoves(board,i,j,moves);
                            break;

                        case 4:
                        case -4:
                            Rook.calculatePossibleMoves(board,i,j,moves);
                            break;

                        case 5:
                        case -5:
                            Queen.calculatePossibleMoves(board,i,j,moves);
                            break;

                        case 6:
                        case -6:
                            King.calculatePossibleMoves(board,i,j,moves);
                            break;
                    }
                }
            }
        }
        return moves.size();
    }

   
    
    public void showState(){
        System.out.println("\nPlayer To Move:\t");
        
        if(playerToMove > 0)
            System.out.print("White");
        else
            System.out.print("Black");

        System.out.println("\n\n");
        for (int i = 0;  i < 8; i++) {
            for(int j = 0; j < 8; j++){
                showPiece(board[i][j]);
            }
        System.out.print("\n\n");
        }
    }
    
    public boolean makeMove(ChessMove pieceMove){
        
        lastOut = board[pieceMove.To[0]][pieceMove.To[1]];
        board[pieceMove.To[0]][pieceMove.To[1]] = board[pieceMove.From[0]][pieceMove.From[1]];
        board[pieceMove.From[0]][pieceMove.From[1]] = 0;
        
        if (board[pieceMove.To[0]][pieceMove.To[1]] == -1 && pieceMove.To[0] == 0){
            promotePawn(pieceMove.To[0],pieceMove.To[1]);
        }
        if (board[pieceMove.To[0]][pieceMove.To[1]] == 1 && pieceMove.To[0] == 7){
            promotePawn(pieceMove.To[0],pieceMove.To[1]);
        }
        
        playerToMove *= -1;
        moves.clear();
        return true;
    }
    
    private void promotePawn(int i, int j){
        //take input
        System.out.println("Promoting pawn........");
        board[i][j] = playerToMove*5;
    }
    
    
    public boolean seeGoal(){
        if (lastOut == -6 || lastOut == 6)
                return true; // player 1 wins
        else return false;
    }
    
    public Vector moves;
    public int playerToMove;
    public int[][] board;
    private int lastOut;
}
