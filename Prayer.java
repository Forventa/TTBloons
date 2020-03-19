package zulrah;

import java.util.List;

import net.runelite.api.Projectile;
import simple.hooks.filters.SimplePrayers.Prayers;
import simple.hooks.scripts.task.Task;
import simple.hooks.simplebot.Projectiles;
import simple.hooks.wrappers.SimpleNpc;
import simple.robot.api.ClientContext;

public class Prayer extends Task {

    public Prayer(ClientContext ctx) {
        super(ctx);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean condition() {
    	
        SimpleNpc zulrahrange = ctx.npcs.populate().filter(2042).nearest().next();
        SimpleNpc zulrahmage = ctx.npcs.populate().filter(2044).nearest().next();
        return zulrahrange != null && ctx.prayers.prayerActive(Prayers.PROTECT_FROM_MISSILES) == false || zulrahmage != null && ctx.prayers.prayerActive(Prayers.PROTECT_FROM_MAGIC) == false;
        
    }
    	
    
    
    

    @Override
    public void run() {
        SimpleNpc zulrahrange = ctx.npcs.populate().filter(2042).nearest().next();
        SimpleNpc zulrahmage = ctx.npcs.populate().filter(2044).nearest().next();
    	
    	if(zulrahrange != null && ctx.prayers.prayerActive(Prayers.PROTECT_FROM_MISSILES) == false) {
    		ctx.prayers.prayer(Prayers.PROTECT_FROM_MISSILES);
    	}
        
    	if(zulrahmage != null && ctx.prayers.prayerActive(Prayers.PROTECT_FROM_MAGIC) == false) {
    		ctx.prayers.prayer(Prayers.PROTECT_FROM_MAGIC);
    	}
        
    }

    @Override
    public String status() {
        // TODO Auto-generated method stub
        return "Switching prayer";
    }

}