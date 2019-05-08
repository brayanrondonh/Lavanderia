package jdbc;

import java.sql.*;

public class Conexion
{
    private static String jdbc_driver = "com.mysql.jdbc.Driver";
    private static String jdbc_url = "jdbc:mysql://localhost:3306/lavanderia?useSSL=false";
    private static String jdbc_user = "root";
    private static String jdbc_pass = "test";
    private static Driver driver = null;

    public static synchronized Connection getConnection() throws SQLException
    {
        if(driver == null)
        {
            try
            {
                Class jdbcDriverClass = Class.forName(jdbc_driver);
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver(driver);
            }
            catch(Exception e)
            {
                System.out.println("Exploto la conexion");
                System.out.println(e.getMessage());
            }
        }
        return DriverManager.getConnection(jdbc_url, jdbc_user, jdbc_pass);
    }

    public static void close(ResultSet rs)
    {
        try
        {
            if(rs == null)
            {
                rs.close();
            }
        }
        catch (SQLException s)
        {
            System.out.println("Exploto cerrar el rs");
        }
    }

    public static void close(PreparedStatement pstmt)
    {
        try
        {
            if(pstmt == null)
            {
                pstmt.close();
            }
        }
        catch (SQLException s)
        {
            System.out.println("Exploto cerrar el pstmt");
        }
    }

    public static void close(Connection conn)
    {
        try
        {
            if(conn == null)
            {
                conn.close();
            }
        }
        catch (SQLException s)
        {
            System.out.println("Exploto cerrar el conn");
        }
    }
}
