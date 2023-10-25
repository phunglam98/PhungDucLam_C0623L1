package Manager;

import DAO.ReadAndWriteListStudent;
import Models.Student;

import java.util.ArrayList;

public class StudentManager implements IManager<Student> {
    private ArrayList<Student> list;
    private ReadAndWriteListStudent readAndWriteListStudent;

    public StudentManager() {
        readAndWriteListStudent = new ReadAndWriteListStudent();
        list = readAndWriteListStudent.readFile();
    }

    public int findIndex(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean add(Student student) {
        list.add(student);
        readAndWriteListStudent.writeList(list);
        return true;
    }

    @Override
    public boolean edit(int index, Student student) {
        list.set(index, student);
        readAndWriteListStudent.writeList(list);
        return true;
    }

    @Override
    public boolean delete(int index) {
        list.remove(index);
        readAndWriteListStudent.writeList(list);
        return true;
    }

    @Override
    public ArrayList<Student> findAll() {
        return list;
    }


}
