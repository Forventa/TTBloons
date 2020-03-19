package zulrah;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleNpc;
import simple.robot.api.ClientContext;

public class StandOnTile extends Task {

    public StandOnTile(ClientContext ctx) {
        super(ctx);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean condition() {
        SimpleNpc zulrah = ctx.npcs.populate().filter("Zulrah").nearest().next();
        return ZulrahMain.started == true && !ctx.pathing.onTile(new WorldPoint(2272, 3078, 0)) && zulrah != null;
    }

    @Override
    public void run() {
        ctx.pathing.step(new WorldPoint(2272, 3078, 0));
        ctx.onCondition(() -> ctx.pathing.step(new WorldPoint(2272, 3078, 0)), 6000);
        
    }

    @Override
    public String status() {
        // TODO Auto-generated method stub
        return "Walking to tile";
    }

}