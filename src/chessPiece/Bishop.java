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
public class Bishop {
    public static void calculatePossibleMoves(int[][] board, int i, int j, Vector moves){
        
        int value = board[i][j];
        //Rightward Movements
        
        for (int a = i+1, b = j+1; a < 8 && b < 8; a++,b++)  {  
            if(board[a][b] == 0)   //empty cells
                moves.addElement(new ChessMove(i,j,a,b));
            
            else if (board[a][b] > 0 && value < 0 || board[a][b] < 0 && value > 0){ //can kill opponent
                moves.addElement(new ChessMove(i,j,a,b));
                break;
                }
            else //friendly piece in way
                break;
        }

        for (int a = i-1,b = j+1; a > -1 && b < 8; a--,b++)  {	
            if(board[a][b] == 0)  //empty cells
                moves.addElement(new ChessMove(i,j,a,b));
                
            else if (board[a][b] > 0 && value < 0 || board[a][b] < 0 && value > 0){ //can kill opponent
                moves.addElement(new ChessMove(i,j,a,b));      
                break;
                }
            else //friendly piece in way
                break;
        }
        
        //Leftward Movements
        
        for (int a = i-1,b = j-1; a > -1 && b > -1; a--,b--){
            if(board[a][b] == 0) //empty cells
                moves.addElement(new ChessMove(i,j,a,b));
            else if (board[a][b] > 0 && value < 0 || board[a][b] < 0 && value > 0){ //can kill opponent
                moves.addElement(new ChessMove(i,j,a,b));       
                break;
                }
            else //friendly piece in way
                break;
        }

                    
        for (int a=i+1,b=j-1 ; a < 8 && b > -1; a++,b--)  {  
            if(board[a][b] == 0) //empty cells
                moves.addElement(new ChessMove(i,j,a,b));
            else if (board[a][b] > 0 && value < 0 || board[a][b] < 0 && value > 0){ //can kill opponent
                moves.addElement(new ChessMove(i,j,a,b));       
                break;
                }
            else //friendly piece in way
                break;
        }
    }
}
