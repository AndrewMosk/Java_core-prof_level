package Lesson_2;

public class Lesson2_Main {
    public static void main(String[] args) {
        DataBase.connect();

        DataBase.createDB();
        DataBase.createTableStudents();

        DataBase.insertStudent("Bob", "29");
        DataBase.updateStudent("Bob Smith", "29", 1);
        DataBase.deleteStudent(1);

        DataBase.dropTableStudents();
        DataBase.close();
    }
}
