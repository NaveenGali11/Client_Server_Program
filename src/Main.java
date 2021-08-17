import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;
class Main {
    public static void main(String[] args) throws IOException
    {
        ServerSocket s = new ServerSocket(2000);
        while(true)
        {
            Socket c = s.accept();
            InputStream in = c.getInputStream();
            InputStreamReader inr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(inr);
            String str = br.readLine();
            System.out.println("Ping command received from : "+c.getInetAddress() +" with string "+str);
            PrintStream ps = new PrintStream(c.getOutputStream());
            ps.println(str);
        }
    }
}
