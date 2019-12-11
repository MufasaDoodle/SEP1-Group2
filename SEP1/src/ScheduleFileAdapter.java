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

  //todo fix in astah
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

  public Examiner getExaminerByName(String firstName, String lastName)
  {
    ExaminerList result = null;
    Examiner returnExaminer = null;
    try
    {
      result = (ExaminerList) mfio.readObjectFromFile(examinerFile);
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

  public ExamList getAllExamsInOrder()
  {
    ExamList exams = new ExamList();
    Exam[] tempArray;

    try
    {
      ExamList result = (ExamList) mfio.readObjectFromFile(examFile);
      tempArray = result.getAllExamsInOrder();
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

  public ExamList getAllExamsByType(String examType)
  {
    ExamList exams = new ExamList();
    Exam[] tempArray;

    try
    {
      ExamList result = (ExamList) mfio.readObjectFromFile(examFile);
      tempArray = result.getAllExamsByType(examType);
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

  public int getExamDuration(String courseName)
  {
    ExamList exams = new ExamList();
    int returnInt = 0;

    try
    {
      ExamList result = (ExamList) mfio.readObjectFromFile(examFile);
      returnInt = result.getExamDuration(courseName);
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

  public RoomList getAllAvailableRooms(int day)
  {
    RoomList rooms = null;
    Room[] tempArray;

    try
    {
      RoomList result = (RoomList) mfio.readObjectFromFile(roomFile);
      ExamList exams = (ExamList) mfio.readObjectFromFile(examFile);
      tempArray = result.getAllAvailableRooms(day, exams);
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

  public RoomList getAllUnavailableRooms(int day)
  {
    RoomList rooms = null;
    Room[] tempArray;

    try
    {
      RoomList result = (RoomList) mfio.readObjectFromFile(roomFile);
      ExamList exams = (ExamList) mfio.readObjectFromFile(examFile);
      tempArray = result.getAllUnavailableRooms(day, exams);
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
      RoomList result = (RoomList) mfio.readObjectFromFile(courseFile);
      returnInt = result.getNumberOfRooms();
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
      result = (RoomList) mfio.readObjectFromFile(examinerFile);
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
      result = (CourseList) mfio.readObjectFromFile(examinerFile);
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
      result = (ExamList) mfio.readObjectFromFile(examinerFile);
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
      result = (RoomList) mfio.readObjectFromFile(examinerFile);
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
      result = (CourseList) mfio.readObjectFromFile(examinerFile);
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
    ExaminerList result = null;
    try
    {
      result = (ExaminerList) mfio.readObjectFromFile(examinerFile);
      result.addExaminer(examiner);
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
    RoomList result = null;
    try
    {
      result = (RoomList) mfio.readObjectFromFile(examinerFile);
      result.addRoom(room);
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

  public void addCourse(Course course)
  {
    CourseList result = null;
    try
    {
      result = (CourseList) mfio.readObjectFromFile(examinerFile);
      result.addCourse(course);
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
    ExaminerList result = null;
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
    RoomList result = null;
    try
    {
      result = (RoomList) mfio.readObjectFromFile(examinerFile);
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
    CourseList result = null;
    try
    {
      result = (CourseList) mfio.readObjectFromFile(examinerFile);
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