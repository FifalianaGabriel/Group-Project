/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud;

/**
 *
 * @author gabri
 */
public  class GenererId {
 
    public  String numero;
    public int num;
    public String prefixe;
 
    public  void GenererId(String id)
    {
        prefixe = id.substring(0, 2);
        numero = id.substring(2);
        numero= id.replaceAll("[^0-9]", "");
        num = Integer.parseInt(numero);
    }
}
