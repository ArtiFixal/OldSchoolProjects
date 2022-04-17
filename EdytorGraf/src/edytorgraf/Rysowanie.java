package edytorgraf;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * It's responsible for drawing and render actions.
 * 
 * @author ArtiFixal
 */
public class Rysowanie extends JComponent implements MouseListener,MouseMotionListener{
    /**
     * Default background color.
     */
    private final static Color KOLOR_TLA=new Color(238,238,238);
    
    /**
     * Stores shapes which will be rendered.
     */
    private ArrayList<Figura> fig=new ArrayList<Figura>(0);
    
    /**
     * To draw and render shapes.
     */
    private Graphics2D g2;
    
    /**
     * Primary color.
     */
    private Color kolor1;
    
    /**
     * Secondary color.
     */
    private Color kolor2;
    
    /**
     * Mouse press position.
     */
    private Point pocz;
    
    /**
     * Mouse release position.
     */
    private Point kon;
    
    /**
     * Transparency of drawn shape.
     * <p>
     * Within range of 0-1 where:<br>
     * 1 - Means that shape is opaque<br>
     * 0 - Means that shape is transparent
     */
    private float przezr;
    
    /**
     * Id of chosen tool, from tool list.
     * @see GUI#narzedzia
     */
    public int nrNarzedzia;
    
    /**
     * Id of chosen brush/border width, from brush width list.
     * @see GUI#szerokosc
     */
    public int nrGrubosciPedzla;
    
    /**
     * Id of chosen of shape fill style from it's list.
     * @see GUI#wypelnienie
     */
    public int wypelnienie;
    
    /**
     * Last drawn shape to check if new shape have exactly the same info.<br>
     * It helps to stack up similiar shapes to save memory.
     * @see Figura#poz
     */
    private Figura ostFi;
    
    /**
     * Info about last pressed mouse button.
     */
    private int ostPrzy;
    
    /**
     * Info about pressed mouse button.
     */
    private int nacisnieto;
    
    /**
     * Flag which specifies if polygons are being drawn.
     */
    private boolean wielok=false;
    
    /**
     * Flag which specifies if changes were made.
     */
    public boolean zmiany=false;
    
