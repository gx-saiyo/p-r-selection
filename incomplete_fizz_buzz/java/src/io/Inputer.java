import java.io.DataInputStream;

/**
 * ユーザからの入力を取得するクラス
 */
public class Inputer implements Inputable {

    @Override
    public String gets() {
        try {
            DataInputStream stream = new DataInputStream(System.in);
            return stream.readLine();
        } catch (Exception e) {
        }
        return null;
    }
}
