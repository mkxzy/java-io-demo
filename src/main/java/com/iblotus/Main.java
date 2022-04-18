package com.iblotus;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println("Hello world!");

        byte[] src = "IO is easy".getBytes();
        InputStream is = new ByteArrayInputStream(src);
        byte[] flush = new byte[1024];
        int len = -1;

        List<Byte> strBytes = new LinkedList<>();
        while ((len = is.read(flush)) != -1) {
            String str = new String(flush, 0, len);
            System.out.println(str);
        }

        InputStream in = new URL("http://www.baidu.com").openStream();

        try {
            InputStreamReader inR = new InputStreamReader(in);
            BufferedReader buf = new BufferedReader(inR);
            String line;
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            in.close();
        }
    }
}