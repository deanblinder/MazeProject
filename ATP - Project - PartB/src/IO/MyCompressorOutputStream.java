package IO;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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
        byte c,p;
        int cnt =0;
       // HashMap<String,Integer> table =new HashMap<>();
        List<String> comp = new ArrayList<>();
        p=b[0];
        String sc;
        String sp = String.valueOf(p);

       // table.put(sp,cnt);
        comp.add(sp);
        cnt++;
        for (int i=1;i<b.length;i++){
             p=b[i];
             sp = String.valueOf(p);
             if(i+1<b.length) {
                 c = b[i + 1];
                 sc = String.valueOf(c);
             }
            // while (table.containsKey(sp) && i+1 <b.length){
                 while (comp.contains(sp) && i+1 <b.length){
                 c =b[i+1];
                 sc = String.valueOf(c);
                 sp=sp+sc;
                 i++;
             }
            // table.put(sp,cnt);
            comp.add(sp);
            cnt++;
            // p = b[i];
             //sp = String.valueOf(p);
//            if(table.containsKey(sp+sc) ){
//                 sp=sp+sc;
//            }
//            else{
//                //out the code for p.
//                table.put(sp+sc,cnt);
//                cnt++;
//                sp=sc;
//            }


        }
        byte[] bytaArr = new byte[comp.size()];
        for(int i=0;i<bytaArr.length;i++){
            String tmp =  comp.get(i);
            for (int j=0;j<tmp.length();j++) {
                if(tmp.charAt(j)=='0') {
                    bytaArr[i] = (byte) 0;
                }
                else {
                    bytaArr[i] = (byte) 1;
                }
            }
            
        }
        out.write(bytaArr,0,bytaArr.length);

        //System.out.println();

    }


}
