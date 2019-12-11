import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Christian Sejer
 * @version 1.0
 * This class stores info about an exam
 */
public class Exam
{
  private int duration;
  private MyDate date;
  private ArrayList<Course> courses = new ArrayList<>();
  private Room room;
  private ArrayList<Examiner> examiners = new ArrayList<>();
  private String examType;

  //TODO fix javadocs params (add examType)
  /**
   * A constructor with four args that initialises things
   *
   * @param date     the date of the exam
   * @param room     the room of the exam
   * @param duration the duration of the exam
   * @param course   the course of the exam
   */
  public Exam(MyDate date, Room room, int duration, Course course, String examType)
  {
    this.date = date;
    this.duration = duration;
    this.room = room;
    this.courses.add(course);
    this.examType = examType;
  }

  /**
   * A constructor with four args that initialises things
   *
   * @param date     the date of the exam
   * @param room     the room of the exam
   * @param duration the duration of the exam
   * @param courses  the courses that are part of the exam
   */
  public Exam(MyDate date, Room room, int duration, Course[] courses, String examType)
  {
    this.date = date;
    this.duration = duration;
    this.room = room;
    this.courses.addAll(Arrays.asList(courses));
    this.examType = examType;
  }

  /**
   * a five arg constructor that initialises relevant fields
   *
   * @param date      the date of the exam
   * @param room      the room of the exam
   * @param duration  the duration of the exam
   * @param courses   the courses that are part of the exam
   * @param examiners the examiners(Array) that are part of the exam
   */
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

  /**
   * a five arg constructor that initialises relevant fields
   *
   * @param date      the date of the exam
   * @param room      the room of the exam
   * @param duration  the duration of the exam
   * @param courses   the courses that are part of the exam
   * @param examiners the examiners (arrayList) that are part of the exam
   */
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

  public void setExamType(String examType)
  {
    this.examType = examType;
  }

  public String getExamType()
  {
    return examType;
  }

  /**
   * gets the duration
   *
   * @return duration of exam
   */
  public int getDuration()
  {
    return duration;
  }

  /**
   * sets the duration of the exam
   *
   * @param duration duration to be set
   */
  public void setDuration(int duration)
  {
    this.duration = duration;
  }

  /**
   * gets the date of the exam
   *
   * @return the date of the exam
   */
  public MyDate getDate()
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
  public static Comparator<Exam> examDayNumber = new Comparator<Exam>()
  {
    public int compare(Exam e1, Exam e2)
    {
      int examNr1 = e1.getDate().getDay();
      int examNr2 = e2.getDate().getDay();

      /*For ascending order*/
      return examNr1 - examNr2;
    }
  };

  /**
   * a tostring method that shows all exam info
   *
   * @return a string with all the field info
   */
  public String toString()
  {
    if (examiners == null)
    {
      return "Course(s): " + courses.toString() + ", Date: " + date.toString()
          + ", room: " + room.toString() + ", duration: " + duration;
    }
    return "Course(s): " + courses.toString() + ", Date: " + date.toString()
        + ", room: " + room.toString() + ", duration: " + duration
        + ", examiner(s): " + examiners.toString();
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

    if (date.equals(other.getDate()) && room.getRoomNumber()
        .equals(other.getRoom().getRoomNumber()))
    {
      return true;
    }

    return false;
  }
}
