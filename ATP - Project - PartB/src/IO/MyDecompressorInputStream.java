package IO;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.Arrays;
public class MyDecompressorInputStream extends InputStream {
    InputStream in;


    public MyDecompressorInputStream(InputStream in) {
        this.in = in;
    }

//    public byte[] copyArr(byte[] arr,int size){
//        byte[] b = new byte[arr.length+size];
//        for (int i=0;i<arr.length;i++){
//            b[i]=arr[i];
//        }
//        return  b;
//    }

    public int read(byte[] b) throws IOException{
            boolean flag=false;
            byte temp;
            int i=0;
            in.read(b,0,b.length);



            return 0;



        //        byte temp;
//       // byte[] b = new byte[0];
//        boolean flag=false;
//      //  byte[] bytesTemp;
//
//        while ((temp = (byte) in.read()) !=-1){
//
//         //   b = copyArr(b,temp);
//            for(int i=0;i<b.length;i++){
//                    if(!flag){
//                       b[i]=0;
//                    }
//                    else {
//                        b[i]=1;
//                    }
//                }
//            flag=!flag;
//        }
      //  return  b;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }
}
