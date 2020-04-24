package IO;
import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {
    OutputStream out;

    public MyCompressorOutputStream(OutputStream out) {
        this.out=out;
    }

    @Override
    public void write(int i) throws IOException {


    }

    @Override
    public void write(byte[] b) throws IOException {
        int cnt1=0;
        int cnt0=0;
        int startPos=0;
       // super.write(b);
        for (int i=0;i<b.length;i++){

            //count zero
            startPos=i;
            while (  i<b.length && b[i] ==0){
                cnt0++;
                i++;
            }
            out.write(b,startPos,cnt0);
            cnt0=0;
            startPos=i;

            //count one
            while ( i<b.length && b[i] ==1 ) {
                cnt1++;
                i++;
            }
            out.write(b,startPos,cnt1);
            cnt1=0;
        }

    }


}
