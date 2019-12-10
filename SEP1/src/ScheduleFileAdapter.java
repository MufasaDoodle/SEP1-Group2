import java.io.FileNotFoundException;
import java.io.IOException;

public class ScheduleFileAdapter
{
  private MyFileIO mfio;
  private String fileName;

  public ScheduleFileAdapter(String fileName)
  {
    mfio = new MyFileIO();
    this.fileName = fileName;
  }

  public ExaminerList getAllExaminers()
  {
    ExaminerList examiners = new ExaminerList();

    try
    {
      examiners = (ExaminerList) mfio.readObjectFromFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return examiners;
  }

  //todo fix in astah
  public Examiner getExaminerById(String Id)
  {
    Examiner examiner = null;

    try
    {
      ExaminerList result = (ExaminerList) mfio.readObjectFromFile(fileName);

      for (int i = 0; i < result.getSize(); i++)
      {
        if (result.getExaminer(i).getExaminerID().equals(Id))
        {
          examiner = result.getExaminer(i);
          break;
        }
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return examiner;
  }

  //todo fix in astah
  public Examiner getExaminerByCourse(String course)
  {
    Examiner examiner = null;

    try
    {
      ExaminerList result = (ExaminerList) mfio.readObjectFromFile(fileName);

      for (int i = 0; i < result.getSize(); i++)
      {
        Course[] temp = result.getExaminer(i).getAllCourses();

        for (int j = 0; j < temp.length; j++)
        {
          if (temp[j].getCourseName().equals(course))
          {
            examiner = result.getExaminer(i);
            break;
          }
        }
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return examiner;
  }

  public void saveExaminers()
  {
    //TODO implement this
  }

  public RoomList getRooms()
  {
    RoomList rooms = new RoomList();

    try
    {
      rooms = (RoomList) mfio.readObjectFromFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return rooms;
  }

  public Room getRoomByNumber(String roomNumber)
  {
    Room room = null;

    try
    {
      RoomList result = (RoomList) mfio.readObjectFromFile(fileName);

      for (int i = 0; i < result.getSize(); i++)
      {
        if (result.getRoom(i).getRoomNumber().equals(roomNumber))
        {
          room = result.getRoom(i);
          break;
        }
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return room;
  }

  public void saveRooms()
  {
    //TODO implement this
  }

  public CourseList getAllCourse()
  {
    CourseList courses = new CourseList();

    try
    {
      courses = (CourseList) mfio.readObjectFromFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return courses;
  }

  public Course getCourseByName(String name)
  {
    Course course = null;

    try
    {
      CourseList result = (CourseList) mfio.readObjectFromFile(fileName);

      for (int i = 0; i < result.getSize(); i++)
      {
        if (result.getCourseName(i).equals(name))
        {
          course = result.getCourse(i);
          break;
        }
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return course;
  }

  public void saveCourses()
  {
    //TODO implement this
  }

  public void removeExaminerById(String ID)
  {
    //TODO implement this
    saveExaminers(); //to save, right????
  }

  public void removeRoomByNumber(String roomNumber)
  {
    //TODO implement this
    saveRooms(); //to save, right????
  }

  public void removeCourseByName(String courseName)
  {
    //TODO implement this
    saveCourses(); //to save, right????
  }

  public void addExaminer()
  {
    //TODO implement this, not sure what to do for parameters
  }

  public void addRoom()
  {
    //TODO implement this, not sure what to do for parameters
  }

  public void addCourse()
  {
    //TODO implement this, not sure what to do for parameters
  }

  public void changeExaminerInfo()
  {
    //TODO implement this, not sure what to do for parameters
  }

  public void changeRoomInfo()
  {
    //TODO implement this, not sure what to do for parameters
  }

  public void changeCourseInfo()
  {
    //TODO implement this, not sure what to do for parameters
  }
}
