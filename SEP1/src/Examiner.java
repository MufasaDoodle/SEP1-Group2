import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing specific details about examiners.
 * @version 0.1
 */
public class Examiner implements Serializable
{
    private String firstName;
    private String lastName;
    private String examinerID;
    private boolean examinerAvailability;
    private ArrayList<Course> courses;

    /**
     *Three-argument constructor.
     * @param firstName the examiner's first name
     * @param lastName the examiner's last name
     * @param examinerID the examiner's ID
     */
    public Examiner(String firstName, String lastName, String examinerID)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examinerID = examinerID;
        examinerAvailability = true;
        courses = new ArrayList<Course>();
    }

    /**
     * Gets the examiner's first name.
     * @return the examiner's first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Gets the examiner's last name.
     * @return the examiner's last name
     */
    public String getLastName()
    {
        return lastName;
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
     * Sets the examiner's first name.
     * @param firstName what the examiner's first name will be set to
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the examiner's last name.
     * @param lastName what the examiner's last name will be set to
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return new Examiner(firstName, lastName, examinerID);
    }

    /**
     * Returns a string representation of the examiner.
     * @return a string representation of the examiner
     */
    public String toString()
    {
        return "Name: " + firstName + " " + lastName + ". ID: " + examinerID;
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
        return firstName.equals(other.firstName) && lastName.equals(other.lastName) && examinerID.equals(examinerID);
    }
}
