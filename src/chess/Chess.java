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
public class Chess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");
        
        ChessState game = new ChessState();
        game.showState();
        
        ChessMove PlayerMove = new ChessMove();
        Penguins player1 = new Penguins(1);
        Penguins player2 = new Penguins(-1);
        
       while (!(game.seeGoal())){
            player1.decideMoveUsingMINIMAX(game, PlayerMove, 3);
            System.out.println("Move from [" + (PlayerMove.From[0]+1) + "][" + (PlayerMove.From[1]+1) + 
                        "] to [" + + (PlayerMove.To[0]+1) + "][" + (PlayerMove.To[1]+1) + "]");
            game.makeMove(PlayerMove);
            game.showState(); 

            player2.decideMoveUsingMINIMAX(game, PlayerMove, 3);
            System.out.println("Move from [" + (PlayerMove.From[0]+1) + "][" + (PlayerMove.From[1]+1) + 
                        "] to [" + + (PlayerMove.To[0]+1) + "][" + (PlayerMove.To[1]+1) + "]");
            game.makeMove(PlayerMove);
            game.showState(); 
       }
       game.gameResult(game.playerToMove*-1);
    }
}
