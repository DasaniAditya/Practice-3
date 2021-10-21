class Solution {
    int[][] dirs;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        dirs = new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        int[][] nextState = new int[board.length][board[0].length];
        
        for(int i = 0 ; i < board.length; i++) {
            for(int j = 0 ;j < board[0].length; j++) {
                int currentNeighbours = countNeighbours(board, i, j);
                if(board[i][j] == 0) {
                    if(currentNeighbours == 3) {
                        nextState[i][j] = 1;
                    }
                } else {
                    if(currentNeighbours < 2) {
                        nextState[i][j] = 0;
                    } else if(currentNeighbours == 3 || currentNeighbours == 2) {
                        nextState[i][j] = 1;
                    } else if(currentNeighbours > 3) {
                        nextState[i][j] = 0;
                    }
                }
            }
        }
        for(int i = 0 ; i < board.length; i++) {
            for(int j = 0 ;j < board[0].length; j++) {
                board[i][j] = nextState[i][j];
            }
        }
    }
    private int countNeighbours(int[][] board, int row, int column) {
        int count = 0;
        for(int[] dir : dirs) {
            int nr = dir[0] + row;
            int nc = dir[1] + column;
            if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 1) {
                count++;
            }
        }
        return count;
    }
}

class Solution {
    public int distributeCandies(int[] candyType) {
        if(candyType == null || candyType.length == 0) {
            return 0;
        }
        int prev = -1;
        int result = 0;
        Arrays.sort(candyType);
        for(int i = 0 ; i < candyType.length; i++) {
            if(candyType[i] != prev) {
                result++;
                prev = candyType[i];
                if(result == candyType.length / 2) {
                    return result;
                }
            }
        }
        return result;
    }
}