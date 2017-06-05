package html;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class HtmlBuilder {
  private String filename;
  private PrintWriter printWriter;
  private List<String> histories = new Director().getItems();

  public HtmlBuilder(List<String> histories) {
    this.histories = histories;
  }

  /**
   * タイトルを設定するメソッドです
   *
   * @param title ファイル名
   * @return
   */
  public HtmlBuilder makeTitle(String title) {
    filename = title + ".html";
    try {
      printWriter = new PrintWriter(new FileWriter(filename));
    } catch (IOException e) {
      e.printStackTrace();
    }
    printWriter.println("<html><head><title>" + title + "</title></head><body>");
    printWriter.println("<h1>" + title + "</h1>");
    return this;
  }

  /**
   * 表を作成するメソッドです
   *
   * @param tableName 表の名前
   * @return このクラスを返します
   */
  public HtmlBuilder makeTable(String tableName) {
    printWriter.println("<table><caption>" + "表．" + tableName + "</caption>");
    // addItemsを使った処理
    addItem("入力, 出力");
    for (String history : histories) {
      addItem(history);
    }
    printWriter.println("</table>");
    return this;
  }

  /**
   * "a, b"(:String)の形で書かれた行を受け取り，表に挿入していきます．
   *
   * @param item
   * @return
   */
  public void addItem(String item) {
    String[] io = item.split(", ", 0);
    List<String> hoge = Arrays.asList(item.split(", "));
    hoge.iterator();
    printWriter.println("<tr>\n" +
        "\t<th>" + io[0] + "</th>\n" +
        "\t<th>" + io[1] + "</th>\n" +
        "<tr>\n");
  }

  /**
   * printWriterを閉じ，ファイルを生成します．
   */
  public void close() {
    printWriter.println("</body></html>");
    printWriter.close();
  }
}