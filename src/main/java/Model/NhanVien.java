package Model;

import java.time.LocalDate;
import java.util.Objects;

public class NhanVien {
    private Integer maNhanVien;
    private String hoTen;
    private LocalDate ngaySinh;
    private String soDienThoai;
    private String diaChi;
    private String chucVu;
    private LocalDate ngayVaoLam;

    // Constructor mặc định
    public NhanVien() {
    }

    // Constructor có tham số (không có mã nhân viên)
    public NhanVien(String hoTen, LocalDate ngaySinh, String soDienThoai, 
                   String diaChi, String chucVu, LocalDate ngayVaoLam) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
        this.ngayVaoLam = ngayVaoLam;
    }

    // Constructor đầy đủ tham số
    public NhanVien(Integer maNhanVien, String hoTen, LocalDate ngaySinh, 
                   String soDienThoai, String diaChi, String chucVu, LocalDate ngayVaoLam) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
        this.ngayVaoLam = ngayVaoLam;
    }

    // Getter và Setter
    public Integer getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(Integer maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public LocalDate getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(LocalDate ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    // Phương thức tính tuổi
    public int getTuoi() {
        if (ngaySinh == null) {
            return 0;
        }
        return LocalDate.now().getYear() - ngaySinh.getYear();
    }

    // Phương thức tính thâm niên (năm làm việc)
    public int getThamNien() {
        if (ngayVaoLam == null) {
            return 0;
        }
        return LocalDate.now().getYear() - ngayVaoLam.getYear();
    }

    // Kiểm tra nhân viên có hợp lệ không
    public boolean isValid() {
        return hoTen != null && !hoTen.trim().isEmpty() &&
               soDienThoai != null && !soDienThoai.trim().isEmpty();
    }

    // Override equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhanVien nhanVien = (NhanVien) o;
        return Objects.equals(maNhanVien, nhanVien.maNhanVien) &&
               Objects.equals(soDienThoai, nhanVien.soDienThoai);
    }

    // Override hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(maNhanVien, soDienThoai);
    }

    // Override toString()
    @Override
    public String toString() {
        return "NhanVien{" +
                "maNhanVien=" + maNhanVien +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", chucVu='" + chucVu + '\'' +
                ", ngayVaoLam=" + ngayVaoLam +
                ", tuoi=" + getTuoi() +
                ", thamNien=" + getThamNien() +
                '}';
    }
}