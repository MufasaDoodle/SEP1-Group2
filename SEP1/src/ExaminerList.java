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
   * Creates an Array with all examiners from the ArrayList
   *
   * @return an Array with all examiners
   */
  public Examiner[] getAllExaminers()
  {
    Examiner[] tempArray = new Examiner[examiners.size()];
    int j = 0;
    for (int i = 0; i < examiners.size(); i++)
    {
      if (examiners.get(i).getExaminerType().equals("Examiner"))
      {
        tempArray[j] = examiners.get(i);
        j++;
      }
    }
    return examiners.toArray(tempArray);
  }

  /**
   * Creates an Array with all co-examiners from the ArrayList.
   *
   * @return an Array with all co-examiners
   */
  public Examiner[] getAllCoExaminers()
  {
    Examiner[] tempArray = new Examiner[examiners.size()];
    for (int i = 0; i < examiners.size(); i++)
    {
      for (int y = 0; y < examiners.size(); y++)
      {
        if (examiners.get(y).getExaminerType().equals("Co-examiner"))
        {
          tempArray[i] = examiners.get(y);
        }
      }
    }
    return examiners.toArray(tempArray);
  }

  /**
   * Creates an Array with all Examiner objects from the ArrayList.
   *
   * @return an Array with all Examiner objects
   */
  public Examiner[] getEveryone()
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
   * @param firstName the first name of the Examiner object
   * @param lastName  the last name of the Examiner object
   * @return the Examiner object with either the given first name or the last name if one exists, else null
   */
  public Examiner getByName(String firstName, String lastName)
  {
    Examiner examiner = null;
    for (int i = 0; i < examiners.size(); i++)
    {
      if (examiners.get(i).getFirstName().equals(firstName) && examiners.get(i)
          .getLastName().equals(lastName))
      {
        examiner = examiners.get(i);
      }
    }
    return examiner;
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