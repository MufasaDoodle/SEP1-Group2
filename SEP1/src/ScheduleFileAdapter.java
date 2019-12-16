import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ScheduleFileAdapter
{
  private MyFileIO mfio;
  private String examFile;
  private String roomFile;
  private String examinerFile;
  private String courseFile;

  public ScheduleFileAdapter(String examFile, String roomFile,
      String examinerFile, String courseFile)
  {
    mfio = new MyFileIO();
    this.examFile = examFile;
    this.roomFile = roomFile;
    this.examinerFile = examinerFile;
    this.courseFile = courseFile;
  }

  public ExaminerList getAllExaminers()
  {
    ExaminerList examiners = new ExaminerList();

    try
    {
      examiners = (ExaminerList) mfio.readObjectFromFile(examinerFile);
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

  public Examiner getExaminerById(String Id)
  {
    ExaminerList result = null;
    Examiner returnExaminer = null;
    try
    {
      result = (ExaminerList) mfio.readObjectFromFile(examinerFile);

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

  public Examiner getExaminerByName(String fullName)
  {
    ExaminerList result = null;
    Examiner returnExaminer = null;
    try
    {
      result = (ExaminerList) mfio.readObjectFromFile(examinerFile);
      returnExaminer = result.getByName(fullName);

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

  public Examiner getExaminerByCourse(String course)
  {
    Examiner examiner = null;

    try
    {
      ExaminerList result = (ExaminerList) mfio
          .readObjectFromFile(examinerFile);

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
      result = (ExaminerList) mfio.readObjectFromFile(examinerFile);
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
      result = (ExaminerList) mfio.readObjectFromFile(examinerFile);
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

  public ExaminerList getAllAvailableExaminers(int day)
  {
    ExaminerList examiners = new ExaminerList();
    Examiner[] tempArray;

    try
    {
      ExaminerList result = (ExaminerList) mfio
          .readObjectFromFile(examinerFile);
      tempArray = result.getAllExaminers();

      for (int i = 0; i < tempArray.length; i++)
      {
        if (!(tempArray[i].getReservedDays().contains(day)))
        {
          examiners.addExaminer(tempArray[i]);
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

    return examiners;
  }

  public ExaminerList getAllUnavailableExaminers(int day)
  {
    ExaminerList examiners = new ExaminerList();
    Examiner[] tempArray;

    try
    {
      examiners = (ExaminerList) mfio.readObjectFromFile(examinerFile);

      ExaminerList temp = getAllAvailableExaminers(day);
      for (int i = 0; i < temp.getAllExaminers().length; i++)
      {
        examiners.removeExaminerByID(temp.getAllExaminers()[i].getExaminerID());
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

    return examiners;
  }

  public RoomList getAllAvailableRooms(int day)
  {
    RoomList rooms = new RoomList();
    Room[] tempArray;

    try
    {
      RoomList result = (RoomList) mfio.readObjectFromFile(roomFile);
      tempArray = result.getAllRooms();

      for (int i = 0; i < tempArray.length; i++)
      {
        if (!(tempArray[i].getReservedDays().contains(day)))
        {
          rooms.addRoom(tempArray[i]);
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

    return rooms;
  }

  public RoomList getAllUnavailableRooms(int day)
  {
    RoomList rooms = new RoomList();
    Room[] tempArray;

    try
    {
      rooms = (RoomList) mfio.readObjectFromFile(roomFile);

      RoomList temp = getAllAvailableRooms(day);
      for (int i = 0; i < temp.getAllRooms().length; i++)
      {
        rooms.removeRoomByRoomNumber(temp.getAllRooms()[i].getRoomNumber());
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

    return rooms;
  }

  public void saveExaminers(ExaminerList examinerList)
  {
    try
    {
      mfio.writeToFile(examinerFile, examinerList);
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
      exams = (ExamList) mfio.readObjectFromFile(examFile);
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

  public ExamList getAllExamsOnDay(int day)
  {
    ExamList exams = new ExamList();
    Exam[] tempArray;

    try
    {
      ExamList result = (ExamList) mfio.readObjectFromFile(examFile);
      tempArray = result.getAllExamsOnDay(day);
      exams = (ExamList) Arrays.asList(tempArray);
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

  public ExamList getAllExamsByExaminer(String examinerID)
  {
    ExamList exams = new ExamList();
    Exam[] tempArray;

    try
    {
      ExamList result = (ExamList) mfio.readObjectFromFile(examFile);
      tempArray = result.getAllExamsByExaminer(examinerID);
      exams = (ExamList) Arrays.asList(tempArray);
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

  public ExamList getAllExamsByRoom(String roomNumber)
  {
    ExamList exams = new ExamList();
    Exam[] tempArray;

    try
    {
      ExamList result = (ExamList) mfio.readObjectFromFile(examFile);
      tempArray = result.getAllExamsByRoom(roomNumber);
      exams = (ExamList) Arrays.asList(tempArray);
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

  public ExamList getAllExamsByCourse(String courseName)
  {
    ExamList exams = new ExamList();
    Exam[] tempArray;

    try
    {
      ExamList result = (ExamList) mfio.readObjectFromFile(examFile);
      tempArray = result.getAllExamsByCourse(courseName);
      exams = (ExamList) Arrays.asList(tempArray);
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

  public void saveExams(ExamList examList)
  {
    try
    {
      mfio.writeToFile(examFile, examList);
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

  public RoomList getRooms()
  {
    RoomList rooms = new RoomList();

    try
    {
      rooms = (RoomList) mfio.readObjectFromFile(roomFile);
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
      result = (RoomList) mfio.readObjectFromFile(roomFile);
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
      result = (RoomList) mfio.readObjectFromFile(roomFile);
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
      result = (RoomList) mfio.readObjectFromFile(roomFile);
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

  public void setRoomReservation(Integer day, String ID)
  {
    try
    {
      RoomList result = (RoomList) mfio.readObjectFromFile(roomFile);
      Room[] rooms = result.getAllRooms();

      if (!(day < 1) && !(day > 31))
      {
        for (int i = 0; i < rooms.length; i++)
        {
          if (rooms[i].getRoomNumber().equals(ID))
          {
            rooms[i].addReservation(day);
            result.set(rooms[i], i);
            saveRooms(result);
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
  }

  public void removeRoomReservation(Integer day, String ID)
  {
    try
    {
      RoomList result = (RoomList) mfio.readObjectFromFile(roomFile);
      Room[] rooms = result.getAllRooms();

      if (!(day < 1) && !(day > 31))
      {
        for (int i = 0; i < rooms.length; i++)
        {
          if (rooms[i].getRoomNumber().equals(ID))
          {
            for (int j = 0; j < rooms[i].getReservedDays().size(); j++)
            {
              if (rooms[i].getReservedDays().get(j).equals(day))
              {
                rooms[i].removeReservation(day);
                result.set(rooms[i], i);
                saveRooms(result);
                break;
              }
            }
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
  }

  public void setExaminerReservation(Integer day, String ID)
  {
    try
    {
      ExaminerList result = (ExaminerList) mfio
          .readObjectFromFile(examinerFile);
      Examiner[] examiners = result.getAllExaminers();

      if (!(day < 1) && !(day > 31))
      {
        for (int i = 0; i < examiners.length; i++)
        {
          if (examiners[i].getExaminerID().equals(ID))
          {
            examiners[i].addReservation(day);
            result.set(examiners[i], i);
            saveExaminers(result);
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
  }

  public void removeExaminerReservation(Integer day, String ID)
  {
    try
    {
      ExaminerList result = (ExaminerList) mfio
          .readObjectFromFile(examinerFile);
      Examiner[] examiners = result.getAllExaminers();

      if (!(day < 1) && !(day > 31))
      {
        for (int i = 0; i < examiners.length; i++)
        {
          if (examiners[i].getExaminerID().equals(ID))
          {
            for (int j = 0; j < examiners[i].getReservedDays().size(); j++)
            {
              if (examiners[i].getReservedDays().get(j).equals(day))
              {
                examiners[i].removeReservation(day);
                result.set(examiners[i], i);
                saveExaminers(result);
                break;
              }
            }
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
  }

  public RoomList getAllRoomsBiggerThan(int size)
  {

    RoomList rooms = null;
    Room[] tempArray;

    try
    {
      RoomList result = (RoomList) mfio.readObjectFromFile(roomFile);
      ExamList exams = (ExamList) mfio.readObjectFromFile(examFile);
      tempArray = result.getRoomsBiggerThan(size);
      rooms = (RoomList) Arrays.asList(tempArray);
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

  public RoomList getAllRoomsSmallerThan(int size)
  {

    RoomList rooms = null;
    Room[] tempArray;

    try
    {
      RoomList result = (RoomList) mfio.readObjectFromFile(roomFile);
      ExamList exams = (ExamList) mfio.readObjectFromFile(examFile);
      tempArray = result.getRoomsSmallerThan(size);
      rooms = (RoomList) Arrays.asList(tempArray);
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

  public RoomList getAllRoomsWithProjector()
  {

    RoomList rooms = null;
    Room[] tempArray;

    try
    {
      RoomList result = (RoomList) mfio.readObjectFromFile(roomFile);
      ExamList exams = (ExamList) mfio.readObjectFromFile(examFile);
      tempArray = result.getRoomsWithProjector();
      rooms = (RoomList) Arrays.asList(tempArray);
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

  public void saveRooms(RoomList roomList)
  {
    try
    {
      mfio.writeToFile(roomFile, roomList);
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

  public CourseList getAllCourses()
  {
    CourseList courses = new CourseList();

    try
    {
      courses = (CourseList) mfio.readObjectFromFile(courseFile);
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

  public int getNumberOfCourses()
  {
    int returnInt = 0;

    try
    {
      CourseList result = (CourseList) mfio.readObjectFromFile(courseFile);
      returnInt = result.getNumberOfCourses();
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

  public Course getCourse(int index)
  {
    CourseList courses = new CourseList();
    Course course = null;

    try
    {
      courses = (CourseList) mfio.readObjectFromFile(courseFile);
      course = courses.getCourse(index);
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

  public String getCourseName(int index)
  {
    CourseList courses;
    String returnString = "";

    try
    {
      courses = (CourseList) mfio.readObjectFromFile(courseFile);
      returnString = courses.getCourseName(index);
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
    return returnString;
  }

  public String getCourseType(int index)
  {
    CourseList courses;
    String returnString = "";

    try
    {
      courses = (CourseList) mfio.readObjectFromFile(courseFile);
      returnString = courses.getCourseType(index);
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
    return returnString;
  }

  public int getNumberOfStudentsInCourse(int index)
  {
    CourseList courses;
    int returnInt = 0;

    try
    {
      courses = (CourseList) mfio.readObjectFromFile(courseFile);
      returnInt = courses.getNumberOfStudents(index);
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

  public CourseList getAllOralCourses()
  {
    CourseList courses = null;
    Course[] tempArray;

    try
    {
      CourseList result = (CourseList) mfio.readObjectFromFile(courseFile);
      tempArray = result.getAllOralCourses();
      courses = (CourseList) Arrays.asList(tempArray);
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

  public CourseList getAllWrittenCourses()
  {
    CourseList courses = null;
    Course[] tempArray;

    try
    {
      CourseList result = (CourseList) mfio.readObjectFromFile(courseFile);
      tempArray = result.getAllWrittenCourses();
      courses = (CourseList) Arrays.asList(tempArray);
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

  public int getNumberOfOralCourses()
  {
    CourseList courses;
    int returnInt = 0;

    try
    {
      courses = (CourseList) mfio.readObjectFromFile(courseFile);
      returnInt = courses.getNumberOfOralCourses();
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

  public int getNumberOfWrittenCourses()
  {
    CourseList courses;
    int returnInt = 0;

    try
    {
      courses = (CourseList) mfio.readObjectFromFile(courseFile);
      returnInt = courses.getNumberOfWrittenCourses();
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

  public Course getCourseByName(String name)
  {
    Course course = null;

    try
    {
      CourseList result = (CourseList) mfio.readObjectFromFile(courseFile);

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
      mfio.writeToFile(courseFile, courseList);
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
    ExaminerList result = null;
    try
    {
      result = (ExaminerList) mfio.readObjectFromFile(examinerFile);
      result.removeExaminerByID(ID);
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

    saveExaminers(result); //to save, right????
  }

  public void removeRoomByNumber(String roomNumber)
  {
    RoomList result = null;
    try
    {
      result = (RoomList) mfio.readObjectFromFile(roomFile);
      result.removeRoomByRoomNumber(roomNumber);
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
    saveRooms(result); //to save, right????
  }

  public void removeCourseByName(String courseName)
  {
    CourseList result = null;
    try
    {
      result = (CourseList) mfio.readObjectFromFile(courseFile);
      result.removeCourse(courseName);
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
    saveCourses(result); //to save, right????
  }

  public void removeExamByIndex(int index)
  {
    ExamList result = null;
    try
    {
      result = (ExamList) mfio.readObjectFromFile(examFile);
      result.removeExamByIndex(index);
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

    saveExams(result); //to save, right????
  }

  public void removeExaminerByIndex(int index)
  {
    ExaminerList result = null;
    try
    {
      result = (ExaminerList) mfio.readObjectFromFile(examinerFile);
      result.removeExaminerByIndex(index);
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

    saveExaminers(result); //to save, right????
  }

  public void removeRoomByIndex(int index)
  {
    RoomList result = null;
    try
    {
      result = (RoomList) mfio.readObjectFromFile(roomFile);
      result.removeRoomByIndex(index);
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

    saveRooms(result); //to save, right????
  }

  public void removeCourseByIndex(int index)
  {
    CourseList result = null;
    try
    {
      result = (CourseList) mfio.readObjectFromFile(courseFile);
      result.removeCourse(index);
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

    saveCourses(result); //to save, right????
  }

  public void addExaminer(Examiner examiner)
  {
    ExaminerList result = new ExaminerList();
    try
    {
      File file = new File("ExaminerList.bin");
      if (file.length() == 0)
      {
        result.addExaminer(examiner);
      }
      else
      {
        result = (ExaminerList) mfio.readObjectFromFile(examinerFile);
        result.addExaminer(examiner);
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

    saveExaminers(result); //to save, right????
  }

  public void addRoom(Room room)
  {
    RoomList result = new RoomList();
    try
    {
      File file = new File("RoomList.bin");
      if (file.length() == 0)
      {
        result.addRoom(room);
      }
      else
      {
        result = (RoomList) mfio.readObjectFromFile(roomFile);
        result.addRoom(room);
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    saveRooms(result); //to save, right????
  }

  public void addExam(Exam exam)
  {
    ExamList result = new ExamList();
    try
    {
      File file = new File("ExamList.bin");

      if (file.length() == 0)
      {
        result.addExam(exam);
      }
      else
      {
        result = (ExamList) mfio.readObjectFromFile(examFile);
        result.addExam(exam);
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
    saveExams(result); //to save, right????
  }

  public void addCourse(Course course)
  {
    CourseList result = new CourseList();
    try
    {
      File file = new File("CourseList.bin");
      if (file.length() == 0)
      {
        result.addCourse(course);
      }
      else
      {
        result = (CourseList) mfio.readObjectFromFile(courseFile);
        result.addCourse(course);
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
    saveCourses(result); //to save, right????
  }

  public void changeExaminerInfo(Examiner examiner, int index)
  {
    ExaminerList result = new ExaminerList();
    try
    {
      result = (ExaminerList) mfio.readObjectFromFile(examinerFile);
      result.set(examiner, index);
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

    saveExaminers(result); //to save, right????
  }

  public void changeRoomInfo(Room room, int index)
  {
    RoomList result = new RoomList();
    try
    {
      result = (RoomList) mfio.readObjectFromFile(roomFile);
      result.set(room, index);
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
    saveRooms(result); //to save, right????
  }

  public void changeCourseInfo(Course course, int index)
  {
    CourseList result = new CourseList();
    try
    {
      result = (CourseList) mfio.readObjectFromFile(courseFile);
      result.set(course, index);
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
    saveCourses(result); //to save, right????
  }
}