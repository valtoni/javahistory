package org.github.valtoni.matrix.facilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OsDomainSocketChannels {

    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("netstat -an | findstr /C:\"AF_UNIX\" ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                // Use like socket.connect(UnixDomainSocketAddress.of("/var/run/apache/.s.apached.80");
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
