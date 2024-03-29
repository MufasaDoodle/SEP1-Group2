import java.io.Serializable;
import java.util.ArrayList;

/**
 * Used to store an arrayList of courses
 *
 * @author Group2
 * @version 1.0
 */

public class CourseList implements Serializable
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
   * Gets the number of courses from the CourseList
   *
   * @return an int with the size of the CourseList
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

  /**
   * gets the course name at given index
   *
   * @param index the index
   * @return the course name at given index
   */
  public String getCourseName(int index)
  {
    if (index < 0 || index > courses.size())
    {
      return "INVALID INDEX";
    }
    else
    {
      return courses.get(index).getCourseName();
    }
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
  }

  /**
   * Set a course with new details to the required index
   *
   * @param course the new course wanted to be added
   * @param index  the required index want to set the course
   */
  public void set(Course course, int index)
  {
    courses.set(index, course);
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
  }

  /**
   * Remove a course by index from the CourseList
   * @param index the required index want to remove
   */
  public void removeCourseByIndex(int index)
  {
    if (index < 0 || index > courses.size())
    {
    }
    else
    {
      courses.remove(index);
    }
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

    Course[] returnArray = new Course[temp.size()];
    return temp.toArray(returnArray);
  }

  /**
   * Give the size of the CourseList (ArrayList)
   * @return an int with the size of the CourseList
   */
  public int getSize()
  {
    return courses.size();
  }

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

    Course[] returnArray = new Course[temp.size()];
    return temp.toArray(returnArray);
  }

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
   * a to string method that returns every course on different lines
   *
   * @return a String with information about all courses in the list
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
