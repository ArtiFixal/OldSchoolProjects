package edytorgraf;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Inits GUI and handles actions.
 * 
 * @author ArtiFixal
 */
public class GUI extends JFrame {
    
    private String dir="";
    
    public GUI() {
        initComponents();
        setVisible(true);
        pKolor1.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
            kolory(e,pKolor1);
            }
        });
        pKolor2.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
            kolory(e,pKolor2);
            }
        });
        przezroczystosc.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseReleased(MouseEvent e) {
            rysunek.zmienPrzezroczystosc(przezroczystosc.getValue()*0.01f);
            }
        });
        setTitle(getTitle()+": Nowy obraz");
    }
    
    /**
     * Changes primary or seconndary color and updates it in GUI.
     * 
     * @param e MouseEvent listener to specify clicked element
     * @param p JPanel which will have color changed
     */
    public void kolory(MouseEvent e,JPanel p)
    {
        Color c=JColorChooser.showDialog(this,"Wybierz kolor",rysunek.getKolor1());
        if(c!=null)
        {
            if(e.getSource()==pKolor1)
            {
                rysunek.zmienKolor1(c);
                pKolor1.setBackground(c);
            }
            else
            {
                rysunek.zmienKolor2(c);
                pKolor2.setBackground(c);
            }
        }
    }
    
    /**
     * Asks if you want to discard changes made into document.
     * 
     * @return True if user discarded changes or there is no changes, false otherwise.
     */
    public boolean czyNapewno()
    {
        // Don't ask if there aren't any shapes to render
        if(rysunek.isEmpty())
            return true;
        // Ask only when file isn't saved
        return rysunek.getZmiany()&&JOptionPane.showConfirmDialog(this,"Czy na pewno chcesz porzucić zmiany?","Uwaga!",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        narzedzia = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        pKolor1 = new javax.swing.JPanel();
        pKolor2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        szerokosc = new javax.swing.JComboBox<>();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel5 = new javax.swing.JLabel();
        wypelnienie = new javax.swing.JComboBox<>();
        przezroczystosc = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        pWyczysc = new javax.swing.JButton();
        rysunek = new edytorgraf.Rysowanie();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mNowy = new javax.swing.JMenuItem();
        mOtworz = new javax.swing.JMenuItem();
        mZapisz = new javax.swing.JMenuItem();
        mZapiszJako = new javax.swing.JMenuItem();
        mZamknij = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edytor Graficzny");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(780, 220));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        narzedzia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ołówek", "Linia", "Prostokąt", "Koło", "Wielokąt", "Gumka" }));
        narzedzia.setFocusable(false);
        narzedzia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                narzedziaActionPerformed(evt);
            }
        });

        jLabel1.setText("Narzędzie:");

        jLabel2.setText("Kolor1");

        pKolor1.setBackground(new java.awt.Color(0, 0, 0));
        pKolor1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pKolor1.setPreferredSize(new java.awt.Dimension(32, 32));

        javax.swing.GroupLayout pKolor1Layout = new javax.swing.GroupLayout(pKolor1);
        pKolor1.setLayout(pKolor1Layout);
        pKolor1Layout.setHorizontalGroup(
            pKolor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        pKolor1Layout.setVerticalGroup(
            pKolor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pKolor2.setBackground(new java.awt.Color(255, 255, 255));
        pKolor2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pKolor2.setPreferredSize(new java.awt.Dimension(32, 32));

        javax.swing.GroupLayout pKolor2Layout = new javax.swing.GroupLayout(pKolor2);
        pKolor2.setLayout(pKolor2Layout);
        pKolor2Layout.setHorizontalGroup(
            pKolor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        pKolor2Layout.setVerticalGroup(
            pKolor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jLabel3.setText("Kolor2");

        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(pKolor1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(pKolor2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(pKolor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pKolor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pKolor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pKolor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6))
        );

        jLabel4.setText("Szerokość");

        szerokosc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1px", "2px", "3px", "4px", "5px", "6px", "7px", "8px", "9px", "10px" }));
        szerokosc.setFocusable(false);
        szerokosc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                szerokoscActionPerformed(evt);
            }
        });

        jLabel5.setText("Wypełnienie:");

        wypelnienie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Brak", "Kolor 1", "Kolor 2" }));
        wypelnienie.setFocusable(false);
        wypelnienie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wypelnienieActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(wypelnienie, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(wypelnienie, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wypelnienie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        przezroczystosc.setBackground(new java.awt.Color(204, 204, 204));
        przezroczystosc.setForeground(new java.awt.Color(255, 255, 255));
        przezroczystosc.setValue(100);
        przezroczystosc.setFocusable(false);

        jLabel6.setText("Przezroczystość:");

        pWyczysc.setText("Wyczyść");
        pWyczysc.setFocusPainted(false);
        pWyczysc.setFocusable(false);
        pWyczysc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pWyczyscActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(narzedzia, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(szerokosc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(przezroczystosc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pWyczysc)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(narzedzia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(szerokosc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLayeredPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pWyczysc)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(przezroczystosc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout rysunekLayout = new javax.swing.GroupLayout(rysunek);
        rysunek.setLayout(rysunekLayout);
        rysunekLayout.setHorizontalGroup(
            rysunekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        rysunekLayout.setVerticalGroup(
            rysunekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );

        jMenu1.setText("Rysunek");

        mNowy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mNowy.setText("Nowy");
        mNowy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNowyActionPerformed(evt);
            }
        });
        jMenu1.add(mNowy);

        mOtworz.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mOtworz.setText("Otwórz");
        mOtworz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mOtworzActionPerformed(evt);
            }
        });
        jMenu1.add(mOtworz);

        mZapisz.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mZapisz.setText("Zapisz");
        mZapisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mZapiszActionPerformed(evt);
            }
        });
        jMenu1.add(mZapisz);

        mZapiszJako.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mZapiszJako.setText("Zapisz jako");
        mZapiszJako.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mZapiszJakoActionPerformed(evt);
            }
        });
        jMenu1.add(mZapiszJako);

        mZamknij.setText("Zamknij");
        mZamknij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mZamknijActionPerformed(evt);
            }
        });
        jMenu1.add(mZamknij);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rysunek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rysunek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void narzedziaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_narzedziaActionPerformed
        rysunek.zmienNarzedzie(narzedzia.getSelectedIndex());
    }//GEN-LAST:event_narzedziaActionPerformed

    private void szerokoscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_szerokoscActionPerformed
        rysunek.zmienGruboscPedzla(szerokosc.getSelectedIndex()+1);
    }//GEN-LAST:event_szerokoscActionPerformed

    private void wypelnienieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wypelnienieActionPerformed
        rysunek.zmienWypelnienie(wypelnienie.getSelectedIndex());
    }//GEN-LAST:event_wypelnienieActionPerformed

    private void pWyczyscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pWyczyscActionPerformed
        rysunek.wyczysc();
    }//GEN-LAST:event_pWyczyscActionPerformed

    private void mOtworzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mOtworzActionPerformed
        if(!rysunek.getZmiany()||czyNapewno())
        {
            JFileChooser fc=new JFileChooser();
            FileNameExtensionFilter f=new FileNameExtensionFilter("Drawer file","dat");
            fc.setFileFilter(f);
            // Open file chooser in current working directory (where program is executed)
            fc.setCurrentDirectory(Path.of("").toAbsolutePath().toFile());
            if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
            {
                dir=fc.getSelectedFile().toString();
                try{
                    ArrayList<Figura> o=(ArrayList<Figura>)SerializacjaDanych.wczytajOb(dir);
                    rysunek.setFig(o);
                    String name=fc.getSelectedFile().getName();
                    if(name.contains("."))
                    setTitle("Edytor Graiczny: "+name.substring(0,name.indexOf(".")));
                    repaint();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,"Wystąpił błąd przy odczycie: "+e.getMessage(),"Błąd",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_mOtworzActionPerformed

    private void mNowyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNowyActionPerformed
        if(!rysunek.getZmiany()||czyNapewno())
        rysunek.wyczysc();
        setTitle("Edytor Graiczny: Nowy obraz");
        dir="";
        
    }//GEN-LAST:event_mNowyActionPerformed

    private void mZapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mZapiszActionPerformed
        if(dir.isBlank())
        {
            mZapiszJakoActionPerformed(null);
        }
        else
        {
            try{
                    SerializacjaDanych.zapiszOb(rysunek.getFig(), dir);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,"Wystąpił błąd przy zapisie: "+e.getMessage(),"Błąd",JOptionPane.ERROR_MESSAGE);
                }
        }
        rysunek.setZmiany(false);
    }//GEN-LAST:event_mZapiszActionPerformed

    private void mZapiszJakoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mZapiszJakoActionPerformed
        JFileChooser fc=new JFileChooser();
        FileNameExtensionFilter f=new FileNameExtensionFilter("Drawer file","dat");
        fc.setFileFilter(f);
        if(evt!=null)
            fc.setDialogTitle("Zapisz dokument jako");
        else
            fc.setDialogTitle("Zapisz dokument");
        // Open file chooser in current working directory (where program is executed)
        fc.setCurrentDirectory(Path.of("").toAbsolutePath().toFile());
        if(fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
        {
            dir=fc.getSelectedFile().toString();
            String name=fc.getSelectedFile().getName();
            if(name.contains("."))
                setTitle("Edytor Graiczny: "+name.substring(0,name.indexOf(".")));
            if(fc.getAcceptAllFileFilter()==f&&!dir.contains(".dat"))
                dir+=".dat";
            try{
                SerializacjaDanych.zapiszOb(rysunek.getFig(), dir);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"Wystąpił błąd przy zapisie: "+e.getMessage(),"Błąd",JOptionPane.ERROR_MESSAGE);
            }
        }
        rysunek.setZmiany(false);
    }//GEN-LAST:event_mZapiszJakoActionPerformed

    private void mZamknijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mZamknijActionPerformed
        if(!rysunek.getZmiany()||czyNapewno())
            System.exit(0);
    }//GEN-LAST:event_mZamknijActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem mNowy;
    private javax.swing.JMenuItem mOtworz;
    private javax.swing.JMenuItem mZamknij;
    private javax.swing.JMenuItem mZapisz;
    private javax.swing.JMenuItem mZapiszJako;
    private javax.swing.JComboBox<String> narzedzia;
    private javax.swing.JPanel pKolor1;
    private javax.swing.JPanel pKolor2;
    private javax.swing.JButton pWyczysc;
    private javax.swing.JSlider przezroczystosc;
    private edytorgraf.Rysowanie rysunek;
    private javax.swing.JComboBox<String> szerokosc;
    private javax.swing.JComboBox<String> wypelnienie;
    // End of variables declaration//GEN-END:variables
}