    public Rysowanie()
    {
        nrNarzedzia=0;
        nrGrubosciPedzla=1;
        przezr=1;
        wypelnienie=0;
        kolor1=new Color(0,0,0);
        kolor2=new Color(255,255,255);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
    /**
     * Clears screen and occupied memory.
     */
    public void wyczysc()
    {
        fig.clear();
        ostFi=null;
        wielok=false;
        setZmiany(false);
        repaint();
    }
    
    /**
     * Changes tool.
     * 
     * @param nrNarzedzia Selected tool
     */
    public void zmienNarzedzie(int nrNarzedzia)
    {
        this.nrNarzedzia=nrNarzedzia;
        pocz=null;
        kon=null;
        wielok=false;
    }
    
    /**
     * Sets brush width.
     * 
     * @param nrGrubosciPedzla Brush width
     */
    public void zmienGruboscPedzla(int nrGrubosciPedzla)
    {
        this.nrGrubosciPedzla=nrGrubosciPedzla;
    }
    
    /**
     * Sets shape fill style
     * 
     * @param nrWypelnienia Shape fill style
     */
    public void zmienWypelnienie(int nrWypelnienia)
    {
        wypelnienie=nrWypelnienia;
    }
    
    /**
     * Sets transparency.
     * 
     * @param przezroczystosc Opaque value
     * @see #przezr
     */
    public void zmienPrzezroczystosc(float przezroczystosc)
    {
        przezr=przezroczystosc;
    }
    
    /**
     * Sets primary color (brush or border).
     * 
     * @param kolor New color
     */
    public void zmienKolor1(Color kolor)
    {
        kolor1=kolor;
    }
    
    /**
     * @return Array of shapes to render.
     */
    public ArrayList<Figura> getFig()
    {
        return fig;
    }
    
    /**
     * Sets array of shapes to render.
     * @param o New array of shapes
     */
    public void setFig(ArrayList<Figura> o)
    {
        fig=o;
    }
    
    /**
     * @return Primary color (brush or border)
     */
    public Color getKolor1()
    {
        return kolor1;
    }
    
    /**
     * Sets secondary color (shape fill).
     * @param kolor New color
     */
    public void zmienKolor2(Color kolor)
    {
        kolor2=kolor;
    }
    
    /**
    * @return Secondary color (shape fill).
    */
    public Color getKolor2()
    {
        return kolor2;
    }
    
    
    /**
     * Set changes made flag.
     * @param zmiana Were changes made?
     */
    public void setZmiany(boolean zmiana)
    {
        zmiany=zmiana;
    }
    
    /**
     * @return If changes were made.
     */
    public boolean getZmiany()
    {
        return zmiany;
    }
    
    public boolean isEmpty()
    {
        return fig.isEmpty();
    }
    
    /**
     * Renders drawn shapes, and if needed preview of them.
     */
    @Override
    public void paint(Graphics g)
    {
        g2=(Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        for(int i=0;i<fig.size();i++)
        {
            Figura f=fig.get(i);
            WymiarInt w;
            g2.setPaint(f.getKolorRamki());
            g2.setStroke(new BasicStroke(f.getGruboscPedzlaFigury()));
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, f.getPrzezroczystoc()));
            switch(f.getRodzajFigury()) // Switch expressions -> JDK 14+
            {
                // Drawing pencil
                case 0 ->{
                    for(int j=0;j<f.ilePozycji();j++)
                    {
                        w=f.getNpozycja(j);
                        g2.fillOval(w.getX1(), w.getY1(), f.getGruboscPedzlaFigury(), f.getGruboscPedzlaFigury());
                    }
                }
                // Drawing straight line
                case 1 ->{
                    for(int j=0;j<f.ilePozycji();j++)
                    {
                        w=f.getNpozycja(j);
                        g2.drawLine(w.getX1(),w.getY1(),w.getX2(),w.getY2());
                    }
                }
                // Drawing rectangle
                case 2 ->{
                    for(int j=0;j<f.ilePozycji();j++)
                    {
                        w=f.getNpozycja(j);
                        g2.drawRect(w.getX(),w.getY(),w.getSzer(),w.getWys());
                        if(f.getKolorWypelnienia()!=null)
                        {
                            g2.setColor(f.getKolorWypelnienia());
                            g2.fillRect(w.getInnerX(f.getGruboscPedzlaFigury()),w.getInnerY(f.getGruboscPedzlaFigury()),w.getInnerSzer(f.getGruboscPedzlaFigury()),w.getInnerWys(f.getGruboscPedzlaFigury()));
                            g2.setPaint(f.getKolorRamki());
                        }
                    }
                }
                // Drawing oval
                case 3 -> {
                    for(int j=0;j<f.ilePozycji();j++)
                    {
                        w=f.getNpozycja(j);
                        g2.drawOval(w.getX(),w.getY(),w.getSzer(),w.getWys());
                        if(f.getKolorWypelnienia()!=null)
                        {
                            g2.setColor(f.getKolorWypelnienia());
                            g2.fillOval(w.getInnerX(f.getGruboscPedzlaFigury()),w.getInnerY(f.getGruboscPedzlaFigury()),w.getInnerSzer(f.getGruboscPedzlaFigury()),w.getInnerWys(f.getGruboscPedzlaFigury()));
                            g2.setPaint(f.getKolorRamki());
                        }
                    }
                }
                // Drawing polygon
                case 4 ->{
                    for(int j=0;j<f.ilePozycji();j++)
                    {
                        w=f.getNpozycja(j);
                        g2.drawLine(w.getX1(),w.getY1(),w.getX2(),w.getY2());
                    }
                }
                // "Rubber"
                case 5 ->{
                    for(int j=0;j<f.ilePozycji();j++)
                    {
                        w=f.getNpozycja(j);
                        g2.fillOval(w.getX()-5,w.getY()-5,f.getGruboscPedzlaFigury(),f.getGruboscPedzlaFigury());
                    }
                }
            }
        }
        // Whille mouse is pressed preview of shape are being drawn.
        if(pocz!=null&&kon!=null)
        {
            g2.setStroke(new BasicStroke(nrGrubosciPedzla));
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            g2.setColor(Color.GRAY);
            switch(nrNarzedzia)
            {
                case 1 ->{
                    g2.drawLine((int)pocz.getX(),(int)pocz.getY(),(int)kon.getX(),(int)kon.getY());
                }
                case 2 ->{
                    g2.drawRect(oblMinX(pocz,kon),oblMinY(pocz,kon),oblSzer(pocz,kon),oblWys(pocz,kon));
                }
                case 3 ->{
                    g2.drawOval(oblMinX(pocz,kon),oblMinY(pocz,kon),oblSzer(pocz,kon),oblWys(pocz,kon));
                }
                case 4 ->{
                    g2.drawLine((int)pocz.getX(),(int)pocz.getY(),(int)kon.getX(),(int)kon.getY());
                    if(ostFi!=null&&ostFi.getRodzajFigury()==4)
                    {
                        WymiarInt w=ostFi.getNpozycja(0);
                        g2.fillOval(w.getX1()-10, w.getY1()-10, 20, 20);
                    }
                }
                case 5 ->{
                    g2.fillOval((int)kon.getX()-5,(int)kon.getY()-5,nrGrubosciPedzla,nrGrubosciPedzla);
                }
            }
        }
    }
    
