package edytortekstowy;

import java.awt.Color;
import static java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Path;
import java.util.zip.ZipException;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

public class GUI extends JFrame implements CaretListener{
    
    /**
     * Sets filter to search for an specific file extension which helps to find files to open.
     */
    private final static FileNameExtensionFilter FILTR = new FileNameExtensionFilter("Dokument edytora tekstowego","doca");
    
    /**
     * Document to store text and styles.
     */
    private DefaultStyledDocument dsd=new DefaultStyledDocument();
    
    /**
     * Stores directory to a saved file.
     */
    private String dir="";
    
    /**
     * Describes if changes were made to a file.
     */
    private boolean zmiany=false;
    
    /**
     * Describes if changes were saved.
     */
    private boolean zapisano=false;
    
    public GUI() {
        initComponents();
        panel.setStyledDocument(dsd);
        zaladujCzcionki();
        pPogrubienie.addActionListener(new StyledEditorKit.BoldAction());
        pPochylenie.addActionListener(new StyledEditorKit.ItalicAction());
        pPodkreslenie.addActionListener(new StyledEditorKit.UnderlineAction());
        pKolor.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e)
            {
                zmienKolor();
            }
        });
        pKolorTla.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e)
            {
                zmienKolorTla();
            }
        });
        SimpleAttributeSet aset=new SimpleAttributeSet();
        StyleConstants.setForeground(aset, Color.BLACK);
        StyleConstants.setFontFamily(aset, "Alef");
        panel.setCharacterAttributes(aset,false);
        panel.addCaretListener(this);
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e)
            {
                zapisano=false;
                liczWszystko();
            }
        });
        // Display in the middle of a screen.
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /**
     * Loads up system fonts to allow their usage.
     */
    private void zaladujCzcionki()
    {
        DefaultComboBoxModel<String> cz=new DefaultComboBoxModel(getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        rCzcionki.setModel(cz);
        zmienCzcionke((String)rCzcionki.getSelectedItem());
    }
    
    /**
     * Counts number of characters and words.
     */
    private void liczWszystko()
    {
        int iloscZ=0,iloscS=0;
        String s=panel.getText();
        // Stores last character
        char oz=' ';
        for(int i=0;i<s.length();i++)
        {
            
            // Checks if last character isn't whitespace character.
            if(s.charAt(i)!=' '&&s.charAt(i)!='\t'&&s.charAt(i)!='\r'&&s.charAt(i)!='\n')
            {
                iloscZ++;
                // If it is then we encountered a new word
                if(oz==' '||oz=='\t'||i>=2&&s.charAt(i-2)=='\r'&&oz=='\n')
                iloscS++;
            }
            // Update last character
            oz=s.charAt(i);
        }
        dlugosci.setText("Ilośc znaków: "+iloscZ+"    Ilość słów: "+iloscS);
    }
    
    /**
     * Opens color picker to change text color of selected text.
     */
    public void zmienKolor()
    {
        // Open ColorChoser to chose new text color
        Color c=JColorChooser.showDialog(this,"Wybierz kolor tekstu",Color.BLACK);
        if(c!=null)
        {
            SimpleAttributeSet aset=new SimpleAttributeSet();
            StyleConstants.setForeground(aset, c);
            panel.setCharacterAttributes(aset,false);
            pKolor.setBackground(c);
            zmiany=true;
        }
    }
    
    /**
     * Opens color picker to change background color of selected text.
     */
    public void zmienKolorTla()
    {
        // Open ColorChoser to chose new background color
        Color c=JColorChooser.showDialog(this,"Wybierz kolor tła",Color.WHITE);
        if(c!=null)
        {
            SimpleAttributeSet aset=new SimpleAttributeSet();
            StyleConstants.setBackground(aset, c);
            panel.setCharacterAttributes(aset,false);
            pKolorTla.setBackground(c);
            zmiany=true;
        }
    }
    
    /**
     * Change font of a selected text.
     * 
     * @param s Selected text
     */
    public void zmienCzcionke(String s)
    {
        SimpleAttributeSet aset=new SimpleAttributeSet();
        StyleConstants.setFontFamily(aset, s);
        panel.setCharacterAttributes(aset,false);
        zmiany=true;
    }
    /**
     * Change font size of a selected text.
     * 
     * @param s Selected text
     */
    private void zmienWielkosc(String s)
    {
        int rozmiar=Integer.parseInt(s.substring(0,s.length()-3));
        SimpleAttributeSet aset=new SimpleAttributeSet();
        StyleConstants.setFontSize(aset, rozmiar);
        panel.setCharacterAttributes(aset,false);
        zmiany=true;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lCzcionki = new javax.swing.JLayeredPane();
        tCzcionka = new javax.swing.JLabel();
        rCzcionki = new javax.swing.JComboBox<>();
        lRozmiaruCz = new javax.swing.JLayeredPane();
        tRozmiar = new javax.swing.JLabel();
        rozmiarCz = new javax.swing.JComboBox<>();
        pPogrubienie = new javax.swing.JToggleButton();
        pPochylenie = new javax.swing.JToggleButton();
        pPodkreslenie = new javax.swing.JToggleButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        pKolor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        pKolorTla = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        dlugosci = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        mDokument = new javax.swing.JMenu();
        mdNowy = new javax.swing.JMenuItem();
        mdOtworz = new javax.swing.JMenuItem();
        mdZapisz = new javax.swing.JMenuItem();
        mdZapiszJako = new javax.swing.JMenuItem();
        mdZamknij = new javax.swing.JMenuItem();
        mEdycja = new javax.swing.JMenu();
        meKopiuj = new javax.swing.JMenuItem();
        meWytnij = new javax.swing.JMenuItem();
        meWklej = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edytor tekstowy");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 300));
        setPreferredSize(new java.awt.Dimension(800, 400));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tCzcionka.setText("Czcionka:");

        rCzcionki.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Segore UI" }));
        rCzcionki.setFocusable(false);
        rCzcionki.setRequestFocusEnabled(false);
        rCzcionki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rCzcionkiActionPerformed(evt);
            }
        });

        lCzcionki.setLayer(tCzcionka, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lCzcionki.setLayer(rCzcionki, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lCzcionkiLayout = new javax.swing.GroupLayout(lCzcionki);
        lCzcionki.setLayout(lCzcionkiLayout);
        lCzcionkiLayout.setHorizontalGroup(
            lCzcionkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lCzcionkiLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(lCzcionkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tCzcionka)
                    .addComponent(rCzcionki, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        lCzcionkiLayout.setVerticalGroup(
            lCzcionkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lCzcionkiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tCzcionka)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rCzcionki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        tRozmiar.setText("Rozmiar:");

        rozmiarCz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6 px", "8 px", "9 px", "10 px", "11 px", "12 px", "13 px", "14 px", "15 px", "16 px", "17 px", "18 px", "20 px", "22 px", "24 px", "26 px", "28 px", "32 px", "36 px", "40 px", "44 px", "48 px", "54 px", "60 px", "66 px", "72 px", "80 px", "88 px", "96 px", "144 px" }));
        rozmiarCz.setSelectedIndex(5);
        rozmiarCz.setFocusable(false);
        rozmiarCz.setRequestFocusEnabled(false);
        rozmiarCz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rozmiarCzActionPerformed(evt);
            }
        });

        lRozmiaruCz.setLayer(tRozmiar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lRozmiaruCz.setLayer(rozmiarCz, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lRozmiaruCzLayout = new javax.swing.GroupLayout(lRozmiaruCz);
        lRozmiaruCz.setLayout(lRozmiaruCzLayout);
        lRozmiaruCzLayout.setHorizontalGroup(
            lRozmiaruCzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lRozmiaruCzLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(lRozmiaruCzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tRozmiar)
                    .addComponent(rozmiarCz, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        lRozmiaruCzLayout.setVerticalGroup(
            lRozmiaruCzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lRozmiaruCzLayout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(tRozmiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rozmiarCz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pPogrubienie.setText("Pogrubienie");
        pPogrubienie.setFocusPainted(false);
        pPogrubienie.setFocusable(false);
        pPogrubienie.setRequestFocusEnabled(false);

        pPochylenie.setText("Pochylenie");
        pPochylenie.setFocusPainted(false);
        pPochylenie.setFocusable(false);
        pPochylenie.setRequestFocusEnabled(false);

        pPodkreslenie.setText("Podkreślenie");
        pPodkreslenie.setFocusPainted(false);
        pPodkreslenie.setFocusable(false);
        pPodkreslenie.setRequestFocusEnabled(false);

        pKolor.setBackground(new java.awt.Color(0, 0, 0));
        pKolor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        pKolor.setFocusable(false);
        pKolor.setPreferredSize(new java.awt.Dimension(24, 24));
        pKolor.setRequestFocusEnabled(false);

        javax.swing.GroupLayout pKolorLayout = new javax.swing.GroupLayout(pKolor);
        pKolor.setLayout(pKolorLayout);
        pKolorLayout.setHorizontalGroup(
            pKolorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        pKolorLayout.setVerticalGroup(
            pKolorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jLabel1.setText("Kolor");

        pKolorTla.setBackground(new java.awt.Color(255, 255, 255));
        pKolorTla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        pKolorTla.setFocusable(false);
        pKolorTla.setPreferredSize(new java.awt.Dimension(24, 24));
        pKolorTla.setRequestFocusEnabled(false);

        javax.swing.GroupLayout pKolorTlaLayout = new javax.swing.GroupLayout(pKolorTla);
        pKolorTla.setLayout(pKolorTlaLayout);
        pKolorTlaLayout.setHorizontalGroup(
            pKolorTlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        pKolorTlaLayout.setVerticalGroup(
            pKolorTlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jLabel2.setText("Kolor tła");

        jLayeredPane2.setLayer(pKolorTla, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(pKolorTla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2)))
                .addGap(0, 0, 0))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(pKolorTla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jLayeredPane1.setLayer(pKolor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLayeredPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(pKolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1)))
                .addGap(13, 13, 13)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(pKolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lCzcionki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lRozmiaruCz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pPogrubienie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pPochylenie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pPodkreslenie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lRozmiaruCz, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lCzcionki, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pPogrubienie)
                                .addComponent(pPochylenie)
                                .addComponent(pPodkreslenie)))))
                .addContainerGap())
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setToolTipText("");
        jScrollPane1.setViewportView(panel);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 24));

        dlugosci.setText("Ilośc znaków: 0    Ilość słów: 0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(dlugosci)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(dlugosci)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menu.setBorder(null);

        mDokument.setText("Dokument");

        mdNowy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mdNowy.setText("Nowy");
        mdNowy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mdNowyActionPerformed(evt);
            }
        });
        mDokument.add(mdNowy);

        mdOtworz.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mdOtworz.setText("Otwórz");
        mdOtworz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mdOtworzActionPerformed(evt);
            }
        });
        mDokument.add(mdOtworz);

        mdZapisz.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mdZapisz.setText("Zapisz");
        mdZapisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mdZapiszActionPerformed(evt);
            }
        });
        mDokument.add(mdZapisz);

        mdZapiszJako.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mdZapiszJako.setText("Zapisz jako");
        mdZapiszJako.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mdZapiszJakoActionPerformed(evt);
            }
        });
        mDokument.add(mdZapiszJako);

        mdZamknij.setText("Zamknij");
        mdZamknij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mdZamknijActionPerformed(evt);
            }
        });
        mDokument.add(mdZamknij);

        menu.add(mDokument);

        mEdycja.setText("Edycja");

        meKopiuj.setText("Kopiuj");
        meKopiuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meKopiujActionPerformed(evt);
            }
        });
        mEdycja.add(meKopiuj);

        meWytnij.setText("Wytnij");
        meWytnij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meWytnijActionPerformed(evt);
            }
        });
        mEdycja.add(meWytnij);

        meWklej.setText("Wklej");
        meWklej.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meWklejActionPerformed(evt);
            }
        });
        mEdycja.add(meWklej);

        menu.add(mEdycja);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rCzcionkiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rCzcionkiActionPerformed
        if(!zmiany)
        zmienCzcionke((String)rCzcionki.getSelectedItem());
    }//GEN-LAST:event_rCzcionkiActionPerformed

    private void rozmiarCzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rozmiarCzActionPerformed
        if(!zmiany)
        zmienWielkosc((String)rozmiarCz.getSelectedItem());
    }//GEN-LAST:event_rozmiarCzActionPerformed

    private void mdOtworzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mdOtworzActionPerformed
        // Checks if there isn't unsaved changes
        if(!zmiany||czyNapewno())
        {
        JFileChooser fc=new JFileChooser();
        fc.setDialogTitle("Otwórz dokument");
        fc.setFileFilter(FILTR);
        // Open file chooser in current working directory (where program is executed)
        fc.setCurrentDirectory(Path.of("").toAbsolutePath().toFile());
        if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
        {
            dir=fc.getSelectedFile().getPath();
            // Try to uncompress and open selected file.
            try{
                dsd=(DefaultStyledDocument)SerializacjaDanych.wczytajOb(dir);
                panel.setStyledDocument(dsd);
            }catch(ZipException ze){
                JOptionPane.showMessageDialog(panel, "Nie udało się wczytać pliku, nie jest to plik edytora tekstowego.");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(panel, "Nie udało się wczytać pliku.");
            }
        }
        }
    }//GEN-LAST:event_mdOtworzActionPerformed

    /**
     * Asks if you want to discard changes made into document.
     * 
     * @return True if user discarded changes or there is no changes, false otherwise.
     */
    private boolean czyNapewno()
    {
        // Don't ask if there is no text in editor at all
        if(dsd.getEndPosition().getOffset()==1)
            return true;
        // Ask only when file isn't saved
        return !zapisano&&JOptionPane.showConfirmDialog(panel,"Czy na pewno chcesz porzucić zmiany?","Uwaga!",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION;
    }
    
    private void mdNowyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mdNowyActionPerformed
        // Clears editor and resets changes
        if(!zmiany||czyNapewno())
        {
            dir="";
            pKolor.setBackground(Color.BLACK);
            rozmiarCz.setSelectedIndex(5);
            rCzcionki.setSelectedIndex(0);
            dsd=new DefaultStyledDocument();
            panel.setDocument(dsd);
            zmienWielkosc((String)rozmiarCz.getSelectedItem());
            zmienCzcionke((String)rCzcionki.getSelectedItem());
            dlugosci.setText("Ilośc znaków: 0    Ilość słów: 0");
            zapisano=false;
        }
    }//GEN-LAST:event_mdNowyActionPerformed

    private void mdZapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mdZapiszActionPerformed
        // If save path isn't specified then open FileChooser dialog
        if(dir.isBlank())
        {
            mdZapiszJakoActionPerformed(null);
        }
        else 
        {
            try{
                SerializacjaDanych.zapiszOb(dsd, dir);
                zapisano=true;
            }catch(Exception e){
                JOptionPane.showMessageDialog(panel, "Nie udało się zapisać pliku");
            }
        }
    }//GEN-LAST:event_mdZapiszActionPerformed

    private void mdZamknijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mdZamknijActionPerformed
        if(czyNapewno())
        System.exit(0);
    }//GEN-LAST:event_mdZamknijActionPerformed

    private void mdZapiszJakoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mdZapiszJakoActionPerformed
        JFileChooser fc=new JFileChooser();
        fc.setFileFilter(FILTR);
        fc.setDialogTitle("Zapisz dokument jako");
        // Open file chooser in current working directory (where program is executed)
        fc.setCurrentDirectory(Path.of("").toAbsolutePath().toFile());
        if(fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
        {
            dir=fc.getSelectedFile().getPath();
            if(fc.getFileFilter()==FILTR&&!dir.contains(".doca"))
                dir+=".doca";
            try{
                SerializacjaDanych.zapiszOb(dsd, dir);
                zapisano=true;
            }catch(Exception e){
                JOptionPane.showMessageDialog(panel, "Nie udało się zapisać pliku");
            }
        }
    }//GEN-LAST:event_mdZapiszJakoActionPerformed
    
    private void meKopiujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meKopiujActionPerformed
        panel.copy();
    }//GEN-LAST:event_meKopiujActionPerformed

    private void meWklejActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meWklejActionPerformed
        panel.paste();
    }//GEN-LAST:event_meWklejActionPerformed

    private void meWytnijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meWytnijActionPerformed
        panel.cut();
    }//GEN-LAST:event_meWytnijActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dlugosci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLayeredPane lCzcionki;
    private javax.swing.JLayeredPane lRozmiaruCz;
    private javax.swing.JMenu mDokument;
    private javax.swing.JMenu mEdycja;
    private javax.swing.JMenuItem mdNowy;
    private javax.swing.JMenuItem mdOtworz;
    private javax.swing.JMenuItem mdZamknij;
    private javax.swing.JMenuItem mdZapisz;
    private javax.swing.JMenuItem mdZapiszJako;
    private javax.swing.JMenuItem meKopiuj;
    private javax.swing.JMenuItem meWklej;
    private javax.swing.JMenuItem meWytnij;
    private javax.swing.JMenuBar menu;
    private javax.swing.JPanel pKolor;
    private javax.swing.JPanel pKolorTla;
    private javax.swing.JToggleButton pPochylenie;
    private javax.swing.JToggleButton pPodkreslenie;
    private javax.swing.JToggleButton pPogrubienie;
    private javax.swing.JTextPane panel;
    private javax.swing.JComboBox<String> rCzcionki;
    private javax.swing.JComboBox<String> rozmiarCz;
    private javax.swing.JLabel tCzcionka;
    private javax.swing.JLabel tRozmiar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void caretUpdate(CaretEvent e) {
        // Check if editor isn't empty
        int poz=e.getDot()-1;
        if(poz>0)
        {
        zmiany=true;
        // Update info about selected text font family in GUI
        rCzcionki.setSelectedItem(dsd.getCharacterElement(poz).getAttributes().getAttribute(StyleConstants.FontFamily));
        // Update info about selected text font size in GUI
        rozmiarCz.setSelectedItem(dsd.getCharacterElement(poz).getAttributes().getAttribute(StyleConstants.FontSize)+" px");
        // Update info about selected text color in GUI
        pKolor.setBackground((Color)dsd.getCharacterElement(poz).getAttributes().getAttribute(StyleConstants.Foreground));
        // Update info about selected text background color in GUI
        Color tlo=(Color)dsd.getCharacterElement(poz).getAttributes().getAttribute(StyleConstants.Background);
        if(tlo!=null)
            pKolorTla.setBackground(tlo);
        else
            pKolorTla.setBackground(Color.WHITE);
        // Update info about selected text boldness in GUI
        pPogrubienie.setSelected(dsd.getCharacterElement(poz).getAttributes().getAttribute(StyleConstants.Bold).toString().equals("true"));
        // Update info about selected text italics in GUI
        pPochylenie.setSelected(dsd.getCharacterElement(poz).getAttributes().getAttribute(StyleConstants.Italic).toString().equals("true"));
        // Update info about selected text underline in GUI
        if(dsd.getCharacterElement(poz).getAttributes().getAttribute(StyleConstants.Underline)!=null)
            pPodkreslenie.setSelected(dsd.getCharacterElement(poz).getAttributes().getAttribute(StyleConstants.Underline).toString().equals("true"));
        else
            pPodkreslenie.setSelected(false); 
        zmiany=false;
        }
    }
}
