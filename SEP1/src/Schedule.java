/**
 * A class containing the exam schedule.
 * @version 0.1
 */

public class Schedule
{
  private ExamList exams;
  private int semester;
  private char _class;

  /**
   * A constructor initializing the schedule.
   * @param semester the semester of the class.
   * @param _class the classes semester.
   * @param exams the exam list.
   */

  public Schedule (int semester, char _class, ExamList exams){
    this.semester=semester;
    this._class=_class;
    this.exams=exams;

  }

  /**
   * Get the class.
   * @return the class
   */

  public char get_class()
  {
    return _class;
  }

  /**
   * Get the semester.
   * @return the semester
   */
  public int getSemester()
  {
    return semester;
  }

  /**
   * Get the exam list.
   * @return the exam list
   */

  public ExamList getExams()
  {
    return exams;
  }

  /**
   * Sets all the fields for schedule.
   * @param semester what is the semester being set to.
   * @param _class what is the class being set to.
   * @param exams what is the exam schedule being set to.
   */

  public void set(int semester, char _class, ExamList exams){
    this.semester=semester;
    this._class=_class;
    this.exams=exams;
  }

  /**
   * Returns a string representing of the schedule.
   * @return a string representing of the schedule.
   */

  public String toString(){
    return ("Semester: " +semester+ ", Class: " + _class + "\n Exam List: " + exams);
  }

}