package lesson2;

import java.sql.*;

public class MainDB {
    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
        try {
            connect();

            createTable("parents", "id", "name");
//            insertToParents(1, "Alex");
//            insertToParents(2, "Max");
//            insertToParents(3, "Max");
//            updateToParents(4, "Anna", 2);
//            deleteFromParents(4);
//            selectFromParents(3 );
           deleteTable("parents");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(String tableName, String idColumnName, String textColumnName){

        String sql = String.format("CREATE TABLE IF NOT EXISTS `%s` ( `%s` INTEGER, `%s` TEXT );", tableName, idColumnName, textColumnName);
        try {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTable(String tableName){
        //String sql = String.format("DROP TABLE IF EXISTS '%s'", tableName);
        //String sql = String.format("DROP TABLE IF EXISTS " + tableName);
        try {
            stmt.execute("DROP TABLE IF EXISTS " + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertToParents(int id, String name ){
        try {
            String sql = String.format("INSERT INTO parents (id, name) VALUES (%s, '%s' )", id, name);
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateToParents(int idNew, String newName, int id ){
        try {
            String sql = String.format("UPDATE parents SET id = %s, name = '%s' WHERE id = %s", idNew, newName, id);
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFromParents(int id ){
        try {
            String sql = String.format("DELETE FROM parents  WHERE id = %s", id);
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectFromParents(int id ){
        try {
            String sql = String.format("SELECT id, name FROM parents  WHERE id = %s", id);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                System.out.println("id = " + rs.getInt(1) + "  name = " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
