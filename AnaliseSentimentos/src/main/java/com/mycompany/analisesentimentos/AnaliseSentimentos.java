/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.analisesentimentos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AnaliseSentimentos {

    private static String caminhoPython = "C:\\Users\\jacks\\AppData\\Local\\Programs\\Python\\Python312\\python.exe";
    private static String caminhoScriptPython = "D:\\GitHub\\AnaliseSentimentosPythoneJava\\analise.py";

    public String AnaliseSentimentos(String texto) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder(caminhoPython, caminhoScriptPython);
        processBuilder.redirectErrorStream(true);
        Process processo = processBuilder.start();

        // Enviar o texto para o stdin do script Python
        try (OutputStreamWriter writer = new OutputStreamWriter(processo.getOutputStream(), StandardCharsets.UTF_8)) {
            writer.write(texto);
            writer.flush();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(processo.getInputStream(), StandardCharsets.UTF_8));
        String linha;
        StringBuilder saidaPython = new StringBuilder();
        while ((linha = reader.readLine()) != null) {
            saidaPython.append(linha).append("\n");
        }

        int codigoSaida = processo.waitFor();

        return saidaPython.toString() + (codigoSaida == 0 ? "" : "\nCódigo da saída: " + codigoSaida);
    }
}