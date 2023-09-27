import org.w3c.dom.ranges.Range;

import java.util.List;

public class Game {
    
    //游戏主方法playGame
    //输入为对弈双方轮番落子的位置，以英文逗号为间隔，X先走
    char[][] board = {{'_', '_', '_'},{'_', '_', '_'},{'_', '_', '_'}};
    Result result = Result.GAMING;
    public Result playGame(String s){
        String[] compete = s.split(",");
        for (int i = 0; i < compete.length; i++) {
            fillBoard(compete[i], i);
            if (result != Result.GAMING){
                return result;
            }
        }
        return null;
    }

    Result isOver(){
        if (board[0][0] != '_' && board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            if (board[0][0] == 'X')
                return Result.X_WIN;
            else
                return Result.O_WIN;
        }
        if (board[2][0] != '_' && board[2][0] == board[1][1] && board[1][1] == board[0][2]){
            if (board[2][0] == 'X')
                return Result.X_WIN;
            else
                return Result.O_WIN;
        }
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '_' && board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                if (board[i][0] == 'X')
                    return Result.X_WIN;
                else
                    return Result.O_WIN;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != '_' && board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                if (board[0][i] == 'X')
                    return Result.X_WIN;
                else
                    return Result.O_WIN;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                if (board[i][i1] == '_')
                    return Result.GAMING;
            }
        }
        return Result.DRAW;
    }

    void fillBoard(String s, int i){

        if (i % 2 == 0)
            board[s.charAt(1) - (int)'1'][s.charAt(0) - (int) 'A'] = 'X';
        else
            board[s.charAt(1) - (int)'1'][s.charAt(0) - (int) 'A'] = 'O';
        System.out.println("  A B C");
        System.out.println("1 " + board[0][0] + ' ' + board[0][1] + ' ' + board[0][2]);
        System.out.println("2 " + board[1][0] + ' ' + board[1][1] + ' ' + board[1][2]);
        System.out.println("3 " + board[2][0] + ' ' + board[2][1] + ' ' + board[2][2]);
        result = isOver();
    }

    
    public static void main(String[] args){
        Game game = new Game();
        Result result = game.playGame("B2,C2,C1,A3,B3,B1,A2,B2,C3,A1,A3,B3,C2,B1,B2,A2,A1,C1,C3");
        System.out.println(result);
    }
}
