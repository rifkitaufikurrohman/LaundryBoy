package com.tubes.pengantaran;

import com.tubes.Invoice;
import com.tubes.admin.PegawaiAdmin;

public class Pengantaran {
    protected PegawaiAdmin pegawaiAdmin;

    public Pengantaran(PegawaiAdmin pegawaiAdmin) {
        this.pegawaiAdmin = pegawaiAdmin;
    }

    // Metode untuk memulai pengantaran
    public void mulaiPengantaran(int idInvoice) {
        Invoice invoice = pegawaiAdmin.getInvoice(idInvoice);
        if (invoice != null) {
            invoice.setStatusLaundry("Sedang di Antar"); // Mengubah status laundry
            System.out.println("Status laundry untuk Invoice ID " + idInvoice + " telah diubah menjadi 'Sedang di Antar'.");
        } else {
            System.out.println("Invoice tidak ditemukan untuk ID: " + idInvoice);
        }
    }

    // Metode untuk menyelesaikan pengantaran
    public void selesaiPengantaran(int idInvoice) {
        Invoice invoice = pegawaiAdmin.getInvoice(idInvoice);
        if (invoice != null) {
            invoice.setStatusLaundry("Laundry telah sampai di tujuan"); // Mengubah status laundry
            System.out.println("Status laundry untuk Invoice ID " + idInvoice + " telah diubah menjadi 'Laundry telah selesai'.");
        } else {
            System.out.println("Invoice tidak ditemukan untuk ID: " + idInvoice);
        }
    }

    // Metode untuk mencetak invoice
    public void cetakInvoice(int idInvoice) {
        Invoice invoice = pegawaiAdmin.getInvoice(idInvoice);
        if (invoice != null) {
            System.out.println("Invoice ID: " + invoice.getIdInvoice());
            System.out.println("Nama: " + invoice.getNamaPelanggan());
            System.out.println("Alamat: " + invoice.getAlamatPelanggan());
            System.out.println("No HP: " + invoice.getNoHpPelanggan());
            System.out.println("Tanggal: " + invoice.getTanggal());
            System.out.println("Tipe Pesanan: " + invoice.getTipePesanan());
            System.out.println("Biaya Tagihan: " + invoice.getBiayaTagihan());
            System.out.println("Status Pembayaran: " + (invoice.getStatusPembayaran() ? "Sudah Dibayar" : "Belum Dibayar"));
            System.out.println("Status Laundry: " + invoice.getStatusLaundry());
        } else {
            System.out.println("Invoice tidak ditemukan untuk ID: " + idInvoice);
        }
    }
}