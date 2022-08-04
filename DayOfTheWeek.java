//Eno Dynowski, COMP-271 - Data Structures, Fall 2022

import java.util.Scanner;
public class DayOfTheWeek {
    public static void main(String[] args){
        System.out.println(dayOfWeekString(UserInput()));       
    }

    //taking user input and returning the date as an array of integers
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

    //takes the 3 integers the user entered and converts to an in 0-6. 0 is Sunday, 1 is Monday, etc.
    public static int dayOfWeek(int month, int day, int year){
        int a = (14 - month) / 12;
        int y = year - a;
        int m = month + 12 * a - 2;
        int d = (day + y + y/4 - y/100 + y/400 + (31*m)/12) % 7;
        return d;
    }
    
    //taking the user input, coverting to an int between 0 and 6, then converting that to a day of the week
    public static String dayOfWeekString(int[] date){
        int day = dayOfWeek(date[0], date[1], date[2]);
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String dayString = days[day];
        return dayString;
    }

}

