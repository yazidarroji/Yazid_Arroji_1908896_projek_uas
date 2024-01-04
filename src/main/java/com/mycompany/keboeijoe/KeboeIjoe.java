/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.keboeijoe;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author yazidarroji
 */
// Kelas turunan pertama abstract
public abstract class KeboeIjoe implements GamePlay {
    // Implementasi encapsulation modifier yang dapat diakses kelas turunan
    //memanfaatkan struktur data array list
    protected ArrayList<String> inventory = new ArrayList<>();
    protected Scanner myScanner = new Scanner(System.in);
    protected Scanner enterScanner = new Scanner(System.in);
    protected int playerHP;
    protected String playerName;
    protected String playerWeapon;
    protected int choice;
    protected int KeboeIjoeHP;
    protected int silverRing;

    public static void main(String[] args) {
        
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Selamat Datang\nSelamat Bermain\nTaklukan Keboe Ijoe sebagai musuh anda untuk bisa masuk ke kota");
        System.out.println("Pilih Level Bermain Anda");
        System.out.println("1. Mudah");
        System.out.println("2. Sulit");
        System.out.println("3. Setting Sesuai Kemauan Anda");
        System.out.println("Pilih Level: ");
        //event handling
        try {
            int pilihanLevel = inputScanner.nextInt();
            inputScanner.nextLine();
            if (pilihanLevel == 1) {
                Easy gampang = new Easy();
                gampang.callplayerSetUp();
                gampang.callTownGate();
            } else if (pilihanLevel == 2) {
                Advance sulit = new Advance();
                sulit.callplayerSetUp();
                sulit.callTownGate();
            } else if (pilihanLevel == 3) {
                System.out.println("Tolong Masukan Nama Anda: ");
                String playerName = inputScanner.nextLine();
//                inputScanner.nextLine();// Consuming the leftover newline
                System.out.println("Setting HP(Health Point) anda: ");
                int playerHP = inputScanner.nextInt();
                inputScanner.nextLine(); // Consuming the leftover newline
                System.out.println("Setting HP(Health Point) Keboe Ijoe: ");
                int monsterHP = inputScanner.nextInt();
                inputScanner.nextLine(); // Consuming the leftover newline
                System.out.println("Setting Senjata Anda: ");
                String playerWeapon = inputScanner.nextLine();
                Custom settingan = new Custom(playerName, playerHP, monsterHP, playerWeapon);
                settingan.playerSetUp();
                settingan.callTownGate();
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Mohon masukkan angka.");
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Terjadi kesalahan dalam pembacaan input.");
        } finally {
            inputScanner.close(); 
        }
    }
    @Override
    public void townGate() {
      
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("Anda telah memasuki gerbang kota.");
                System.out.println("Temukan senjata baru dengan berpetualang ke arah mata angin.");
		System.out.println("Seorang penjaga berdiri di depan Anda.");
		System.out.println("");
		System.out.println("Apa yang ingin anda lakukan?");
		System.out.println("");
		System.out.println("1: Bicaralah dengan penjaga");
		System.out.println("2: Serang Penjaga");
		System.out.println("3: Pergi");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) {
			if (silverRing == 1) {
				ending();
			} else {
				System.out.println("Penjaga: Halo, orang asing. Jadi namamu adalah " + playerName
						+ "? \nMaaf tapi kami tidak bisa membiarkan orang asing memasuki kota kami.\nSebelum Anda membunuh Keboe Ijoe.");
				enterScanner.nextLine();
				townGate();
			}

		} else if (choice == 2) {
			playerHP = playerHP - 1;
			System.out.println(
					"Penjaga: Hei, jangan bodoh.\n\nPenjaga itu memukulmu dengan keras dan kamu menyerah.\n(Anda menerima 1 damage)\n");
			System.out.println("HP(Health Point) Anda: " + playerHP);
                        if (playerHP < 1) {
                            dead();
			}else{
                           enterScanner.nextLine();
                           townGate();
                        } 
		} else if (choice == 3) {
			crossRoad();
		} else {
			townGate();
		}
    }
    //polymorphism
    @Override
    public void north() {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("Ada sebuah sungai.\nAnda minum airnya dan beristirahat di tepi sungai.");
            System.out.println("HP(Health Point) Anda Bertambah.");
            playerHP = playerHP + 1;
            System.out.println("HP(Health Point) Anda: " + playerHP);
            System.out.println("\n\n1: Kembali ke persimpangan jalan");
            System.out.println("\n------------------------------------------------------------------\n");

            choice = myScanner.nextInt();

            if (choice == 1) {
                    crossRoad();
            } else {
                    north();
            }
    }
    @Override
    public void east() {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("Anda berjalan ke hutan dan menemukan Pedang!");
            playerWeapon = "Pedang";
            System.out.println("Senjata Anda: " + playerWeapon);
            System.out.println("\n\n1: Kembali ke persimpangan jalan");
            System.out.println("\n------------------------------------------------------------------\n");

            choice = myScanner.nextInt();

            if (choice == 1) {
                    crossRoad();
            } else {
                    east();
            }
    }
    @Override
    public void west() {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("Anda bertemu dengan Keboe Ijoe!\n");
            System.out.println("1: Bertarung");
            System.out.println("2: Lari");
            System.out.println("\n------------------------------------------------------------------\n");

            choice = myScanner.nextInt();

            if (choice == 1) {
                    fight();
            } else if (choice == 2) {
                    crossRoad();
            } else {
                    west();
            }
    }
    @Override
    public void crossRoad() {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("Anda berada di persimpangan jalan.\nJika Anda pergi ke selatan, kamu akan kembali ke gerbang kota.\n\n");
            System.out.println("1: Pergi ke utara");
            System.out.println("2: Pergi ke timur");
            System.out.println("3: Pergi ke Selatan");
            System.out.println("4: Pergi ke Barat");
            System.out.println("\n------------------------------------------------------------------\n");

            choice = myScanner.nextInt();

            if (choice == 1) {
                    north();
            } else if (choice == 2) {
                    east();
            } else if (choice == 3) {
                    townGate();
            } else if (choice == 4) {
                    west();
            } else {
                    crossRoad();
            }
    }
    @Override
    public void fight() {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("HP(Health Point) Anda: " + playerHP);
            System.out.println("HP(Health Point) Keboe Ijoe: " + KeboeIjoeHP);
            System.out.println("\n1: Bertarung");
            System.out.println("2: Lari");
            System.out.println("\n------------------------------------------------------------------\n");

            choice = myScanner.nextInt();

            if (choice == 1) {
                    attack();
            } else if (choice == 2) {
                    crossRoad();
            } else {
                    fight();
            }
    }
    @Override
    public void attack() {
            int playerDamage = 0;
            // ... existing code remains the same...

            Scanner scanner = new Scanner(System.in);
            System.out.println("Masukkan pilihan Anda: (1) Gunting, (2) Kertas,  (3) Batu");
            int playerChoice = scanner.nextInt();
            if(playerChoice <= 3 && playerChoice > 0){
                Random rand = new Random();
                int systemChoice = rand.nextInt(3) + 1; // 1 for Rock, 2 for Paper, 3 for Scissors
                // Display user and system choices
                String[] choices = {"Gunting", "Kertas", "Batu"};
                System.out.println("Pilihan Anda: " + choices[playerChoice - 1]);
                System.out.println("Pilihan Keboe Ijoe: " + choices[systemChoice - 1]);

                int result = determineWinner(playerChoice, systemChoice);
                if (result == 1) {
                    playerDamage = new Random().nextInt(8)+1;
                    System.out.println("Anda menyerang Keboe Ijoe dan memberi " + playerDamage + " damage!");
                    // ... existing code remains the same...
                    KeboeIjoeHP = KeboeIjoeHP - playerDamage;
                    if (KeboeIjoeHP < 1) {
                            win();
                    }else{
                        fight();
                    }

                } else if (result == -1) {
                    // ... existing code remains the same...
                    int monsterDamage = rand.nextInt(5) + 2;
                    System.out.println("Keboe Ijoe menyerangmu dan memberi " + monsterDamage + " damage!");
                    playerHP = playerHP - monsterDamage;
                    System.out.println("HP(Health Point) Anda: " + playerHP);
                    if (playerHP < 1) {
                            dead();
                    } else if (playerHP > 0) {
                            fight();
                    }
                } else {
                    System.out.println("Imbang!\nAnda dan Keboe Ijoe memiliki pilihan yang sama");
                    // Implement the case for a draw (optional)
                    fight();
                }
            }else{
                System.out.println("Invalid");
                attack();
            }

    }
    @Override
    public void dead() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Anda Mati!!!");
        System.out.println("\n\nGAME OVER");
        System.out.println("\n------------------------------------------------------------------\n");
    }
    @Override
    public void win() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Anda Membunuh Keboe Ijoe!");
        System.out.println("Keboe Ijoe menjatuhkan sebuah cincin!");
        System.out.println("Anda memperoleh cincin perak!\n\n");

        inventory.add("Cincin Perak");

        System.out.println("Inventaris Anda: " + inventory);

        System.out.println("1: Kembali ke persimpangan jalan");
        System.out.println("\n------------------------------------------------------------------\n");

        silverRing = 1;

        choice = myScanner.nextInt();
        if (choice == 1) {
            crossRoad();
        } else {
            win();
        }
        enterScanner.nextLine();
    }
    @Override
    public void ending() {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("Penjaga: Oh, kamu membunuh Keboe Ijoe!??");
            System.out.println("Penjaga: Berikan bukti kamu telah membunuh Keboe Ijoe!");
            System.out.println("1: Perlihatkan Inventory");
            System.out.println("2: Pergi");
            System.out.println("\n------------------------------------------------------------------\n");
            int inventoryUser = myScanner.nextInt();

            if (inventoryUser == 1) {
                    if (inventory == null) {
                        System.out.println("\n\n Anda Belum Membunuh Keboe Ijoe karena tidak punya bukti ");
                        townGate();
                    }else{
                            System.out.println("\n------------------------------------------------------------------\n");
                            System.out.println("Inventaris Anda: " + inventory.get(0));
                            System.out.println("Penjaga: Anda telah membuktikan telah membunuh Keboe Ijoe.");
                            System.out.println("Penjaga: Silahkan Masuk dan Selamat datang di kota.");
                            System.out.println("\n\n           Selamat Anda Menang                    ");
                            System.out.println("\n\n              GAME SELESAI                    ");
                            System.out.println("\n------------------------------------------------------------------\n");
                    }
            }else{
                townGate();
            } 
    }
    @Override
    public void playerSetUp() {
        // Implementing an overridden version of playerSetUp() in AdvancedBoncel
        System.out.println("HP(Health Point) Anda: " + playerHP);
        System.out.println("HP(Health Point) Keboe Ijoe: " + KeboeIjoeHP);
        System.out.println("Senjata Anda: " + playerWeapon);
        System.out.println("Tolong Masukan Nama Anda:");
        playerName = myScanner.nextLine();
        System.out.println("Hello " + playerName + ", Mari Mulai Bermain!");
    }
    private int determineWinner(int player, int system) {
        // 1 for player win, -1 for system win, 0 for draw
        if ((player == 3 && system == 1) || (player == 1 && system == 2) || (player == 2 && system == 3)) {
            return 1; // Player wins
        } else if ((system == 3 && player == 1) || (system == 1 && player == 2) || (system == 2 && player == 3)) {
            return -1; // System wins
        } else {
            return 0; // Draw
        }
    }

}
