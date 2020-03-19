package zulrah;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;

public class EnterBoat extends Task {

    public EnterBoat(ClientContext ctx) {
        super(ctx);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean condition() {
        SimpleObject boat = ctx.objects.populate().filter(10068).nearest().next();
        return ZulrahMain.started == true && boat != null;
    }

    @Override
    public void run() {
    	SimpleObject boat = ctx.objects.populate().filter(10068).nearest().next();
    	if(boat != null && boat.validateInteractable()) {
    		boat.click(1);
    		ctx.onCondition(() -> ctx.pathing.onTile(new WorldPoint(2268, 3069, 0)), 5000);
    	}
        
    }

    @Override
    public String status() {
        // TODO Auto-generated method stub
        return "Banking";
    }

}