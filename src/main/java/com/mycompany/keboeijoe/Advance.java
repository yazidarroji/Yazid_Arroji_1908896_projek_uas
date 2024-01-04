/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.keboeijoe;

/**
 *
 * @author yazidarroji
 */
// Kelas turunan kedua
public class Advance extends KeboeIjoe implements GamePlay {
    
    // Overloaded Constructor 2: Constructor dengan beberapa parameter
    public Advance() {
        // Inisialisasi nilai default
        playerHP = 10;
        KeboeIjoeHP = 20;
        playerWeapon = "Pisau";
    }
    public void callTownGate() {
        super.townGate(); // Memanggil metode townGate() dari kelas induk (Boncel)
    }
    public void callplayerSetUp() {
        super.playerSetUp(); // Memanggil metode townGate() dari kelas induk (Boncel)
    }
}