package generatestudents;

import dataStructures.*;

/**
 *
 * @author breud
 */
public class GenerateStudents {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentList students = new StudentList(5000);
        //System.out.println(students);
        int collisions=0;
        QuadraticProbingHash hash = new QuadraticProbingHash(5113);
        Student[] student = students.getList();
        for (Student student1 : student) {
            collisions += hash.put(student1.getLdap(), student1.getEcts());
        }
        System.out.println(collisions);
        
    }

}
