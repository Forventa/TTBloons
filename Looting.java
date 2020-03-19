package zulrah;

import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleGroundItem;
import simple.hooks.wrappers.SimpleItem;
import simple.robot.api.ClientContext;

public class Looting extends Task {

    public Looting(ClientContext ctx) {
        super(ctx);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean condition() {
    	SimpleGroundItem rare = ctx.groundItems.populate().filter(Util.rare).nearest().next();
        SimpleGroundItem scale = ctx.groundItems.populate().filter("Zulrah's scales").nearest().next();
        SimpleGroundItem other = ctx.groundItems.populate().filter(Util.common).nearest().next();
        		
        return ZulrahMain.started == true && scale != null || ZulrahMain.started == true && other != null || ZulrahMain.started == true && rare != null;
    }

    @Override
    public void run() {
    	SimpleGroundItem rare = ctx.groundItems.populate().filter(Util.rare).nearest().next();
        SimpleGroundItem scale = ctx.groundItems.populate().filter("Zulrah's scales").nearest().next();
        SimpleGroundItem other = ctx.groundItems.populate().filter(Util.common).nearest().next();    	
        
        if(!ctx.inventory.inventoryFull() && rare != null) {
        	rare.click("Take");
        	ZulrahMain.rares = ZulrahMain.rares + 1;
        	ctx.sleep(1000);
        }
        
        if(other == null && scale != null && !ctx.inventory.inventoryFull()) {
        	scale.click("Take");
        	ZulrahMain.zkc = ZulrahMain.zkc + 1;
        	ctx.sleep(1000);
        }
        
    	if(other != null && !ctx.inventory.inventoryFull()) {
    		other.click("Take");
    	}
    	
    	if(ctx.inventory.inventoryFull()) {
    		SimpleItem shark = ctx.inventory.populate().filter(Util.food).next();
    		shark.click(1);
    		ctx.sleep(500);
    	}
    	
    }

    @Override
    public String status() {
        // TODO Auto-generated method stub
        return "Looting";
    }

}