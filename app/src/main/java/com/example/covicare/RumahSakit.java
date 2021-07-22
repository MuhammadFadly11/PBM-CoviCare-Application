package com.example.covicare;

public class RumahSakit {

    private String namars, notelprs, alamatrs, statusrs, lokasirs;

    public RumahSakit(String namars, String notelprs, String alamatrs, String statusrs, String lokasirs) {
        this.namars = namars;
        this.notelprs = notelprs;
        this.alamatrs = alamatrs;
        this.statusrs = statusrs;
        this.lokasirs = lokasirs;
    }

    public String getNamars() {
        return namars;
    }

    public String getAlamatrs() {
        return alamatrs;
    }

    public String getNotelprs() {
        return notelprs;
    }

    public String getStatusrs() {
        return statusrs;
    }

    public String getLokasirs() {
        return lokasirs;
    }

    public void setNamars(String namars) {
        this.namars = namars;
    }

    public void setNotelprs(String notelprs) {
        this.notelprs = notelprs;
    }

    public void setAlamatrs(String alamatrs) {
        this.alamatrs = alamatrs;
    }

    public void setStatusrs(String statusrs) {
        this.statusrs = statusrs;
    }

    public void setLokasirs(String lokasirs) {
        this.lokasirs = lokasirs;
    }
}
