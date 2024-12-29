package com.tubes;

public class Pembayaran implements IPembayaran {
    private Invoice invoice; // Referensi ke invoice yang akan dibayar
    private String nomorBisnis = "082234709831" ;

    public Pembayaran(Invoice invoice) {
        this.invoice = invoice; // Inisialisasi invoice
    }

    @Override
    public void bayarEwallet(String nomorHpBisnis, int nominal) {
        if(nomorHpBisnis == this.nomorBisnis){
            if (nominal >= invoice.getBiayaTagihan()) {
                System.out.println("Pembayaran menggunakan eWallet berhasil.");
                System.out.println("Nomor HP Bisnis: " + nomorHpBisnis);
                System.out.println("Nominal: " + nominal);
                invoice.setStatusLaundry("Laundry telah selesai"); // Mengubah status invoice menjadi selesai
                System.out.println("Status invoice telah diubah menjadi 'selesai'.");
            } else {
                System.out.println("Pembayaran gagal. Nominal tidak cukup.");
            }
        }else{
            System.out.println("Nomor HP Bisnis: " + this.nomorBisnis);
        }
    }

    @Override
    public void bayarQris( int nominal) {
        if (nominal >= invoice.getBiayaTagihan()) {
            System.out.println("Pembayaran menggunakan QRIS berhasil.");
            System.out.println("Nominal: " + nominal);
            invoice.setStatusLaundry("Laundry telah selesai"); // Mengubah status invoice menjadi selesai
            System.out.println("Status invoice telah diubah menjadi 'selesai'.");
        } else {
            System.out.println("Pembayaran gagal. Nominal tidak cukup.");
        }
    }

    @Override
    public void bayarCash(int nominal) {
        if (nominal >= invoice.getBiayaTagihan()) {
            System.out.println("Pembayaran tunai berhasil.");
            System.out.println("Nominal: " + nominal);
            invoice.setStatusLaundry("Laundry telah selesai"); // Mengubah status invoice menjadi selesai
            System.out.println("Status invoice telah diubah menjadi 'selesai'.");
        } else {
            System.out.println("Pembayaran gagal. Nominal tidak cukup.");
        }
    }
}