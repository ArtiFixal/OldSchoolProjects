package edytorgraf;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Container for drawn shapes.
 * 
 * @author ArtiFixal
 */
public class Figura implements Serializable {
    // UID of drawer serialized objects
    private static final long serialVersionUID=213L;
    
    /**
     * Describes type of figure or shape as below: <br>
     * 0 - Pencil <br>
     * 1 - Straight line <br>
     * 2 - Rectangle <br>
     * 3 - Oval <br>
     * 4 - Polygon <br>
     * 5 - Rubber coordinates
     */
    public int rodzaj;
    
    /**
     * Stores info about brush width, which also affects on shape border width.
     */
    public int gruboscPedzla;
    
    /** 
     * Describes transparency of drawn shape.
     */
    private final float przezr;
    
    /**
     * Stores info abour brush or border color.
     */
    private final Color ramka;
    
    /**
     * Stores info abour fill color.
     */
    private final Color wypelnienie;
    
    /**
     * Stores coordinates of similiar shapes with similiar info, which saves some memory.
     * @see WymiarInt
     */
    private ArrayList<WymiarInt> poz=new ArrayList<WymiarInt>(0);
    
    /**
     * 
     * @param rodzajFigury Type of shape.
     * @param gruboscPedzla Brush or border width.
     * @param przezroczystoscFigury Transparency of shape.
     * @param kolorRamki Border or 1st colour.
     * @param kolorWypelnienia Shape fill colour.
     * @param rozmiar Coordinates of shape
     */
    public Figura(int rodzajFigury,int gruboscPedzla,float przezroczystoscFigury,Color kolorRamki,Color kolorWypelnienia,WymiarInt rozmiar)
    {
        rodzaj=rodzajFigury;
        this.gruboscPedzla=gruboscPedzla;
        przezr=przezroczystoscFigury;
        ramka=kolorRamki;
        wypelnienie=kolorWypelnienia;
        poz.add(rozmiar);
    }
    
    /**
     * @return Border color
     */
    public Color getKolorRamki()
    {
        return ramka;
    }
    
    /**
     * @return Returns fill color
     */
    public Color getKolorWypelnienia()
    {
        return wypelnienie;
    }
    
    /**
     * @return Returns type of figure
     */
    public int getRodzajFigury()
    {
        return rodzaj;
    }
    
    /**
     * @return Returns width of figure
     */
    public int getGruboscPedzlaFigury()
    {
        return gruboscPedzla;
    }
    
    /**
     * @return Returns trasparency
     */
    public float getPrzezroczystoc()
    {
        return przezr;
    }
    
    /**
     * Add new similiar shape to the array.
     * 
     * @param pozycja New shape coordinates
     */
    public void dodajPunkty(Wymiar pozycja)
    {
        poz.add(pozycja);
    }
    
    /**
     * @param i index
     * @return Returns shape coordinates object from i-th index.
     */
    public WymiarInt getNpozycja(int i)
    {
        return poz.get(i);
    }
    
    /**
     * @return Array length of similiar shapes.
     */
    public int ilePozycji()
    {
        return poz.size();
    }
    
    @Override
    public String toString()
    {
        return rodzaj+" "+gruboscPedzla+" "+przezr+" "+ramka+" "+wypelnienie;
    }
}
