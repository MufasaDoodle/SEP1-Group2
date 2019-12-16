import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing all the rooms
 * @author Group2
 * @version 1.0
 */
public class RoomList implements Serializable
{
  private ArrayList<Room> rooms;

  /**
   * No-argument constructor initializing the RoomList.
   */
  public RoomList()
  {
    rooms = new ArrayList<>();
  }

  /**
   * Gives the number of rooms
   *
   * @return an int with the size of the Rooms array list
   */
  public int getNumberOfRooms()
  {
    return rooms.size();
  }

  /**
   * Gives the room with the specific index
   *
   * @param index index the position in the list of the Room object
   * @return the Room at index if one exists, else null
   */
  public Room getRoom(int index)
  {
    if (index < rooms.size())
    {
      return rooms.get(index);
    }
    else
    {
      return null;
    }
  }

  /**
   * Gives the room with the specific room number
   *
   * @param roomNumber String, specify the wanted room number
   * @return the Room with the specific Room Number
   */
  public Room getRoomByNumber(String roomNumber)
  {
    Room result = null;

    for (int i = 0; i < rooms.size(); i++)
    {
      if (rooms.get(i).getRoomNumber().equals(roomNumber))
      {
        result = rooms.get(i);
      }
    }
    return result;
  }

  /**
   * Adds a Room to the list
   *
   * @param room the room to add to the list
   */
  public void addRoom(Room room)
  {
    rooms.add(room);
  }

  /**
   * Removes a Room by its Index
   *
   * @param index the index of the room to be removed
   */
  public void removeRoomByIndex(int index)
  {
      if (index < 0 || index > rooms.size())
      {
        //do nothing boi
      }
      else
      {
        rooms.remove(index);
      }
  }

  /**
   * Removes a Room by its room number
   *
   * @param roomNumber the room number of the room to be removed
   */
  public void removeRoomByRoomNumber(String roomNumber)
  {
    for (int i = 0; i < rooms.size(); i++)
    {
      if (rooms.get(i).getRoomNumber().equals(roomNumber))
      {
        rooms.remove(i);
      }
    }
  }

  /**
   * Gives all the rooms from the room list
   *
   * @return all rooms from the room list
   */
  public Room[] getAllRooms()
  {
    ArrayList<Room> temp = new ArrayList<>();
    temp = rooms;
    Room[] returnArray = temp.toArray(new Room[temp.size()]);

    return returnArray;
  }

  /**
   * Return the the ArrayList size
   * @return an int with the size of the ArrayList
   */
  public int getSize()
  {
    return rooms.size();
  }

  /**
   * Gives the rooms with bigger size than the given argument
   *
   * @param size an int, the room size wanted to be bigger
   * @return all the rooms with bigger size than the given argument
   */
  public Room[] getRoomsBiggerThan(int size)
  {
    ArrayList<Room> resultRooms = new ArrayList<>();

    for (int i = 0; i < rooms.size(); i++)
    {
      if (rooms.get(i).getRoomSize() >= size)
      {
        resultRooms.add(rooms.get(i));
      }
    }

    Room[] returnArray = new Room[resultRooms.size()];
    return resultRooms.toArray(returnArray);
  }

  /**
   * Gives the rooms with smaller size than the given argument
   *
   * @param size an int, the room size wanted to be smaller
   * @return all the rooms with smaller size than the given argument
   */
  public Room[] getRoomsSmallerThan(int size)
  {
    ArrayList<Room> resultRooms = new ArrayList<>();

    for (int i = 0; i < rooms.size(); i++)
    {
      if (rooms.get(i).getRoomSize() <= size)
      {
        resultRooms.add(rooms.get(i));
      }
    }

    Room[] returnArray = new Room[resultRooms.size()];
    return resultRooms.toArray(returnArray);
  }

  /**
   * Set a room with new details to the required index
   * @param room the new room wanted to be added
   * @param index the required index want to set the room
   */
  public void set(Room room, int index)
  {
    rooms.set(index, room);
  }

  /**
   * Gives all the rooms with projector
   *
   * @return all the rooms with projector
   */
  public Room[] getRoomsWithProjector()
  {
    ArrayList<Room> resultRooms = new ArrayList<>();

    for (int i = 0; i < rooms.size(); i++)
    {
      if (rooms.get(i).hasProjector())
      {
        resultRooms.add(rooms.get(i));
      }
    }

    Room[] returnArray = new Room[resultRooms.size()];
    return resultRooms.toArray(returnArray);
  }

  /**
   * Returns the information about the rooms in the ArrayList
   * @return a String with information about all rooms in the list
   */
  public String toString(){
    String str = "";
    for (int i = 0; i < rooms.size(); i++){
      str += rooms.get(i).toString() + "\n";
    }
    return str;
  }

}
