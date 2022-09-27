package MeuAnalisadorSemantico;

public class MeuAnalisador {
    MinhaEntrada entrada;

    public MeuAnalisador(String arquivo) {
        this.entrada = new MinhaEntrada(arquivo);
    }

    public Token proximoToken() {
        // Implementação inicial.
        //      Ignora espaços em branco.
        //      isread -1 sinaliza que ele terminou a leitura.
        int caractereLido = -1;
        while((caractereLido = entrada.lerProximoCaractere()) != -1) {
            char c = (char) caractereLido; //se não for menos 1, converte pra caractere.
            if( c == ' ' || c == '\n') {
                continue;
            }
        
            // token com um único caractere
            if(c == '*') {
                return new Token(TipoToken.OperadorMultiplicacao, "*");
            } else if(c == '+') {
                return new Token(TipoToken.OperadorSoma, "+");
            } else if(c == '-') {
                return new Token(TipoToken.OperadorSubtracao, "-");
            } else if (c == '/') {
                return new Token(TipoToken.OperadorDivisao, "/");
            } 

            // tokens relacionais.
            // implementar uma lógica para dois caracteres
            else if(c == '<') {
                c = (char) entrada.lerProximoCaractere();
                if (c == '=') {
                    return new Token(TipoToken.OperadorMenorIgual, "<=");
                } else {
                    return new Token(TipoToken.OperadorMenor, "<");
                }
            }
            else if(c == '>') {
                c = (char) entrada.lerProximoCaractere();
                if (c == '=') {
                    return new Token(TipoToken.OperadorMaiorIgual, ">=");
                } else {
                    return new Token(TipoToken.OperadorMaior, ">");
                }
            }
            else if(c == '!') {
                c = (char) entrada.lerProximoCaractere();
                if (c == '=') { 
                    return new Token(TipoToken.OperadorDiferente, "!=");
                }
            }
            // Operadores Lógicos
            else if( c == 'S'){
                c = (char) entrada.lerProximoCaractere();
                if(c == 'e'){
                    c = (char) entrada.lerProximoCaractere();
                    if(c == 'n') {
                        c = (char) entrada.lerProximoCaractere();
                        if(c == 'a') {
                            c = (char) entrada.lerProximoCaractere();
                            if(c == 'o') {
                                c = (char) entrada.lerProximoCaractere(); 
                                if (c == ' ') {
                                    c = (char) entrada.lerProximoCaractere();
                                    if(c == 's') {
                                        c = (char) entrada.lerProximoCaractere();
                                        if(c == 'e') {
                                            return new Token(TipoToken.OperadorSenao, "Senao se");
                                        }
                                    }
                                } else {
                                    return new Token(TipoToken.OperadorSenao, "Senao");
                                }
                                return new Token(TipoToken.OperadorSenao, "Se");
                            }
                        }
                    } else {
                        return new Token(TipoToken.OperadorSe, "Se");
                    }
                }
            }
            else if(c =='|') {
                c = (char) entrada.lerProximoCaractere();
                if(c == '|') {
                    return new Token(TipoToken.OperadorOu, "Ou");
                }
            }
            else if(c =='&') {
                c = (char) entrada.lerProximoCaractere();
                if(c == '&') {
                    return new Token(TipoToken.OperadorE, "E");
                }
            }

            // Loops 
            else if (c == 'E') {
                c = (char) entrada.lerProximoCaractere();
                if(c == 'n') {
                    c = (char) entrada.lerProximoCaractere();
                    if(c == 'q') {
                        c = (char) entrada.lerProximoCaractere();
                        if(c == 'u') {
                            c = (char) entrada.lerProximoCaractere();
                            if(c == 'a') {
                                c = (char) entrada.lerProximoCaractere();
                                if(c == 'n') {
                                    c = (char) entrada.lerProximoCaractere();
                                    if(c == 't') {
                                        c = (char) entrada.lerProximoCaractere();
                                        if(c == 'o') {
                                            return new Token(TipoToken.OperadorEnquanto, "Enquanto");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else if(c == 'F') {
                c = (char) entrada.lerProximoCaractere();
                if(c == 'a') {
                    c = (char) entrada.lerProximoCaractere();
                    if(c == 'c') { 
                        c = (char) entrada.lerProximoCaractere();
                        if(c == 'a') { 
                            c = (char) entrada.lerProximoCaractere();
                            if(c == ' ') { 
                                c = (char) entrada.lerProximoCaractere();
                                if(c == 'e') { 
                                    c = (char) entrada.lerProximoCaractere();
                                    if(c == 'n') {
                                        c = (char) entrada.lerProximoCaractere();
                                            if(c == 'q') { 
                                                c = (char) entrada.lerProximoCaractere();
                                                if(c == 'u') { 
                                                    c = (char) entrada.lerProximoCaractere();
                                                    if(c == 'a') { 
                                                        c = (char) entrada.lerProximoCaractere();
                                                        if(c == 'n') { 
                                                            c = (char) entrada.lerProximoCaractere();
                                                            if(c == 't') { 
                                                                c = (char) entrada.lerProximoCaractere();
                                                                if(c == 'o') { 
                                                                    return new Token(TipoToken.OperadorFacaEnquanto, "Faça enquanto");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                    }
                                }
                            }
                        }
                    } 
                }
            } else if (c == 'P') {
                c = (char) entrada.lerProximoCaractere();
                if(c == 'a') { 
                    c = (char) entrada.lerProximoCaractere();
                    if(c == 'r') { 
                        c = (char) entrada.lerProximoCaractere();
                            if(c == 'a') { 
                                return new Token(TipoToken.OperadorPara, "Para");
                            }
                    } 
                }
            } 
            // Tipos de Variáveis
            // NumeroInteiro,
            // Cadeia,
            // NumeroReal,
            // NumeroRealGrande,
            // NumeroLogico,
            else if (c == 'I' ) {
                c = (char) entrada.lerProximoCaractere();
                if(c == 'n') { 
                    c = (char) entrada.lerProximoCaractere();
                    if(c == 't') { 
                        c = (char) entrada.lerProximoCaractere();
                        if(c == 'e') { 
                            c = (char) entrada.lerProximoCaractere();
                                if(c == 'i') { 
                                    c = (char) entrada.lerProximoCaractere();
                                    if(c == 'r') {
                                        c = (char) entrada.lerProximoCaractere();
                                        if(c == 'o') {
                                            return new Token(TipoToken.NumeroInteiro, "Inteiro");
                                        }
                                    }
                                }
                        }
                    }
                }
            }
            else if (c == 'C' ) {
                c = (char) entrada.lerProximoCaractere();
                if(c == 'a') { 
                    c = (char) entrada.lerProximoCaractere();
                    if(c == 'd') { 
                        c = (char) entrada.lerProximoCaractere();
                        if(c == 'e') { 
                            c = (char) entrada.lerProximoCaractere();
                                if(c == 'i') { 
                                    c = (char) entrada.lerProximoCaractere();
                                    if(c == 'a') {
                                        return new Token(TipoToken.Cadeia, "Cadeia");
                                    }
                                }
                        }
                    }
                }
            }
            else if (c == 'R' ) {
                c = (char) entrada.lerProximoCaractere();
                if(c == 'e') { 
                    c = (char) entrada.lerProximoCaractere();
                    if(c == 'a') { 
                        c = (char) entrada.lerProximoCaractere();
                        if(c == 'l') { 
                            return new Token(TipoToken.NumeroReal, "Real");
                        }
                    }
                }
            }
            else if (c == 'R' ) {
                c = (char) entrada.lerProximoCaractere();
                if(c == 'e') { 
                    c = (char) entrada.lerProximoCaractere();
                    if(c == 'a') { 
                        c = (char) entrada.lerProximoCaractere();
                        if(c == 'l') { 
                            c = (char) entrada.lerProximoCaractere();
                                if(c == 'G') { 
                                    c = (char) entrada.lerProximoCaractere();
                                    if(c == 'r') {
                                        c = (char) entrada.lerProximoCaractere();
                                        if(c == 'a') {
                                            c = (char) entrada.lerProximoCaractere();
                                            if(c == 'n') {
                                                c = (char) entrada.lerProximoCaractere();
                                                if(c == 'd') {
                                                    c = (char) entrada.lerProximoCaractere();
                                                    if(c == 'e') {
                                                        return new Token(TipoToken.NumeroRealGrande, "Real Grande");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                        }
                    }
                }
            }
            else if (c == 'L' ) {
                c = (char) entrada.lerProximoCaractere();
                if(c == 'o') { 
                    c = (char) entrada.lerProximoCaractere();
                    if(c == 'g') { 
                        c = (char) entrada.lerProximoCaractere();
                        if(c == 'i') { 
                            c = (char) entrada.lerProximoCaractere();
                                if(c == 'c') { 
                                    c = (char) entrada.lerProximoCaractere();
                                    if(c == 'o') {
                                        return new Token(TipoToken.NumeroLogico, "Lógico");
                                    }
                                }
                        }
                    }
                }
            }
        }
        return null;
    }
}
