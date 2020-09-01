/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessPiece;
import java.util.Vector;
/**
 *
 * @author Acer
 */
public class Queen {
     public static void calculatePossibleMoves(int[][] board, int i, int j, Vector moves){
         Rook.calculatePossibleMoves(board, i, j, moves);
         Bishop.calculatePossibleMoves(board, i, j, moves);
     }
}
