package zulrah;

import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleItem;
import simple.hooks.wrappers.SimpleNpc;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;

public class TeleportWizard extends Task {

    public TeleportWizard(ClientContext ctx) {
        super(ctx);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean condition() {
    	SimpleNpc wizard = ctx.npcs.populate().filter("Wizard Distentor").nearest().next();
        SimpleItem recoil = ctx.inventory.populate().filter("Ring of recoil").next();
        SimpleItem shark = ctx.inventory.populate().filter(Util.food).next();
        SimpleItem prayer = ctx.inventory.populate().filter("Super restore(4)").next();
        return ZulrahMain.started == true && recoil != null && shark != null && prayer != null && wizard != null;
    }

    @Override
    public void run() {
    	SimpleObject fountain = ctx.objects.populate().filter(29241).nearest().next();
    	if(fountain != null && fountain.validateInteractable()) {
    		fountain.click(1);
    		ctx.sleep(500);
    		ctx.onCondition(() -> ctx.pathing.inMotion() == false, 4000);
    	}
    	
    	
        SimpleNpc wizard = ctx.npcs.populate().filter("Wizard Distentor").nearest().next();
        if(wizard != null && wizard.validateInteractable()) {
        	wizard.click("Teleport-previous");
        	ctx.onCondition(() -> ctx.players.getLocal().getAnimation() == 741, 6000);
        }
        
    }

    @Override
    public String status() {
        // TODO Auto-generated method stub
        return "Teleporting";
    }

}