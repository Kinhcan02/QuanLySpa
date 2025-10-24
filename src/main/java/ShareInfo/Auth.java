/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShareInfo;

/**
 *
 * @author ASUS
 */
public class Auth {
     private Auth() {
    }
    
    public static  int maTaiKhoan = -1;
    public static  String tenDangNhap= null;
    public static  String matKhau  = null;
    public static  String loaiNguoiDung = null;
    public static  boolean dangNhap = false;
    
    public static void clear(){
        maTaiKhoan= -1;
        tenDangNhap = null;
        matKhau = null;
        loaiNguoiDung = null;
        dangNhap = false;
    }
    public static boolean isLogin() {
        return dangNhap;
    }
}