    /**
     * Uses <code>Point</code> class.<p>
     * Allows drawing in all X directions of graph axis.
     * 
     * @param p Mouse press coordinates
     * @param k Mouse release coordinates
     * @return Closest X coordinate to point (0,0)
     * @see java.awt.geom.Point2D
     */
    public int oblMinX(Point p,Point k)
    {
        return Math.min((int)p.getX(),(int)k.getX());
    }
    
    /**
     * Uses <code>Point</code> class.<p>
     * Allows drawing in all Y directions of graph axis.
     * 
     * @param p Mouse press coordinates
     * @param k Mouse release coordinates
     * @return Closest Y coordinate to point (0,0)
     * @see java.awt.geom.Point2D
     */
    public int oblMinY(Point p,Point k)
    {
        return Math.min((int)p.getY(),(int)k.getY());
    }
    
    /**
     * Uses <code>Point</code> class.<p>
     * Allows drawing in all directions of graph quarters.
     * 
     * @param p Mouse press coordinates
     * @param k Mouse release coordinates
     * @return Absolute value of shape width
     * @see java.awt.geom.Point2D
     */
    public int oblSzer(Point p,Point k)
    {
        return Math.abs((int)p.getX()-(int)k.getX());
    }
    
    /**
     * Allows drawing in all directions of graph quarters.
     * 
     * @param x1 Mouse press X coordinates
     * @param x2 Mouse release X coordinates
     * @return Absolute value of shape width
     */
    public int oblSzer(int x1,int x2)
    {
        return Math.abs(x1-x2);
    }
    
    /**
     * Uses <code>Point</code> class.<p>
     * Allows drawing in all directions of graph quarters.
     * 
     * @param p Mouse press coordinates
     * @param k Mouse release coordinates
     * @return Absolute value of shape height
     * @see java.awt.geom.Point2D
     */
    public int oblWys(Point p,Point k)
    {
        return Math.abs((int)p.getY()-(int)k.getY());
    }
    
    /**
     * Allows drawing in all directions of graph quarters.
     * 
     * @param y1 Mouse press Y coordinate
     * @param y2 Mouse release Y coordinate
     * @return Absolute value of shape height
     */
    public int oblWys(int y1,int y2)
    {
        return Math.abs(y1-y2);
    }
    
    /**
     * @return Selected shape fill color.
     */
    public Color ustawWypelnienie()
    {
        return switch (wypelnienie) {
            case 0 -> null;
            case 1 -> kolor1;
            default -> kolor2;
        };
    }
    
