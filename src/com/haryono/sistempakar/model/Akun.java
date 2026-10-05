package com.haryono.sistempakar.model;

public class Akun {
    private int idAkun;
    private String namaLengkap;
    private String username;
    private String password;
    private String role; 

    public Akun() {
    }

    public Akun(int idAkun, String namaLengkap, String username, String password, String role) {
        this.idAkun = idAkun;
        this.namaLengkap = namaLengkap;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getIdAkun() {
        return idAkun;
    }

    public void setIdAkun(int idAkun) {
        this.idAkun = idAkun;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isAdmin() {
        return "admin".equalsIgnoreCase(role);
    }
}
