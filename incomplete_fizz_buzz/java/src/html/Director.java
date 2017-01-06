package html;

import java.util.List;

/**
 * HtmlBuilderは再利用可能なクラスなので，本クラスを通して実行する
 */
public class Director {
  private HtmlBuilder htmlBuilder;
  private List<String> items;

  Director(){}

  public Director(HtmlBuilder htmlBuilder,List<String> items){
    this.htmlBuilder = htmlBuilder;
    this.items = items;
  }

  public void director(){
    htmlBuilder.makeTitle("FizzBuzz")
        .makeTable("FizzBuzz")
        .close();
  }

  List<String> getItems() {
    return items;
  }
}