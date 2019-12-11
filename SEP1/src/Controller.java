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
  @FXML private TextArea roomList;
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
  @FXML private TextArea examinerList;
  @FXML private Button examinerAdd;
  @FXML private Button examinerRemove;

  @FXML private TextArea courseList;
  @FXML private Button courseAdd;
  @FXML private Button courseRemove;
  @FXML private TextField courseName;
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

  public void initialize()
  {
    adapter = new ScheduleFileAdapter("ExamList.bin", "RoomList.bin",
        "Examiner.bin", "Course.bin");
    roomDay.getItems().clear();
    for (int i = 1; i <= 31; i++)
    {
      roomDay.getItems().add(i);
    }
    roomDay.getSelectionModel().selectFirst();
    roomAvailability.getItems().add("Available");
    roomAvailability.getItems().add("Unavailable");
    roomAvailability.getSelectionModel().selectFirst();



  }

  public void handleRoom(ActionEvent e)
  {
    if (e.getSource() == roomAllRooms)
    {
      adapter.getRooms();
    }
    if (e.getSource() == roomAvailableRooms)
    {
      adapter
          .getAllAvailableRooms(roomDay.getSelectionModel().getSelectedItem());
    }
    if (e.getSource() == roomUnavailableRooms)
    {
      adapter.getAllUnavailableRooms(
          roomDay.getSelectionModel().getSelectedItem());
    }
    if (e.getSource() == roomOralRooms)
    {
      adapter.getAllRoomsWithProjector();
    }

    if (e.getSource() == roomAdd)
    {
      if (!(roomRoomSize.getText() == null) && !(roomRoomNumber.getText()
          == null) && (
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

}
