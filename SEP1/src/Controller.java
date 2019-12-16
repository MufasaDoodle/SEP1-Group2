import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;

public class Controller
{

  private ScheduleFileAdapter adapter;

  @FXML private ComboBox<Integer> roomDay;
  @FXML private RadioButton roomAllRooms;
  @FXML private RadioButton roomAvailableRooms;
  @FXML private RadioButton roomUnavailableRooms;
  @FXML private RadioButton roomOralRooms;
  @FXML private TextField roomRoomSize;
  @FXML private TextField roomRoomNumber;
  @FXML private ComboBox<String> roomAvailability;
  @FXML private CheckBox roomProjector;
  @FXML private CheckBox roomHDMI;
  @FXML private CheckBox roomVGA;
  @FXML private Button roomUpdate;
  @FXML private ListView<Room> roomList;
  @FXML private Button roomAdd;
  @FXML private Button roomRemove;

  @FXML private ComboBox<Integer> examinerDay;
  @FXML private RadioButton examinerAllExaminers;
  @FXML private RadioButton examinerAvailableExaminers;
  @FXML private RadioButton examinerUnavailableExaminers;
  @FXML private TextField examinerName;
  @FXML private TextField examinerID;
  @FXML private ComboBox<Course> examinerCourse;
  @FXML private ComboBox<String> examinerAvailability;
  @FXML private Button examinerUpdate;
  @FXML private ListView<Examiner> examinerList;
  @FXML private Button examinerAdd;
  @FXML private Button examinerRemove;
  @FXML private Button examinerAddMoreCourse;

  @FXML private ListView<Course> courseList;
  @FXML private Button courseAdd;
  @FXML private Button courseRemove;
  @FXML private TextField courseName;
  @FXML private TextField courseNumberOfStudents;
  @FXML private ComboBox<String> courseExamInfo;
  @FXML private Button courseUpdate;

  @FXML private ComboBox<Integer> examDate;
  @FXML private TextField examFrom;
  @FXML private TextField examTo;
  @FXML private ComboBox<Course> examCourse;
  @FXML private ComboBox<Room> examRoom;
  @FXML private ComboBox<Examiner> examExaminer;
  @FXML private TextField examCoExaminer;
  @FXML private Button examSave;
  @FXML private ListView<Exam> examList;
  @FXML private Button examRemove;
  @FXML private Button updateListsButton;

  public void initialize()
  {
    adapter = new ScheduleFileAdapter("ExamList.bin", "RoomList.bin",
        "ExaminerList.bin", "CourseList.bin");
    roomDay.getItems().clear();
    examinerDay.getItems().clear();
    for (int i = 1; i <= 31; i++)
    {
      roomDay.getItems().add(i);
      examinerDay.getItems().add(i);
      examDate.getItems().add(i);
    }
    roomDay.getSelectionModel().selectFirst();
    examinerDay.getSelectionModel().selectFirst();
    examDate.getSelectionModel().selectFirst();
    roomAvailability.getItems().add("Available");
    roomAvailability.getItems().add("Unavailable");
    roomAvailability.getSelectionModel().selectFirst();
    examinerAvailability.getItems().add("Available");
    examinerAvailability.getItems().add("Unavailable");
    examinerAvailability.getSelectionModel().selectFirst();
    courseExamInfo.getItems().add("Written");
    courseExamInfo.getItems().add("Oral");
    courseExamInfo.getSelectionModel().selectFirst();

    CourseList courses1 = adapter.getAllCourses();
    for (int i = 0; i < courses1.getSize(); i++)
    {
      examinerCourse.getItems().add(courses1.getCourse(i));
      examCourse.getItems().add(courses1.getCourse(i));
    }
    examinerCourse.getSelectionModel().selectFirst();

    CourseList courses = new CourseList();
    courses = adapter.getAllCourses();
    for (int i = 0; i < courses.getSize(); i++)
    {
      courseList.getItems().add(courses.getCourse(i));
    }

    ExaminerList examiners = new ExaminerList();
    examiners = adapter.getAllAvailableExaminers(examDate.getSelectionModel().getSelectedItem());
    for (int i = 0; i < examiners.getSize(); i++)
    {
      examinerList.getItems().add(examiners.getExaminer(i));
      examExaminer.getItems().add(examiners.getExaminer(i));
    }

    RoomList rooms = new RoomList();
    rooms = adapter
        .getAllAvailableRooms(examDate.getSelectionModel().getSelectedItem());
    for (int i = 0; i < rooms.getSize(); i++)
    {
      examRoom.getItems().add(rooms.getRoom(i));
    }

    ExamList exams = new ExamList();
    exams = adapter.getAllExams();
    for (int i = 0; i < exams.getSize(); i++)
    {
      examList.getItems().add(exams.getExam(i));
    }

    courseList.getSelectionModel().selectedItemProperty()
        .addListener((new MyListListener()));
    roomList.getSelectionModel().selectedItemProperty()
        .addListener((new MyListListenerRoom()));
    examinerList.getSelectionModel().selectedItemProperty()
        .addListener(new MyListListenerExaminer());
  }

