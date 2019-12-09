public class MyDate
{
  private int day;
  private int month;
  private int year;
  private String myDateTime;

  public MyDate(int day, int month, int year, String myDateTime)
  {
    this.day = day;
    this.month = month;
    this.year = year;
    this.myDateTime = myDateTime;
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public String getMyDateTime()
  {
    return myDateTime;
  }

  public void set(int day, int month, int year, String myDateTime)
  {
    this.day = day;
    this.month = month;
    this.year = year;
    this.myDateTime = myDateTime;
  }

  public MyDate copy()
  {
    return new MyDate(day, month, year, myDateTime);
  }

  public String toString()
  {
    return ("Day: " + day + ", Month: " + month + ", Year: " + year
        + ", My Date Time: " + myDateTime);
  }

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
