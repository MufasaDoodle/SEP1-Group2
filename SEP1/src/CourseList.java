import java.util.ArrayList;

/**
 * @author Christian Sejer
 * @version 1.0
 * Used to store an arrayList of courses
 */

public class CourseList
{
  private ArrayList<Course> courses;

  /**
   * No-arg constructor that initialises the arrayList of courses
   */
  public CourseList()
  {
    courses = new ArrayList<>();
  }

  /**
   * Gets the number of courses from the courselist
   *
   * @return
   */
  public int getNumberOfCourses()
  {
    return courses.size();
  }

  /**
   * gets the course at index param
   *
   * @param index the index
   * @return the course at given index
   */
  public Course getCourse(int index)
  {
    return courses.get(index);
  }
//TODO if-else
  /**
   * gets the course name at given index
   *
   * @param index the index
   * @return the course name at given index
   */
  public String getCourseName(int index)
  {
    return courses.get(index).getCourseName();
  }

  /**
   * gets the course type at given index
   *
   * @param index the index
   * @return returns the course at given index
   */
  public String getCourseType(int index)
  {
    return courses.get(index).getCourseType();
  }

  /**
   * get the number of students at given index
   *
   * @param index index
   * @return the number of students at given index
   */
  public int getNumberOfStudents(int index)
  {
    return courses.get(index).getNumberOfStudents();
  }

  /**
   * Add a course to the list
   *
   * @param course the course to be added
   */
  public void addCourse(Course course)
  {
    courses.add(course);
  }

  /**
   * removes a course at given index
   *
   * @param index the index
   */
  public void removeCourse(int index)
  {
    courses.remove(index);
    //TODO check examinerList if it has an examiner with with the name
  }

  /**
   * remove a course with a given name
   *
   * @param name the name of the course to be removed
   */
  public void removeCourse(String name)
  {
    for (int i = 0; i < courses.size(); i++)
    {
      if (courses.get(i).getCourseName().equals(name))
      {
        courses.remove(i);
      }
    }
    //TODO check examinerList if it has an examiner with with the name
  }

  /**
   * Gets an array with all the courses from the list
   *
   * @return an array with courses
   */
  public Course[] getAllCourses()
  {
    return (Course[]) courses.toArray();
  }

  /**
   * gets a course list with all the oral courses
   *
   * @return array with courses
   */
  public Course[] getAllOralCourses()
  {
    ArrayList<Course> temp = new ArrayList<>();

    for (int i = 0; i < courses.size(); i++)
    {
      if (courses.get(i).getCourseType() == "Oral"
          || courses.get(i).getCourseType() == "oral")
      {
        temp.add(courses.get(i));
      }
    }

    return (Course[]) courses.toArray();
  }
//TODO return temp
  /**
   * gets an array with all courses marked as written
   *
   * @return an array with written courses
   */
  public Course[] getAllWrittenCourses()
  {
    ArrayList<Course> temp = new ArrayList<>();

    for (int i = 0; i < courses.size(); i++)
    {
      if (courses.get(i).getCourseType() == "Written"
          || courses.get(i).getCourseType() == "written")
      {
        temp.add(courses.get(i));
      }
    }

    return (Course[]) courses.toArray();
  }
  //TODO return temp
  /**
   * get the number of oral courses
   *
   * @return an int with oral courses
   */
  public int getNumberOfOralCourses()
  {
    int returnInt = 0;

    for (int i = 0; i < courses.size(); i++)
    {
      if (courses.get(i).getCourseType() == "Oral"
          || courses.get(i).getCourseType() == "oral")
      {
        returnInt++;
      }
    }
    return returnInt;
  }

  /**
   * return the number of written courses
   *
   * @return an int with written courses
   */
  public int getNumberOfWrittenCourses()
  {
    int returnInt = 0;

    for (int i = 0; i < courses.size(); i++)
    {
      if (courses.get(i).getCourseType() == "Written"
          || courses.get(i).getCourseType() == "written")
      {
        returnInt++;
      }
    }

    return returnInt;
  }

  /**
   * a tostring method that returns every course on different lines
   *
   * @return
   */
  public String toString()
  {
    String returnString = "";

    for (int i = 0; i < courses.size(); i++)
    {
      returnString += courses.get(i).toString() + "\n";
    }

    return returnString;
  }
}
