import java.util.List;
import java.util.ArrayList;

/**
 * fizzbuzzを実行するためのクラス
 */
public class FizzBuzzRunner {
    //ユーザが選択した機能を判断するための不変オブジェクト
    private final static String SELECTOR_PRINT = "1";
    private final static String SELECTOR_HISTORY = "2";
    private final static String SELECTOR_WRITE = "3";
    private final static String SELECTOR_READ = "4";

    //入力を取得するための変数
    private Inputable inputer;

    //表示のための変数
    private Printable printer;

    //fizzbuzzの履歴を保持するリスト
    private List<Integer> histories = new ArrayList<Integer>();

    /**
     * コンストラクタ
     * @param inputer 入力を取得するための変数
     * @param printer 表示のための変数
     */
    public FizzBuzzRunner(Inputable inputer, Printable printer) {
        this.inputer = inputer;
        this.printer = printer;
    }

    /**
     * fizzbuzzを実行するメソッド
     * @param selector ユーザが選択した機能の番号
     */
    public void run(String selector) {
        switch (selector) {
            case SELECTOR_PRINT:
                int number = Integer.parseInt(inputer.gets());
                histories.add(number);
                FizzBuzz.print(number, printer);
                break;
            case SELECTOR_HISTORY:
                for (Integer history : histories) {
                    FizzBuzz.printHistory(history, printer);
                }
                break;
            case SELECTOR_WRITE:
                FizzBuzz.write(histories);
                break;
            case SELECTOR_READ:
                FizzBuzz.read(printer);
                break;
            default:
        }
    }
}
