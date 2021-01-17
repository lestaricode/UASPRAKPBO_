package sample;


public class KaryawanModel {
    private String nama;
    private String alamat;
    private String posisi;
    private String umur;
    private String jenisk;

    KaryawanModel(String nama, String alamat, String posisi, String umur, String jenisk){
        this.nama = nama;
        this.alamat = alamat;
        this.posisi = posisi;
        this.umur = umur;
        this.jenisk = jenisk;
    }

    public String getNama(){
        return  nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat(){
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPosisi(){
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getUmur(){
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getJenisk(){
        return jenisk;
    }

    public void setJenisk(String jenisk) {
        this.jenisk = jenisk;
    }
}
