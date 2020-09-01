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
public abstract class ChessPlayer {
    
    public int playerColor;
    
    private double evaluateState() { 
        return 1;
    }
    
    public ChessPlayer(int playerColor){
        this.playerColor = playerColor;
    }
    
    public ChessPlayer(){
        
    }
    public  abstract int decideMoveUsingMINIMAX(ChessState gameState, ChessMove returnMove, int depth);
}
