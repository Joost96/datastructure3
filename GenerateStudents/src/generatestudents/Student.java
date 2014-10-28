package generatestudents;

/**
 * Student consists in this example only of an ldap and the amount of ects
 * earned.
 *
 * @author breud
 */
public class Student {

    private final String ldap;
    private final int ects;

    public Student(String ldap, int ects) {
        this.ldap = ldap;
        this.ects = ects;
    }

    public String getLdap() {
        return ldap;
    }

    public int getEcts() {
        return ects;
    }

    /**
     * Converts the student to a string.
     *
     * @return the converted student
     */
    @Override
    public String toString() {
        return "Student{" + "ldap=" + ldap + ", ects=" + ects + '}';
    }

    public int hashCode() {

        int hashcode = 0;
        int mod = 443;
        int nrValue = 37;
        for (int i = 0; i < ldap.length(); i++) {
            hashcode = (nrValue % mod + ldap.charAt(i)* hashcode);
        }
        return hashcode;
    }
}
