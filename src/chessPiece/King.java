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
public class King {
    public static void calculatePossibleMoves(int[][] board, int i, int j, Vector moves){
        int value = board[i][j];
        
        int [][] index = {
            {i+1, j},
            {i, j+1},
            {i-1, j},
            {i, j-1},
            {i+1, j+1},
            {i-1, j-1},
            {i-1, j+1},
            {i+1, j-1}
        };
        
        for (int x = 0; x < 8; x++){
                if (index[x][0] > -1 && index[x][0] < 8
                        && index[x][1] > -1 && index[x][1] < 8 ){
                    if ((board[index[x][0]][index[x][1]] > 0 && value < 0)  
                        ||  (board[index[x][0]][index[x][1]] < 0 && value > 0)    
                        ||    board[index[x][0]][index[x][1]] == 0)
                        moves.addElement(new ChessMove(i,j,index[x][0],index[x][1]));
            }
        }
    }
}
