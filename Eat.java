package zulrah;

import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleItem;
import simple.hooks.wrappers.SimpleNpc;
import simple.robot.api.ClientContext;

public class Eat extends Task {

    public Eat(ClientContext ctx) {
        super(ctx);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean condition() {
        SimpleNpc zulrah = ctx.npcs.populate().filter("zulrah").nearest().next();
        return ZulrahMain.started == true && ctx.combat.health() <= Util.hptoeat && zulrah != null;
    }

    @Override
    public void run() {
        SimpleItem food = ctx.inventory.populate().filter(Util.food).next();
        if(food != null) {
        	food.click(1);
        	ctx.sleep(150);
        }
        
    }

    @Override
    public String status() {
        // TODO Auto-generated method stub
        return "Eating";
    }

}