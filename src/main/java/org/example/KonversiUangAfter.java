package org.example;

import java.util.Scanner;

/**
 * Program ini digunakan untuk mengonversi mata uang dari Rupiah (IDR) ke mata uang lain seperti Dolar AS (USD), Euro (EUR), atau Yen Jepang (JPY).
 * Pengguna akan diminta memasukkan jumlah uang dalam Rupiah dan memilih mata uang tujuan.
 * Program kemudian akan menghitung dan menampilkan hasil konversi.
 */

public class KonversiUangAfter {

    /**
     * Nilai tukar dari IDR ke USD.
     */
    private static final double RATE_TO_USD = 0.000064;

    /**
     * Nilai tukar dari IDR ke EUR.
     */
    private static final double RATE_TO_EUR = 0.000059;

    /**
     * Nilai tukar dari IDR ke JPY.
     */
    private static final double RATE_TO_JPY = 0.00958;

    /**
     * Meminta input jumlah rupiah dan pilihan mata uang tujuan dari pengguna,
     * kemudian melakukan konversi dan menampilkan hasilnya.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah Rupiah (IDR): ");
        double amountInRupiah = getAmountInIDR(scanner);

        System.out.println("Pilih mata uang tujuan: ");
        System.out.println("1. Dolar AS (USD)");
        System.out.println("2. Euro (EUR)");
        System.out.println("3. Yen Jepang (JPY)");
        System.out.print("Masukkan Pilihan: ");
        int choice = getChoice(scanner);

        convertCurrency();
        switch (choice) {
            case 1:
                System.out.printf("%.2f IDR = %.2f USD\n", amountInRupiah, amountInRupiah * getRateToUsd());
                break;
            case 2:
                System.out.printf("%.2f IDR = %.2f EUR\n", amountInRupiah, amountInRupiah * getRateToEur());
                break;
            case 3:
                System.out.printf("%.2f IDR = %.2f JPY\n", amountInRupiah, amountInRupiah * getRateToJpy());
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
        scanner.close();
    }

    /**
     * Meminta jumlah uang dalam rupiah dari pengguna.
     * paramameter scanner objek Scanner berguna untuk membaca input pengguna.
     * return jumlah uang dalam Rupiah.
     */
    private static double getAmountInIDR(Scanner scanner) {
        double amountInRupiah = scanner.nextDouble();
        return amountInRupiah;
    }

    private static void convertCurrency() {
        double convertedAmount;
    }

    /**
     * Meminta pilihan mata uang yang akan dikonversi dari pengguna.
     * parameter scanner objek Scanner untuk membaca input pengguna.
     * return pilihan mata uang tujuan.
     */
    private static int getChoice(Scanner scanner) {
        int choice = scanner.nextInt();
        return choice;
    }

    /**
     * Mengambil nilai tukar dari IDR ke USD.
     */
    public static double getRateToUsd() {
        return RATE_TO_USD;
    }

    /**
     * Mengambil nilai tukar dari IDR ke EUR.
     */
    public static double getRateToEur() {
        return RATE_TO_EUR;
    }

    /**
     * Mengambil nilai tukar dari IDR ke JPY.
     */
    public static double getRateToJpy() {
        return RATE_TO_JPY;
    }
}
