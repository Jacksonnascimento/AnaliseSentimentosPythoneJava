/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analisesentimentos;

import java.io.IOException;

/**
 *
 * @author jacks
 */
public class Teste {
    public static void main(String[] args) throws IOException, InterruptedException {
        AnaliseSentimentos analise = new AnaliseSentimentos();
        String resultado = analise.AnaliseSentimentos("Nós somos lindos");
        System.out.println(resultado);
    }
}
