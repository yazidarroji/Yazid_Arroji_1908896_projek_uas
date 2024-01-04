/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.keboeijoe;

/**
 *
 * @author yazidarroji
 */
// Kelas turunan khusus
public class Custom extends KeboeIjoe implements GamePlay {
     // Overloaded Constructor 2: Constructor dengan beberapa parameter
    public Custom(String playerName, int playerHP, int KeboeIjoeHP, String playerWeapon) {
        this.playerName = playerName;
        this.playerHP = playerHP;
        this.KeboeIjoeHP = KeboeIjoeHP;
        this.playerWeapon = playerWeapon;
    }
    public void playerSetUp() {
        // Implementing
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("HP(Health Point) Anda: " + playerHP);
        System.out.println("HP(Health Point) Keboe Ijoe: " + KeboeIjoeHP);
        System.out.println("Senjata Anda: " + playerWeapon);
        System.out.println("Hello " + playerName + ", Mari Mulai Bermain!");
    }
    public void callTownGate() {
        super.townGate(); // Memanggil metode townGate() dari kelas induk (Boncel)
    }
}

