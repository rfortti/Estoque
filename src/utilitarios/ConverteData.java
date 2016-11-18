/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilitarios;

/**
 *
 * @author Aluno
 */
public class ConverteData {
    
    public static String converteData(String data){
        String[] novaData = data.split("/");
        return novaData[2] + "-" + novaData[1] + "-" + novaData[0];
    }
    
    public static String desconverteData(String data){
        String[] novaData = data.split("-");
        return novaData[2] + "/" + novaData[1] + "/" + novaData[0];
    }
    
}
