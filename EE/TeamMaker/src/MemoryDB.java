import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryDB {

    private Map<String, Student> storage;

    public MemoryDB() {
        storage = new HashMap<>();
    }

    public void insert(String name, GENDER gender, REGION region, int age, int point) {
        Student student = new Student(name, gender, region, age, point);
        insert(student);
    }

    public void insert(Student student) {
        storage.put(student.name, student);
    }

    public void delete(String name) {
        if (storage.containsKey(name) == false) {
            return;
        }
        storage.remove(name);
    }

    public int count() {
        return storage.size();
    }

    public ArrayList<Student> findByTeam(int teamNumber) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : storage.values()) {
            if (student.team == teamNumber) {
                list.add(student);
            }
        }
        return list;
    }

    public ArrayList<Student> selectAll() {
        return new ArrayList<>(storage.values());
    }
}
