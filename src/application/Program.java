package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.BoardException;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
			
			try {
			
			UI.clearScreen();
			
			UI.printBoard(chessMatch.getPieces());
			System.out.println();
			System.out.println();
			System.out.print("Souce: ");
			ChessPosition source = UI.readChessPositon(sc);
			
			boolean[][] possibleMoves = chessMatch.possibleMoves(source);
			UI.clearScreen();
			UI.printBoard(chessMatch.getPieces(), possibleMoves);
			
			System.out.println();
			System.out.println();
			System.out.print("Targe: ");
			ChessPosition target = UI.readChessPositon(sc);
			
			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			System.out.println();
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
						
		}
		
	}

}
