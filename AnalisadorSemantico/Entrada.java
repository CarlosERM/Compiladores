package AnalisadorSemantico;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Entrada {
    InputStream is;

    public Entrada(String arquivo) {
        try {
            is = new FileInputStream(new File(arquivo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int lerProximoCaractere() {
        try {
            int ret = is.read();
            System.out.println((char)ret);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
