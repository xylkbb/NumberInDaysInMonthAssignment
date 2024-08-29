public class Main {

    public static void main(String[] args) {
        System.out.println(getDaysInMonth(1, 2020));
        System.out.println(getDaysInMonth(2, 2020));
        System.out.println(getDaysInMonth(2, 2018));
        System.out.println(getDaysInMonth(-1, 2020));
        System.out.println(getDaysInMonth(2, -2020));
    }

    public static boolean isLeapYear(int year) {
        if (year >= 1 && year <= 9999) {
            return div4Check(year);
        } else {
            return false;
        }
    }


    private static boolean div4Check(int year) {
        if (year % 4 == 0) {
            return div100Check(year);
        } else {
            return false;
        }
    }

    private static boolean div100Check(int year) {
        if (year % 100 == 0) {
            return div400Check(year);

        } else {
            return true;
        }
    }

    private static boolean div400Check(int year) {

        return year % 400 == 0;
    }


    public static int getDaysInMonth(int month, int year) {
        if (year < 1 || year > 9999) {
            return -1;
        }

        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 9, 6, 11 -> 30;
            case 2 -> {
                if (isLeapYear(year)) {
                    yield 29;
                }
                yield 28;

            }

            default -> -1;
        };
    }
}
