package com.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


import javax.swing.table.DefaultTableModel;

public class Model {

  private static final String DB_URL = "jdbc:mysql://localhost:3306/db_toko_telur";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "";

  private static Connection connect;
  private static Statement statement;

  private static void connection()
  {
    try {
      connect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // mitra static function
  public static DefaultTableModel getAllMitra()
  {
    connection();
    
    String[] dataHeader = {"ID Mitra", "Nama Mitra", "Email Mitra"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwallmitra";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = { resultData.getInt("id_mitra"), resultData.getString("nama_mitra"), resultData.getString("email_mitra") };
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountAllMitra()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwallmitra";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getMitraNonVerifikasi()
  {
    connection();
    String[] dataHeader = {"ID Mitra", "Nama", "Email"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwmitranonverifikasi";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = { resultData.getInt("id_mitra"), resultData.getString("nama_mitra"), resultData.getString("email_mitra") };
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }
  
  public static int getCountMitraNonVerifikasi()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwmitranonverifikasi";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getMitraTerverifikasi()
  {
    connection();
    
    String[] dataHeader = {"ID Mitra", "Nama Mitra", "Email Mitra"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwmitraterverifikasi";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = { resultData.getInt("id_mitra"), resultData.getString("nama_mitra"), resultData.getString("email_mitra") };
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }
  
  public static int getCountMitraTerverifikasi()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwmitraterverifikasi";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getAllSaldoMitra()
  {
    connection();

    String[] dataHeader = {"ID Barang Mitra", "ID Mitra", "Nama", "Email", "Barang"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwbarangmitra";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = { resultData.getInt("id_barang"), resultData.getInt("id_mitra"), resultData.getString("nama_mitra"), resultData.getString("email_mitra"), resultData.getInt("barang_mitra") };
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }
  
  public static boolean verifyEmailMitra( String email )
  {
    connection();
    boolean available = false;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwallmitra WHERE emailMitra = '" + email + "'";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      if ( resultData.getInt(1) == 0){
        available = true;
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return available;
  }
  
  public static boolean verifyAkunMitra( String email, String password )
  {
    connection();
    boolean available = false;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwallmitra WHERE email_mitra = '" + email + "' AND password_mitra = '" + password + "'";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      if ( resultData.getInt(1) == 1){
        available = true;
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return available;
  }

  public static int getDetailSaldoMitra( int id_mitra )
  {
    connection();

    int barang = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT barang_mitra FROM vwbarangmitra WHERE id_mitra = " + id_mitra;

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      barang = resultData.getInt("barang_mitra");
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return barang;

  }
  

  // Customer static function
  public static DefaultTableModel getCustomer()
  {
    connection();
    
    String[] dataHeader = {"ID Customer", "Nama Customer", "No HP", "Email"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwcustomer";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("id_customer"), resultData.getString("nama_customer"), resultData.getString("nomor_hp_customer"), resultData.getString("email_customer")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static DefaultTableModel getPulsaKuotaCustomer()
  {
    connection();
    String[] dataHeader = {"ID Telur Vitamin", "ID Customer", "Nama Customer", "No. Hp", "Telur", "Vitamin"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwtelurvitamincustomer";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("id_telurvitaminustomer"), resultData.getInt("id_customer"), resultData.getString("nama_customer"), resultData.getString("nomor_hp_customer"), resultData.getInt("telur_customer"), resultData.getInt("vitamin_customer") + "Pack"};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }
  
  public static boolean verifyNoHpCustomer( String no_hp )
  {
    connection();
    boolean available = false;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwcustomer WHERE nomor_hp_customer = '" + no_hp + "'";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      if ( resultData.getInt(1) == 0){
        available = true;
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return available;
  }

  public static boolean verifyAkunCustomer( String no_hp, String password )
  {
    connection();
    boolean available = false;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwcustomer WHERE nomor_hp_customer = '" + no_hp + "' AND password_customer = '" + password + "'";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      if ( resultData.getInt(1) == 1){
        available = true;
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return available;
  }

  public static int getCountCustomer()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwcustomer";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }


  // Paket static function
  public static DefaultTableModel getAllPaket()
  {
    connection();
    
    String[] dataHeader = {"ID Paket", "Nama Paket", "Vitamin", "Harga", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwallvitamin ORDER BY id_vitamin DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("id_vitamin"), resultData.getString("nama_vitamin"), resultData.getInt("vitamin") + "GB", "Rp." + resultData.getInt("harga_vitamin"), (resultData.getString("status_aktif").toString().equalsIgnoreCase("1")) ? "Aktif" : "Tidak Aktif"};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountAllPaket()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwallvitamin";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getPaketAktif()
  {
    connection();
    
    String[] dataHeader = {"ID Vitamin", "Nama Vitamin", "Vitamin", "Harga", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwvitamin ORDER BY id_vitamin DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("id_vitamin"), resultData.getString("nama_vitamin"), resultData.getInt("vitamin") + "Pack", "Rp." + resultData.getInt("harga_vitamin"), "Aktif"};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }
  
  public static DefaultTableModel getPaketAktifByCustomer()
  {
    connection();
    
    String[] dataHeader = {"ID Vitamin", "Nama Paket", "Vitamin", "Harga"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwpaketaktif ORDER BY idPaket DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("id_vitamin"), resultData.getString("nama_vitamin"), resultData.getInt("vitamin") + "Pack", "Rp." + resultData.getInt("harga_vitamin")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountPaketAktif()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwvitamin";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getPaketNonAktif()
  {
    connection();
    
    String[] dataHeader = {"ID Vitamin", "Nama Vitamin", "Vitamin", "Harga", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwvitamin ORDER BY idPaket DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("id_vitamin"), resultData.getString("nama_vitamin"), resultData.getInt("vitamin") + "Pack", "Rp." + resultData.getInt("harga_vitamin"), "Tidak Aktif"};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountPaketNonAktif()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwvitamin";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }


  // Transaksi Paket function static
  public static DefaultTableModel getAllTransaksiPaket()
  {
    connection();
    String[] dataUHeader = {"ID Transaksi Vitamin", "Customer", "No HP", "Vitamin", "Jumlah", "Harga", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataUHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwalltransaksi_vitamin ORDER BY waktu_transaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("id_transaksi_vitamin"), resultData.getString("nama_customer"), resultData.getString("nomor_hp_customer"), resultData.getString("nama_vitamin"), resultData.getInt("vitamin") + "Pack", "Rp." + resultData.getInt("harga_vitamin"), resultData.getString("waktu_transaksi"), resultData.getString("status_transaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static DefaultTableModel getAllTransaksiPaketByCustomer( int id_customer)
  {
    connection();
    
    String[] dataHeader = {"Nama Vitamin", "Vitamin", "Harga", "Waktu Transaksi", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwalltransaksi_vitamin WHERE idCustomer = " + id_customer + " ORDER BY waktu_transaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getString("nama_vitamin"), resultData.getInt("vitamin") + "Pack", "Rp." + resultData.getInt("harga_vitamin"), resultData.getString("waktu_transaksi"), resultData.getString("status_transaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountAllTransaksiPaket()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwalltransaksi_vitamin";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getDoneTransaksiPaket()
  {
    connection();
    
    String[] dataHeader = {"ID Transaksi Vitamin", "Nama Customer", "No HP", "Nama Vitamin", "Vitamin", "Harga", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwdonetransaksi_telur ORDER BY waktu_transaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("id_transaksi_vitamin"), resultData.getString("nama_customer"), resultData.getString("nomor_hp_customer"), resultData.getString("nama_vitamin"), resultData.getInt("vitamin") + "Pack", "Rp." + resultData.getInt("harga_vitamin"), resultData.getString("waktu_transaksi"), resultData.getString("status_transaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountDoneTransaksiPaket()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwdonetransaksi_vitamin";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getPendingTransaksiPaket()
  {
    connection();
    
    String[] dataHeader = {"ID Transaksi Vitamin", "Nama Customer", "No HP", "Nama Vitamin", "Vitamin", "Harga", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwtransaksi_vitamin ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("id_transaksi_vitamin"), resultData.getString("nama_customer"), resultData.getString("nomor_hp_customer"), resultData.getString("nama_paket"), resultData.getInt("vitamin") + "Pack", "Rp." + resultData.getInt("harga_vitamin"), resultData.getString("waktu_transaksi"), resultData.getString("status_transaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountPendingTransaksiPaket()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwtransaksi_vitamin";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }


  // Transaksi Pulsa function static
  public static DefaultTableModel getAllTransaksiPulsa()
  {
    connection();

    String[] dataHeader = {"ID Transaksi Telur", "Customer", "No HP", "Telur", "Mitra", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwalltransaksi_telur ORDER BY waktu_transaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("id_transaksi_telur"), resultData.getString("nama_customer"), resultData.getString("nomor_hp_customer"), resultData.getInt("jumlah_vitamin"), resultData.getString("nama_mitra"), resultData.getString("waktu_transaksi"), resultData.getString("status_transaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static DefaultTableModel getAllTransaksiPulsaByCustomer( int id_customer )
  {
    connection();
    
    String[] dataHeader = {"Jumlah Telur", "Mitra", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwalltransaksi_telur WHERE id_customer = " + id_customer + " ORDER BY waktu_transaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("jumlah_telur"), resultData.getString("nama_mitra"), resultData.getString("waktu_transaksi"), resultData.getString("status_transaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return tm;
  }

  public static int getCountAllTransaksiPulsa()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwalltransaksi_telur";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getDoneTransaksiPulsa()
  {
    connection();
    
    String[] dataHeader = {"ID Transaksi Telur", "Nama Customer", "No HP", "Jumlah Telur", "Mitra", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwdonetransaksi_telur ORDER BY waktu_transaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("id_transaksi_telur"), resultData.getString("nama_customer"), resultData.getString("nomor_hp_customer"), resultData.getInt("jumlah_telur"), resultData.getString("nama_mitra"), resultData.getString("waktu_transaksi"), resultData.getString("status_transaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return tm;

  }

  public static int getCountDoneTransaksiPulsa()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwtransaksi_telur";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getDoneTransaksiPulsaByMitra( int idMitra )
  {
    connection();
    
    String[] dataHeader = {"Nama Customer", "No HP", "Jumlah Telur", "Waktu"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwtransaksi_telur WHERE id_mitra = " + idMitra + " ORDER BY waktu_transaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getString("nama_customer"), resultData.getString("nomor_customer"), resultData.getInt("jumlah_pulsa"),resultData.getString("waktu_transaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountDoneTransaksiPulsaMitra(int id_mitra)
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwdtransaksi_telur WHERE id_mitra = " + id_mitra;

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getPendingTransaksiPulsa()
  {
    connection();
    
    String[] dataHeader = {"ID Transaksi Telur", "Nama Customer", "No HP", "Jumlah Telur", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwtransaksi_telur ORDER BY waktu_transaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("id_transaksi_telur"), resultData.getString("nama_customer"), resultData.getString("nomor_hp_customer"), resultData.getInt("jumlah_telur"), resultData.getString("waktu_transaksi"), resultData.getString("status_transaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountPendingTransaksiPulsa()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwtransaksi_telur";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }


  // Transaksi Saldo function static
  public static DefaultTableModel getAllTransaksiSaldo()
  {
    connection();
    
    String[] dataHeader = {"ID Transaksi Barang", "Nama Mitra", "Jumlah Barang", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwalltransaksi_barang ORDER BY waktu_transaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("id_transaksi_barang"), resultData.getString("nama_mitra"), resultData.getInt("jumlah_saldo"), resultData.getString("waktu_transaksi"), resultData.getString("status_transaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return tm;

  }

  public static DefaultTableModel getAllTransaksiSaldoByMitra( int id_mitra )
  {
    connection();
    
    String[] dataHeader = {"Jumlah Barang", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwalltransaksi_barang WHERE id_mitra = " + id_mitra + " ORDER BY waktuTransaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("jumlah_barang"), resultData.getString("waktu_transaksi"), resultData.getString("status_transaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountAllTransaksiSaldo()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwalltransaksi_barang";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getDoneTransaksiSaldo()
  {
    connection();
    String[] dataHeader = {"ID Transaksi Barang", "Nama Mitra", "Jumlah Barang", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwdonetransaksi_barang ORDER BY waktu_transaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("id_transaksi_barang"), resultData.getString("nama_mitra"), resultData.getInt("jumlah_saldo"), resultData.getString("waktu_transaksi"), resultData.getString("status_transaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountDoneTransaksiSaldo()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwtranskasi_barang";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel getPendingTransaksiSaldo()
  {
    connection();
    String[] dataHeader = {"ID Transaksi Barang", "Nama Mitra", "Jumlah Barang", "Waktu", "Status"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwtransaksi_barang ORDER BY waktu_transaksi DESC";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = {resultData.getInt("id_transaksi_barang"), resultData.getString("nama_mitra"), resultData.getInt("jumlah_barang"), resultData.getString("waktu_transaksi"), resultData.getString("status_transaksi")};
        tm.addRow(rowData);
      }
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }

  public static int getCountPendingTransaksiSaldo()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwtransaksi_barang";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }


  // Detail get Data
  public static Object[] getDetailMitra( int id_mitra )
  {
    connection();

    Object rowData[] = new Object[3];

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwallmitra WHERE id_mitra = " + id_mitra;

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      rowData[0] = resultData.getInt("id_mitra");
      rowData[1] = resultData.getString("nama_mitra");
      rowData[2] = resultData.getString("email_mitra");
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return rowData;

  }
  
  public static Object[] getDetailCustomer( int id_customer )
  {
    connection();

    Object rowData[] = new Object[4];

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM vwcustomer WHERE id_customer = " + id_customer;

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      rowData[0] = resultData.getInt("id_customer");
      rowData[1] = resultData.getString("nama_customer");
      rowData[2] = resultData.getString("nomor_hp_customer");
      rowData[3] = resultData.getString("email_customer");
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return rowData;

  }
  
  public static Object[] getDetailPulsaKuotaCustomer( int id_customer )
  {
    connection();

    Object[] pulsaKuota = new Object[2];

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT telur_customer, vitamin_customer FROM vwtelur_vitamincustomer WHERE id_customer = " + id_customer;

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      pulsaKuota[0] = resultData.getInt("telur_customer");
      pulsaKuota[1] = resultData.getInt("vitamin_customer");
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return pulsaKuota;
  }

  public static Object[] getDetailPaket( int id_vitamin )
  {
    connection();

    Object[] rowData = new Object[6];

    try {

      // buat object statement yang ambil dari koneksi
      statement = connect.createStatement();

      // query select
      String query = "SELECT * FROM tbl_vitamin WHERE id_vitamin = " + id_vitamin;

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      rowData[0] = resultData.getInt("id_vitamin");
      rowData[1] = resultData.getString("nama_vitamin");
      rowData[2] = resultData.getString("deskripsi_vitamin");
      rowData[3] = resultData.getInt("vitamin");
      rowData[4] = resultData.getInt("harga_vitamin");
      rowData[5] = resultData.getString("status_aktif");
      
      // close statement dan connection
      statement.close();
      connect.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return rowData;

  }


}