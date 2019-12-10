/**
 * A class containing the specific details about a room
 */
public class Room
{
  private int roomSize;
  private String roomNumber;
  private boolean roomAvailability;
  private boolean hasProjector;
  private boolean hasHDMI;
  private boolean hasVGA;

  /**
   * Two-argument constructor initializing the room with room's size and room's number.
   *
   * @param roomSize   specify the room's size
   * @param roomNumber specify the room's number
   */
  public Room(int roomSize, String roomNumber)
  {
    this.roomSize = roomSize;
    this.roomNumber = roomNumber;
    hasProjector = false;
    hasHDMI = false;
    hasVGA = false;
    roomAvailability = true;
  }

  /**
   * Five-argument constructor initializing the room with room's size, room's number, projector availability, HDMI availability,  VGA availability.
   *
   * @param roomSize     specify the room's size
   * @param roomNumber   specify the room's number
   * @param hasProjector specify that a room has a projector or not
   * @param hasHDMI      specify that a room has a HDMI or not
   * @param hasVGA       specify that a room has a VGA or not
   */
  public Room(int roomSize, String roomNumber, boolean hasProjector,
      boolean hasHDMI, boolean hasVGA)
  {
    this.roomSize = roomSize;
    this.roomNumber = roomNumber;
    this.hasProjector = hasProjector;
    this.hasHDMI = hasHDMI;
    this.hasVGA = hasVGA;
    roomAvailability = true;
  }

  /**
   * Give back the room number
   * @return String with the room's number
   */
  public String getRoomNumber(){
    return roomNumber;
  }

  /**
   * Give back the room size
   * @return an int with size of the room
   */
  public int getRoomSize(){
    return roomSize;
  }

  /**
   * Give back true if a room has a projector, or false if it doesn't
   *
   * @return true if a room has a projector
   */
  public boolean hasProjector()
  {
    return hasProjector;
  }

  /**
   * Give back true if a room has a HDMI cable, or false if it doesn't
   *
   * @return true if a room has a HDMI cable
   */
  public boolean hasHDMI()
  {
    return hasHDMI;
  }

  /**
   * Give back true if a room has a VGA cable, or false if it doesn't
   *
   * @return true if a room has a VGA cable
   */
  public boolean hasVGA()
  {
    return hasVGA;
  }

  /**
   * Give back true if the room is available, or false if it is not
   *
   * @return true if the room is available
   */
  public boolean getRoomAvailability()
  {
    return roomAvailability;
  }

  /**
   * Replaces the room with its new size and number
   *
   * @param roomSize   specify the new room's size
   * @param roomNumber specify the new room's number
   */
  public void setRoom(int roomSize, String roomNumber)
  {
    this.roomSize = roomSize;
    this.roomNumber = roomNumber;
  }

  /**
   * Set that the room has a projector or not
   *
   * @param projector it is a boolean, if it is true the room has projector
   */
  public void setProjector(boolean projector)
  {
    this.hasProjector = projector;
  }

  /**
   * Set that the room has  HDMI cable or not
   *
   * @param HDMI it is a boolean, if it is true the room has HDMI cable
   */
  public void setHDMI(boolean HDMI)
  {
    this.hasHDMI = HDMI;
  }

  /**
   * Set that the room has a VGA cable or not
   *
   * @param VGA it is a boolean, if it is true the room has VGA cable
   */
  public void setVGA(boolean VGA)
  {
    this.hasVGA = VGA;
  }

  /**
   * Set that the room is available or not
   *
   * @param roomAvailability it is a boolean, if it is true the room is available
   */
  public void setRoomAvailability(boolean roomAvailability)
  {
    this.roomAvailability = roomAvailability;
  }

  /**
   * Compare two rooms equality by their room number
   *
   * @param obj the Room you want to be compared against
   * @return true if two rooms have the same room number
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Room))
    {
      return false;
    }
    Room other = (Room) obj;

    return roomNumber.equals(other.roomNumber);
  }

  /**
   * It shows all the details of a room
   * @return a String with all the details of the room
   */
  public String toString()
  {
    return "Room size: " + roomSize + "\n" + "Room number: " + roomNumber + "\n"
        + "Room availability: " + roomAvailability + "\n" + "Projector: "
        + hasProjector + "\n" + "HDMI: " + hasHDMI + "\n" + "VGA: " + hasVGA;
  }

}