import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Contains an arraylist of all the exams
 * @author Group2
 * @version 1.0
 */
public class ExamList implements Serializable
{
  private ArrayList<Exam> exams;

  /**
   * No-arg constructor that initialises the arrayList
   */
  public ExamList()
  {
    exams = new ArrayList<>();
  }

  /**
   * Adds an exam to the list
   *
   * @param exam the exam to be added
   */
  public void addExam(Exam exam)
  {
    exams.add(exam);
  }

  /**
   * removes an exam from the list
   *
   * @param exam to be removed
   */
  public void removeExam(Exam exam)
  {
    if (exams.contains(exam))
    {
      exams.remove(exam);
    }
  }

  /**
   * Remove and exam by index
   * @param index wanted to be removed
   */
  public void removeExamByIndex(int index)
  {
    if (index < 0 || index > exams.size())
    {
    }
    else
    {
      exams.remove(index);
    }
  }

  /**
   * Remove an exam from the list by course name
   *
   * @param name the String name of the course to be removed
   */
  public void removeExamByCourseName(String name)
  {
    for (int i = 0; i < exams.size(); i++)
    {
      Course[] temp = exams.get(i).getAllCourses();
      for (int j = 0; j < temp.length; j++)
      {
        if (temp[j].getCourseName().equals(name))
        {
          exams.remove(i);
        }
      }
    }
  }

  /**
   * removes an exam by examiner ID
   *
   * @param examinerID String ID to be removed
   */
  public void removeExamByExaminerID(String examinerID)
  {
    for (int i = 0; i < exams.size(); i++)
    {
      Examiner[] temp = exams.get(i).getAllExaminers();

      for (int j = 0; j < temp.length; j++)
      {
        if (temp[j].getExaminerID().equals(examinerID))
        {
          exams.remove(i);
        }
      }
    }
  }

  /**
   * removes all exams on a given day
   *
   * @param day the day to be removed
   */
  public void removeAllExamsByDay(int day)
  {
    for (int i = 0; i < exams.size(); i++)
    {
      if (exams.get(i).getDate() == day)
      {
        exams.remove(i);
        //removes all exams with that day
      }
    }
  }

  /**
   * gets all the exams from the list
   *
   * @return array of all exams
   */
  public Exam[] getAllExams()
  {
    ArrayList<Exam> temp = new ArrayList<>();

    temp.addAll(exams);

    Exam[] returnArray = new Exam[temp.size()];
    return temp.toArray(returnArray);
  }

  /**
   * gets all exams on a given day
   *
   * @param day the day of the exams
   * @return array of all the exams on that day
   */
  public Exam[] getAllExamsOnDay(int day)
  {
    ArrayList<Exam> temp = new ArrayList<>();

    for (int i = 0; i < exams.size(); i++)
    {
      if (exams.get(i).getDate() == day)
      {
        temp.add(exams.get(i));
      }
    }

    Exam[] returnArray = new Exam[temp.size()];
    return temp.toArray(returnArray);
  }

  /**
   * Get an exam by index
   * @param index wanted to be gotten
   * @return an exam
   */
  public Exam getExam(int index)
  {
    if (index < exams.size())
    {
      return exams.get(index);
    }
    else
    {
      return null;
    }
  }

  /**
   * gets all the exams by examiner
   *
   * @param examinerID of the exams to be added
   * @return array with exams of given examiner ID
   */
  public Exam[] getAllExamsByExaminer(String examinerID)
  {
    ArrayList<Exam> temp = new ArrayList<>();

    for (int i = 0; i < exams.size(); i++)
    {
      Examiner[] exTemp = exams.get(i).getAllExaminers();

      for (int j = 0; j < exTemp.length; j++)
      {
        if (exTemp[j].getExaminerID().equals(examinerID))
        {
          temp.add(exams.get(i));
        }
      }
    }

    Exam[] returnArray = new Exam[temp.size()];
    return temp.toArray(returnArray);
  }

  /**
   * gets all the exams with a given roomnumber
   *
   * @param roomNumber roomnumber to find exams in
   * @return array of rooms in given roomnumber
   */
  public Exam[] getAllExamsByRoom(String roomNumber)
  {
    ArrayList<Exam> temp = new ArrayList<>();

    for (int i = 0; i < exams.size(); i++)
    {
      if (exams.get(i).getRoom().getRoomNumber().equals(roomNumber))
      {
        temp.add(exams.get(i));
      }
    }

    Exam[] returnArray = new Exam[temp.size()];
    return temp.toArray(returnArray);
  }

  /**
   * gets all exams with a given course name
   *
   * @param courseName course name to be searched with
   * @return array with all exams with given course name
   */
  public Exam[] getAllExamsByCourse(String courseName)
  {
    ArrayList<Exam> temp = new ArrayList<>();

    for (int i = 0; i < exams.size(); i++)
    {
      Course[] courseTemp = exams.get(i).getAllCourses();

      for (int j = 0; j < courseTemp.length; j++)
      {
        if (courseTemp[j].getCourseName().equals(courseName))
        {
          temp.add(exams.get(i));
        }
      }
    }

    Exam[] returnArray = new Exam[temp.size()];
    return temp.toArray(returnArray);
  }

  /**
   * Get the size of the ExamList
   * @return an int with the size of the examList
   */
  public int getSize()
  {
    return exams.size();
  }

  /**
   * to string method that prints all exams on separate lines
   *
   * @return
   */
  public String toString()
  {
    String returnString = "";

    for (int i = 0; i < exams.size(); i++)
    {
      returnString += exams.get(i).toString() + "\n";
    }

    return returnString;
  }
}
