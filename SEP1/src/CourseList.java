import java.util.ArrayList;

public class CourseList
{
  private ArrayList<Course> courses;

  public CourseList()
  {
    courses = new ArrayList<>();
  }

  public int getNumberOfCourses()
  {
    return courses.size() + 1;
  }

  public Course getCourse(int index)
  {
    return courses.get(index);
  }

  public String getCourseName(int index)
  {
    return courses.get(index).getCourseName();
  }

  public String getCourseType(int index)
  {
    return courses.get(index).getCourseType();
  }

  public int getNumberOfStudents(int index)
  {
    return courses.get(index).getNumberOfStudents();
  }

  public void addCourse(Course course)
  {
    courses.add(course);
  }

  public void removeCourse(int index)
  {
    courses.remove(index);
    //TODO check examinerList if it has an examiner with with the name
  }

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

  public Course[] getAllCourses()
  {
    return (Course[]) courses.toArray();
  }

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
