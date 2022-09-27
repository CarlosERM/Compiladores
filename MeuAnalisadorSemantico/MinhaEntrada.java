package MeuAnalisadorSemantico;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MinhaEntrada {
    InputStream arq;

    public MinhaEntrada(String arquivo) {
        try {
            arq = new FileInputStream(new File(arquivo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int lerProximoCaractere() {
        try {
            int caractere = arq.read();
            System.out.println((char)caractere);
            return caractere;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
