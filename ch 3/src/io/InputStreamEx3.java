package io;
// 2025.10.20

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamEx3 {
    public static void main(String[] args) {
        try (InputStream in = new FileInputStream("c:\\temp\\file1.txt");
                OutputStream out = new FileOutputStream("c:\\temp\\file3.txt");) {

            // InputStream in = new FileInputStream(new File(" "));
            // int input = in.read(); // 한 바이트씩 밖에 못 읽어와서 반복문을 쓴다

            int input = 0;
            while ((input = in.read()) != -1) { // 읽어오고 input에 대입 후 -1인지 아닌지 비교
                // System.out.print((char) input); // 한 바이트씩 읽어와서 한글 출력 불가능
                out.write(input);
            }
            // in.close();
            // out.close();
        } catch (IOException e) { // IOExceptiom이 FileNotFoundException의 부모라서 덮어쓴다
            e.printStackTrace();
        }
    }
}
