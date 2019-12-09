/**
 * A class containing the date of exams.
 * @version 1.0
 */
public class MyDate
{
  private int day;
  private int month;
  private int year;
  private String myDateTime;

  /**
   * A constructor initializing the Date.
   * @param day to give it the day of the exam.
   * @param month to give it the month of the exam.
   * @param year to give it the year of the exam.
   * @param myDateTime to give it time of the exam.
   */
  public MyDate(int day, int month, int year, String myDateTime)
  {
    this.day = day;
    this.month = month;
    this.year = year;
    this.myDateTime = myDateTime;
  }

  /**
   * To get the day of exam.
   * @return int day.
   */
  public int getDay()
  {
    return day;
  }

  /**
   * To get the month.
   * @return int month.
   */

  public int getMonth()
  {
    return month;
  }

  /**
   * To get the year.
   * @return int year.
   */

  public int getYear()
  {
    return year;
  }

  /**
   * To get the time of the exam.
   * @return String time of the exam.
   */

  public String getMyDateTime()
  {
    return myDateTime;
  }

  /**
   * A constructor to set the Date and time
   * @param day set the day.
   * @param month set the month.
   * @param year set the year.
   * @param myDateTime set the time.
   */

  public void set(int day, int month, int year, String myDateTime)
  {
    this.day = day;
    this.month = month;
    this.year = year;
    this.myDateTime = myDateTime;
  }

  /**
   * To make a copy of the date.
   * @return a new date.
   */
  public MyDate copy()
  {
    return new MyDate(day, month, year, myDateTime);
  }

  /**
   * To display the date and time of the exam.
   * @return the day, month, year and time of the exam.
   */
  public String toString()
  {
    return ("Day: " + day + ", Month: " + month + ", Year: " + year
        + ", My Date Time: " + myDateTime);
  }

  /**
   * To checks if two date objects are the same by comparing the fields.
   * @param obj the date you want to be compared against.
   * @return boolean.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof MyDate))
    {
      return false;
    }

    MyDate other = (MyDate) obj;

    return other.day == day && other.month == month && other.year == year
        && other.myDateTime.equals(myDateTime);
  }
}
