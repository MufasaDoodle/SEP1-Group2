
/**
 * Class which holds information about a course
 * @author Christian Sejer
 * @version 0.5
 * */

public class Course
{
  private String courseName, courseType;
  private int numberOfStudents;
  //TODO add Room (see astah)

  /**
   * A three-argument constructor that initialises a course
   * @param courseName the name of the course
   * @param courseType the type of course
   * @param numberOfStudents the number of students in a course
   * */
  public Course(String courseName, String courseType, int numberOfStudents)
  {
    set(courseName, courseType, numberOfStudents);
  }

  /**
   * Gets the course type
   * @return String with type of course
   * */
  public String getCourseType()
  {
    return courseType;
  }
  /**
   * Gets the course name
   * @return String with name of course
   * */
  public String getCourseName()
  {
    return courseName;
  }

  /**
   * Gets the number of students in course
   * @return int with number of students
   * */
  public int getNumberOfStudents()
  {
    return numberOfStudents;
  }

  /**
   * Sets all the course information
   * @param courseName name of course
   * @param courseType type of course
   * @param numberOfStudents number of students in course
   * */
  public void set(String courseName, String courseType, int numberOfStudents)
  {
    this.courseName = courseName;
    this.courseType = courseType;
    this.numberOfStudents = numberOfStudents;
  }

  /**
   * Copies the course by returning a new instance with same information
   * @return Course object with the same fields
   * */
  public Course copy()
  {
    return new Course(courseName, courseType, numberOfStudents);
  }

  /**
   * Prints all the information about the course
   * @return String with info about fields
   */
  public String toString()
  {
    return "Course name: " + courseName + ", course type: " + courseType
        + ", number of students: " + numberOfStudents;
  }

  /**
   * Checks if two Course object are the same by comparing the fields
   * @param obj the Course you want to be compared against
   * @return boolean true if fields are same, false if not
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Course))
    {
      return false;
    }
    Course other = (Course) obj;

    if (courseName.equals(other.getCourseName()) && courseType
        .equals(other.getCourseType()) && numberOfStudents == other
        .getNumberOfStudents())
    {
      return true;
    }
    return false;
  }
}
