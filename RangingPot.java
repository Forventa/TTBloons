package zulrah;

import simple.hooks.filters.SimpleSkills.Skills;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleItem;
import simple.hooks.wrappers.SimpleNpc;
import simple.robot.api.ClientContext;

public class RangingPot extends Task {

    public RangingPot(ClientContext ctx) {
        super(ctx);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean condition() {
        SimpleItem rangingpot = ctx.inventory.populate().filter("Ranging potion(4)", "Ranging potion(3)", "Ranging potion(2)", "Ranging potion(1)").next();
        SimpleNpc zulrah = ctx.npcs.populate().filter("Zulrah").nearest().next();
        return Util.rpot == true && ZulrahMain.started == true && rangingpot != null && zulrah != null && ctx.skills.level(Skills.RANGED) <= 110;
    }

    @Override
    public void run() {
    	SimpleItem rangingpot = ctx.inventory.populate().filter("Ranging potion(4)", "Ranging potion(3)", "Ranging potion(2)", "Ranging potion(1)").next();
        rangingpot.click(1);
    }

    @Override
    public String status() {
        // TODO Auto-generated method stub
        return "Sipping";
    }

}