import parser.ParserException;
import parser.XmlJsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * A class which operated with files
 */
public class ScheduleFileAdapter
{
  private MyFileIO mfio;
  private String examFile;
  private String roomFile;
  private String examinerFile;
  private String courseFile;

  /**
   * Four-argument constructor initializing the ScheduleFileAdapter
   * @param examFile name of the exam holder file
   * @param roomFile name of the room holder file
   * @param examinerFile name of the examiner holder file
   * @param courseFile name of the course holder file
   */
  public ScheduleFileAdapter(String examFile, String roomFile,
      String examinerFile, String courseFile)
  {
    mfio = new MyFileIO();
    this.examFile = examFile;
    this.roomFile = roomFile;
    this.examinerFile = examinerFile;
    this.courseFile = courseFile;

  }

  /**
   * Gives all the examiner from the ExaminerList
   * @return an ExaminerList with all examiner
   */
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

  /**
   * Gives the examiner by ID
   * @param Id the required examiner's ID as a String
   * @return an Examiner
   */
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

  /**
   * Gives the examiner by name
   * @param fullName the required examiner's full name as a String
   * @return an examiner
   */
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

  /**
   * Gives the Examiner by course
   * @param course the required examiner's course
   * @return an examiner
   */
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

  /**
   * Gives the number of examiners from the examinerList
   * @return an integer with the number of examiners
   */
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

  /**
   * Gives an examiner by index
   * @param index the required index from the list
   * @return an examiner from the examinerList by index
   */
  public Examiner getExaminerByIndex(int index)
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

  /**
   * Gives all available examiners by day
   * @param day the required day wanted to be gotten the examiners
   * @return an ExaminerList
   */
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
  /**
   * Gives all unavailable examiners by day
   * @param day the required day wanted to be gotten the examiners
   * @return an ExaminerList
   */
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
  /**
   * Gives all available rooms by day
   * @param day the required day wanted to be gotten the rooms
   * @return a RoomList
   */
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

  /**
   * Gives all unavailable rooms by day
   * @param day the required day wanted to be gotten the rooms
   * @return a RoomList
   */
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

  /**
   * Save an examiner to the examList
   * @param examinerList the list you want to save the examiner(s)
   */
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

  /**
   * Gives all the exams
   * @return an ExamList with all exams
   */
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

  /**
   * Save the exam to the examList
   * @param examList the list you want to save the exam(s)
   */
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

  /**
   * Gives all the rooms from the roomList
   * @return a roomList with all the rooms
   */
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

  /**
   * Gives room from the roomList by index
   * @param index an int, the required index
   * @return a Room
   */
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

  /**
   * Set the room reservation by day and room's ID
   * @param day an int, you want to reserve the room
   * @param ID a String, the room's ID you want to set
   */
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

  /**
   * Remove a room's reservation by day and room's ID
   * @param day an int, you want to remove the room
   * @param ID a String, the room's ID you want to remove
   */
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

  /**
   * Set the examiner reservation by day and examiner's ID
   * @param day an int, you want to reserve the examiner
   * @param ID a String, the examiner's ID you want to set
   */
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
  /**
   * Remove an examiner's reservation by day and examiner's ID
   * @param day an int, you want to remove the examiner
   * @param ID a String, the examiner's ID you want to remove
   */
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

  /**
   * Gives all he rooms with bigger size than the given argument
   * @param size an int, want a bigger room size than it
   * @return a roomList with the required rooms
   */
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

  /**
   * Gives all he rooms with smaller size than the given argument
   * @param size an int, want a smaller room size than it
   * @return a roomList with the required rooms
   */
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

  /**
   * Gives all he rooms with projector
   * @return a roomList with the required rooms
   */
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

  /**
   * Save the rooms to the roomList
   * @param roomList the list you want to save the room(s)
   */
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

  /**
   * Gives all the courses from the courseList
   * @return a CourseList with all courses in it
   */
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

  /**
   * Gives the number of the courses
   * @return an int with the number of the courses
   */
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

  /**
   * Gives a course by index
   * @param index an int, index
   * @return a Course by index
   */
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

  /**
   * Gives the course name by index from the courseList
   * @param index an int, index from the list
   * @return a String with the required course name
   */
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

  /**
   * Gives the course type by index
   * @param index an int, an index from the list
   * @return a String with the required course type
   */
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

  /**
   * Gives the number of students of the chosen course
   * @param index an int, the chosen course
   * @return an int, with the number of students of the course
   */
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

  /**
   * Gives all oral courses
   * @return a courseList with all oral courses
   */
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

  /**
   * Gives all written courses
   * @return a courseList with all written courses
   */
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
  /**
   * Gives the number of oral courses
   * @return an int, with number of oral courses
   */
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
  /**
   * Gives the number of written courses
   * @return an int, with number of written courses
   */
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
  /**
   * Gives a course by its name
   * @param name a String the required course's name
   * @return a Course
   */
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

  /**
   * Save the course(s) to the courseList
   * @param courseList the list you want to save the course(s)
   */
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

  /**
   * Remove an exam from the examList by index
   * @param index an int, as an index want to remove from the list
   */
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

    saveExams(result);
  }
  /**
   * Remove an examiner from the examinerList by index
   * @param index an int, as an index want to remove from the list
   */
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

    saveExaminers(result);
  }
  /**
   * Remove a room from the roomList by index
   * @param index an int, as an index want to remove from the list
   */
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

    saveRooms(result);
  }
  /**
   * Remove a course from the courseList by index
   * @param index an int, as an index want to remove from the list
   */
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

    saveCourses(result);
  }

  /**
   * Add an examiner to the examinerList
   * @param examiner an Examiner wanted to be added to the list
   */
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

    saveExaminers(result);
  }
  /**
   * Add a room to the roomList
   * @param room a Room wanted to be added to the list
   */
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
    saveRooms(result);
  }
  /**
   * Add an exam to the examList
   * @param exam an exam wanted to be added to the list
   */
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
    saveExams(result);
  }
  /**
   * Add a course to the courseList
   * @param course a Course wanted to be added to the list
   */
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
    saveCourses(result);
  }

  /**
   * Change the information about an examiner
   * @param examiner an Examiner wanted to be changed
   * @param index an int, the required index from list
   */
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

    saveExaminers(result);
  }
  /**
   * Change the information about a room
   * @param room a Room wanted to be changed
   * @param index an int, the required index from list
   */
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
    saveRooms(result);
  }
  /**
   * Change the information about a course
   * @param course a Course wanted to be changed
   * @param index an int, the required index from list
   */
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
    saveCourses(result);
  }

    public void exportToXml(ExamList exams) throws ParserException {
        XmlJsonParser parser = new XmlJsonParser();
        File file = parser.toXml(exams, "website.xml");
    }
}