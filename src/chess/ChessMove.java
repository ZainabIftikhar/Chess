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
public class ChessMove {
    public ChessMove(){
        From = new int[2];
        To = new int[2];
        From[0] = From[1] = 0;
        To[0]   = To[1]   = 0;
    }
    
    public ChessMove(int fromRow, int fromColumn, int toRow, int toColumn){
        From = new int[2];
        To = new int[2];
        From[0] = fromRow;
        From[1] = fromColumn;
        To[0]   = toRow;
        To[1]   = toColumn;
    }
    
    int evaluate(int playerToMove,ChessBoard board){
        int Value = 0;
	//if player to move is 1; subtract white pieces from black
        //else subtract black pieces from white
        Value=(100*(board.No_of_chessPiece(1*playerToMove)-board.No_of_chessPiece(-1*playerToMove)))+ //Pawns
                        (320*(board.No_of_chessPiece(2*playerToMove)-board.No_of_chessPiece(-2*playerToMove)))+ //Knights
                        (330*(board.No_of_chessPiece(3*playerToMove)-board.No_of_chessPiece(-3*playerToMove)))+ //Bishops
                        (500*(board.No_of_chessPiece(4*playerToMove)-board.No_of_chessPiece(-4*playerToMove)))+ //Rooks
                        (900*(board.No_of_chessPiece(5*playerToMove)-board.No_of_chessPiece(-5*playerToMove)))+ //Queens
                        (20000*(board.No_of_chessPiece(6*playerToMove)-board.No_of_chessPiece(-6*playerToMove))); //Kings
	
	return Value;
    }
 
    int From[];
    int To[];
}
