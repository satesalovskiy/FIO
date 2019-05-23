package qwer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class FIO {

    String secName = new String();
    String firstName = new String();
    String shortFN = new String();
    String thirdName = new String();
    String shortTN = new String();
    String birthDate = new String();
    String name = new String();
    String data = new String();

    public int getYears() {
        return years;
    }

    int years = 0;

    LocalDate date;
    LocalDate dateToday;

    public String getSex() {
        return sex;
    }

    String sex = new String();

    public String getShortFN() {
        return shortFN;
    }

    public String getShortTN() {
        return shortTN;
    }
    public String getSecName() {
        return secName;
    }

    void Start()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите Фамилию Имя Отчество и Дату Рождения (дд-мм-гггг): ");
        data = in.nextLine();
        int n=0;
            for (int i = 0; i < data.length(); i++) {
                if (data.charAt(i) == ' ') {
                    if (n == 0) {
                        secName = name.replaceAll("\\s", "");
                        name = "";
                        n++;
                    } else if (n == 1) {
                        firstName = name.replaceAll("\\s", "");
                        name = "";
                        n++;
                    } else if (n == 2) {
                        thirdName = name.replaceAll("\\s", "");
                        name = "";
                    }
                }
                name += data.charAt(i);
            }
        birthDate = name.replaceAll("\\s","");

        CheckName(thirdName);

        CutName(firstName, firstName);
        CutName(thirdName, thirdName);

        DiffDate(birthDate);
    }
    void CheckName(String name)
    {
        for (int i =name.length()-1; i>=0 ;i--)
        {
            if (name.charAt(i)=='ч')
            {
                sex+="Мужской";
                break;
            }
            else
            {
                sex+="Женский";
                break;
            }
        }
    }

    void CutName(String name, String shortN)
    {
        if (shortN==firstName) {
            for (int i = 0; i <= name.length(); i++) {
                char shortName = name.charAt(i);
                shortFN ="";
                shortFN +=  shortName;
                break;
            }
        }
        if (shortN==thirdName) {
            for (int i = 0; i <= name.length(); i++) {
                char shortName = name.charAt(i);
                shortTN="";
                shortTN +=shortName;
                break;
            }
        }
    }

    void DiffDate(String dateInString)
    {
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
             date = LocalDate.parse(dateInString, formatter);
        } catch (DateTimeException e) {

            System.out.println("Ошибка приведения даты");
        }
        //System.out.println(date.getDayOfMonth());

       /* if ((date.getYear()%4!=0)&&(date.getYear()%400!=0)&&(date.getYear()%100==0))
        {
                System.out.println("Год не високосный");
                if((date.getMonth()==2)&&(date.getDay()>=29))
                {
                    System.out.println("Неверная дата");
                    return;
                }
        } */

        if((date.getYear()%4!=0)&&(date.getYear()%400!=0))
        {
            System.out.println("Год не високосный");
           // System.out.println(date.getMonth());
            if ((date.getMonth().getValue()==2)&&(date.getDayOfMonth()>=28))
            {
                System.out.println("Не верная дата");
                System.exit(1);
            }
        }


        if ((date.getMonth().getValue()==4)&&(date.getDayOfMonth()>30))
        {
            System.out.println("Не верная дата");
            System.exit(1);
        }
        dateToday = LocalDate.now();
        Period bet = Period.between(date,dateToday);
        years = bet.getYears();

       // System.out.println(dateToday.getYear());

       // int milli = dateToday.getYear() - date.getYear();
       // years = milli;
    }

}
