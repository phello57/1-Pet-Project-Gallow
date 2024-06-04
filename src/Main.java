

public class Main {
    public static void main(String[] args)   {

        /* Все логи в консоль и какие то дефолтные определения состояний я вынес в класс Settings
        */

       boolean b_start_game = true;
        while(b_start_game) {
            Game newGame = new Game();
            b_start_game = newGame.start();
        }
    }
}