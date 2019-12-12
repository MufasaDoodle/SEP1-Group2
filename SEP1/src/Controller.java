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
  @FXML private ListView roomList;
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
  @FXML private ListView examinerList;
  @FXML private Button examinerAdd;
  @FXML private Button examinerRemove;

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
  @FXML private ListView examList;
  @FXML private Button examRemove;

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
    }
    roomDay.getSelectionModel().selectFirst();
    examinerDay.getSelectionModel().selectFirst();
    roomAvailability.getItems().add("Available");
    roomAvailability.getItems().add("Unavailable");
    roomAvailability.getSelectionModel().selectFirst();
    courseExamInfo.getItems().add("Written");
    courseExamInfo.getItems().add("Oral");
    courseExamInfo.getSelectionModel().selectFirst();

    CourseList courses = new CourseList();
    courses = adapter.getAllCourses();
    for (int i = 0; i < courses.getSize(); i++)
    {
      courseList.getItems().add(courses.getCourse(i));
    }

    courseList.getSelectionModel().selectedItemProperty()
        .addListener((new MyListListener()));
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
      System.out.println(rooms.toString());
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
          .equals("")) && (
          (roomProjector.isSelected() && (roomHDMI.isSelected() || roomVGA
              .isSelected())) || !(roomProjector.isSelected())))
      {
        Room room = new Room(Integer.parseInt(roomRoomSize.getText()),
            roomRoomNumber.getText());
        if (roomProjector.isSelected())
        {
          room.setProjector(true);
        }
        else if (roomHDMI.isSelected())
        {
          room.setHDMI(true);
        }
        else if (roomVGA.isSelected())
        {
          room.setVGA(true);
        }

        adapter.addRoom(room);
      }
      else
      {
        JOptionPane.showMessageDialog(null, "Fill in all fields!", "Error",
            JOptionPane.WARNING_MESSAGE);
      }
    }
  }

  public void handleExaminer(ActionEvent e)
  {
    if (e.getSource() == examinerAllExaminers)
    {
      adapter.getAllExaminers();
    }
    if (e.getSource() == examinerAvailableExaminers)
    {
      //get examiners by day
    }
    if (e.getSource() == examinerUnavailableExaminers)
    {
      //get un examiners  by day
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
      CourseList courses = new CourseList();
      courses = adapter.getAllCourses();
      for (int i = 0; i < courses.getSize() ; i++)
      {
        courseList.getItems().add(courses.getCourse(i));
      }
      courseName.setText("");
      courseNumberOfStudents.setText("");
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
}
