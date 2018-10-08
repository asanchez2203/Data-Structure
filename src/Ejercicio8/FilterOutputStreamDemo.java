package Ejercicio8;

import java.io.*;

public class FilterOutputStreamDemo {

    OutputStream os;
    FilterOutputStream fos;
    FileInputStream fis;
    byte[] buffer = {65, 66, 67, 68, 69};
    int i=0;
    char c;
    final String path="e8.txt";
    
    void open() throws IOException{
        //create output stream
        os=new FileOutputStream(path);
        fos=new FilterOutputStream(os);
    }
    
    void reporta() throws IOException{
        while((i=fis.read())!=-1){
            c=(char)i;
            System.out.println("Character Read: "+c);
        }
    }
    
    void lecturayreporta()throws IOException{
        //Create inputStreams
        try {
            fis=new FileInputStream(path);
            reporta();
        } catch (IOException e) {
            System.err.println("Can't read file");
        }
        fis.close();
    }
    
    public static void main(String[] args) throws IOException{
        FilterOutputStreamDemo fosd=new FilterOutputStreamDemo();
        try {
            fosd.open();
            //Writes Buffer to the output stream
            fosd.fos.write(fosd.buffer);
            //Forces contents written out the stream
            fosd.fos.flush();
        } catch (IOException e) {
            System.err.println("Close() is invoked prior to write");
        }finally{
            if (fosd.os!=null) {
                fosd.os.close();
            }
            if (fosd.fos!=null) {
                fosd.fos.close();
            }
            fosd.lecturayreporta();
        }
    }
}