  public void handleRoom(ActionEvent e)
  {
    if (e.getSource() == roomAllRooms)
    {
      roomList.getItems().clear();
      RoomList rooms = adapter.getRooms();
      for (int i = 0; i < rooms.getSize(); i++)
      {
        roomList.getItems().add(rooms.getRoom(i));
      }

    }
    if (e.getSource() == roomAvailableRooms)
    {
      roomList.getItems().clear();
      RoomList rooms = adapter
          .getAllAvailableRooms(roomDay.getSelectionModel().getSelectedItem());
      for (int i = 0; i < rooms.getSize(); i++)
      {
        roomList.getItems().add(rooms.getRoom(i));
      }
    }
    if (e.getSource() == roomUnavailableRooms)
    {
      roomList.getItems().clear();
      RoomList rooms = adapter.getAllUnavailableRooms(
          roomDay.getSelectionModel().getSelectedItem());

      for (int i = 0; i < rooms.getSize(); i++)
      {
        roomList.getItems().add(rooms.getRoom(i));
      }
    }
    if (e.getSource() == roomOralRooms)
    {
      roomList.getItems().clear();
      RoomList rooms = adapter.getAllRoomsWithProjector();
      for (int i = 0; i < rooms.getSize(); i++)
      {
        roomList.getItems().add(rooms.getRoom(i));
      }

    }

    if (e.getSource() == roomAdd)
    {
      if (!(roomRoomSize.getText().equals("")) && !(roomRoomNumber.getText()
          .equals("")))
      {
        Room room = new Room(Integer.parseInt(roomRoomSize.getText()),
            roomRoomNumber.getText());
        if (roomProjector.isSelected())
        {
          room.setProjector(true);
          if (roomHDMI.isSelected())
          {
            room.setHDMI(true);
          }
          if (roomVGA.isSelected())
          {
            room.setVGA(true);
          }
        }
        if (!(roomProjector.isSelected()) && (roomHDMI.isSelected() || roomVGA
            .isSelected()))
        {
          JOptionPane.showMessageDialog(null,
              "You forgot to choose projector, please update the added room!",
              "Error", JOptionPane.WARNING_MESSAGE);
        }

        adapter.addRoom(room);
        roomList.getItems().add(room);

        examRoom.getItems().clear();
        RoomList rooms = adapter.getRooms();
        for (int i = 0; i < rooms.getSize(); i++)
        {
          examRoom.getItems().add(rooms.getRoom(i));
        }
      }

      else
      {
        JOptionPane.showMessageDialog(null, "Fill in all fields!", "Error",
            JOptionPane.WARNING_MESSAGE);
      }
    }

    if (e.getSource() == roomUpdate)
    {
      /*roomRoomSize.setText(roomRoomSize.getText());
      roomRoomNumber.setText(roomRoomNumber.getText());*/
      roomAvailability.getSelectionModel().getSelectedItem();

      boolean projector = false;
      boolean HDMI = false;
      boolean VGA = false;
      if (roomProjector.isSelected())
      {
        projector = true;
      }
      if (roomHDMI.isSelected())
      {
        HDMI = true;
      }
      if (roomVGA.isSelected())
      {
        VGA = true;
      }

      boolean availability = roomAvailability.getSelectionModel()
          .getSelectedItem().equals("Available");

      Room room = new Room(Integer.parseInt(roomRoomSize.getText()),
          roomRoomNumber.getText(), projector, HDMI, VGA, availability);

      adapter.changeRoomInfo(room,
          roomList.getSelectionModel().getSelectedIndex());
      roomList.getItems().clear();
      examRoom.getItems().clear();
      RoomList rooms = new RoomList();
      rooms = adapter.getRooms();
      for (int i = 0; i < rooms.getSize(); i++)
      {
        roomList.getItems().add(rooms.getRoom(i));
        examRoom.getItems().add(rooms.getRoom(i));
      }
      roomRoomSize.setText("");
      roomRoomNumber.setText("");
    }

    if (e.getSource() == roomRemove)
    {
      ExamList temp = adapter.getAllExams();
      boolean isSafe = true;

      for (int i = 0; i < temp.getSize(); i++)
      {
        if (temp.getExam(i).getRoom().getRoomNumber().equals(
            roomList.getSelectionModel().getSelectedItem().getRoomNumber()))
        {
          JOptionPane.showMessageDialog(null,
              "You cannot remove a room that is assigned to an exam!", "Error",
              JOptionPane.WARNING_MESSAGE);
          isSafe = false;
        }
      }
      if (isSafe)
      {
        adapter
            .removeRoomByIndex(roomList.getSelectionModel().getSelectedIndex());
        roomList.getItems()
            .remove(roomList.getSelectionModel().getSelectedIndex());

        examRoom.getItems().clear();
        RoomList rooms = adapter.getRooms();
        for (int j = 0; j < rooms.getSize(); j++)
        {
          examRoom.getItems().add(rooms.getRoom(j));
        }
      }

    }
  }

