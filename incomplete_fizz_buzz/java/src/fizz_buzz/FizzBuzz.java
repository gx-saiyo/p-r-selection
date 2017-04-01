import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * fizz_buzzクラス
 */
public class FizzBuzz {
    //出力ファイルの名前
    private final static String TEXT_NAME = "data.txt";

    /**
     * numberに該当するfizzbuzzまたはnumberを表示する
     * @param number 入力値
     * @param printer 表示するための変数
     */
    public static void print(int number, Printable printer) {
        printer.execute(numberToFizzBuzz(number));
    }

    /**
     * numberとnumberに該当するfizzbuzzを表示する
     * @param number
     * @param printer
     */
    public static void printHistory(int number, Printable printer) {
        printer.execute(String.valueOf(number) + ", " + numberToFizzBuzz(number));
    }

    /**
     * numberをfizz_buzzに変換する
     * @param number 入力値
     * @return numberに該当するfizzbuzzの文字列
     */
    private static String numberToFizzBuzz(int number) {
        if (number % 15 == 0) return "FizzBuzz";
        else if (number % 3 == 0) return "Fizz";
        else if (number % 5 == 0) return "Buzz";
        else return String.valueOf(number);
    }

    /**
     * historiesをテキストファイルに保存する
     * @param histories fizzbuzzの履歴
     */
    public static void write(List<Integer> histories) {
        try {
            FileWriter fileWrite = new FileWriter(TEXT_NAME);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);
            for (Integer history : histories) {
                bufferedWriter.write(String.valueOf(history) + ", " + numberToFizzBuzz(history));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWrite.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * テキストファイルの内容を表示する
     * @param printer 表示のための変数
     */
    public static void read(Printable printer) {
        try {
            FileReader fileReader = new FileReader(TEXT_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) break;
                printer.execute(line);
            }
            fileReader.close();
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
