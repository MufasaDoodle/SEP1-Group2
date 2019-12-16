import java.io.Serializable;
import java.util.ArrayList;
/**
 * A class containing specific details about examiners.
 * @author Group2
 * @version 1.0
 */
public class Examiner implements Serializable
{
    private String fullName;
    private String examinerID;
    private ArrayList<Course> courses;
    private ArrayList<Integer> reservedDays;

    /**
     *Two-argument constructor.
     * @param fullName the examiner's first name
     * @param examinerID the examiner's ID
     */
    public Examiner(String fullName, String examinerID)
    {
        this.fullName = fullName;
        this.examinerID = examinerID;
        courses = new ArrayList<>();
        reservedDays = new ArrayList<>();
    }

    /**
     * Give back the reserved days for a room
     * @return an ArrayList with integers
     */
    public ArrayList<Integer> getReservedDays()
    {
        return reservedDays;
    }

    /**
     * Add a reservation day to an examiner
     * @param day wanted to be reserved to an examiner
     */
    public void addReservation(Integer day)
    {
        reservedDays.add(day);
    }

    /**
     * Remove a reservation day for an examiner
     * @param day wanted to be removed for an examiner
     */
    public void removeReservation(Integer day)
    {
        reservedDays.remove(day);
    }

    /**
     * Gets the examiner's full name.
     * @return the examiner's full name
     */
    public String getFullName()
    {
        return fullName;
    }

    /**
     * Gets the examiner's ID.
     * @return the examiner's ID
     */
    public String getExaminerID()
    {
        return examinerID;
    }

    /**
     * Adds a Course object to the list of examiner's courses.
     * @param course the course to add to the list
     */
    public void addCourse(Course course)
    {
        courses.add(course);
    }

    /**
     * Removes a Course object from the list of examiner's courses.
     * @param course the course to remove from the list
     */
    public void removeCourse(Course course)
    {
        courses.remove(course);
    }

    /**
     * Gets a Course object from position index from the list.
     * @param index the position in the list of the Course object
     * @return the Course at index if one exists, else null
     */
    public Course getCourse(int index)
    {
        if(index<courses.size())
        {
            return courses.get(index);
        }
        else return null;
    }

    /**
     * Creates an Array with all Course objects from the ArrayList.
     * @return an Array with all courses
     */
    public Course[] getAllCourses()
    {
        Course[] tempArray = new Course[courses.size()];
        return courses.toArray(tempArray);
    }


    /**
     * Sets the examiner's last name.
     * @param fullName what the examiner's last name will be set to
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Sets the examiner's ID.
     * @param examinerID what the examiner's ID will be set to
     */
    public void setExaminerID(String examinerID) {
        this.examinerID = examinerID;
    }

    /**
     * Returns a string representation of the examiner.
     * @return a string representation of the examiner
     */
    public String toString()
    {
        String str="Name: " + fullName + ",  ID: " + examinerID+ ",  Courses: ";
        for (int i = 0; i < courses.size(); i++)
        {
            str+=courses.get(i).getCourseName() + ", ";
        }
        return str;
    }

    /**
     * Compares first name, last name and examiner ID of two Examiner objects.
     * @param obj the object to compare with
     * @return true if the given object is equal to the examiner
     */
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Examiner))
        {
            return false;
        }
        Examiner other = (Examiner) obj;
        return fullName.equals(other.fullName)  && examinerID.equals(other.examinerID);
    }
}
