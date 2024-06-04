import java.util.ArrayList;
import java.util.Arrays;


public class Settings {
    private static String s_mode_easy = "3-5";
    private static String s_mode_medium = "6-8";
    private static String s_mode_hard = "9-20";

    public static String get_mode(String p_mode) {
        if (p_mode.equals("easy")) {
            return s_mode_easy;
        } else if (p_mode.equals("medium")) {
            return s_mode_medium;
        } else {
            return s_mode_hard;
        }
    }
    public static void print_hello() {
        System.out.println("Приветствую! Суть игры в том, что бы отгадать слово. Вы можете ошибиться 6 раз. На каждом ходу вы должны ввести 1 русскую букву");
    }
    public static void print_ask_complication() {
        System.out.println("Введите уровень сложности. Доступные значения: " +
                "\"easy\" ("+s_mode_easy+"), " +
                "\"medium\" ("+s_mode_medium+"), " +
                "\"hard\" ("+s_mode_hard+")");
    }
    public static void print_user_get_mistake() {
        System.out.println("Вы ошиблись. Такой буквы в слове нет");
    }
    public static void print_value_is_uncorrect() {
        System.out.println("Введенное значение невалидно.");
    }
    public static void print_value_is_long() {
        System.out.println("Введенное значение имеет больше одного символа. Нужно ввести одну русскую букву");
    }
    public static void print_current_word(ArrayList<String> p_word) {
        StringBuilder str_word = new StringBuilder();
        for (String val : p_word) {
            str_word.append(val);
        }
        System.out.println("Текущее слово: " + str_word);
    }
    public static void print_ask_letter() {
        System.out.println("Введите букву: ");
    }
    public static void print_victory() {
        System.out.println("Вы отгадали все буквы, вы победили!");
    }
    public static void print_lose() {
        System.out.println("Вы проиграли.");
    }
    public static void print_gallow(int counter) {
        switch (counter) {
            case 1:
                System.out.println("  _______");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 2:
                System.out.println("  _______");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |     |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 3:
                System.out.println("  _______");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |    /|");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 4:
                System.out.println("  _______");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |    /|\\");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 5:
                System.out.println("  _______");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |    /|\\");
                System.out.println("  |    /");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 6:
                System.out.println("  _______");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |    /|\\");
                System.out.println("  |    / \\");
                System.out.println("  |");
                System.out.println("__|__");
        }

    }
    public static void print_ask_play() {
        System.out.println("Что бы начать новую игру введите \"1\"");
        System.out.println("Что бы выйти из приложения введите любой символ");
    }
}