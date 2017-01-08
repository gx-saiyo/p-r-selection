package if_statement;

/**
 * Created by n1631107 on 2017/01/08.
 */
public abstract class Statement {
    protected boolean condition(int number) {
        return true;
    }

    protected abstract void select(int number);
}
