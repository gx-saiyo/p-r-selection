/**
 * FizzBuzzRunnerを繰り返し実行するクラスです
 */
public class Looper {

    //fizz_buzzを実行するための変数
    private FizzBuzzRunner fizzBuzzRunner;

    //ユーザからの入力を取得する変数
    private Inputable inputer;

    /**
     * コンストラクタ
     *
     * @param fizzBuzzRunner fizz_buzzを実行するための変数
     * @param inputer        ユーザからの入力を取得する変数
     */
    public Looper(FizzBuzzRunner fizzBuzzRunner, Inputable inputer) {
        this.fizzBuzzRunner = fizzBuzzRunner;
        this.inputer = inputer;
    }

    /**
     * 入力値に対してfizz_buzzを実行し続けるメソッド
     */
    public void loop() {
        while (true) {
            String selector = inputer.gets();
            if (selector.equals("0")) {
                return;
            }
            fizzBuzzRunner.run(selector);
        }
    }
}
