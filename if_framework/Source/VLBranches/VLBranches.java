package VLBranches;

import java.util.ArrayList;

/**
 * Created by shimomuratsubasa on 2017/05/03.
 */

public class VLBranches implements VConditionFilled{
    private ArrayList<VCSet> branch = new ArrayList<VCSet>();

    class VCSet{
        private VCondition condition;
        private VConditionFilled action;

        VCSet(VCondition con, VConditionFilled act){
            condition = con;
            action = act;
        }

        Boolean checkCondition(int num){
            return condition.checkCondition(num);
        }

        void doAction(){action.doAction();}
    }

    public void addBranch(VCondition condition, VConditionFilled action) {
        branch.add(new VCSet(condition, action));
    }

    public void select(int number){
        for(VCSet set: branch){
            if(set.checkCondition(number)){
                if(set.action instanceof VLBranches)
                    ((VLBranches) set.action).select(number);
                else
                    set.doAction();
                break;
            }
        }
    }

    public void doAction() {
        //elseにあたる
    }
}

