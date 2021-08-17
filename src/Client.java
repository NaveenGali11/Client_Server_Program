import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) throws IOException
    {
        long t1, t2;
        while(true)
        {
            try{
                Socket soc = new Socket("localhost",2000);
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                System.out.println("Type a string to ping : ");
                String str = br.readLine();
                OutputStream os = soc.getOutputStream();
                PrintWriter pw = new PrintWriter(os,true);
                InputStream in = soc.getInputStream();
                InputStreamReader inr = new InputStreamReader(in);
                BufferedReader br1 = new BufferedReader(inr);
                t1 = System.currentTimeMillis();
                pw.println(str);

                String str1 = br1.readLine();
                t2 = System.currentTimeMillis();
                System.out.println("Pinging "+soc.getInetAddress()+" with string "+str );
                System.out.println("Reply from "+soc.getInetAddress() +" String "+str1+" Length : "+str1.length());
                System.out.println("Sent : "+str.length()+" Received : "+str1.length()+" Lost : "+(str.length()-str1.length()));
                System.out.println("Approx. Time in Milliseconds  = "+(t2-t1));
            }
            catch(Exception e)
            {
                System.out.println("Error : "+e.getMessage());
            }
        }

    }

}