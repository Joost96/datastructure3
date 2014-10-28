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
        StudentList students = new StudentList(10000);
        //System.out.println(students);
        int collisions=0;
        LinearProbingHash hash = new LinearProbingHash(10501);
        Student[] student = students.getList();
        for (Student student1 : student) {
            collisions += hash.put(student1, student1.getEcts());
        }
        System.out.println(collisions);
        
    }

}
