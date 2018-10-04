/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicdemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
class Word{
    HashMap<String,String> data_E_V;
    HashMap<String,String> data_V_E;
    ArrayList<String> keys_E;
    ArrayList<String> keys_V;
    String[] DelKey_V;
    String[] DelKey_E;
    long index_E;
    long index_V;
    private static int k; // dem cac tu English bi xoa
    private static int k1; // dem cac tu VieNam bi xoa
    public Word(){
        k=0;
        k1=0;
        DelKey_E= new String[100];
        DelKey_V= new String[100];
        data_E_V=new HashMap<String,String>();
        data_V_E=new HashMap<String,String>();
        keys_E=new ArrayList<String>();
        keys_V=new ArrayList<String>();
        index_E=0;
        index_V=0;
    }
    
    public void showAllWord_E_V(){
        for (int i=0;i<index_E;i++){
            System.out.println(keys_E.get(i)+"\t"+data_E_V.get(keys_E.get(i)));
        }
    }
    public String[] getList_E_V(String Word){
        String[] list = new String[10000];
        int j=0;
        int t=0;
        
        //System.out.println("jj");
        for(int i=0;i<index_E;i++){
            String a=keys_E.get(i);
            t=0;
            if(a.indexOf(Word)==0) {
              for(int h=0;h<=k;h++){
                  if(a.equals(DelKey_E[h])){
                      t=1;
                  }
              }
              if(t==0){
                  list[j]= new String();
                  list[j] = a;
                  j++;
              }
              
            }
        }
        return list;
    }
    public String[] getList_V_E(String Word){
        String[] list = new String[10000];
        int t=0;
        int j=0;
        //System.out.println("jj");
        for(int i=0;i<index_V;i++){
            String a=keys_V.get(i);
            t=0;
            if(a.indexOf(Word)==0) {
              for(int h=0;h<=k1;h++){
                  if(a.equals(DelKey_V[h])){
                      t=1;
                  }
              }
              if(t==0){
                  list[j]= new String();
                  list[j] = a;
                  j++;
              }
              
            }
        }
        return list;
    }
    public void ReadFile_V_E(){
        BufferedReader reader;
         File path = new File("V_E.txt");
         String line,word,def;
         FileInputStream file;
         int index,index1;
         try {
              file = new FileInputStream(path);
              reader = new BufferedReader(new InputStreamReader(file));
             while ((line = reader.readLine()) != null) {
                 index = line.indexOf("<html>");
                 index1 = line.indexOf("<ul>");
               // System.out.println(line);
                if (index1 != -1 && index > index1) {
                    index = index1;
                }
                       

                if (index != -1) {
                    word = line.substring(0, index);
                    word = word.trim();
                    keys_V.add(word);
                    word = word.toLowerCase();
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
     public void ReadFile_E_V() {
         BufferedReader reader;
         File path = new File("E_V.txt");
         String line,word,def;
         FileInputStream file;
         int index,index1;
         try {
              file = new FileInputStream(path);
              reader = new BufferedReader(new InputStreamReader(file));
             while ((line = reader.readLine()) != null) {
                 index = line.indexOf("<html>");
                 index1 = line.indexOf("<ul>");
               // System.out.println(line);
                if (index1 != -1 && index > index1) {
                    index = index1;
                }
                       

                if (index != -1) {
                    word = line.substring(0, index);
                    word = word.trim();
                    keys_E.add(word);
                    word = word.toLowerCase();
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
          
         
     }
     public String getDic_E_V(String a){
         return data_E_V.get(a);
     }
     public String getDic_V_E(String a){
         return data_V_E.get(a);
     }
     public int editWord(String word, String explain, int n){
         if(n==0){
             if(data_E_V.get(word)==null) return 0;
             else {
                 data_E_V.remove(word);
                 data_E_V.put(word,explain);
             }
         }
         else if(n==1){
             if(data_V_E.get(word)==null) return 0;
             else {
                 data_V_E.remove(word);
                 data_V_E.put(word,explain);
             }
         }
         return 1;
     }
     public int delWord(String word, int n){
         if(n==0){
             if(data_E_V.get(word)==null) return 0;
             else {
                 data_E_V.remove(word);
                 DelKey_E[k] = new String();
                 DelKey_E[k]=word;
                 k++;
               //  keys_E.remove(word);
             }
         }
         if(n==1){
             if(data_V_E.get(word)==null) return 0;
             else {
                 data_V_E.remove(word);
                 DelKey_V[k1] = new String();
                 DelKey_V[k1]=word;
                 k1++;
            //     keys_V.remove(word);
             }
         }
         return 1;
    }
     public int releaseFile(String word, int n) throws FileNotFoundException, IOException{
         File path = new File("data.html");
         FileOutputStream file = new FileOutputStream(path);
         BufferedWriter write = new BufferedWriter(new OutputStreamWriter(file));
         if(n==0){
             if(data_E_V.get(word)==null) return 0;
             String a = data_E_V.get(word);
             write.write(a);
         }
         else if(n==1){
             if(data_E_V.get(word)==null) return 0;
             String a = data_V_E.get(word);
           //  String b = a.substring(a.indexOf("<i>")+2,a.indexOf("</i>"));
             write.write(a);
         }
         write.close();
         return 1;
     }
     public void addWord(String word, String explain, int n){
         if(n==0){
             System.out.println(n);
             data_E_V.put(word,explain);
             keys_E.add(word);
             index_E++;
         }
         else if(n==1){
             data_V_E.put(word,explain);
             keys_V.add(word);
              index_V++;
         }
         else {
             System.out.println("kjjkjk");
         }
     }
}
        
public class DicDemo{
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Word dic = new Word();
        dic.ReadFile_E_V();
        dic.ReadFile_V_E();
        int n=dic.releaseFile("a", 1);
        if(n==0) System.out.println("a");
       
        
        // TODO code application logic here
      // for(int j=0;j<10;j++) System.out.println(list[j]);
        //dic.showAllWord();
    }
}
