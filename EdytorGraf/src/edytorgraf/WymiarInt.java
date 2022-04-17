package edytorgraf;

/**
 * Basic functions used in <code>Wymiar</code> classes.
 * <p>
 * Allows to save some memory since <code>Wymiar2D</code> stores 2 ints more.
 * 
 * @author ArtiFixal
 */
public interface WymiarInt{
    /**
     * @return First click or mouse press X position.
     */
    public int getX1();
    
    /**
     * @return Second click or mouse press X position.
     */
    public int getX2();
    
    /**
     * @return First click or mouse press Y position.
     */
    public int getY1();
    
    /**
     * @return Second click or mouse press Y position.
     */
    public int getY2();
    
    /**
     * Allows drawing in all directions of a X graph axis.
     * 
     * @return Nearest X position to point (0,0).
     */
    public int getX();
    
    /**
     * Allows drawing in all directions of a Y graph axis.
     * 
     * @return Nearest Y position to point (0,0).
     */
    public int getY();
    
    /**
     * @return Width of a shape.
     */
    public int getSzer();
    
    /**
     * @return Height of a shape.
     */
    public int getWys();
    
    /**
     * Allows drawing shape fill in all directions of a graph quarters.
     * @param liczba Brush size.
     * @return Nearest X position of shape fill to point (0,0).
     */
    public int getInnerX(int liczba);
    
    /**
     * Allows drawing shape fill in all directions of a graph quarters.
     * @param liczba Brush size.
     * @return Nearest Y position of shape fill to point (0,0).
     */
    public int getInnerY(int liczba);
    
    /**
     * @param liczba Brush size.
     * @return Width of shape fill.
     */
    public int getInnerSzer(int liczba);
    
    /**
     * @param liczba Brush size.
     * @return Height of shape fill.
     */
    public int getInnerWys(int liczba);
    
}
