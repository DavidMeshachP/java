package study.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class IoBasics {

    public static void main(String args[]) {

        // 3 types of streams
        // system.out.
        System.out.println(" system.out.println ");

        // system.in. (ASCII code of 1st character)
        try {
            System.out.println("enter more than one character...");
            System.out.println(" system.in.read() " + (char) System.in.read());
        } catch (IOException e) {
            System.out.println(" error " + e);
        }

        // system.err.
        System.err.println(" system.err.println ");

        fileOutputWrite();
        fileOutputWriteString();
        fileInputStream();
        bufferedOutputStream();
        bufferedInputStream();
        sequentialInputStream();
        readFilesUsingSequentialInputStreamAndWrite();
        sequenceInputStreamReadDataUsingEnumeration();
        byteArrayOutputStream();
        byteArrayInputStream();
        dataOutputStream();
        dataInputStream();
        filterOutputStream();
        filterInputStream();

    }

    public static void fileOutputWrite() {
        try {
            FileOutputStream fout = new FileOutputStream("C:/Users/david/Downloads/fileoutputbytetestout.txt");
            fout.write(65);// byte value for A
            fout.close();
            System.out.println("success... file write output for byte...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void fileOutputWriteString() {
        try {
            FileOutputStream fout = new FileOutputStream("C:/Users/david/Downloads/fileoutputstringtestout.txt");
            String s = "Welcome to java,fileoutputwritestring.";
            byte b[] = s.getBytes();// converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("success... file write output for string ....");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void fileInputStream() {
        try {
            FileInputStream fin = new FileInputStream("C:/Users/david/Downloads/fileoutputstringtestout.txt");
            int i = 0;
            System.out.println(" The Characters are ... ");
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void bufferedOutputStream() {
        try {
            FileOutputStream fout = new FileOutputStream("C:/Users/david/Downloads/bufferedoutputstreamtestout.txt");
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            String s = "Welcome to java,bufferedoutputstream.";
            byte b[] = s.getBytes();
            bout.write(b);
            bout.flush();
            bout.close();
            fout.close();
            System.out.println("success... bufferedoutputstream...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void bufferedInputStream() {
        try {
            FileInputStream fin = new FileInputStream("C:/Users/david/Downloads/bufferedoutputstreamtestout.txt");
            BufferedInputStream bin = new BufferedInputStream(fin);
            int i;
            System.out.println(" bufferedInputStream ..");
            while ((i = bin.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();
            bin.close();
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void sequentialInputStream() {
        try {
            FileInputStream input1 = new FileInputStream("C:/Users/david/Downloads/fileoutputstringtestout.txt");
            FileInputStream input2 = new FileInputStream("C:/Users/david/Downloads/bufferedoutputstreamtestout.txt");
            SequenceInputStream inst = new SequenceInputStream(input1, input2);
            int j;
            System.out.println("sequentialInputStream....");
            while ((j = inst.read()) != -1) {
                System.out.print((char) j);
            }
            System.out.println();
            inst.close();
            input1.close();
            input2.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void readFilesUsingSequentialInputStreamAndWrite() {
        try {
            FileInputStream fin1 = new FileInputStream("C:/Users/david/Downloads/fileoutputstringtestout.txt");
            FileInputStream fin2 = new FileInputStream("C:/Users/david/Downloads/bufferedoutputstreamtestout.txt");
            FileOutputStream fout = new FileOutputStream("C:/Users/david/Downloads/sequentialoutputstreamtestout.txt");
            SequenceInputStream sis = new SequenceInputStream(fin1, fin2);
            int i;
            while ((i = sis.read()) != -1) {
                fout.write(i);
            }
            sis.close();
            fout.close();
            fin1.close();
            fin2.close();
            System.out.println("Success.. sequential write stream..");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void sequenceInputStreamReadDataUsingEnumeration() {
        try {
            FileInputStream fin = new FileInputStream("C:/Users/david/Downloads/fileoutputbytetestout.txt");
            FileInputStream fin2 = new FileInputStream("C:/Users/david/Downloads/fileoutputstringtestout.txt");
            FileInputStream fin3 = new FileInputStream("C:/Users/david/Downloads/bufferedoutputstreamtestout.txt");
            FileInputStream fin4 = new FileInputStream("C:/Users/david/Downloads/sequentialoutputstreamtestout.txt");
            Vector v = new Vector();
            v.add(fin);
            v.add(fin2);
            v.add(fin3);
            v.add(fin4);
            Enumeration e = v.elements();
            SequenceInputStream bin = new SequenceInputStream(e);
            int i = 0;
            System.out.println("sequence input stream data using enumeration.....");
            while ((i = bin.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();
            bin.close();
            fin.close();
            fin2.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // it is used where we need to write the same data in two or more files.
    public static void byteArrayOutputStream() {
        try {
            FileOutputStream fout1 = new FileOutputStream("C:/Users/david/Downloads/bytearrayoutputstream1testout.txt");
            FileOutputStream fout2 = new FileOutputStream("C:/Users/david/Downloads/bytearrayoutputstream2testout.txt");

            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            bout.write(65);
            bout.writeTo(fout1);
            bout.writeTo(fout2);

            bout.flush();
            bout.close();
            System.out.println("Success... byte array output stream ");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void byteArrayInputStream() {
        try {
            FileInputStream fis = new FileInputStream("C:/Users/david/Downloads/fileoutputstringtestout.txt");
            byte[] byteArr = new byte[(int) fis.available()];
            fis.read(byteArr);
            ByteArrayInputStream byt = new ByteArrayInputStream(byteArr);
            int k = 0;
            System.out.println("byte array input stream ..............");
            while ((k = byt.read()) != -1) {
                char ch = (char) k;
                System.out.println("ASCII value of Character is:" + k + "; Special character is: " + ch);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void dataOutputStream() {
        try {

            FileOutputStream fout = new FileOutputStream("C:/Users/david/Downloads/dataoutputstreamtestout.txt");
            DataOutputStream data = new DataOutputStream(fout);
            data.writeInt(65);
            data.writeInt(70);
            data.writeInt(75);
            data.writeInt(66);
            data.flush();
            data.close();
            System.out.println("success......dataoutputstream......................");

        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public static void dataInputStream() {
        try {

            InputStream input = new FileInputStream("C:/Users/david/Downloads/dataoutputstreamtestout.txt");
            DataInputStream dataInput = new DataInputStream(input);
            int count = input.available();
            byte[] byteArr = new byte[count];
            dataInput.read(byteArr);
            System.out.println("datainptstream values are...........");
            for (byte b : byteArr) {
                if (b != 0) {
                    System.out.print(((char) b) + "-");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void filterOutputStream() {
        try {
            FileOutputStream file = new FileOutputStream("C:/Users/david/Downloads/filteroutputstreamtestout.txt");
            FilterOutputStream filter = new FilterOutputStream(file);
            String s = "Welcome to java filteroutputstream.";
            byte b[] = s.getBytes();
            filter.write(b);
            filter.flush();
            filter.close();
            System.out.println("success....... filterOutputstream ...........");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void filterInputStream() {
        try {
            FileInputStream file = new FileInputStream("C:/Users/david/Downloads/filteroutputstreamtestout.txt");
            FilterInputStream filter = new BufferedInputStream(file);
            int k = 0;
            System.out.println("data of filterinputstream.......");
            while((k=filter.read())!=-1){  
                System.out.print((char)k);  
            }  
            filter.close();
    
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}