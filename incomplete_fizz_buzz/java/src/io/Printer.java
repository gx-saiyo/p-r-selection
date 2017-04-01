/**
 * コマンドラインに情報を表示するクラス
 */
public class Printer implements Printable {

    @Override
    public void execute(String s) {
        System.out.println(s);
    }
}
