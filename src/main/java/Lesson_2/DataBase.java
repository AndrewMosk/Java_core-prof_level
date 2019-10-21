package Lesson_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class DataBase {
    private static Connection connection;
    private static Statement stmt;

    static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            stmt = connection.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }

    static void createDB() {

    }

    static void createTableStudents() {
      try {
            String sql = "CREATE TABLE IF NOT EXISTS students("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "name TEXT,"+
                    "score TEXT)";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void dropTableStudents() {
        String sql = "DROP TABLE IF EXISTS students";
        try {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void insertStudent(String name, String score) {
        try {
            String sql = String.format("INSERT INTO table (name, score) + VALUES('%s', '%s')", name, score);
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void updateStudent(String name, String score, int id) {
        try {
            String sql = String.format("UPDATE students SET name = '%s', score = '%s' WHERE id = '%s'", name, score, id);
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void deleteStudent(int id) {
        try {
            String sql = String.format("DELETE from students WHERE id = '%s'", id);
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
