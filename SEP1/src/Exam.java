import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Christian Sejer
 * @version 1.0
 * This class stores info about an exam
 */
public class Exam implements Serializable
{
  private int date;
  private String duration;
  private ArrayList<Course> courses = new ArrayList<>();
  private Room room;
  private ArrayList<Examiner> examiners = new ArrayList<>();
  private String coExaminer;

  //TODO fix javadocs params (add examType)

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
/*
  /**

  public Exam(MyDate date, Room room, int duration, Course[] courses,
      Examiner[] examiners, String examType)
  {
    this.date = date;
    this.duration = duration;
    this.room = room;
    this.courses.addAll(Arrays.asList(courses));
    this.examiners.addAll(Arrays.asList(examiners));
    this.examType = examType;
  }


  public Exam(MyDate date, Room room, int duration, Course[] courses,
      ArrayList<Examiner> examiners, String examType)
  {
    this.date = date;
    this.duration = duration;
    this.room = room;
    this.courses.addAll(Arrays.asList(courses));
    this.examiners = examiners;
    this.examType = examType;
  }
  */

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
   * add an examiner to the exam
   *
   * @param examiner the examiner wished to be added
   */
  public void addExaminer(Examiner examiner)
  {
    examiners.add(examiner);

    //TODO check if examiner already has an exam on same date
    // one way to do this, is to have an examList, that the schedule checks
    // through and see if two exams has the same date and same examiner
  }

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
    return (Examiner[]) examiners.toArray();
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

  //TODO javadocs
  /*public static Comparator<Exam> examDayNumber = new Comparator<Exam>()
  {
    public int compare(Exam e1, Exam e2)
    {
      int examNr1 = e1.getDate().getDay();
      int examNr2 = e2.getDate().getDay();

      For ascending order
      return examNr1 - examNr2;
    }
  };*/

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
            + room.getRoomNumber() + "                                               " + examiners.get(0)
            .getFullName() + "                      ";
      }
      else
      {
        return "January: " + date + "     " + duration + "                   "
            + courses.get(0).getCourseName() + "(" + courses.get(0)
            .getCourseType() + ")"
            + "                                       " + room
            .getRoomNumber() + "                                               " + examiners.get(0)
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
            + room.getRoomNumber() + "                                               " + examiners.get(0)
            .getFullName() + "                                            " + coExaminer;
      }
      else
      {
        return "January: " + date + "     " + duration + "                   "
            + courses.get(0).getCourseName() + "(" + courses.get(0)
            .getCourseType() + ")"
            + "                                       " + room
            .getRoomNumber() + "                                               " + examiners.get(0)
            .getFullName() + "                                            " + coExaminer;
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
}
