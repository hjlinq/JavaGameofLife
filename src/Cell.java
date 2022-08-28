import java.awt.*;
import java.util.ArrayList;

public class Cell extends GameObject {

    protected State state = State.Dead;
    
    private boolean isEdge = false;

    public void setIndex(int xIndex, int yIndex)
    {
        this.xIndex = xIndex;
        this.yIndex = yIndex;
    }

    public int xIndex()
    {
        return this.xIndex;
    }

    public int yIndex()
    {
        return this.yIndex;
    }


    public void setState(State state)
    {
        this.state = state;
    }

    public State getState()
    {
        return this.state;
    }

    public int NumberOfNeighbors(ArrayList<ArrayList<GameObject>> board)
    {
        int numNeighbors = 0;

        
        /*
        //The below if statements handle edge cases to simulate a toroidal board
        
        //If we're on the left edge of the board
        if(xIndex == 0){
        	
        	//If we're in the top left cell
        	if(yIndex == 0){
        		
        		//NW = the bottom right cell
        		State NW = board.get(board.size()).get(board.size()).getState();
        		//N = the bottom left cell
            	State N = board.get(0).get(board.size()).getState();
            	//NE = the cell to the right of the bottom left cell
            	State NE = board.get(1).get(board.size()).getState();
            	
            	//W = the top right cell
            	State W = board.get(board.size()).get(0).getState();
            	//E = the cell to the right of the top left cell
            	State E = board.get(1).get(0).getState();
            	
            	//SW = the cell below the top right cell
            	State SW = board.get(board.size()).get(1).getState();
            	//S = the cell below the top left cell
            	State S = board.get(0).get(1).getState();
            	//SE = the cell SE of the top left cell
            	State SE = board.get(1).get(1).getState();
        	}
        	
        	//else if we're on the bottom left square
        	else if(yIndex == board.size()) {
        		
        		//NW = the cell above the bottom right square
        		State NW = board.get(board.size()).get(board.size() -1).getState();
        		//N = the cell above the bottom left square
            	State N = board.get(0).get(board.size() -1).getState();
            	//NE = the cell NE of the bottom left square
            	State NE = board.get(1).get(board.size() -1).getState();
            	
            	//W = the bottom right square
            	State W = board.get(board.size()).get(board.size()).getState();
            	//E = the cell to the right of the bottom left square
            	State E = board.get(1).get(board.size()).getState();
            	
            	//SW = the cell below the top right square
            	State SW = board.get(board.size()).get(0).getState();
            	//S = the top left square
            	State S = board.get(0).get(0).getState();
            	//SE = the cell to the right of the top left square
            	State SE = board.get(xIndex+1).get(0).getState();
        	}
        	else {  //If we're anywhere else on the left edge
        		
        		//NW = the cell on the right edge above the current cell
        		State NW = board.get(board.size()).get(yIndex-1).getState();
        		//N = the cell above the current cell
            	State N = board.get(0).get(yIndex-1).getState();
            	//NE = the cell NE of the current cell
            	State NE = board.get(1).get(yIndex - 1).getState();
            	
            	//W = the cell on the right edge on the same row
            	State W = board.get(board.size()).get(yIndex).getState();
            	//E = the cell E of the current cell
            	State E = board.get(xIndex+1).get(yIndex).getState();
            	
            	//SW = the cell on the right edge below the current cell
            	State SW = board.get(board.size()).get(yIndex+1).getState();
            	//S = the cell below the current cell
            	State S = board.get(0).get(yIndex+1).getState();
            	//SE = the cell SE of the current cell
            	State SE = board.get(1).get(yIndex+1).getState();
        	}
        }
        else if(xIndex == board.size()) {
        	if(yIndex == 0) {

            	State NW = board.get(xIndex-1).get(board.size()).getState();
            	State N = board.get(xIndex).get(board.size()).getState();
            	State NE = board.get(0).get(board.size()).getState();
            	
            	State W = board.get(xIndex-1).get(yIndex).getState();
            	State E = board.get(0).get(yIndex).getState();
            	
            	State SW = board.get(xIndex-1).get(yIndex+1).getState();
            	State S = board.get(xIndex).get(yIndex+1).getState();
            	State SE = board.get(0).get(yIndex+1).getState();
        	}
        	else if(yIndex == board.size()) {

            	State NW = board.get(xIndex-1).get(yIndex-1).getState();
            	State N = board.get(xIndex).get(yIndex-1).getState();
            	State NE = board.get(0).get(yIndex - 1).getState();
            	
            	State W = board.get(xIndex-1).get(yIndex).getState();
            	State E = board.get(0).get(yIndex).getState();
            	
            	State SW = board.get(xIndex-1).get(0).getState();
            	State S = board.get(xIndex).get(0).getState();
            	State SE = board.get(0).get(0).getState();
        	}
        	else {

            	State NW = board.get(xIndex-1).get(yIndex-1).getState();
            	State N = board.get(xIndex).get(yIndex-1).getState();
            	State NE = board.get(0).get(yIndex - 1).getState();
            	
            	State W = board.get(xIndex-1).get(yIndex).getState();
            	State E = board.get(0).get(yIndex).getState();
            	
            	State SW = board.get(xIndex-1).get(yIndex+1).getState();
            	State S = board.get(xIndex).get(yIndex+1).getState();
            	State SE = board.get(0).get(yIndex+1).getState();
        	}
        }
        else {
        	State NW = board.get(xIndex-1).get(yIndex-1).getState();
        	State N = board.get(xIndex).get(yIndex-1).getState();
        	State NE = board.get(xIndex+1).get(yIndex - 1).getState();
        	
        	State W = board.get(xIndex-1).get(yIndex).getState();
        	State E = board.get(xIndex+1).get(yIndex).getState();
        	
        	State SW = board.get(xIndex-1).get(yIndex+1).getState();
        	State S = board.get(xIndex).get(yIndex+1).getState();
        	State SE = board.get(xIndex+1).get(yIndex+1).getState();
        }
        
        */
        
        State NW = State.Dead;
        State N = State.Dead;
        State NE = State.Dead;
        
        State W = State.Dead;
        State E = State.Dead;
        
        State SW = State.Dead;
        State S = State.Dead;
        State SE = State.Dead;
        
        try {NW = board.get(xIndex-1).get(yIndex-1).getState();} catch (Exception e){};
        try {N = board.get(xIndex).get(yIndex-1).getState();} catch (Exception e){};
        try {NE = board.get(xIndex+1).get(yIndex - 1).getState();} catch (Exception e){};
        
        try {W = board.get(xIndex-1).get(yIndex).getState();}catch (Exception e){};
        try {E = board.get(xIndex+1).get(yIndex).getState();}catch (Exception e){};
        
        try {SW = board.get(xIndex-1).get(yIndex+1).getState();}catch (Exception e){};
        try {S = board.get(xIndex).get(yIndex+1).getState();}catch (Exception e){};
        try {SE = board.get(xIndex+1).get(yIndex+1).getState();}catch (Exception e){};
        
        if(NW == State.Alive){ numNeighbors++;}
        if(N == State.Alive){ numNeighbors++;}
        if(NE == State.Alive){ numNeighbors++;}
        
        if(W == State.Alive){ numNeighbors++;}
        if(E == State.Alive){ numNeighbors++;}
        
        if(SW == State.Alive){ numNeighbors++;}
        if(S == State.Alive){ numNeighbors++;}
        if(SE == State.Alive){ numNeighbors++;}
        
        return numNeighbors;

    }

