import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class stores info about an exam
 * @author Group2
 * @version 1.0
 */
public class Exam implements Serializable
{
  private int date;
  private String duration;
  private ArrayList<Course> courses = new ArrayList<>();
  private Room room;
  private ArrayList<Examiner> examiners = new ArrayList<>();
  private String coExaminer;

  /**
   *  Six-arguments constructor initializing the exam
   * @param date int day of the exam
   * @param duration String the time of the exam
   * @param course Course of the taken exam
   * @param room Room the exam is taken in
   * @param examiner Examiner of the exam
   * @param coExaminer CoExaminer of the exam
   */
  public Exam(int date, String duration, Course course, Room room,
      Examiner examiner, String coExaminer)
  {
    this.date = date;
    this.duration = duration;
    courses = new ArrayList<>();
    this.courses.add(course);
    this.room = room;
    examiners = new ArrayList<>();
    this.examiners.add(examiner);
    this.coExaminer = coExaminer;
  }

  /**
   * Five-arguments constructor initializing the exam
   * @param date int day of the exam
   * @param duration String the time of the exam
   * @param course Course of the taken exam
   * @param room Room the exam is taken in
   * @param examiner Examiner of the exam
   */
  public Exam(int date, String duration, Course course, Room room,
      Examiner examiner)
  {
    this.date = date;
    this.duration = duration;
    courses = new ArrayList<>();
    this.courses.add(course);
    this.room = room;
    examiners = new ArrayList<>();
    this.examiners.add(examiner);
  }

  /**
   * sets the duration of the exam
   *
   * @param duration duration to be set
   */
  public void setDuration(String duration)
  {
    this.duration = duration;
  }

  /**
   * gets the date of the exam
   *
   * @return the date of the exam
   */
  public int getDate()
  {
    return date;
  }

  /**
   * gets the duration of an exam
   * @return the duration of the exam
   */

  public String getDuration()
  {
    return duration;
  }

  /**
   * adds an examiner to an exam
   * @param examiner the examiner that is to be added
   */
  public void addExaminer(Examiner examiner)
  {
    examiners.add(examiner);
  }

  /**
   * Add an examiner to the ExaminerList by ID
   * @param ID examiner's ID want to be added
   * @param examinerList the list you want to add the examier
   */
  public void addExaminerByID(String ID, ExaminerList examinerList)
  {
    Examiner[] examinerArray = examinerList.getAllExaminers();

    for (int i = 0; i < examinerArray.length; i++)
    {
      if (examinerArray[i].getExaminerID().equals(ID))
      {
        examiners.add(examinerList.getByID(ID));
      }
    }
  }

  /**
   * gets all examiners
   *
   * @return an array with the examiners
   */
  public Examiner[] getAllExaminers()
  {
    Examiner[] returnArray = new Examiner[examiners.size()];
    returnArray = examiners.toArray(returnArray);

    return returnArray;
  }

  /**
   * remove an examiner by id
   *
   * @param ID the id of the examiner to be removed
   */
  public void removeExaminer(String ID)
  {
    for (int i = 0; i < examiners.size(); i++)
    {
      if (ID.equals(examiners.get(i).getExaminerID()))
      {
        examiners.remove(i);
        break;
      }
    }
  }

  /**
   * add a room to the exam
   *
   * @param room the room wished to be added
   */
  public void addRoom(Room room)
  {
    this.room = room;
  }

  /**
   * removes the room
   */
  public void removeRoom()
  {
    room = null;
  }

  /**
   * get the room
   *
   * @return the room of the exam
   */
  public Room getRoom()
  {
    return room;
  }

  /**
   * get all courses as array
   *
   * @return all courses as an array
   */
  public Course[] getAllCourses()
  {
    return (Course[]) courses.toArray();
  }

  /**
   * get the first course from the ArrayList of courses for an exam
   * @return the first course of an exam
   */

  public Course getTheCourse()
  {
    return courses.get(0);
  }
  /**
   * add a course to the exam
   *
   * @param course the course wished to be added to the exam
   */
  public void addCourse(Course course)
  {
    courses.add(course);
  }

  /**
   * remove a course from the exam
   *
   * @param courseName name of course to be removed from list
   */
  public void removeCourse(String courseName)
  {
    for (int i = 0; i < courses.size(); i++)
    {
      if (courses.get(i).getCourseName().equals(courseName))
      {
        courses.remove(i);
        break;
      }
    }
  }

  /**
   * a tostring method that shows all exam info
   *
   * @return a string with all the field info
   */
  public String toString()
  {
    if (coExaminer == null)
    {
      if (courses.get(0).getCourseType().equals("Written"))
      {
        return "January: " + date + "     " + duration + "                   "
            + courses.get(0).getCourseName() + "(" + courses.get(0)
            .getCourseType() + ")" + "                                 "
            + room.getRoomNumber() + "                               " + examiners.get(0)
            .getFullName() + "                      ";
      }
      else
      {
        return "January: " + date + "     " + duration + "                   "
            + courses.get(0).getCourseName() + "(" + courses.get(0)
            .getCourseType() + ")"
            + "                                       " + room
            .getRoomNumber() + "                               " + examiners.get(0)
            .getFullName() + "                      ";
      }
    }
    else
    {
      if (courses.get(0).getCourseType().equals("Written"))
      {
        return "January: " + date + "     " + duration + "                   "
            + courses.get(0).getCourseName() + "(" + courses.get(0)
            .getCourseType() + ")" + "                                 "
            + room.getRoomNumber() + "                               " + examiners.get(0)
            .getFullName() + "                            " + coExaminer;
      }
      else
      {
        return "January: " + date + "     " + duration + "                   "
            + courses.get(0).getCourseName() + "(" + courses.get(0)
            .getCourseType() + ")"
            + "                                       " + room
            .getRoomNumber() + "                               " + examiners.get(0)
            .getFullName() + "                            " + coExaminer;
      }
    }
  }

  /**
   * equals method to check if two exams are at the same time and room
   *
   * @param obj the object to be compared against
   * @return true or false if it's the same
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Exam))
    {
      return false;
    }

    Exam other = (Exam) obj;

    if (date == other.date && room.getRoomNumber()
        .equals(other.getRoom().getRoomNumber()))
    {
      return true;
    }

    return false;
  }

  /**
   * get the first examiner of an exam
   * @return the first examiner of an exam
   */
  public Examiner getExaminer()
  {
    return examiners.get(0);
  }

  /**
   * get the co-examiner of an exam
   * @return the co-examiner of the exam
   */
  public String getCoExaminer()
  {
    return coExaminer;
  }
}
