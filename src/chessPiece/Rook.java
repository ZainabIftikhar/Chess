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
public class Rook {
    public static void calculatePossibleMoves(int[][] board, int i, int j, Vector moves){
        int value = board[i][j];
        
        //Vertical Moves
        for(int a = i+1; a < 8; a++){
            if(board[a][j] == 0) //empty cells
                moves.addElement(new ChessMove(i,j,a,j));
            else if (board[a][j] > 0 && value < 0 || board[a][j] < 0 && value > 0){ //can kill opponent
                moves.addElement(new ChessMove(i,j,a,j));       
                break;
                }
            else //friendly piece in way
                break;
        }
        
        for(int a = i-1; a > -1; a--){
            if(board[a][j] == 0) //empty cells
                moves.addElement(new ChessMove(i,j,a,j));
            else if (board[a][j] > 0 && value < 0 || board[a][j] < 0 && value > 0){ //can kill opponent
                moves.addElement(new ChessMove(i,j,a,j));       
                break;
                }
            else //friendly piece in way
                break;
        }
        
        //Horizontal Moves
        for (int b = j+1; b < 8; b++){
            if(board[i][b] == 0) //empty cells
                moves.addElement(new ChessMove(i,j,i,b));
            else if (board[i][b] > 0 && value < 0 || board[i][b] < 0 && value > 0){ //can kill opponent
                moves.addElement(new ChessMove(i,j,i,b));       
                break;
                }
            else //friendly piece in way
                break;
        }
        
        for (int b = j-1; b > -1; b--){
            if(board[i][b] == 0) //empty cells
                moves.addElement(new ChessMove(i,j,i,b));
            else if (board[i][b] > 0 && value < 0 || board[i][b] < 0 && value > 0){ //can kill opponent
                moves.addElement(new ChessMove(i,j,i,b));       
                break;
                }
            else //friendly piece in way
                break;
        }
    }
}