    /**
     * @return Selected brush or shape border color.
     */
    private Color ustawKolor()
    {
        return switch (ostPrzy) {
            case 0 -> kolor1;
            case 1 -> kolor2;
            default -> null;
        };
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        setZmiany(true);
        // Specify which mouse button was pressed
        // 0 - Left
        // 1 - Right or any mouse button
        if((e.getModifiersEx()& InputEvent.BUTTON1_DOWN_MASK) == InputEvent.BUTTON1_DOWN_MASK)
            nacisnieto=0;
        else //if((e.getModifiersEx()& InputEvent.BUTTON3_DOWN_MASK) == InputEvent.BUTTON3_DOWN_MASK)
            nacisnieto=1;
        if(nrNarzedzia!=0&&nrNarzedzia!=4)
        {
            pocz=new Point(e.getX(),e.getY());
            kon=pocz;
            repaint();
        }
        // Draw polygon
        else if(nrNarzedzia==4)
        {
            if(!wielok)
            pocz=new Point(e.getX(),e.getY());
            else
            {
                if(ostFi!=null&&ostPrzy==nacisnieto&&ostFi.getRodzajFigury()==nrNarzedzia&&ostFi.getGruboscPedzlaFigury()==nrGrubosciPedzla&&ostFi.getPrzezroczystoc()==przezr&&ostFi.getKolorRamki()==ustawKolor())
                {
                    WymiarInt w=ostFi.getNpozycja(0);
                    
                        if(!(oblSzer((int)kon.getX(),w.getX1())<=10&&oblWys((int)kon.getY(),w.getY1())<=10))
                        fig.get(fig.size()-1).dodajPunkty(new Wymiar2d((int)pocz.getX(),(int)pocz.getY(),(int)kon.getX(),(int)kon.getY()));
                        else
                        {
                            fig.get(fig.size()-1).dodajPunkty(new Wymiar2d((int)pocz.getX(),(int)pocz.getY(),w.getX1(),w.getY1()));
                            ostFi=null;
                            pocz=null;
                            kon=null;
                            wielok=false;
                            return;
                        }
                }
                else
                {
                    Figura f;
                    if(nacisnieto==0)
                    {
                        f=new Figura(nrNarzedzia,nrGrubosciPedzla,przezr,kolor1,null,new Wymiar2d((int)pocz.getX(),(int)pocz.getY(),(int)kon.getX(),(int)kon.getY()));
                        ostPrzy=0;
                    }
                    else
                    {
                        f=new Figura(nrNarzedzia,nrGrubosciPedzla,przezr,kolor2,null,new Wymiar2d((int)pocz.getX(),(int)pocz.getY(),(int)kon.getX(),(int)kon.getY()));
                        ostPrzy=1;
                    }
                    fig.add(f);
                    ostFi=f;
                }
            pocz=kon;
            }
            wielok=true;
            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(nrNarzedzia!=0&&nrNarzedzia!=4&&nrNarzedzia!=5)
        {
            if(ostFi!=null&&ostPrzy==nacisnieto&&ostFi.getRodzajFigury()==nrNarzedzia&&ostFi.getGruboscPedzlaFigury()==nrGrubosciPedzla&&ostFi.getPrzezroczystoc()==przezr&&ostFi.getKolorRamki()==ustawKolor()&&ostFi.getKolorWypelnienia()==ustawWypelnienie())
            {
                try{
                    fig.get(fig.size()-1).dodajPunkty(new Wymiar2d((int)pocz.getX(),(int)pocz.getY(),e.getX(),e.getY()));
                }catch(Exception ex){
                    //Exception if mouse spam with both buttons
                }
            }
            else
            {
                Figura f;
                if(nacisnieto==0)
                {
                    f=new Figura(nrNarzedzia,nrGrubosciPedzla,przezr,kolor1,ustawWypelnienie(),new Wymiar2d((int)pocz.getX(),(int)pocz.getY(),e.getX(),e.getY()));
                    ostPrzy=0;
                }
                else
                {
                    f=new Figura(nrNarzedzia,nrGrubosciPedzla,przezr,kolor2,ustawWypelnienie(),new Wymiar2d((int)pocz.getX(),(int)pocz.getY(),e.getX(),e.getY()));
                    ostPrzy=1;
                }
                fig.add(f);
                ostFi=f;
            }
        }
        if(nrNarzedzia!=4)
        {
        pocz=null;
        kon=null;
        }
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(nrNarzedzia==0)
        {
            int x=e.getX(),y=e.getY();
            if(ostFi!=null&&ostPrzy==nacisnieto&&ostFi.getRodzajFigury()==0&&ostFi.getGruboscPedzlaFigury()==nrGrubosciPedzla&&ostFi.getPrzezroczystoc()==przezr&&ostFi.getKolorRamki()==kolor1&&ostFi.getKolorWypelnienia()==ustawWypelnienie())
            {
                fig.get(fig.size()-1).dodajPunkty(new Wymiar(x,y));
            }
            else
            {
                Figura fd;
                if(nacisnieto==0)
                {
                    fd=new Figura(nrNarzedzia,nrGrubosciPedzla,przezr,kolor1,null,new Wymiar(x,y));
                    ostPrzy=0;
                }
                else
                {
                    fd=new Figura(nrNarzedzia,nrGrubosciPedzla,przezr,kolor2,null,new Wymiar(x,y));
                    ostPrzy=1;
                }
                fig.add(fd);
                ostFi=fd;
            }
        }
        else if(nrNarzedzia==5)
        {
            int x=e.getX(),y=e.getY();
            if(ostFi!=null&&ostFi.getRodzajFigury()==nrNarzedzia&&ostFi.getGruboscPedzlaFigury()==nrGrubosciPedzla)
            {
                fig.get(fig.size()-1).dodajPunkty(new Wymiar(x,y));
            }
            else
            {
                Figura f=new Figura(nrNarzedzia,nrGrubosciPedzla,1f,KOLOR_TLA,null,new Wymiar(e.getX(),e.getY()));
                fig.add(f);
                ostFi=f;
            }
        }
        kon=new Point(e.getX(),e.getY());
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(nrNarzedzia==4)
        {
            kon=new Point(e.getX(),e.getY());
            repaint();
        }
        if(nrNarzedzia==5)
        {
            pocz=new Point(e.getX(),e.getY());
            kon=pocz;
            repaint();
        }
    }
    
}
