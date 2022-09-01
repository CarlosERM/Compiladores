package AnalisadorSemantico;

public class Analisador {
    Entrada ent;

    public Analisador(String arquivo) {
        this.ent = new Entrada(arquivo);
    }

    public Token proximoToken() {
        // Implementação inicial.
        //      Ignora espaços em branco.
        //      isread -1 sinaliza que ele terminou a leitura.
        int caractereLido = -1;
        while((caractereLido = ent.lerProximoCaractere()) != -1) {
            char c = (char) caractereLido;
            if( c == ' ' || c == '\n') {
                continue;
            }
        
            // token com um único caractere
            if(c == '*') {
                return new Token(TipoToken.OprAritMult, "*");
            } else if(c == '+') {
                return new Token(TipoToken.OprAritSoma, "+");
            }

            // tokens relacionais.
            // implementar uma lógica para dois caracteres
            else if(c == '<') {
                c = (char) ent.lerProximoCaractere();
                if(c == '>') {
                    return new Token(TipoToken.OprRelDif, "<>");
                } else if (c == '=') {
                    return new Token(TipoToken.OprRelMenorIgual, "<=");
                } else {
                    return new Token(TipoToken.OprRelMenor, "<");
                }
            }
        }
        return null;
    }

    
}