  public void handleExaminer(ActionEvent e)
  {
    if (e.getSource() == examinerAllExaminers)
    {
      examinerList.getItems().clear();
      ExaminerList examiners = adapter.getAllExaminers();
      for (int i = 0; i < examiners.getSize(); i++)
      {
        examinerList.getItems().add(examiners.getExaminer(i));
      }
    }
    if (e.getSource() == examinerAvailableExaminers)
    {
      examinerList.getItems().clear();
      ExaminerList examiners = adapter
          .getAllAvailableExaminers(examinerDay.getSelectionModel().getSelectedItem());
      for (int i = 0; i < examiners.getSize(); i++)
      {
        examinerList.getItems().add(examiners.getExaminer(i));
      }
    }
    if (e.getSource() == examinerUnavailableExaminers)
    {
      examinerList.getItems().clear();
      ExaminerList examiners = adapter
          .getAllUnavailableExaminers(examinerDay.getSelectionModel().getSelectedItem());
      for (int i = 0; i < examiners.getSize(); i++)
      {
        examinerList.getItems().add(examiners.getExaminer(i));
      }
    }

    if (e.getSource() == examinerAdd)
    {
      if (!(examinerName.getText().equals("")) && !(examinerID.getText()
          .equals("")))
      {
        Examiner examiner = new Examiner(examinerName.getText(),
            examinerID.getText());
        examiner
            .addCourse(examinerCourse.getSelectionModel().getSelectedItem());

        adapter.addExaminer(examiner);
        examinerList.getItems().add(examiner);
        examinerName.setText("");
        examinerID.setText("");

        examExaminer.getItems().clear();
        ExaminerList examiners = adapter.getAllExaminers();
        for (int i = 0; i < examiners.getSize(); i++)
        {
          examExaminer.getItems().add(examiners.getExaminer(i));
        }

      }
      else
      {
        JOptionPane.showMessageDialog(null, "Fill in all fields!", "Error",
            JOptionPane.WARNING_MESSAGE);
      }
    }

    if (e.getSource() == examinerRemove)
    {
      ExamList temp = adapter.getAllExams();
      boolean isSafe = true;

      for (int i = 0; i < temp.getSize(); i++)
      {
        for (int j = 0; j < temp.getExam(i).getAllExaminers().length; j++)
        {
          if (temp.getExam(i).getAllExaminers()[j].getExaminerID().equals(
              examinerList.getSelectionModel().getSelectedItem().getExaminerID()))
          {
            JOptionPane.showMessageDialog(null,
                "You cannot remove an examiner that is assigned to an exam!", "Error",
                JOptionPane.WARNING_MESSAGE);
            isSafe = false;
          }
        }
      }
      if (isSafe)
      {
        adapter.removeExaminerByIndex(
            examinerList.getSelectionModel().getSelectedIndex());
        examinerList.getItems()
            .remove(examinerList.getSelectionModel().getSelectedIndex());

        examExaminer.getItems().clear();
        ExaminerList examiners = adapter.getAllExaminers();
        for (int i = 0; i < examiners.getSize(); i++)
        {
          examExaminer.getItems().add(examiners.getExaminer(i));
        }
      }
    }

    if (e.getSource() == examinerUpdate)
    {
      Examiner selectedExaminer = examinerList.getSelectionModel()
          .getSelectedItem();

      selectedExaminer.setFullName(examinerName.getText());
      selectedExaminer.setExaminerID(examinerID.getText());

      if (examinerAvailability.getSelectionModel().getSelectedItem()
          .equals("Available"))
      {
        selectedExaminer.setAvailable(true);
      }
      else
      {
        selectedExaminer.setAvailable(false);
      }

      adapter.changeExaminerInfo(selectedExaminer,
          examinerList.getSelectionModel().getSelectedIndex());
      examinerList.getItems().clear();
      examExaminer.getItems().clear();
      ExaminerList examiners = adapter.getAllExaminers();
      for (int i = 0; i < examiners.getSize(); i++)
      {
        examinerList.getItems().add(examiners.getExaminer(i));
        examExaminer.getItems().add(examiners.getExaminer(i));
      }
      examinerName.setText("");
      examinerID.setText("");
      examinerCourse.getSelectionModel().selectFirst();
      examinerAvailability.getSelectionModel().selectFirst();
    }

    if (e.getSource() == examinerAddMoreCourse)
    {
      Examiner selectedExaminer = examinerList.getSelectionModel()
          .getSelectedItem();

      selectedExaminer
          .addCourse(examinerCourse.getSelectionModel().getSelectedItem());
      if (examinerCourse.getSelectionModel().getSelectedItem()
          .equals(selectedExaminer))
      {
        JOptionPane.showMessageDialog(null, "Fill in all fields!", "Error",
            JOptionPane.WARNING_MESSAGE);
      }

      examinerList.getItems().add(selectedExaminer);
      examinerList.getItems()
          .remove(examinerList.getSelectionModel().getSelectedIndex());
      adapter.removeExaminerByIndex(
          examinerList.getSelectionModel().getSelectedIndex());
      adapter.addExaminer(selectedExaminer);

      examExaminer.getItems().clear();
      ExaminerList examiners = adapter.getAllExaminers();
      for (int i = 0; i < examiners.getSize(); i++)
      {
        examExaminer.getItems().add(examiners.getExaminer(i));
      }

      examinerName.setText("");
      examinerID.setText("");
      examinerCourse.getSelectionModel().selectFirst();
      examinerAvailability.getSelectionModel().selectFirst();
    }

  }

