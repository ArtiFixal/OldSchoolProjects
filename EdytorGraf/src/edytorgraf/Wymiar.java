package edytorgraf;

import java.io.Serializable;

/**
 * Stores X and Y coordinates.
 * 
 * @author ArtiFixal
 */
public class Wymiar implements WymiarInt,Serializable {
    // UID of drawer serialized objects
    private static final long serialVersionUID=123L;
    
    /**
     * Mouse press X position.
     */
    public int x1;
    
    /**
     * Mouse press Y position.
     */
    public int y1;
    
    /**
     * Stores int position of shape.
     * 
     * @param x1 Mouse press X position.
     * @param y1 Mouse press Y position.
     */
    public Wymiar(int x1,int y1)
    {
        this.x1=x1;
        this.y1=y1;
    }
    
    @Override
    public final int getX1()
    {
        return x1;
    }
    
    @Override
    public int getX2()
    {
        return getX1();
    }
    
    @Override
    public final int getY1()
    {
        return y1;
    }
    
    @Override
    public int getY2()
    {
        return getY1();
    }
    
    @Override
    public int getX()
    {
        return getX1();
    }
    
    @Override
    public int getY()
    {
        return getY1();
    }
    
    /**
     * Unused in this class.
     * @return 0 - Because it's unnecessary to store proper brush width.
     */
    @Override
    @Deprecated
    public int getSzer()
    {
        return 0;
    }
    
    /**
     * Unused in this class.
     * @return 0 - Because it's unnecessary to store proper brush height.
     */
    @Override
    @Deprecated
    public int getWys()
    {
        return 0;
    }
    
    /**
     * Unused in this class.
     * @return 0 - Because it's unnecessary to fill this shape.
     */
    @Override
    @Deprecated
    public int getInnerX(int liczba)
    {
        return 0;
    }
    
    /**
     * Unused in this class.
     * @return 0 - Because it's unnecessary to fill this shape.
     */
    @Override
    @Deprecated
    public int getInnerY(int liczba)
    {
        return 0;
    }
    
    /**
     * Unused in this class.
     * @return 0 - Because it's unnecessary to fill this shape and store proper brush width.
     */
    @Override
    @Deprecated
    public int getInnerSzer(int liczba)
    {
        return 0;
    }
    
    /**
     * Unused in this class.
     * @return 0 - Because it's unnecessary to fill this shape and store proper brush height.
     */
    @Override
    @Deprecated
    public int getInnerWys(int liczba)
    {
        return 0;
    }
}
