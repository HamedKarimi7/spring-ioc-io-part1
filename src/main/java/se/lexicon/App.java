package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.dao.StudentDAOImpl;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;

public class App {

    public static void main(String[] args) {
        Student student = new Student("hamed");
        // oop - core -save to menmory
        /*StudentDAOImpl studentDAO = new StudentDAOImpl();
        studentDAO.save(student);
        Student studentAli = new Student("ali");
        studentDAO.save(studentAli);
        System.out.println(studentDAO.findAll());*/


        // spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDao studentDAO = context.getBean(StudentDao.class);
        studentDAO.save(student);
        Student studentAli = new Student("ali");
        studentDAO.save(studentAli);
        System.out.println(studentDAO.findAll());

    }

}
