/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.keboeijoe;

/**
 *
 * @author yazidarroji
 */
// Kelas turunan pertama

public class Easy extends KeboeIjoe implements GamePlay {
   
    // Overloaded Constructor 
    public Easy() {
        // Inisialisasi nilai default
        playerHP = 20;
        KeboeIjoeHP = 10;
        playerWeapon = "Panah";
    }
    public void callTownGate() {
        super.townGate(); // Memanggil metode townGate() dari kelas induk (Boncel)
    }
    public void callplayerSetUp() {
        super.playerSetUp(); // Memanggil metode townGate() dari kelas induk (Boncel)
    }
}
