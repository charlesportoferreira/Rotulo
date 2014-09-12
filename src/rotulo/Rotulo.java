/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotulo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author charleshenriqueportoferreira
 */
public class Rotulo {

    public static String rotulo;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * @param args the command line arguments
         */
        String nomeArquivo = args[0];
        rotulo = "";

        try {
            rotulo = lerRotulo(nomeArquivo);
        } catch (IOException ex) {
            Logger.getLogger(Rotulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        String arquivoRotulado = "";
        try {
            arquivoRotulado = lerArquivo(args[1]);
        } catch (IOException ex) {
            Logger.getLogger(Rotulo.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            printFile(args[2], arquivoRotulado);
        } catch (IOException ex) {
            Logger.getLogger(Rotulo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String lerRotulo(String filePath) throws FileNotFoundException, IOException {
        StringBuilder linha = new StringBuilder();
        try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr)) {

            while (br.ready()) {
                String linhaLida = br.readLine();
                linha.append(linhaLida);
                //linha.append("\n");
            }
            br.close();
            fr.close();

        }
        return linha.toString();
    }

    public static String lerArquivo(String filePath) throws FileNotFoundException, IOException {
        StringBuilder linha = new StringBuilder();
        try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr)) {
            ArrayList<String[]> arrays = new ArrayList<>();

            while (br.ready()) {
                String linhaLida = br.readLine();
                if (linhaLida.equals("")) {
                    break;
                }
                linha.append(linhaLida);
                linha.append("\n");

            }
            linha.append(rotulo);
            br.close();
            fr.close();

        }
        return linha.toString();
    }

    public static void printFile(String fileName, String texto) throws IOException {
        try (FileWriter fw = new FileWriter(fileName); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(texto);
            bw.newLine();
            bw.close();
            fw.close();
        }
    }

    public static boolean pertenceALL(int numero) {
        return (numero >= 1 && numero <= 27)
                | (numero >= 39 && numero <= 39)
                | (numero >= 55 && numero <= 56)
                | (numero == 59)
                | (numero >= 67 && numero <= 72);

    }

}
