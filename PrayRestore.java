package zulrah;

import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleItem;
import simple.hooks.wrappers.SimpleNpc;
import simple.robot.api.ClientContext;

public class PrayRestore extends Task {

    public PrayRestore(ClientContext ctx) {
        super(ctx);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean condition() {
    	SimpleNpc zulrah = ctx.npcs.populate().filter("Zulrah").nearest().next();
        SimpleItem restore = ctx.inventory.populate().filter("Super restore(4)", "Super restore(3)", "Super restore(2)", "Super restore(1)").next();
        return ZulrahMain.started == true && ctx.prayers.points() <= Util.praytopot && zulrah != null;
    }

    @Override
    public void run() {
    	SimpleItem restore = ctx.inventory.populate().filter("Super restore(4)", "Super restore(3)", "Super restore(2)", "Super restore(1)").next();
    	restore.click(1);
        
    }

    @Override
    public String status() {
        // TODO Auto-generated method stub
        return "Drinking prayerpot";
    }

}