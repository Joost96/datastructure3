
package generatestudents;

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
        
        Student[] student = students.getList();
         for (int i = 0; i < student.length; i++) {
            int value = Math.abs(student[i].hash() %97);

            System.out.println(value);
        }
    }
    
}
