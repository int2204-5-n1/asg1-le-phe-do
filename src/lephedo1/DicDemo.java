/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lephedo1;

/**
 *
 * @author Dell
 */
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author Dell
 */
class Word {

    HashMap<String, String> data_E_V;
    HashMap<String, String> data_V_E;
    ArrayList<String> keys_E;
    ArrayList<String> keys_V;
    String[] DelKey_V;
    String[] DelKey_E;
    private static int index_E;
    private static int index_V;
    private static int del; 
    private static int k;  // dem cac tu English bi xoa
    private static int k1; // dem cac tu VieNam bi xoa

    public Word() {
        k = 0;
        k1 = 0;
        del = 0;
        DelKey_E = new String[100];
        DelKey_V = new String[100];
        data_E_V = new HashMap<String, String>();
        data_V_E = new HashMap<String, String>();
        keys_E = new ArrayList<String>();
        keys_V = new ArrayList<String>();
        index_E = 0;
        index_V = 0;
    }

    public void modify(String word, String defi, int n) throws IOException {
        if (n == 1) {
            delWord(word, n);
            File path = new File("data", "addWord_V.txt");
            if (!path.exists()) {
                try {
                    path.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(addWord_V.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            BufferedWriter bw = null;
            FileWriter fw = null;
            try {
                fw = new FileWriter(path.getAbsoluteFile(), true);
            } catch (IOException ex) {
                Logger.getLogger(addWord_V.class.getName()).log(Level.SEVERE, null, ex);
            }
            bw = new BufferedWriter(fw);
            String line = word + defi;
            bw.write(line + "\r\n");
            data_V_E.put(word, defi);
            keys_V.add(word);
            index_V++;
            bw.close();
            fw.close();

        } else if (n == 0) {
            delWord(word, n);
            File path = new File("data", "addWord_E.txt");
            if (!path.exists()) {
                try {
                    path.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(addWord_V.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            BufferedWriter bw = null;
            FileWriter fw = null;
            try {
                fw = new FileWriter(path.getAbsoluteFile(), true);
            } catch (IOException ex) {
                Logger.getLogger(addWord_V.class.getName()).log(Level.SEVERE, null, ex);
            }
            bw = new BufferedWriter(fw);
            String line = word + defi;
            bw.write(line + "\r\n");
            data_E_V.put(word, defi);
            keys_E.add(word);
            index_E++;
            bw.close();
            fw.close();
        }
    }

    public void addRecent(String word, int n) throws IOException {
        if (n == 0) {
            int t = 0;
            File path1 = new File("data", "recentWord_E.txt");
            BufferedReader reader = null;
            String line;
            FileInputStream file;

            try {
                file = new FileInputStream(path1);
                reader = new BufferedReader(new InputStreamReader(file,"UTF-8"));
                while ((line = reader.readLine()) != null) {

                    line = line.trim();
                    //   System.out.println(line);
                    if (line.equals(word)) {
                        t = 1;
                        break;
                    }
                    line = reader.readLine();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
            }
            reader.close();

            if (t == 0) {
                File path = new File("data", "recentWord_E.txt");
                BufferedWriter bw = null;
                FileWriter fw = null;
                fw = new FileWriter(path.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);
                bw.write(word + "\r\n");
                bw.close();
                fw.close();
            }

        } else if (n == 1) {

            // String[] list2 = ReadFile_Del();
            int t = 0;
            File path1 = new File("data", "recentWord_V.txt");
            BufferedReader reader = null;
            String line;
            FileInputStream file;

            try {
                file = new FileInputStream(path1);
                reader = new BufferedReader(new InputStreamReader(file,"UTF-8"));
                while ((line = reader.readLine()) != null) {

                    line = line.trim();
                    //   System.out.println(line);
                    if (line.equals(word)) {
                        t = 1;
                        break;
                    }
                    line = reader.readLine();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
            }
            reader.close();
            if (t == 0) {
                File path = new File("data", "recentWord_V.txt");
                BufferedWriter bw = null;
                FileWriter fw = null;
                fw = new FileWriter(path.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);
                bw.write(word + "\r\n");
                bw.close();
                fw.close();
            }
        }
    }

    public String[] getListRecent_E() throws IOException {

        File path = new File("data", "recentWord_E.txt");
        BufferedReader reader;
        String line;
        FileInputStream file;
        String[] list = new String[10000];
        int del1 = 0;
        try {
            file = new FileInputStream(path);
            reader = new BufferedReader(new InputStreamReader(file, "UTF-8"));
            while ((line = reader.readLine()) != null) {
                list[del1] = new String();
                line = line.trim();
                list[del1] = line;
                del1++;
                line = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] list1 = new String[10000];
        String[] list2 = ReadFile_Del();
        for (int i = del1 - 1; i >= 0; i--) {
            list1[del1 - 1 - i] = new String();
            list1[del1 - 1 - i] = list[i];
        }
        return list1;
    }

    public String[] getListRecent_V() {
        File path = new File("data", "recentWord_V.txt");
        BufferedReader reader;
        String line;
        FileInputStream file;
        String[] list = new String[10000];
        int del1 = 0;
        try {
            file = new FileInputStream(path);
            reader = new BufferedReader(new InputStreamReader(file, "UTF-8"));
            while ((line = reader.readLine()) != null) {
                list[del1] = new String();
                line = line.trim();
                //   System.out.println(line);
                list[del1] = line;
                del1++;

                line = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] list1 = new String[10000];
        for (int i = del1 - 1; i >= 0; i--) {
            list1[del1 - 1 - i] = new String();
            list1[del1 - 1 - i] = list[i];
        }
        return list1;
    }

    public void showAllWord_E_V() {
        for (int i = 0; i < index_E; i++) {
            System.out.println(keys_E.get(i) + "\t" + data_E_V.get(keys_E.get(i)));
        }
    }

    public String[] getList_E_V(String Word) throws IOException {
        String[] list = new String[10000];
        int j = 0;
        int t = 0;

        String[] list1 = ReadFile_Del();
        for (int i = 0; i < index_E; i++) {
            String a = keys_E.get(i).toString().toLowerCase();
            t = 0;
            if (a.indexOf(Word) == 0) {
                for (int j1 = 0; j1 < del; j1++) {
                    if (a.equals(list1[j1])) {
                        t = 1;
                    }
                }
                if (t == 0) {
                    list[j] = new String();
                    list[j] = a;
                    j++;
                }

            }
        }
        return list;
    }

    public String[] getList_V_E(String Word) throws IOException {
        String[] list = new String[10000];
        int t = 0;
        int j = 0;
        String[] list1 = ReadFile_Del();
        //System.out.println("jj");
        for (int i = 0; i < index_V; i++) {
            String a = keys_V.get(i).toString().toLowerCase();
            t = 0;
            if (a.indexOf(Word) == 0) {
                
                for (int j1 = 0; j1 < del; j1++) {
                    if (a.equals(list1[j1])) {
                        t = 1;
                    }
                }
                if (t == 0) {
                    list[j] = new String();
                    list[j] = a;
                    j++;
                }

            }
        }
        return list;
    }

    public String[] ReadFile_Del() throws FileNotFoundException, IOException {
        File path = new File("data", "delWord.txt");
        BufferedReader reader;
        String line;
        FileInputStream file;
        String[] list = new String[10000];
        del = 0;
        try {
            file = new FileInputStream(path);
            reader = new BufferedReader(new InputStreamReader(file, "UTF-8"));
            while ((line = reader.readLine()) != null) {
                list[del] = new String();
                line = line.trim();
                //   System.out.println(line);
                list[del] = line;
                del++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void ReadFile_V_E() throws IOException {
        BufferedReader reader;
        File path = new File("data", "V_E.txt");
        String line, word, def;
        FileInputStream file;
        int index, index1;

        String[] list1 = ReadFile_Del();
        try {
            file = new FileInputStream(path);
            reader = new BufferedReader(new InputStreamReader(file, "UTF-8"));
            while ((line = reader.readLine()) != null) {
                index = line.indexOf("<html>");
                index1 = line.indexOf("<ul>");
                if (index1 != -1 && index > index1) {
                    index = index1;
                }
                int k2 = 1;
                if (index != -1) {
                    word = line.substring(0, index);
                    word = word.trim();
                    word = word.toLowerCase();
                    keys_V.add(word);
                    int j = 0;
                    while (j < del) {
                        //     System.out.println(list1[j]);
                        if (list1[j].equals(word)) {
                            k2 = 0;
                            break;
                        }
                        j++;
                    }

                    def = line.substring(index);
                    if (k2 == 1) {

                        data_V_E.put(word, def);
                        index_V++;
                    }

                    // System.out.println(index2);
                }
            }
            reader.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        }
        // BufferedReader reader;
        path = new File("data", "addWord_V.txt");
        // String[] list1 = ReadFile_Del();
        try {
            file = new FileInputStream(path);
            reader = new BufferedReader(new InputStreamReader(file, "UTF-8"));
            while ((line = reader.readLine()) != null) {
                index = line.indexOf("<html>");
                index1 = line.indexOf("<ul>");
                if (index1 != -1 && index > index1) {
                    index = index1;
                }

                if (index != -1) {
                    word = line.substring(0, index);
                    // word = word.trim();
                    word = word.toLowerCase();
                    keys_V.add(word);

                    def = line.substring(index);
                    data_V_E.put(word, def);
                    index_V++;

                    // System.out.println(index2);
                }
            }
            reader.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ReadFile_E_V() throws IOException {
        BufferedReader reader;
        File path = new File("data", "E_V.txt");
        String line, word, def;
        FileInputStream file;
        int index, index1;
        try {
            file = new FileInputStream(path);
            reader = new BufferedReader(new InputStreamReader(file, "UTF-8"));
            String[] list1 = ReadFile_Del();
            while ((line = reader.readLine()) != null) {
                index = line.indexOf("<html>");
                index1 = line.indexOf("<ul>");
                // System.out.println(line);
                if (index1 != -1 && index > index1) {
                    index = index1;
                }

                int k2 = 1;
                if (index != -1) {
                    word = line.substring(0, index);
                    word = word.trim();
                    keys_E.add(word);
                    word = word.toLowerCase();
                    int j = 0;
                    while (j < del) {
                        //             System.out.println(list1[j]);
                        if (list1[j].equals(word)) {
                            k2 = 0;
                            break;
                        }
                        j++;
                    }

                    def = line.substring(index);
                    if (k2 == 1) {
                        data_E_V.put(word, def);
                        index_E++;
                    }
                    /////
                    // System.out.println(index2);
                }
            }
            reader.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        }
        path = new File("addWord_E.txt");

        // String[] list1 = ReadFile_Del();
        try {
            file = new FileInputStream(path);
            reader = new BufferedReader(new InputStreamReader(file));
            while ((line = reader.readLine()) != null) {
                index = line.indexOf("<html>");
                index1 = line.indexOf("<ul>");
                if (index1 != -1 && index > index1) {
                    index = index1;
                }

                if (index != -1) {
                    word = line.substring(0, index);
                    //  word = word.trim();
                    word = word.toLowerCase();
                    keys_E.add(word);

                    def = line.substring(index);

                    data_E_V.put(word, def);
                    index_E++;

                    // System.out.println(index2);
                }
            }
            reader.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        }

        // BufferedReader reader;
    }

    public String getDic_E_V(String a) {
        return data_E_V.get(a);
    }

    public String getDic_V_E(String a) {
        return data_V_E.get(a);
    }

    public int delWord(String word, int n) throws IOException {
        if (n == 0) {
            if (data_E_V.get(word) == null) {
                return 0;
            } else {
                data_E_V.remove(word);
                DelKey_E[k] = new String();
                DelKey_E[k] = word;
                k++;
                //  keys_E.remove(word);
            }
        }
        if (n == 1) {
            if (data_V_E.get(word) == null) {
                return 0;
            } else {
                data_V_E.remove(word);
                DelKey_V[k1] = new String();
                DelKey_V[k1] = word;
                k1++;
                //     keys_V.remove(word);
            }
        }
        File path = new File("data", "delWord.txt");
        if (!path.exists()) {
            path.createNewFile();
        }
        BufferedWriter bw = null;
        FileWriter fw = null;
        fw = new FileWriter(path.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        bw.write(word + "\r\n");
        bw.close();
        fw.close();
        return 1;
    }

    public int releaseFile(String word, int n) throws FileNotFoundException, IOException {
        File path = new File("data", "word.html");
        FileOutputStream file = new FileOutputStream(path);
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(file));
        if (n == 0) {
            String a = data_E_V.get(word);
            write.write(a);
        } else if (n == 1) {
            
            String a = data_V_E.get(word);
            write.write(a);
        }
        write.close();
        return 1;
    }

    public void addWord(int no) throws IOException {

        if (no == 0) {
            addWord_E add = new addWord_E();
            // System.out.println(n);
            // data_E_V.put(word,explain);
            //  keys_E.add(word);

        }
        if (no == 1) {
            addWord_V add = new addWord_V();
        }

    }

    class addWord_E extends JFrame {

        private JTextPane textPane1;
        private JTextPane textPane2;
        private JPanel contentPane;
        private JButton btnAdd;
        public JTextArea textArea;
        public JTextArea textArea_1;
        private String a;
        private String b;
        public int t;
        public int n;

        public addWord_E() {
            n = 0;
            creatAndShow();
        }

        public void creatAndShow() {
            t = -1;
            //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(500, 300, 500, 500);
            this.setResizable(false);
            contentPane = new JPanel();
            contentPane.setBackground(SystemColor.controlHighlight);
            contentPane.setBorder(null);
            setContentPane(contentPane);
            contentPane.setLayout(null);
            btnAdd = new JButton("ADD");

            btnAdd.setBackground(SystemColor.textHighlight);
            btnAdd.setBounds(185, 300, 100, 35);
            contentPane.add(btnAdd);
            textArea = new JTextArea();
            textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            textArea.setBounds(10, 117, 300, 150);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            contentPane.add(textArea);
            textArea.setText("");
            textArea_1 = new JTextArea();
            textArea_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            textArea_1.setBounds(10, 11, 264, 95);
            textArea_1.setLineWrap(true);
            textArea_1.setWrapStyleWord(true);
            textArea_1.setText("");
            contentPane.add(textArea_1);
            JScrollPane scrollPane = new JScrollPane(textArea_1);
            scrollPane.setBounds(20, 50, 400, 95);
            contentPane.add(scrollPane);
            JScrollPane scrollPane_1 = new JScrollPane(textArea);
            scrollPane_1.setBounds(20, 200, 400, 95);
            contentPane.add(scrollPane_1);
            this.setVisible(true);
            btnAdd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        a = textArea_1.getText().toString();
                        b = textArea.getText().toString();  // lấy nghĩa của từ 
                        //  a = a.toLowerCase();
                        //  b = b.toLowerCase();
                        String a1 = "<i>" + a + "</i><br/><ul><li><font color='#cc0000'><b>" + b + "</b></font></li></ul></html>";

                        data_E_V.put(a, a1);
                        keys_E.add(a);
                        index_E++;
                        File path = null;
                        path = new File("data", "addWord_E.txt");
                        //  if(n==1) path = new File("addWord_V.txt");
                        if (!path.exists()) {
                            try {
                                path.createNewFile();
                            } catch (IOException ex) {
                                Logger.getLogger(addWord_E.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        BufferedWriter bw = null;
                        FileWriter fw = null;
                        try {
                            fw = new FileWriter(path.getAbsoluteFile(), true);
                        } catch (IOException ex) {
                            Logger.getLogger(addWord_E.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        bw = new BufferedWriter(fw);
                        String line = a + "<html><i>" + a + "</i><br/><ul><li><font color='#cc0000'><b>" + b + "</b></font></li></ul></html>";
                        bw.write(line + "\r\n");

                        bw.close();
                        fw.close();
                        if (a.equals("") || b.equals("")) {
                            JOptionPane.showMessageDialog(rootPane, "Failed", "DIC_UET", HEIGHT);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Add new word successfully");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(addWord_E.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            JLabel label = new JLabel();
            label.setBounds(20, 10, 200, 50);
            label.setText("Write new word here: ");
            label.setVisible(true);
            this.add(label);
            JLabel label1 = new JLabel();
            label1.setBounds(20, 156, 200, 50);
            label1.setText("Write defintion here: ");
            label1.setVisible(true);
            this.add(label1);
        }

    }

    class addWord_V extends JFrame {

        private JTextPane textPane1;
        private JTextPane textPane2;
        private JPanel contentPane;
        private JButton btnAdd;
        public JTextArea textArea;
        public JTextArea textArea_1;
        private String a;
        private String b;
        public int t;

        public addWord_V() {
            creatAndShow();
        }

        public void creatAndShow() {
            t = -1;
            //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(500, 300, 500, 500);
            this.setResizable(false);
            contentPane = new JPanel();
            contentPane.setBackground(SystemColor.controlHighlight);
            contentPane.setBorder(null);
            setContentPane(contentPane);
            contentPane.setLayout(null);
            btnAdd = new JButton("ADD");

            btnAdd.setBackground(SystemColor.textHighlight);
            btnAdd.setBounds(185, 300, 100, 35);
            contentPane.add(btnAdd);
            textArea = new JTextArea();
            textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            textArea.setBounds(10, 117, 300, 150);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            contentPane.add(textArea);
            textArea.setText("");
            textArea_1 = new JTextArea();
            textArea_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            textArea_1.setBounds(10, 11, 264, 95);
            textArea_1.setLineWrap(true);
            textArea_1.setWrapStyleWord(true);
            textArea_1.setText("");
            contentPane.add(textArea_1);
            JScrollPane scrollPane = new JScrollPane(textArea_1);
            scrollPane.setBounds(20, 50, 400, 95);
            contentPane.add(scrollPane);
            JScrollPane scrollPane_1 = new JScrollPane(textArea);
            scrollPane_1.setBounds(20, 200, 400, 95);
            contentPane.add(scrollPane_1);
            this.setVisible(true);
            btnAdd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        a = textArea_1.getText().toString();
                        b = textArea.getText().toString();
                        //  a = a.toLowerCase();
                        //  b = b.toLowerCase();
                        String a1 = "<i>" + a + "</i><br/><ul><li><font color='#cc0000'><b>" + b + "</b></font></li></ul></html>";

                        data_V_E.put(a, a1);
                        keys_V.add(a);
                        index_V++;
                        File path = new File("data", "addWord_V.txt");
                        if (!path.exists()) {
                            try {
                                path.createNewFile();
                            } catch (IOException ex) {
                                Logger.getLogger(addWord_V.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        BufferedWriter bw = null;
                        FileWriter fw = null;
                        try {
                            fw = new FileWriter(path.getAbsoluteFile(), true);
                        } catch (IOException ex) {
                            Logger.getLogger(addWord_V.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        bw = new BufferedWriter(fw);
                        String line = a + "<html><i>" + a + "</i><br/><ul><li><font color='#cc0000'><b>" + b + "</b></font></li></ul></html>";
                        bw.write(line + "\r\n");

                        bw.close();
                        fw.close();
                        if (a.equals("") || b.equals("")) {
                            JOptionPane.showMessageDialog(rootPane, "Failed", "DIC_UET", HEIGHT);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Add new word successfully");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(addWord_V.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            JLabel label = new JLabel();
            label.setBounds(20, 10, 200, 50);
            label.setText("Write new word here: ");
            label.setVisible(true);
            this.add(label);
            JLabel label1 = new JLabel();
            label1.setBounds(20, 156, 200, 50);
            label1.setText("Write defintion here: ");
            label1.setVisible(true);
            this.add(label1);

        }

        // btnAdd.setActionCommand("d");
        //       btnAdd.addActionListener(this);
    }
}

public class DicDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //    addWord_V cc = new addWord_V();

        // TODO code application logic here
        // for(int j=0;j<10;j++) System.out.println(list[j]);
        //dic.showAllWord();
    }
}


/*
class addWord_E extends JFrame {

    private JTextPane textPane1;
    private JTextPane textPane2;
    private JPanel contentPane;
    private JButton btnAdd;
    public JTextArea textArea;
    public JTextArea textArea_1;
    private static String a;
    private static String b;
    public static int t;
    public int n;

    public addWord_E() {
        n = 0;
        creatAndShow();
    }

    public void creatAndShow() {
        t = -1;
        //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 300, 500, 500);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.controlHighlight);
        contentPane.setBorder(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        btnAdd = new JButton("ADD");

        btnAdd.setBackground(SystemColor.textHighlight);
        btnAdd.setBounds(185, 300, 100, 35);
        contentPane.add(btnAdd);
        textArea = new JTextArea();
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textArea.setBounds(10, 117, 300, 150);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        contentPane.add(textArea);
        textArea.setText("");
        textArea_1 = new JTextArea();
        textArea_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textArea_1.setBounds(10, 11, 264, 95);
        textArea_1.setLineWrap(true);
        textArea_1.setWrapStyleWord(true);
        textArea_1.setText("");
        contentPane.add(textArea_1);
        JScrollPane scrollPane = new JScrollPane(textArea_1);
        scrollPane.setBounds(20, 50, 400, 95);
        contentPane.add(scrollPane);
        JScrollPane scrollPane_1 = new JScrollPane(textArea);
        scrollPane_1.setBounds(20, 156, 400, 95);
        contentPane.add(scrollPane_1);
        this.setVisible(true);
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    a = textArea_1.getText().toString();
                    b = textArea.getText().toString();
                    a = a.toLowerCase();
                    b = b.toLowerCase();
                    File path = null;
                    path = new File("addWord_E.txt");
                    //  if(n==1) path = new File("addWord_V.txt");
                    if (!path.exists()) {
                        try {
                            path.createNewFile();
                        } catch (IOException ex) {
                            Logger.getLogger(addWord_E.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    BufferedWriter bw = null;
                    FileWriter fw = null;
                    try {
                        fw = new FileWriter(path.getAbsoluteFile(), true);
                    } catch (IOException ex) {
                        Logger.getLogger(addWord_E.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    bw = new BufferedWriter(fw);
                    String line = a + "<html><i>" + a + "</i><br/><ul><li><font color='#cc0000'><b>" + b + "</b></font></li></ul></html>";
                    bw.write(line + "\r\n");
                    bw.close();
                    fw.close();
                    if (a.equals("") || b.equals("")) {
                        JOptionPane.showMessageDialog(rootPane, "Failed", "DIC_UET", HEIGHT);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Add new word successfully");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(addWord_E.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    // btnAdd.setActionCommand("add");
    //       btnAdd.addActionListener(this);
}
 */
