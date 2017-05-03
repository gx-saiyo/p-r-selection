import VLBranches.*;

/**
 * Created by shimomuratsubasa on 2017/05/03.
 */
public class Test {
    public static void main(String[] args) {

        VLBranches varBranches = new VLBranches();

        VCondition aCondtion = new VCondition() {
            public Boolean checkCondition(int number) {
                return number < 1;
            }
        };

        VConditionFilled aAction = new VConditionFilled() {
            public void doAction() {
                System.out.println("Aの処理を実行");
            }
        };

        varBranches.addBranch(aCondtion, aAction);

        VCondition bCondition = new VCondition(){
            public Boolean checkCondition(int number){
                return number < 2;
            }
        };

        VConditionFilled bAction = new VConditionFilled() {
            public void doAction() {
                System.out.println("Bの処理を実行");
            }
        };

        varBranches.addBranch(bCondition, bAction);

        VCondition nCondtion = new VCondition() {
            public Boolean checkCondition(int number) {
                return number < 5;
            }
        };

        VLBranches nBranch = new VLBranches();

        varBranches.addBranch(nCondtion, nBranch);

        VCondition cCondition = new VCondition(){
            public Boolean checkCondition(int number){
                return number < 3;
            }
        };

        VConditionFilled cAction = new VConditionFilled() {
            public void doAction() {
                System.out.println("Cの処理を実行");
            }
        };

        nBranch.addBranch(cCondition, cAction);

        VCondition dCondition = new VCondition(){
            public Boolean checkCondition(int number){
                return number < 4;
            }
        };

        VConditionFilled dAction = new VConditionFilled() {
            public void doAction() {
                System.out.println("Dの処理を実行");
            }
        };

        nBranch.addBranch(dCondition, dAction);

        varBranches.select(0);
        varBranches.select(1);
        varBranches.select(2);
        varBranches.select(3);
        varBranches.select(5);
    }
}
