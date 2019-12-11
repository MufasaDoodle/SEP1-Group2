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
    ExaminerList result = null;
    Examiner returnExaminer = null;
    try
    {
      result = (ExaminerList) mfio.readObjectFromFile(fileName);

      returnExaminer = result.getByID(Id);
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

    return returnExaminer;
  }

  public Examiner getExaminerByName(String firstName, String lastName)
  {
    ExaminerList result = null;
    Examiner returnExaminer = null;
    try
    {
      result = (ExaminerList) mfio.readObjectFromFile(fileName);
      returnExaminer = result.getByName(firstName, lastName);

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

    return returnExaminer;
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

  public int getAmountOfExaminers()
  {
    ExaminerList result = null;
    int returnInt = 0;
    try
    {
      result = (ExaminerList) mfio.readObjectFromFile(fileName);
      returnInt = result.getSize();
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

    return returnInt;
  }

  public Examiner getExaminer(int index)
  {
    ExaminerList result = null;
    Examiner returnExaminer = null;
    try
    {
      result = (ExaminerList) mfio.readObjectFromFile(fileName);
      returnExaminer = result.getExaminer(index);

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

    return returnExaminer;
  }

  public void saveExaminers(ExaminerList examinerList)
  {
    try
    {
      mfio.writeToFile(fileName, examinerList);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }

  public ExamList getAllExams()
  {
    ExamList exams = new ExamList();

    try
    {
      exams = (ExamList) mfio.readObjectFromFile(fileName);
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
    return exams;
  }

  //TODO the rest of the things here

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
    RoomList result;
    Room room = null;

    try
    {
      result = (RoomList) mfio.readObjectFromFile(fileName);
      room = result.getRoomByNumber(roomNumber);
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

  public int getAmountOfRooms(int index)
  {
    RoomList result;
    int amount = 0;

    try
    {
      result = (RoomList) mfio.readObjectFromFile(fileName);
      amount = result.getSize();
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
    return amount;
  }

  public Room getRoom(int index)
  {
    RoomList result;
    Room room = null;

    try
    {
      result = (RoomList) mfio.readObjectFromFile(fileName);
      room = result.getRoom(index);
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

  public RoomList getAllAvailableRooms(int day)
  {
    RoomList result;
    RoomList rooms = null;

    try
    {
      result = (RoomList) mfio.readObjectFromFile(fileName);
      rooms = result.getAllAvailableRooms(day, result);
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

  public void saveRooms(RoomList roomList)
  {
    try
    {
      mfio.writeToFile(fileName, roomList);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
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

  public void saveCourses(CourseList courseList)
  {
    try
    {
      mfio.writeToFile(fileName, courseList);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
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
