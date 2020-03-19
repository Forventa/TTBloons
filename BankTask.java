package zulrah;

import simple.hooks.filters.SimpleBank.Amount;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;

public class BankTask extends Task {

    public BankTask(ClientContext ctx) {
        super(ctx);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean condition() {
        SimpleObject bankbooth = ctx.objects.populate().filter("Bank booth").nearest().next();
        return ZulrahMain.started == true && ctx.inventory.populate().filter(Util.food).isEmpty() && bankbooth != null;
    }

    @Override
    public void run() {
    	
    	SimpleObject bankbooth = ctx.objects.populate().filter("Bank booth").nearest().next();
    	if(ctx.bank.bankOpen() == false && bankbooth != null) {
    		bankbooth.click("Bank");
    		ctx.onCondition(() -> ctx.bank.bankOpen(), 3000);
    	}
    	
    	
        if(ctx.bank.bankOpen()) {
        	ctx.bank.depositInventory();
        	ctx.sleep(250);
        	ctx.bank.withdraw("Ring of recoil", 3);
        	ctx.sleep(250);
        	ctx.bank.withdraw("Ranging potion (4)", Amount.ONE);
        	ctx.sleep(250);
        	ctx.bank.withdraw("Super restore(4)", Amount.FIVE);
        	ctx.sleep(250);
        	ctx.bank.withdraw("Ranging potion(4)", 1);
        	ctx.sleep(250);
        	ctx.bank.withdraw(Util.food, Amount.ALL);
        	ctx.bank.closeBank();
        	ctx.onCondition(() -> ctx.bank.bankOpen() == false, 2000);
        }
        
    }

    @Override
    public String status() {
        // TODO Auto-generated method stub
        return "Banking";
    }

}