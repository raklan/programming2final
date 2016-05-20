
/**
 * Write a description of class Map here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map
{
    private boolean[][] map = new boolean[5][5];

    public Map()
    {
        for(int row = 0;row<map.length;row++)
        {
            for(int col = 0;col<map[row].length;col++)
            {
                map[row][col] = false;
            }
        }
    }

    public boolean isHere(int row, int col)
    {
        return map[row][col];
    }

    public int getRow()
    {
        int r=0;
        for(int row = 0;row<map.length;row++)
        {
            for(int col = 0;col<map[row].length;col++)
            {
                if(map[row][col]==true)
                    r = row;
            }
        }
        return r;
    }

    public int getCol()
    {
        int c = 0;
        for(int row = 0;row<map.length;row++)
        {
            for(int col = 0;col<map[row].length;col++)
            {
                if(map[row][col]==true)
                    c = col;
            }
        }
        return c;
    }

    public void enterRoom(int row, int col)
    {
        map[row][col] = true;
    }

    public void leaveRoom(int row, int col)
    {
        map[row][col] = false;
    }
    public void printMap()
    {
        for(int row = 0;row<map.length;row++)
        {
            for(int col = 0;col<map[row].length;col++)
            {
                if(row==4&&col==4)
                    System.out.println("_X_" + "   ");
                else if(map[row][col]==false)
                    System.out.print("___" + "   ");
                else if(map[row][col]==true)
                    System.out.print("_O_" + "   ");
            }
            System.out.println();
        }
    }
}
