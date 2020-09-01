/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessPiece;

import chess.ChessMove;
import java.util.Vector;

/**
 *
 * @author Acer
 */
public class Pawn{
    public static void calculatePossibleMoves(int[][] board, int i, int j, Vector moves){
        int value = board[i][j];
        
        if (value > 0){
            if (i == 6 && board[i-2][j] == 0 && board[i-1][j] == 0) //exception in the beginning
                moves.addElement(new ChessMove(i,j,i-2,j));
            if (board[i-1][j] == 0 ) //move ahead
                moves.addElement(new ChessMove(i,j,i-1,j));
            if (j < 7 && board[i-1][j+1] < 0) //opponent piece; can attack!
                moves.addElement(new ChessMove(i,j,i-1,j+1));
            if (j > 0 && board[i-1][j-1] < 0) //opponent piece; can attack
                moves.addElement(new ChessMove(i,j,i-1,j-1));
        }
        
        if (value < 0){
            if (i == 1 && board[i+2][j] == 0 && board[i+1][j] == 0) //exception in the beginning
                moves.addElement(new ChessMove(i,j,i+2,j));
            if (board[i+1][j] == 0 ) //move ahead
                moves.addElement(new ChessMove(i,j,i+1,j)); 
            if (j < 7 && board[i+1][j+1] > 0) //opponent piece; can attack!
                moves.addElement(new ChessMove(i,j,i+1,j+1));
            if (j > 0 && board[i+1][j-1] > 0) //opponent piece; can attack
                moves.addElement(new ChessMove(i,j,i+1,j-1));
            
        }
    }
}

