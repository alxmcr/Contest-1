import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class MainTicTacToe {
	private static final String ILLEGAL = "illegal";
    private static final String FIRST_PLAYER_WON = "the first player won";
    private static final String SECOND_PLAYER_WON = "the second player won";
    private static final String FIRST_PLAYER_TURN = "first";
    private static final String SECOND_PLAYER_TURN = "second";
    private static final String DRAW = "draw";
    private static final String POINT = ".";
    private static final String X = "X";
    private static final String ZERO = "0";

    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);

        String line1 = scn.nextLine();
        String line2 = scn.nextLine();
        String line3 = scn.nextLine();

        MainTicTacToe.processRows(line1, line2, line3);

        scn.close();
    }

    private static void processRows(String line1, String line2, String line3) {
        if (line1 == null || line1 == "") {
            System.out.println(ILLEGAL);
        } else if (line2 == null || line2 == "") {
            System.out.println(ILLEGAL);
        } else if (line3 == null || line3 == "") {
            System.out.println(ILLEGAL);
        }

        // Remove whitespaces
        line1 = line1.trim();
        line2 = line2.trim();
        line3 = line3.trim();

        String[] row1 = line1.split("");
        String[] row2 = line2.split("");
        String[] row3 = line3.split("");

        if (row1 == null || row1.length < 3) {
            System.out.println(ILLEGAL);
        } else if (row2 == null || row2.length < 3) {
            System.out.println(ILLEGAL);
        } else if (row3 == null || row3.length < 3) {
            System.out.println(ILLEGAL);
        } else {

            String[][] board = new String[][] {
                {
                    row1[0], row1[1], row1[2]
                }, {
                    row2[0],
                    row2[1],
                    row2[2]
                }, {
                    row3[0],
                    row3[1],
                    row3[2]
                }
            };

            MainTicTacToe.algorithm(board);
        }

    }

    public static void algorithm(String [][] board) {

    }

    private static int countRepetionByRowAndCharacter(String elementToFind, String[] row) {

        if (elementToFind == null) {
            return 0;
        }

        if (row == null) {
            return 0;
        }

        if (row.length == 0) {
            return 0;
        }

        int count = 0;

        for (String item: row) {
            if (Objects.equals(item, elementToFind)) {
                count++;
            }
        }

        return count;
    }

    private static boolean hasEmptySpaces(String[] row) {
        if (row == null) {
            return true;
		}

        for (String element: row) {
            if (Objects.equals(element, POINT)) {
                return true;
            }
        }

        return false;

    }
}
