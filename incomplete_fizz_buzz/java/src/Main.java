/**
 * 実行クラス
 */
public class Main {

    /**
     * メインメソッド
     *
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        Inputer inputer = new Inputer();
        Printer printer = new Printer();
        FizzBuzzRunner runner = new FizzBuzzRunner(inputer, printer);
        Looper looper = new Looper(runner, inputer);
        looper.loop();
    }
}