  public void handleCourse(ActionEvent e)
  {
    if (e.getSource() == courseAdd)
    {
      if (!(courseName.getText().equals("")) && !(courseNumberOfStudents
          .getText().equals("")))
      {
        Course course = new Course(courseName.getText(),
            courseExamInfo.getSelectionModel().getSelectedItem(),
            Integer.parseInt(courseNumberOfStudents.getText()));
        adapter.addCourse(course);
        courseList.getItems().add(course);
        courseName.setText("");
        courseNumberOfStudents.setText("");
        examinerCourse.getItems().clear();
        examCourse.getItems().clear();
        CourseList courses1 = adapter.getAllCourses();
        for (int i = 0; i < courses1.getSize(); i++)
        {
          examinerCourse.getItems().add(courses1.getCourse(i));
          examCourse.getItems().add(courses1.getCourse(i));
        }
        examinerCourse.getSelectionModel().selectFirst();
      }
      else
      {
        JOptionPane.showMessageDialog(null, "Fill in all fields!", "Error",
            JOptionPane.WARNING_MESSAGE);
      }
    }

    if (e.getSource() == courseRemove)
    {
      adapter.removeCourseByIndex(
          courseList.getSelectionModel().getSelectedIndex());
      courseList.getItems()
          .remove(courseList.getSelectionModel().getSelectedIndex());

      examinerCourse.getItems().clear();
      CourseList courses1 = adapter.getAllCourses();
      for (int i = 0; i < courses1.getSize(); i++)
      {
        examinerCourse.getItems().add(courses1.getCourse(i));
      }
      examinerCourse.getSelectionModel().selectFirst();

      examCourse.getItems().clear();
      CourseList courses2 = adapter.getAllCourses();
      for (int i = 0; i < courses2.getSize(); i++)
      {
        examCourse.getItems().add(courses2.getCourse(i));
      }

    }

    if (e.getSource() == courseList.getSelectionModel().getSelectedItem())
    {
      int index = courseList.getSelectionModel().getSelectedIndex();
      courseName.setText(adapter.getCourseName(index));
      courseNumberOfStudents.setText(
          Integer.toString(adapter.getNumberOfStudentsInCourse(index)));
    }

    if (e.getSource() == courseUpdate)
    {
      courseName.setText(courseName.getText());
      courseNumberOfStudents.setText(courseNumberOfStudents.getText());
      courseExamInfo.getSelectionModel().getSelectedItem();
      Course course = new Course(courseName.getText(),
          courseExamInfo.getSelectionModel().getSelectedItem(),
          Integer.parseInt(courseNumberOfStudents.getText()));
      adapter.changeCourseInfo(course,
          courseList.getSelectionModel().getSelectedIndex());
      courseList.getItems().clear();
      examCourse.getItems().clear();
      CourseList courses = adapter.getAllCourses();
      for (int i = 0; i < courses.getSize(); i++)
      {
        courseList.getItems().add(courses.getCourse(i));
        examCourse.getItems().add(courses.getCourse(i));
      }
      courseName.setText("");
      courseNumberOfStudents.setText("");
    }
  }

