package se.lexicon.dao;

import org.springframework.stereotype.Component;
import se.lexicon.dao.sequencer.StudentIdSequencer;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentDAOImpl implements StudentDao {

    private List<Student> students;

    public StudentDAOImpl() {

        students = new ArrayList<>();
    }

    @Override
    public Student save(Student student) {
        if (student == null) throw new IllegalArgumentException("Student is null");
        student.setId(StudentIdSequencer.nextId());
        students.add(student);
        return null;
    }

    @Override
    public Student find(int id) throws DataNotFoundException {

        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElseThrow(() -> new DataNotFoundException("Not Found","Student"));

    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public void delete(int id) throws DataNotFoundException {
        Student result = find(id);
        if (result != null ) {students.remove(result); }
        //Optional.ofNullable(find(id)).ifPresent(students::remove); use when we didnot put throw new IllegalArgumentException
    }

    public void clear(){
        students.clear();
    }

}

