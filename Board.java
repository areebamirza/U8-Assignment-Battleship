public class Board{

  private String[][] squares;

  public Board(){
    squares = new String[10][10];
    
    for(int r = 0; r < squares.length; r++)
    {
      for(int c = 0; c < squares[r].length; c++)
      {
        squares[r][c] = "-";
      }
    }
  }

  public String toString(){
    String board = "";
    
    for(int r = 0; r < squares.length; r++)
    {
      for(int c = 0; c < squares[r].length; c++)
      {
        board += squares[r][c] + " ";
      }
      board = board.substring(0, board.length() - 1);
      board += "\n";
    }
    
    return board;
  }

  public boolean addShip(int row, int col, int len, boolean horizontal){
    if((row < squares.length && row >= 0) && (col < squares[row].length && col >= 0))
    {
      if(horizontal && ((col + len - 1) < squares[row].length))
      {
        for(int c = col; c < col + len; c++)
        {
          if(squares[row][c].equals("b"))
          {
            return false;
          }
        }
        for(int c = col; c < col + len; c++)
        {
          squares[row][c] = "b";
        }
        return true;
      }
      if(!horizontal && ((row + len - 1) < squares.length))
      {
        for(int r = row; r < row + len; r++)
        {
          if(squares[r][col].equals("b"))
          {
            return false;
          }
        }
        for(int r = row; r < row + len; r++)
        {
          squares[r][col] = "b";
        }
        return true;
      }
    }
    
    return false;
  }

  public boolean foundShip(int len){
    for(int r = 0; r < squares.length; r++)
    {
      int found = 0;
      for(int c = 0; c < squares[r].length; c++)
      {
        if(squares[r][c].equals("b"))
        {
          found++;
        }
        if(!squares[r][c].equals("b") || c == squares[r].length - 1)
        {
          if(found == len)
          {
            return true;
          }
          found = 0;
        }
      }
    }
    
    for(int c = 0; c < squares[0].length; c++)
    {
      int found = 0;
      for(int r = 0; r < squares.length; r++)
      {
        if(squares[r][c].equals("b"))
        {
          found++;
        }
        if(!squares[r][c].equals("b") || r == squares.length - 1)
        {
          if(found == len)
          {
            return true;
          }
          found = 0;
        }
      }
    }
    
    return false;
  }

  public int shoot(int row, int col){
    if(row >= squares.length || row < 0 || col >= squares[0].length || col < 0)
    {
      return -1;
    }
    
    if(squares[row][col].equals("-"))
    {
      squares[row][col] = "m";
      return 0;
    }
    
    if(squares[row][col].equals("b"))
    {
      squares[row][col] = "x";
      return 1;
    }
    
    if(squares[row][col].equals("x") || squares[row][col].equals("m"))
    {
      return 2;
    }
    
    return 0;
  }

  public boolean gameOver(){
    for(int r = 0; r < squares.length; r++)
    {
      for(int c = 0; c < squares[r].length; c++)
      {
        if(squares[r][c].equals("b"))
        {
          return false;
        }
      }
    }
    
    return true;
  }

}