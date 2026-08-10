import student.Student;
import faculty.faculty;

class CollegeManagement {

    public static void main(String[] args) {

        Student student = new Student();
        faculty faculty = new faculty();

        student.displayStudent();

        System.out.println();

        faculty.displayFaculty();
    }
}
