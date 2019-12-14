import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Examiner objects.
 *
 * @version 0.1;
 */
public class ExaminerList implements Serializable
{
  private ArrayList<Examiner> examiners;

  /**
   * No-argument constructor initializing the ExaminerList.
   */
  public ExaminerList()
  {
    examiners = new ArrayList<Examiner>();
  }

  /**
   * Adds an examiner to the list.
   *
   * @param examiner the examiner to add to the list
   */
  public void addExaminer(Examiner examiner)
  {
    examiners.add(examiner);
  }

  /**
   * Gets an Examiner object from position index from the list.
   *
   * @param index the position in the list of the Examiner object
   * @return the Examiner object at position index if one exists, else null
   */
  public Examiner getExaminer(int index)
  {
    if (index < examiners.size())
    {
      return examiners.get(index);
    }
    else
      return null;
  }

  /**
   * Removes an Examiner object.
   *
   * @param examiner the examiner to remove from the list
   */
  public void removeExaminer(Examiner examiner)
  {
    examiners.remove(examiner);
  }

  /**
   * Creates an Array with all Examiner objects from the ArrayList.
   *
   * @return an Array with all Examiner objects
   */
  public Examiner[] getAllExaminers()
  {
    Examiner[] tempArray = new Examiner[examiners.size()];
    return examiners.toArray(tempArray);
  }

  /**
   * Replaces the Examiner object at index with examiner
   *
   * @param examiner the examiner to replace with
   * @param index    the position in the list that will be replaced
   */
  public void set(Examiner examiner, int index)
  {
    examiners.set(index, examiner);
  }

  /**
   * Gets an Examiner object with either the given first name or the last name from the list.
   *
   * @param fullName the first name of the Examiner object
   * @return the Examiner object with either the given first name or the last name if one exists, else null
   */
  public Examiner getByName(String fullName)
  {
    Examiner examiner = null;
    for (int i = 0; i < examiners.size(); i++)
    {
      if (examiners.get(i).getFullName().equals(fullName))
      {
        examiner = examiners.get(i);
      }
    }
    return examiner;
  }

  //TODO astah
  public Examiner[] getAllAvailableExaminers(int day, ExamList exams)
  {
    ArrayList<Examiner> examinerResult = new ArrayList<>();

    for (int i = 0; i < examiners.size(); i++)
    {
      examinerResult.add(examiners.get(i));
    }

    for (int i = 0; i < exams.getSize(); i++)
    {
      if(exams.getAllExams()[i].getDate().getDay()==day)
      {
        for (int j = 0; j < exams.getAllExams()[i].getAllExaminers().length; j++)
        {
          examinerResult.remove(exams.getAllExams()[i].getAllExaminers()[j]);
        }
      }
    }

    Examiner[] returnArray = new Examiner[examinerResult.size()];
    return examinerResult.toArray(returnArray);
  }

  //TODO astah
  public Examiner[] getAllUnavailableExaminers(int day, ExamList exams)
  {
    ArrayList<Examiner> examinerResult = new ArrayList<>();

    for (int i = 0; i < examiners.size(); i++)
    {
      examinerResult.add(examiners.get(i));
    }

    Examiner[] available = getAllAvailableExaminers(day, exams);

    for (int i = 0; i < available.length; i++)
    {
      examinerResult.remove(available[i]);
    }

    Examiner[] returnArray = new Examiner[examinerResult.size()];
    return examinerResult.toArray(returnArray);
  }

  /**
   * Gets an Examiner object with the given ID from the list.
   *
   * @param examinerID the ID of the Examiner object
   * @return the Examiner object with the given ID if one exists, else null
   */
  public Examiner getByID(String examinerID)
  {
    Examiner examiner = null;
    for (int i = 0; i < examiners.size(); i++)
    {
      if (examiners.get(i).getExaminerID().equals(examinerID))
      {
        examiner = examiners.get(i);
      }
    }
    return examiner;
  }

  /**
   * Removes an Examiner object with the given ID
   * @param examinerID the ID of the Examiner object that is to be removed
   */
  public void removeExaminerByID(String examinerID)
  {
    for(int i=0; i<examiners.size(); i++)
    {
      if(examiners.get(i).getExaminerID().equals(examinerID))
      {
        examiners.remove(examiners.get(i));
      }
    }
  }

  //TODO javadocs
  public void removeExaminerByIndex(int index)
  {
    if (index < 0 || index > examiners.size())
    {
      //do nothing boi
    }
    else
    {
      examiners.remove(index);
    }
  }

  /**
   * Gets how many Examiner objects are in the list.
   *
   * @return the number of Examiner objects in the list
   */
  public int getSize()
  {
    return examiners.size();
  }

  /**
   * Gets a String representation of the ExaminerList.
   *
   * @return a String containing information about all Examiner objects in the list - each Examiner object followed by a new line character
   */
  public String toString()
  {
    String str = "";
    for (int i = 0; i < examiners.size(); i++)
    {
      Examiner temp = examiners.get(i);
      str += temp + "\n";
    }
    return str;
  }
}