    @Override
    public State tick(ArrayList<ArrayList<GameObject>> board)
    {
        
	        if(NumberOfNeighbors(board) < 2 || NumberOfNeighbors(board) > 3) {
	        	/*if(this.state == State.Alive) {
	        		System.out.println("Cell " + xIndex + ", " + yIndex + " has died");
	        	}*/
	        	setState(State.Dead);
	        }
	
	        if(NumberOfNeighbors(board) == 3){
	        	/*if(this.state == State.Dead) {
	        		System.out.println("Cell " + xIndex + ", " + yIndex + " was born");
	        	}*/
	        	setState(State.Alive); 
	        }
        
	        
	    return this.state;
    }

    @Override
    public void render(Graphics g)
    {
        if(state == State.Alive)
        {
            g.setColor(Color.green);
            g.fillRect(x, y, Game.CELLSIZE, Game.CELLSIZE);
        }
        else if(state == State.Dead)
        {
            g.setColor(Color.gray);
            g.drawRect(x, y, Game.CELLSIZE, Game.CELLSIZE);
        }

        g.setColor(Color.red);
        //g.drawString(String.valueOf(NumberOfNeighbors()), x+10, y+10);
        g.drawString(xIndex + ", " + yIndex, x+20, y+20);

    }

    public Cell(int x, int y)
    {
        super(x, y, ID.Cell);
    }

}
