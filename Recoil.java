package zulrah;

import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleItem;
import simple.robot.api.ClientContext;

public class Recoil extends Task {

    public Recoil(ClientContext ctx) {
        super(ctx);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean condition() {
    	SimpleItem recoilring = ctx.inventory.populate().filter("ring of recoil").next();
        return ZulrahMain.started == true && ctx.equipment.populate().filter("Ring of recoil").isEmpty() && ctx.bank.bankOpen() == false && recoilring != null;
    }

    @Override
    public void run() {
        SimpleItem recoilring = ctx.inventory.populate().filter("ring of recoil").next();
        if(recoilring != null) {
        	recoilring.click(1);
        	ctx.sleep(150);
        }
        
    }

    @Override
    public String status() {
        // TODO Auto-generated method stub
        return "Equipping recoil";
    }

}