package zulrah;

import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleNpc;
import simple.robot.api.ClientContext;

public class TeleportHome extends Task {

    public TeleportHome(ClientContext ctx) {
        super(ctx);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean condition() {
        SimpleNpc zulrah = ctx.npcs.populate().filter("Zulrah").nearest().next();
        return ZulrahMain.started == true && ctx.inventory.populate().filter(Util.food).isEmpty() && zulrah != null;
    }

    @Override
    public void run() {
        ctx.magic.castSpellOnce("Edgeville Home Teleport");
        ctx.sleep(2000);
        
    }

    @Override
    public String status() {
        // TODO Auto-generated method stub
        return "Teleporting Home";
    }

}