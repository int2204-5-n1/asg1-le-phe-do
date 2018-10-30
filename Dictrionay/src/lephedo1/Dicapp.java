/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lephedo1;

import com.sun.glass.events.KeyEvent;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.Color;
import java.awt.Event;
import java.awt.FlowLayout;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class Dicapp extends javax.swing.JFrame {

    /**
     * Creates new form dominhkha
     */
    Word dic;
    int n;
    int t1;
    private int t;
    String[] str = {""};
    JLabel back ;
    public Dicapp() throws IOException {
        initComponents();
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        text1.setText("Search here");
        // delete.setVisible(false);
        t = 1;
        n = -1;
        t1 = -1;
        dic = new Word();
        dic.ReadFile_E_V();
        dic.ReadFile_V_E();
        pane1.setContentType("text/html");
        System.setProperty("file.encoding","utf-8");
        jList1.setListData(str);
        if (t == 0) {
            String[] list1 = dic.getListRecent_E();
            jList1.setListData(list1);
        } else if (t == 1) {
            String[] list1 = dic.getListRecent_V();
            jList1.setListData(list1);
        }
        this.setVisible(false);
        this.getContentPane().setBackground(Color.white);
        this.setLocationRelativeTo(null);
       // this.setSize(1042, 770);
       this.setBounds(200, 50,1042, 770);
        this.setResizable(false);
        pane1.setEditable(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        text1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        pane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exit = new javax.swing.JMenuItem();
        addToFile = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        Modify = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(500, 500, 1000, 770));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        text1.setText("jTextField1");
        text1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                text1MouseClicked(evt);
            }
        });
        text1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                text1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text1KeyReleased(evt);
            }
        });

        jLabel1.setBackground(java.awt.SystemColor.textHighlight);
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 32)); // NOI18N
        jLabel1.setForeground(java.awt.SystemColor.textHighlightText);
        jLabel1.setText("Dictionary");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lephedo1/soundIcon.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vietnamese-English", "English-Vietnamese" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1110, 150);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(12, 157, 218, 520);

        pane1.setContentType("text/html"); // NOI18N
        pane1.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        pane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pane1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(pane1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(242, 157, 718, 520);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lephedo1/wasteBacket.png"))); // NOI18N
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(967, 575, 53, 57);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lephedo1/background1.jpg"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1, -30, 1110, 730);

        jMenuBar1.setBackground(java.awt.SystemColor.textHighlight);
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(java.awt.SystemColor.textHighlight);
        jMenuBar1.setBorderPainted(false);

        jMenu1.setBackground(java.awt.SystemColor.text);
        jMenu1.setForeground(java.awt.SystemColor.textHighlight);
        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jMenu1.setOpaque(true);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exit.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        exit.setForeground(java.awt.SystemColor.textHighlight);
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        addToFile.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        addToFile.setForeground(java.awt.SystemColor.textHighlight);
        addToFile.setText("Add to file");
        addToFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToFileActionPerformed(evt);
            }
        });
        jMenu1.add(addToFile);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(java.awt.SystemColor.text);
        jMenu2.setForeground(java.awt.SystemColor.textHighlight);
        jMenu2.setText("Edit");
        jMenu2.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jMenu2.setOpaque(true);

        jMenu3.setForeground(java.awt.SystemColor.textHighlight);
        jMenu3.setText("Add word");
        jMenu3.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jMenuItem3.setForeground(java.awt.SystemColor.textHighlight);
        jMenuItem3.setText("Vietnamese-English");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jMenuItem4.setForeground(java.awt.SystemColor.textHighlight);
        jMenuItem4.setText("English-Vietnamese");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenu2.add(jMenu3);

        Modify.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        Modify.setForeground(java.awt.SystemColor.textHighlight);
        Modify.setText("Modify");
        Modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyActionPerformed(evt);
            }
        });
        jMenu2.add(Modify);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // TODO add your handling code here:
        String a = jList1.getSelectedValue().toString();
        if (t == 1) {
            try {
                if (t1 == -1) {
                    dic.addRecent(a, 1);
                }
            } catch (IOException ex) {
                Logger.getLogger(Dicapp.class.getName()).log(Level.SEVERE, null, ex);
            }
            byte[] utf8Bytes=dic.getDic_V_E(a).getBytes();
            String b1 = null;
            try {
                b1 = new String(utf8Bytes,dic.getDic_V_E(a));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Dicapp.class.getName()).log(Level.SEVERE, null, ex);
            }
            pane1.setText(b1);
            pane1.setText(dic.getDic_V_E(a));
            //  if(dic.getDic_E_V(a)==null) pane1.setText("tu nay da bi xoa");
        }
        if (t == 0) {
            try {
                if (t1 == -1) {
                    dic.addRecent(a, 0);
                }
            } catch (IOException ex) {
                Logger.getLogger(Dicapp.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
           // pane1.setText(b1);
            pane1.setText(dic.getDic_E_V(a));
            //     if(dic.getDic_E_V(a)==null) pane1.setText("tu nay da bi xoa");
        }
        text1.setText(jList1.getSelectedValue().toString());

    }//GEN-LAST:event_jList1ValueChanged

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        System.exit(WIDTH);
    }//GEN-LAST:event_exitActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            dic.addWord(1);
        } catch (IOException ex) {
            Logger.getLogger(Dicapp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            dic.addWord(0);
        } catch (IOException ex) {
            Logger.getLogger(Dicapp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    private void addToFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToFileActionPerformed
        // TODO add your handling code here:
        String b= text1.getText().toString();
        try {
            dic.releaseFile(b,t);
        } catch (IOException ex) {
            Logger.getLogger(Dicapp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addToFileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         String a = text1.getText();
        //  a=jList1.getSelectedValue().toString();
        if (n == -1) {
            t1 = 0;
            int k = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn xoá không?");
            if (k == 0) {
                int h = 0;
                try {
                    h = dic.delWord(a, t);
                } catch (IOException ex) {
                    Logger.getLogger(Dicapp.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (h == 0) {
                    pane1.setContentType("text/html");
                    pane1.setText("<span style=\"color: red\">----------- TỪ NÀY KHÔNG TỒN TẠI ----------</span>");
                    // JOptionPane.showMessageDialog(rootPane,"Please type word","UET_DIC",JOptionPane.ERROR);
                    // JOptionPane.showMessageDialog(rootPane,"Please type word",JOptionPane.ERROR);
                } else {
                    pane1.setContentType("text/html");
                    pane1.setText("<span style=\"color: blue\">----------- XOÁ TỪ THÀNH CÔNG ----------</span>");

                }
                text1.setText("");
                
                jList1.setListData(str);
               jList1.clearSelection();
               
             //  jList1.removeListSelectionListener(null);
            }
        }

        if (n == 1) {
            String word = text1.getText().toString().toLowerCase();
            String defi = pane1.getText().toString().toLowerCase();
            try {
                dic.modify(word, defi, t);
                JOptionPane.showMessageDialog(rootPane, "Modify successfully");
                text1.setText("");
                pane1.setText("");
                jList1.setListData(str);
            } catch (IOException ex) {
                Logger.getLogger(Dicapp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      //  dic.delWord(a, n)
    }//GEN-LAST:event_jButton1ActionPerformed
    public static final String VoiceName = "kevin16";
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice(VoiceName);
        voice.allocate();
        try {
            voice.speak(jList1.getSelectedValue());

        } catch (Exception e) {

        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String a = jComboBox1.getSelectedItem().toString();
        if (("Vietnamese-English").equals(a)) {
            t = 1;
            String[] list2 = dic.getListRecent_V();
            jList1.setListData(list2);
            text1.setEditable(true);
            text1.setText("Search here: ");
            pane1.setText("");
        } else if (("English-Vietnamese").equals(a)) {
            t = 0;
            try {
                String[] list2 = dic.getListRecent_E();
                jList1.setListData(list2);
                pane1.setText("");
            } catch (IOException ex) {
                Logger.getLogger(Dicapp.class.getName()).log(Level.SEVERE, null, ex);
            }
            text1.setEditable(true);
            text1.setText("Search here: ");

        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void text1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text1KeyReleased
        // TODO add your handling code here:
        if (t == 0) {
            try {
                explain_E_V();
            } catch (IOException ex) {
                Logger.getLogger(Dicapp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (t == 1) {
            try {
                explain_V_E();
            } catch (IOException ex) {
                Logger.getLogger(Dicapp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_text1KeyReleased

    private void text1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text1MouseClicked
        // TODO add your handling code here:
        if (t == 0) {
            try {
                String[] list1 = dic.getListRecent_E();
                jList1.setListData(list1);
            } catch (IOException ex) {
                Logger.getLogger(Dicapp.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (t == 1) {
            String[] list1 = dic.getListRecent_V();
            jList1.setListData(list1);
        }
        text1.setText("");
        pane1.setText("");
    }//GEN-LAST:event_text1MouseClicked

    private void ModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyActionPerformed
        // TODO add your handling code here:
        pane1.setEditable(true);
    }//GEN-LAST:event_ModifyActionPerformed

    private void pane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==Event.ENTER){
           int k = JOptionPane.showConfirmDialog(rootPane,"Do you want to save this word ?");
           if(k==0){
               try {
                   dic.modify(text1.getText(),pane1.getText(),t);
               } catch (IOException ex) {
                   Logger.getLogger(Dicapp.class.getName()).log(Level.SEVERE, null, ex);
               }
               JOptionPane.showMessageDialog(rootPane,"Modify successfully");
           }
            pane1.setEditable(false);
        }
       
    }//GEN-LAST:event_pane1KeyPressed

    private void text1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String a = text1.getText();
        if (t == 1) {
            try {
                if (t1 == -1) {
                    dic.addRecent(a, 1);
                }
            } catch (IOException ex) {
                Logger.getLogger(Dicapp.class.getName()).log(Level.SEVERE, null, ex);
            }
            byte[] utf8Bytes=dic.getDic_V_E(a).getBytes();
            String b1 = null;
            try {
                b1 = new String(utf8Bytes,dic.getDic_V_E(a));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Dicapp.class.getName()).log(Level.SEVERE, null, ex);
            }
            pane1.setText(b1);
            pane1.setText(dic.getDic_V_E(a));
            
        }
        if (t == 0) {
            try {
                if (t1 == -1) {
                    dic.addRecent(a, 0);
                }
            } catch (IOException ex) {
                Logger.getLogger(Dicapp.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
           // pane1.setText(b1);
            pane1.setText(dic.getDic_E_V(a));
            //     if(dic.getDic_E_V(a)==null) pane1.setText("tu nay da bi xoa");
        }
        text1.setText(jList1.getSelectedValue().toString());

        }
    }//GEN-LAST:event_text1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dicapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dicapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dicapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dicapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Dicapp().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Dicapp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void explain_V_E() throws IOException {
        
        String a = text1.getText();
        a = a.toLowerCase();
        String[] list;
        list = dic.getList_V_E(a);
        jList1.setListData(list);
    }

    public void explain_E_V() throws IOException {
        String a = text1.getText();
        a = a.toLowerCase();
        String[] list;
        //  dic.ReadFile_E_V();
        list = dic.getList_E_V(a);
        jList1.setListData(list);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Modify;
    private javax.swing.JMenuItem addToFile;
    private javax.swing.JMenuItem exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane pane1;
    private javax.swing.JTextField text1;
    // End of variables declaration//GEN-END:variables
}
