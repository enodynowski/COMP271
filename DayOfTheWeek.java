import java.util.Scanner;
public class DayOfTheWeek {
    public static void main(String[] args){
        System.out.println(dayOfWeekString(UserInput()));       
    }

    public static int[] UserInput(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter month: ");
        int month = input.nextInt();
        System.out.print("Enter day: ");
        int day = input.nextInt();
        System.out.print("Enter year: ");
        int year = input.nextInt();
        int[] date = {month, day, year};
        input.close();
        return date;
    }

    public static int dayOfWeek(int month, int day, int year){
        int a = (14 - month) / 12;
        int y = year - a;
        int m = month + 12 * a - 2;
        int d = (day + y + y/4 - y/100 + y/400 + (31*m)/12) % 7;
        return d;
    }

    public static String dayOfWeekString(int[] date){
        int day = dayOfWeek(date[0], date[1], date[2]);
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String dayString = days[day];
        return dayString;
    }

}

