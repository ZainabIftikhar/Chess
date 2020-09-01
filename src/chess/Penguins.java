/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author Acer
 */
public class Penguins extends ChessPlayer{
    public Penguins(int playerColor){
        super(playerColor);
    }
    
    @Override
    public int decideMoveUsingMINIMAX(ChessState gameState, ChessMove returnMove, int depth){
        
        int totalMoves = gameState.makeValidMovesList();
        Vector evaluations = new Vector(totalMoves);
        
        returnMove.From[0] = returnMove.From[1] = 0;
        returnMove.To[0] = returnMove.To[0] = 0;
        
        if(totalMoves <= 0 ){
            return -1;
        }
        
        int selectedMove = 0;

        for (int i = 0; i < totalMoves; i++){
            ChessMove tempMove = (ChessMove) gameState.moves.elementAt(i);
            
            ChessBoard b = new ChessBoard(gameState.board);
            
            b.board[tempMove.To[0]][tempMove.To[1]] = b.board[tempMove.From[0]][tempMove.From[1]];
            b.board[tempMove.From[0]][tempMove.From[1]] = 0;
            
            evaluations.addElement(tempMove.evaluate(playerColor,b));
        }

        int max = (int) Collections.max(evaluations);
        selectedMove = evaluations.indexOf(max);
        
        ChessMove tempMove = (ChessMove) gameState.moves.elementAt(selectedMove);
        
        returnMove.From[0] = tempMove.From[0];
        returnMove.From[1] = tempMove.From[1];
        returnMove.To[0] =  tempMove.To[0];
        returnMove.To[1] = tempMove.To[1];

        return selectedMove;
    }
}
