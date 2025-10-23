package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {

    // ⚙️ Cấu hình kết nối SQL Server
    private static final String SERVER_NAME = "MEOW\\SQLEXPRESS"; // Tên máy + instance
    private static final String DB_NAME = "QuanLySpa"; // Đúng với tên DB bạn tạo
    private static final String USER = "ThienMan"; // <-- Hoặc 'sa' nếu bạn dùng tài khoản sa
    private static final String PASS = "123456"; // Mật khẩu SQL Server
    private static final boolean ENCRYPT = false; // Nếu chưa cấu hình SSL, để false

    // ✅ URL kết nối JDBC
    private static final String DB_URL = String.format(
        "jdbc:sqlserver://%s:1433;databaseName=%s;encrypt=%s;trustServerCertificate=true;",
        SERVER_NAME, DB_NAME, ENCRYPT
    );

    // 🔌 Hàm tạo kết nối
    public static Connection getConnection() {
        try {
            // Load driver (JDBC)
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Kết nối
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("✅ Kết nối cơ sở dữ liệu thành công!");
            return conn;

        } catch (ClassNotFoundException e) {
            System.err.println("❌ Không tìm thấy JDBC Driver: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("❌ Lỗi SQL khi kết nối: " + e.getMessage());
            System.err.println("🔎 URL: " + DB_URL);
        }
        return null;
    }

    // 🔒 Đóng kết nối
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("🔌 Đã đóng kết nối cơ sở dữ liệu.");
            } catch (SQLException e) {
                System.err.println("⚠️ Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }

    // 🧪 Kiểm tra thử
    public static void main(String[] args) {
        Connection testConn = getConnection();
        if (testConn != null) {
            closeConnection(testConn);
        } else {
            System.out.println("🚫 Kết nối thất bại, vui lòng kiểm tra lại cấu hình!");
        }
    }
}
