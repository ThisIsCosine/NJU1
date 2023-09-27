package cn.edu.nju.TicTacToe;
public class Board {
	/**
	 * 成员变量的初始化代码请修改，请灵活选择初始化方式
	 * 必要时可添加成员变量
	 */
	protected char[][] cells;
	protected GameChessStrategy chessStrategy;
	protected FiveGameChessStratrgy fiveGameChessStratrgy;
	protected GameWinStrategy_HVD winStrategy;
	protected GameWinStrategy_HV winStrategyHv;
	protected Player player = Player.X;



	/**
	 * 请修改构造方法，并添加合适的构造方法
	 */


	public Board(int boardSize, String gamemode){
		cells = new char[boardSize][boardSize];
		for(int i=0; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				cells[i][j] = '_';
			}
		}
		if (gamemode.charAt(0) == '0')
			chessStrategy = new GameChessStrategy();
		else
			fiveGameChessStratrgy = new FiveGameChessStratrgy();
		if (gamemode.charAt(1) == '0')
			winStrategy = new GameWinStrategy_HVD();
		else
			winStrategyHv = new GameWinStrategy_HV();
	}


	/**
	 * @param move 下棋的位置
	 * @return 落棋之后的结果
	 */
	public Result nextMove(String move, String gamemode, int size, int index) {
		boolean[] error = new boolean[1];
		switch (gamemode) {
			case "00": {
				chessStrategy.putChess(cells, nextPlay(), move, error);
				if (error[0])
					return Result.ERROR;
				return winStrategy.check(cells, size);
			}
			case "01": {
				chessStrategy.putChess(cells, nextPlay(), move, error);
				if (error[0])
					return Result.ERROR;
				return winStrategyHv.check(cells,size);
			}
			case "10":{
				fiveGameChessStratrgy.putChessFive(cells, nextPlay(), move, index, error);
				if (error[0])
					return Result.ERROR;
				return winStrategy.check(cells, size);
			}
			case "11":{
				fiveGameChessStratrgy.putChessFive(cells, nextPlay(), move, index, error);
				if (error[0])
					return Result.ERROR;
				return winStrategyHv.check(cells,size);
			}
		}
		return null;
	}

	/**
	 * @return 下一个落棋的玩家
	 */
	protected Player nextPlay(){
		Player res = player;
		player = player == Player.X ? Player.O : Player.X;
		return res;
	}

	/**
	 * 棋盘的输出方法，根据需要进行修改
	 */
	public void print(int size){
		System.out.print(" ");
		for (int i = 0; i < size; i++) {
			char c = 'A';
			System.out.printf(" %c", c + i);
		}
		System.out.println();
		for(int i = 0 ;i < size; i++){
			System.out.print(i+1);
			for(int j = 0; j < size; j++){
				System.out.print(" "+cells[i][j]);
			}
			System.out.println();
		}
	}
}
