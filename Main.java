import java.util.Scanner;

public class Main {

    public static int taxEarnings(int earnings, int spending) {
        int tax = earnings * 6 / 100;
        if (tax >=0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarningsMinusSpending(int earnings, int spending) {
        int tax = (earnings - spending) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int earnings = 0;
        int spending = 0;

        while (true) {

            System.out.println();
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогооблажения");
            System.out.println("Напишите 'end', чтобы завершить программу.");
            String input = sc.nextLine();
            if ("end".equals(input)) {
                break;
            }

            try {
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        System.out.println("Введите сумму дохода:");
                        String incInput = sc.nextLine();
                        int income = Integer.parseInt(incInput);
                        earnings += income;
                        break;
                    case 2:
                        System.out.println("Введите сумму расходов:");
                        String spInput = sc.nextLine();
                        int spent = Integer.parseInt(spInput);
                        spending += spent;
                        break;
                    case 3:

                        int x = taxEarnings(earnings,spending);
                        int y = taxEarningsMinusSpending(earnings,spending);

                        if (x < y) {
                            System.out.println("Мы советуем вам 'УСН доходы'");
                            System.out.println("Ваш налог составит: " + x + " руб.");
                            System.out.println("Налог на другой системе: " + y + " руб.");
                            System.out.println("Экономия: " + (y - x) + " руб.");
                        } else if (x > y) {
                            System.out.println("Мы советуем вам 'УСН доходы минус расходы'");
                            System.out.println("Ваш налог составит: " + y + " руб.");
                            System.out.println("Налог на другой системе: " + x + " руб.");
                            System.out.println("Экономия: " + (x - y) + " руб.");
                        } else {
                            System.out.println("Налоги равны: " + x + " руб. Можете выбрать любой УСН.");
                        }
                        break;
                    default:
                        System.out.println();
                        System.out.println("Такой операции нет!");
                        System.out.println();
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите корректную команду!");
            }

        }

        System.out.println("Программа завершена!");
    }
}