  public void handleExam(ActionEvent e)
  {
    if (e.getSource() == examSave)
    {
      int day = examDate.getSelectionModel().getSelectedItem();
      String duration = examFrom.getText() + " - " + examTo.getText();
      Course course = examCourse.getSelectionModel().getSelectedItem();
      Room room = examRoom.getSelectionModel().getSelectedItem();
      Examiner examiner = examExaminer.getSelectionModel().getSelectedItem();
      String coExaminer = examCoExaminer.getText();

      Exam exam;
      adapter.setRoomReservation(day, room.getRoomNumber());
      adapter.setExaminerReservation(day, examiner.getExaminerID());

      if (examCoExaminer.getText().equals(""))
      {
        exam = new Exam(day, duration, course, room, examiner);
      }
      else
      {
        exam = new Exam(day, duration, course, room, examiner, coExaminer);
      }

      adapter.addExam(exam);
      examList.getItems().add(exam);

    }

    if (e.getSource() == examRemove)
    {
      Exam exam = examList.getSelectionModel().getSelectedItem();
      int day = exam.getDate();

      adapter.removeRoomReservation(day, exam.getRoom().getRoomNumber());
      for (int i = 0; i < exam.getAllExaminers().length; i++)
      {
        adapter.removeExaminerReservation(day, exam.getAllExaminers()[i].getExaminerID());
      }

      adapter
          .removeExamByIndex(examList.getSelectionModel().getSelectedIndex());
      examList.getItems()
          .remove(examList.getSelectionModel().getSelectedIndex());
    }

    if (e.getSource() == updateListsButton)
    {
      examRoom.getItems().clear();
      RoomList rooms = new RoomList();
      rooms = adapter
          .getAllAvailableRooms(examDate.getSelectionModel().getSelectedItem());
      for (int i = 0; i < rooms.getSize(); i++)
      {
        examRoom.getItems().add(rooms.getRoom(i));
      }

      examExaminer.getItems().clear();
      ExaminerList examiners = new ExaminerList();
      examiners = adapter.getAllAvailableExaminers(examDate.getSelectionModel().getSelectedItem());
      for (int i = 0; i < examiners.getSize(); i++)
      {
        examExaminer.getItems().add(examiners.getExaminer(i));
      }
    }
  }

