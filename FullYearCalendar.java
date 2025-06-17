import java.util.*;

public class FullYearCalendar
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.close();
        
        printFullYearCalendar(year);
    }
    
    public static void printFullYearCalendar(int year)
    {
        // Validate year input
        if (year < 1)
        {
            System.out.println("Invalid year. Please enter a positive number.");
            return;
        }
        
        // Create a calendar instance for the given year
        Calendar cal = new GregorianCalendar(year, Calendar.JANUARY, 1);
        
        // Print calendar for each month
        for (int month = Calendar.JANUARY; month <= Calendar.DECEMBER; month++)
        {
            cal.set(Calendar.MONTH, month);
            printMonthCalendar(cal);
            System.out.println();
        }
    }
    
    public static void printMonthCalendar(Calendar cal)
    {
        // Get month and year
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        
        // Print month and year header
        System.out.println("     " + getMonthName(month) + " " + year);
        System.out.println(" Su Mo Tu We Th Fr Sa");
        
        // Set calendar to first day of month
        cal.set(Calendar.DAY_OF_MONTH, 1);
        
        // Get first day of week (1 = Sunday, 2 = Monday, etc.)
        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        
        // Get number of days in month
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        // Print leading spaces
        for (int i = Calendar.SUNDAY; i < firstDayOfWeek; i++)
        {
            System.out.print("   ");
        }
        
        // Print days of month
        for (int day = 1; day <= daysInMonth; day++)
        {
            System.out.printf("%3d", day);
            
            // Check if this is the last day of the week
            if ((day + firstDayOfWeek - 1) % 7 == 0 || day == daysInMonth)
            {
                System.out.println();
            }
        }
    }
    
    public static String getMonthName(int month)
    {
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                              "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }
}
