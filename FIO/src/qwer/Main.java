package qwer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main (String args[])
    {
        FIO a = new FIO();

        try {
            a.Start();
        }
        catch(StringIndexOutOfBoundsException e)
        {
            System.out.println("Неверный ввод данных");
            return;
        }
        catch (NullPointerException e)
        {
            System.out.println("Неверный ввод данных");
            return;
        }

        System.out.print("");
        System.out.print("Имя: "+a.getSecName());
        System.out.print(" " + a.getShortFN() + ".");
        System.out.println(" " + a.getShortTN() + ".");
        System.out.println("Пол: " + a.getSex());
        System.out.println("Возраст: " + a.getYears());

    }

}

