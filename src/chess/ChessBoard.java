/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author Acer
 */
public class ChessBoard {
    public ChessBoard(int[][]temp){
        board = new int[8][8];
        for (int i = 0; i < 8 ;i++){
            System.arraycopy(temp[i], 0, board[i], 0, 8);
        }
    }
    
    public int[][]board;
    
    public int No_of_chessPiece(int pieceValue){
        int count = 0;
	for(int i = 0;i < 8;i++){
            for(int j = 0;j < 8;j++){
                if(board[i][j]==pieceValue)
                    count++;
		}
	}
	return count;
    }
}
