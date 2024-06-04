
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Game {
    private String s_complication;
    private File file = new File("src/words.txt");
    private int i_mistakes = 6;
    private String s_current_letter;
    private String s_cur_word;
    private ArrayList<String> arr_masked_word = new ArrayList<String>();
    private String[] arr_cur_word;
    private boolean b_victory = false;
    public boolean start() {

        Settings.print_hello();
        ask_complication();
        try {
            chose_word();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }

        while (i_mistakes > 0 && !b_victory) {
            start_round();
        }
        return end_game();
    }
    public void ask_complication() {
        String enterVal;
        // юзер выбирает сложность
        Settings.print_ask_complication();
        Scanner input = new Scanner(System.in);
        enterVal = input.next();
        // проверяем введенное значение на валидность, рекурсивно перезапускаем, пока не получим адекватный ответ
        if (!     (enterVal.equals("easy")
                || enterVal.equals("medium")
                || enterVal.equals("hard")
            ) ) {
            Settings.print_value_is_uncorrect();
            ask_complication();
        }
        s_complication = Settings.get_mode(enterVal);
    }
    public void chose_word() throws FileNotFoundException {
        String s_cur_val;
        // файл переводим в массив, исходя из сложности выбираем слово
        Scanner words_txt = new Scanner(file);

        ArrayList<String> arr_words = new ArrayList<String>();

        Pattern pattern_min = Pattern.compile("^\\d{1,3}");
        Pattern pattern_max = Pattern.compile("\\d{1,3}$");

        // в s_complication лежит сложность, 6-8, например
        Matcher matcher_min =  pattern_min.matcher(s_complication);
        Matcher matcher_max =  pattern_max.matcher(s_complication);

        matcher_min.find();
        matcher_max.find();


        int i_min_length =  Integer.valueOf(matcher_min.group());
        int i_max_length = Integer.valueOf(matcher_max.group());

        // в новый массив сортируем все слова по длинне
        while(words_txt.hasNextLine()) {
            s_cur_val = words_txt.nextLine();
            if (s_cur_val.length() <= i_max_length && s_cur_val.length() >= i_min_length) {
                arr_words.add(s_cur_val);
            }
        }
        System.out.println();
        // рандомно выбираем слово
        Random random = new Random();
        s_cur_word = arr_words.get(random.nextInt(arr_words.size() ));

        System.out.println("devlog : Выбрано слово - " + s_cur_word);

        // формируем ____ маску для вывода в лог
        for (int i = 0; i < s_cur_word.length(); i++) {
            arr_masked_word.add("_");
        }
        arr_cur_word = s_cur_word.split("");
    }
    public void start_round() {
        // каждый раунд одинаковая логика
        Settings.print_current_word(arr_masked_word);

        Settings.print_ask_letter();
        get_letter();
        check_exist_letter_in_word();
        check_whole_word_is_solved();
    }
    public void get_letter() {
        String input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.next().toLowerCase();
        s_current_letter = input;

        validate_letter(input);
    }
    public void validate_letter(String p_letter) {
        boolean is_not_valid = false;
        Pattern pattern_valid = Pattern.compile("[^а-я]");
        Matcher matcher_valid =  pattern_valid.matcher(p_letter);

        if (p_letter.length() > 1) {
            Settings.print_value_is_long();
            is_not_valid = true;
        } else if (matcher_valid.matches()) {
            Settings.print_value_is_uncorrect();
            is_not_valid = true;
        }

        if (is_not_valid) {
            Settings.print_ask_letter();
            get_letter();
        }
    }
    public void check_exist_letter_in_word() {
        int i = 0;
        boolean b_letter_is_found = false;
        for (String val : arr_cur_word) {
            if (s_current_letter.equals(val)) {
                arr_masked_word.set(i, val);
                b_letter_is_found = true;
            }
            i++;
        }
        if (!b_letter_is_found) {
            Settings.print_user_get_mistake();
            i_mistakes = i_mistakes - 1;
            Settings.print_gallow(i_mistakes);
        }
    }

    public void check_whole_word_is_solved() {
        boolean checkWin = true;
        for (String val : arr_masked_word) {
            if (val.equals("_")) {
                checkWin = false;
                break;
            }
        }
        if (checkWin) {
            b_victory = true;
        }
    }

    public boolean end_game() {
        if (i_mistakes == 0) {
            Settings.print_lose();
        } else {
            Settings.print_victory();
        }
        Settings.print_ask_play();
        String enterVal;
        Scanner input = new Scanner(System.in);
        enterVal = input.next();

        if (enterVal.equals("1")) {
            return true;
        } else {
            return false;
        }
    }

}