  private class MyListListener implements ChangeListener<Course>
  {
    public void changed(ObservableValue<? extends Course> courses,
        Course oldCourse, Course newCourse)
    {
      Course temp = courseList.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        courseName.setText(temp.getCourseName());
        courseNumberOfStudents.setText(temp.getNumberOfStudents() + "");
        courseExamInfo.getSelectionModel().select(temp.getCourseType());
      }
    }
  }

  private class MyListListenerRoom implements ChangeListener<Room>
  {
    public void changed(ObservableValue<? extends Room> rooms, Room oldRoom,
        Room newRoom)
    {
      Room temp = roomList.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        roomRoomSize.setText(temp.getRoomSize() + "");
        roomRoomNumber.setText(temp.getRoomNumber());

        RoomList roomRooms = adapter.getRooms();
        int index = roomList.getSelectionModel().getSelectedIndex();

        if (roomRooms.getRoom(index).getRoomAvailability())
        {
          roomAvailability.getSelectionModel().selectFirst();
        }
        else
        {
          roomAvailability.getSelectionModel().selectLast();
        }

        roomVGA.setSelected(false);
        roomHDMI.setSelected(false);
        roomProjector.setSelected(false);

        if (roomList.getSelectionModel().getSelectedItem().hasProjector())
        {
          roomProjector.fire();
        }
        if (roomList.getSelectionModel().getSelectedItem().hasHDMI())
        {
          roomHDMI.fire();
        }
        if (roomList.getSelectionModel().getSelectedItem().hasVGA())
        {
          roomVGA.fire();
        }
      }
    }
  }

  private class MyListListenerExaminer implements ChangeListener<Examiner>
  {
    public void changed(ObservableValue<? extends Examiner> examiners,
        Examiner oldExaminer, Examiner newExaminer)
    {
      Examiner temp = examinerList.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        examinerName.setText(temp.getFullName());
        examinerID.setText(temp.getExaminerID());
        examinerCourse.getSelectionModel().select(temp.getCourse(0));

        if (examinerList.getSelectionModel().getSelectedItem()
            .getExaminerAvailability())
        {
          examinerAvailability.getSelectionModel().selectFirst();
        }
        else
        {
          examinerAvailability.getSelectionModel().selectLast();
        }

      }
    }
  }

}
