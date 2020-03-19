package zulrah;

import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleNpc;
import simple.robot.api.ClientContext;

public class Attack extends Task {

    public Attack(ClientContext ctx) {
        super(ctx);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean condition() {
    	SimpleNpc zulrah = ctx.npcs.populate().filter("Zulrah").nearest().next();
        return ZulrahMain.started == true && ctx.players.getLocal().getInteracting() == null && zulrah != null && !zulrah.isDead();
    }

    @Override
    public void run() {
        SimpleNpc zulrah = ctx.npcs.populate().filter("Zulrah").nearest().next();
        if(zulrah != null && zulrah.turnTo()) {
        	zulrah.click("Attack");
        	ctx.sleep(150);
        }
        
    }

    @Override
    public String status() {
        // TODO Auto-generated method stub
        return "Attacking";
    }

}