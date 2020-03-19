package zulrah;

import net.runelite.api.Skill;
import simple.hooks.filters.SimplePrayers.Prayers;
import simple.hooks.filters.SimpleSkills.Skills;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleNpc;
import simple.robot.api.ClientContext;

public class MoreAttack extends Task {

    public MoreAttack(ClientContext ctx) {
        super(ctx);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean condition() {
        SimpleNpc zulrah = ctx.npcs.populate().filter("Zulrah").nearest().next();
        return Util.rigour == true && ZulrahMain.started == true && zulrah != null && ctx.prayers.prayerActive(Prayers.RIGOUR) == false ||
        		ctx.skills.realLevel(Skills.PRAYER) >= 44 && Util.rigour == false && ZulrahMain.started == true && zulrah != null && ctx.prayers.prayerActive(Prayers.EAGLE_EYE) == false;
    }

    @Override
    public void run() {
    	if(Util.rigour == true) {
    		ctx.prayers.prayer(Prayers.RIGOUR);
    	}else {
    		ctx.prayers.prayer(Prayers.EAGLE_EYE);
    	}
    	
    	
    }

    @Override
    public String status() {
        // TODO Auto-generated method stub
        return "Putting on some pray";
    }

}