package zulrah;

import simple.hooks.filters.SimpleEquipment.EquipmentSlot;
import simple.hooks.scripts.task.Task;
import simple.hooks.simplebot.Combat.Style;
import simple.robot.api.ClientContext;

public class StartTask extends Task {

    public StartTask(ClientContext ctx) {
        super(ctx);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean condition() {
        // TODO Auto-generated method stub
        return Util.startbool == true;
    }

    @Override
    public void run() {
        if(!ctx.equipment.isEquipped(EquipmentSlot.WEAPON)) {
        	ZulrahMain.started = false;
        	ctx.log("You are missing a weapon", true);
        	ctx.onCondition(() -> ctx.equipment.isEquipped(EquipmentSlot.WEAPON), 5000);
        }
        
        
        if(!ctx.equipment.isEquipped(EquipmentSlot.WEAPON) && ctx.equipment.populate().filter("Toxic blowpipe", "Twisted bow").isEmpty()) {
        	ctx.combat.style(Style.DEFENSIVE);
        	ctx.log("Setting long range", true);
        }else {
        	ctx.combat.style(Style.AGGRESSIVE);
        }
        
        ctx.log("Thanks for using TTBloons zulrah", true);
        
        Util.startbool = false;
        
    }

    @Override
    public String status() {
        // TODO Auto-generated method stub
        return "Setting things up.";
    }

}