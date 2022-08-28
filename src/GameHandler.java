

//import java.lang.reflect.Array;
import java.util.ArrayList;
//import java.util.LinkedList;
import java.awt.Graphics;

public class GameHandler {

//    public static ArrayList<ArrayList<GameObject>> objectList = new ArrayList<ArrayList<GameObject>>();

//    public static ArrayList<ArrayList<GameObject>> prevList = new ArrayList<ArrayList<GameObject>>();

    public void tick(ArrayList<ArrayList<GameObject>> board) {
    	
    	ArrayList<ArrayList<GameObject>> newBoard = board;
    	
    	//System.out.println(board);
    	//System.out.println(newBoard);
    	
    	for(int x = 0; x < board.size(); x++)
        {
            for(int y = 0; y < board.get(x).size(); y++)
            {
            	newBoard.get(x).get(y).tick(board);
            }
        }
    }

    public void render(Graphics g, ArrayList<ArrayList<GameObject>> board) {

        for(int x = 0; x < board.size(); x++)
        {
            for(int y = 0; y < board.get(x).size(); y++)
            {
                board.get(x).get(y).render(g);
            }
        }
    }

    public ArrayList<ArrayList<GameObject>> initBoard(int CellNum, int CellSize)
    {
    	ArrayList<ArrayList<GameObject>> board = new ArrayList<ArrayList<GameObject>>();
    	
        for(int x = 0; x < CellNum; x++)
        {
            ArrayList<GameObject> column = new ArrayList<GameObject>();

            for(int y = 0; y < CellNum; y++)
            {
                Cell cell = new Cell(x*CellSize, y*CellSize);
                cell.setIndex(x,y);
                column.add(cell);
            }

            board.add(column);
        }
        board.get(4).get(3).setState(State.Alive);
        board.get(5).get(4).setState(State.Alive);
        board.get(5).get(5).setState(State.Alive);
        board.get(4).get(5).setState(State.Alive);
        board.get(3).get(5).setState(State.Alive);
        
        return board;
        
        
    }

    /*public void addObject(int x, int y, GameObject object)
    {
        ArrayList<GameObject> column = this.objectList.get(x);
        column.set(y, object); //Is this enough?


        //objectList.set(x, column);
    }

    public void removeObject(GameObject object)
    {
        this.objectList.remove(object);
    }

    public void setObjectState(int x, int y, State state)
    {
        this.objectList.get(x).get(y).setState(state);
    }*/
}
