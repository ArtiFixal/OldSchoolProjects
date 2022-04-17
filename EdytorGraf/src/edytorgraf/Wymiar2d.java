package edytorgraf;

/**
 * Stores dual X and Y coordinates.
 * 
 * @author ArtiFixal
 */
public class Wymiar2d extends Wymiar{
    
    /**
     * Mouse release X position.
     */
    public int x2;
    
    /**
     * Mouse release Y position.
     */
    public int y2;
    
    /**
     * Stores int positions of shape.
     * 
     * @param x1 Mouse press X position.
     * @param y1 Mouse press Y position.
     * @param x2 Mouse release X position.
     * @param y2 Mouse release Y position.
     */
    public Wymiar2d(int x1,int y1,int x2,int y2)
    {
        super(x1,y1);
        this.x2=x2;
        this.y2=y2;
    }
    
    @Override
    public final int getX2()
    {
        return x2;
    }
    
    @Override
    public final int getY2()
    {
        return y2;
    }
    
    @Override
    public int getX()
    {
        return Math.min(x1,x2);
    }
    
    @Override
    public int getY()
    {
        return Math.min(y1,y2);
    }
    
    /**
     * &nbsp
     * @return Width of a shape.
     */
    @Override
    public int getSzer()
    {
        return Math.abs(x1-x2);
    }
    
    /**
     * &nbsp
     * @return Height of a shape.
     */
    @Override
    public int getWys()
    {
        return Math.abs(y1-y2);
    }
    
     /**
     * Allows drawing shape fill in all directions of a graph quarters.
     * @param liczba Brush size.
     * @return Nearest X position of shape fill to point (0,0).
     */
    @Override
    public int getInnerX(int liczba)
    {
        return Math.min(x1,x2)+(1+liczba)/2;
    }
    
    /**
     * Allows drawing shape fill in all directions of a graph quarters.
     * @param liczba Brush size.
     * @return Nearest Y position of shape fill to point (0,0).
     */
    @Override
    public int getInnerY(int liczba)
    {
        return Math.min(y1,y2)+(1+liczba)/2;
    }
    
    /**
     * &nbsp
     * @param liczba Brush size.
     * @return Width of shape fill.
     */
    @Override
    public int getInnerSzer(int liczba)
    {
        return Math.abs(x1-x2)-liczba+(1+liczba)/4;
    }
    
    /**
     * &nbsp
     * @param liczba Brush size.
     * @return Height of shape fill.
     */
    @Override
    public int getInnerWys(int liczba)
    {
        return Math.abs(y1-y2)-liczba+(1+liczba)/4;
    }
}
