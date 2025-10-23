package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {

    // ⚙️ Cấu hình kết nối SQL Server
    private static final String SERVER_NAME = "MEOW\\SQLEXPRESS"; // hoặc "MEOW\\SQLEXPRESS" nếu bạn dùng instance
    private static final String DB_NAME = "QUANLYSPA";
    private static final String USER = "sa";
    private static final String PASS = "Meow#meow.999"; // <-- đổi lại mật khẩu của bạn
    private static final boolean ENCRYPT = false; // đặt true nếu dùng SSL

    // ✅ URL kết nối JDBC
    private static final String DB_URL = String.format(
            "jdbc:sqlserver://%s:1433;databaseName=%s;encrypt=%s;trustServerCertificate=true;",
            SERVER_NAME, DB_NAME, ENCRYPT
    );

    // 🔌 Hàm tạo kết nối
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("✅ Kết nối cơ sở dữ liệu thành công!");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("❌ Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
        }
        return conn;
    }

    // 🔒 Hàm đóng kết nối
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

    // 🧪 Hàm test kết nối
    public static void main(String[] args) {
        Connection testConn = getConnection();
        if (testConn != null) {
            closeConnection(testConn);
        }
    }
}
