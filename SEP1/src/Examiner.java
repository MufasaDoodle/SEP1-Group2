import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing specific details about examiners.
 * @version 0.1
 */
public class Examiner implements Serializable
{
    private String fullName;
    private String examinerID;
    private boolean examinerAvailability;
    private ArrayList<Course> courses;
    private ArrayList<Integer> reservedDays;

    /**
     *Two-argument constructor.
     * @param firstName the examiner's first name
     * @param examinerID the examiner's ID
     */
    public Examiner(String firstName, String examinerID)
    {
        this.fullName = firstName;
        this.examinerID = examinerID;
        examinerAvailability = true;
        courses = new ArrayList<>();
        reservedDays = new ArrayList<>();
    }

    //todo astah
    public ArrayList<Integer> getReservedDays()
    {
        return reservedDays;
    }

    //todo astah
    public void addReservation(Integer day)
    {
        reservedDays.add(day);
        if (reservedDays.size() > 0)
        {
            System.out.println(reservedDays.toString());
        }
        else
        {
            System.out.println("No reservations");
        }
    }

    //todo astah
    public void removeReservation(Integer day)
    {
        reservedDays.remove(day);
        if (reservedDays.size() > 0)
        {
            System.out.println(reservedDays.toString());
        }
        else
        {
            System.out.println("No reservations");
        }
    }

    /**
     * Gets the examiner's first name.
     * @return the examiner's first name
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
     * Gets the availability of the examiner.
     * @return the examiner's availability
     */
    public boolean getExaminerAvailability()
    {
        return examinerAvailability;
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
     * Sets the examiner's availability.
     * @param examinerAvailability what the examiner's availability will be set to
     */
    public void setAvailable(boolean examinerAvailability)
    {
        this.examinerAvailability = examinerAvailability;
    }

    /**
     * Creates a copy of the Examiner object.
     * @return a copy of the Examiner object
     */
    public Examiner copy()
    {
        return new Examiner(fullName, examinerID);
    }

    /**
     * Returns a string representation of the examiner.
     * @return a string representation of the examiner
     */
    public String toString()
    {
        String str="Name: " + fullName + ". ID: " + examinerID+ ". Courses: ";
        for (int i = 0; i < courses.size(); i++)
        {
            str+=courses.get(i).getCourseName() + ", ";
        }
        return str + " Availability: " + getExaminerAvailability();
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
