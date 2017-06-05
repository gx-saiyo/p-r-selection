package items;

/**
 * Created by fefe on 2017/03/17.
 */
public enum MenuType {
  FIZZBUZZ(1),
  HISTORY(2),
  SAVE(3),
  LOAD(4);

  private final int id;

  MenuType(int id) {
    this.id = id;
  }

  int getId() {
    return this.id;
  }

  public static MenuType getType(final int id) {
    MenuType[] types = MenuType.values();
    for (MenuType type : types) {
      if (type.getId() == id) {
        return type;
      }
    }
    return null;
  }
}
