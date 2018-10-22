package pl.mateusz.engine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Runner {
    static Scanner sc = new Scanner(System.in);
    static Users user = new Users();

    public static void main(String[] args) {
        String userChoice;

        do {
            System.out.println();
            System.out.println("Welcome in BMI Calculator.");
            System.out.println("[1] Check your body mass index.");
            System.out.println("[2] See other users.");
            System.out.println("[X] Leave the app.");
            System.out.print("Your choose: ");
            userChoice = getUserInput();
            if (userChoice.equals("1")) {
                checkBMI();
            } else if (userChoice.equals("2")) {
                showUsers();
            }
        } while (!userChoice.equalsIgnoreCase("X"));

    }

    private static void checkBMI() {
        Calculator cal = new Calculator();

        System.out.println();
        System.out.print("Name: ");
        cal.setName(getUserInput());

        System.out.print("Age: ");
        cal.setAge(Integer.valueOf(getUserInput()));

        Pattern weightPattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        String readWeight;
        do {
            System.out.print("Weight[kg]: ");
            readWeight = getUserInput();
            if (weightPattern.matcher(readWeight).matches()) {
                cal.setBodyWeight(Float.valueOf(readWeight));
            }
        } while (cal.getBodyWeight() == null);

        Pattern growthPattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        String readGrowth;
        do {
            System.out.print("Growth[m]: ");
            readGrowth = getUserInput();
            if (growthPattern.matcher(readGrowth).matches()) {
                cal.setBodyGrowth(Float.valueOf((readGrowth)));
            }
        } while (cal.getBodyGrowth() == null);

        Pattern datePattern = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String readDate;
        do {
            System.out.println();
            System.out.println("Pattern of date: YYYY.MM.DD.");
            System.out.print("State by day: ");
            readDate = getUserInput();
            if (datePattern.matcher(readDate).matches()) {
                try {
                    cal.setStateByDay(sdf.parse(readDate));
                } catch (ParseException pe) {
                    System.out.println("Wrong date! Try again! Correct format: YYYY.MM.D2D.");
                }
            }
        } while (cal.getStateByDay() == null);

        user.addUser(cal);
    }

    private static void showUsers() {
        Calculator cal;

        for (int i = 0; i < user.getUsers().size(); i++) {
            cal = user.getUsers().get(i);
            System.out.println(i + " : " + cal.getName());
        }

        System.out.println();
        Pattern numberPattern = Pattern.compile("[0-9]+");
        String readNumber;

        do {
            System.out.print("Write the number. Your choose: ");
            readNumber = getUserInput();
        } while (!numberPattern.matcher(readNumber).matches());

        Integer numberOfUser = Integer.parseInt(readNumber);

        if (user.getUsers().size() > numberOfUser) {
            Calculator selectedUser = user.getUsers().get(numberOfUser);
            System.out.print("NAME: " + selectedUser.getName() + "\n");
            System.out.print("AGE: " + selectedUser.getAge() + "\n");
            System.out.print("BMI: " + selectedUser.calculateBMI() + "\n");
        } else {
            System.out.println("In database don't have selected user. You can add him or try again.");
        }
    }

    private static String getUserInput() {
        return sc.nextLine().trim();
    }
}
