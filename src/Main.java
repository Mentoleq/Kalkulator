import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double firstNumber = 0;
        double secondNumber = 0;
        char operation = ' ';
        boolean validInput = false;

        System.out.println("Program jest prostym kalkulatorem pozawlającym na dodawanie, odejmowanie, monżenie i dzielnie wóch liczby rzeczywistch");

        while (!validInput){
            try {
                System.out.println("Proszę podać pierwszą liczbę: ");
                firstNumber = scanner.nextDouble();
                validInput = true;
            }catch (NumberFormatException e){
                System.out.println("Błąd: Wprowadzaono złą wartość");
                scanner.next();
            }
        }
        validInput = false;

        scanner.nextLine();
        while (true) {
            System.out.print("Podaj symbol operacji (+, -, *, /): ");
            String input = scanner.nextLine();
            if (input.length() == 1 && "+-*/".indexOf(input.charAt(0)) != -1) {
                operation = input.charAt(0);
                break;
            } else {
                System.out.println("Błąd: Nieprawidłowy symbol operacji. Spróbuj ponownie.");
            }
        }

        while (!validInput){
            try {
                System.out.println("Proszę podać drugą liczbę: ");
                secondNumber = scanner.nextDouble();
                validInput = true;
            }catch (NumberFormatException e){
                System.out.println("Błąd: Wprowadzaono złą wartość");
                scanner.next();
            }
        }

        try{
            double result = switch (operation) {
                case '+' -> firstNumber + secondNumber;
                case '-' -> firstNumber - secondNumber;
                case '*' -> firstNumber * secondNumber;
                case '/' -> {
                    if (secondNumber == 0) {
                        throw new ArithmeticException("Nie można dzielić przez zero.");
                    }
                    yield firstNumber / secondNumber;
                }
                default -> 0;
            };
            System.out.println("Wynik: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
        System.out.println("Naciśnij klawisz Enter, aby zakończyć działanie programu.");
        scanner.nextLine();
        scanner.nextLine();

        scanner.close();
    }
        }



