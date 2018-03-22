package br.boaventura.cripto.backend;

/**
 * Classe responsável por implementar operações basedas na lógica da "Cifra de
 * César".
 * <p>
 * São elas: Criptografar (encrypt) e Descriptografar (decrypt).
 *
 * @author Alan Boaventura
 */
public class CifraDeBoaventura {

    /**
     * Criptografa um determinado texto com uma determinada chave.
     *
     * @param text Texto a ser criptografado.
     * @param key Chave que será utilizada para criptografar o texto.
     * @return O texto criptografado.
     */
    public static String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();
        int textSize = text.length();

        for (int i = 0; i < textSize; i++) {
            char charAt = text.charAt(i);

            if (!Character.isAlphabetic(charAt)) { // Se for um espaço ou digito, apenas o concatena com o resultado.
                encryptedText.append(charAt);
                continue;
            }

            if (charAt >= 97 && charAt <= 122) { // Letras minusculas na tabela ASCII.
                char encryptedCaracter;

                if (charAt + key > 122) {
                    encryptedCaracter = (char) (((charAt + key) - 122) + 96);
                } else {
                    encryptedCaracter = (char) (charAt + key);
                }

                // Transforma o caracter ASCII criptografado em caracter de novo (cast pra char).
                encryptedText.append((char) encryptedCaracter);
            }

            if (charAt >= 65 && charAt <= 90) { // Letras maiusculas na tabela ASCII.
                char encryptedCaracter;

                if (charAt + key > 90) {
                    encryptedCaracter = (char) (((charAt + key) - 90) + 64);
                } else {
                    encryptedCaracter = (char) (charAt + key);
                }

                // Transforma o caracter ASCII criptografado em caracter de novo (cast pra char).
                encryptedText.append((char) encryptedCaracter);
            }
        }

        return encryptedText.toString();
    }

    /**
     * Descriptografa um determinado texto com uma determinada chave.
     *
     * @param encryptedText Texto a ser descriptografado.
     * @param key Chave que será utilizada para descriptografar o texto.
     * @return O texto descriptografado.
     */
    public static String decrypt(String encryptedText, int key) {
        StringBuilder decryptedText = new StringBuilder();
        int textSize = encryptedText.length();

        for (int i = 0; i < textSize; i++) {
            char charAt = encryptedText.charAt(i);

            if (!Character.isAlphabetic(charAt)) { // Se for um espaço ou digito, apenas o concatena com o resultado.
                decryptedText.append(charAt);
                continue;
            }

            if (charAt >= 97 && charAt <= 122) { // Letras minusculas na tabela ASCII.
                char encryptedCaracter;

                if (charAt - key < 97) {
                    encryptedCaracter = (char) (((charAt - key) + 122) - 96);
                } else {
                    encryptedCaracter = (char) (charAt - key);
                }

                // Transforma o caracter ASCII descriptografado em caracter de novo (cast pra char).
                decryptedText.append((char) encryptedCaracter);
            }

            if (charAt >= 65 && charAt <= 90) { // Letras maiusculas na tabela ASCII.
                char encryptedCaracter;

                if (charAt - key < 65) {
                    encryptedCaracter = (char) (((charAt - key) + 90) - 64);
                } else {
                    encryptedCaracter = (char) (charAt - key);
                }

                // Transforma o caracter ASCII descriptografado em caracter de novo (cast pra char).
                decryptedText.append((char) encryptedCaracter);
            }
        }

        return decryptedText.toString();
    }
}
