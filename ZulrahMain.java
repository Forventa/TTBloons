package zulrah;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import simple.hooks.scripts.Category;
import simple.hooks.scripts.ScriptManifest;
import simple.hooks.scripts.task.Task;
import simple.hooks.scripts.task.TaskScript;
import simple.hooks.simplebot.ChatMessage;

@ScriptManifest(author = "TTBloons", name = "Zulrah", category = Category.FISHING, version = "1.0D",
description = "Set your last destination fairy ring to DKP. Start with dramen staff equipped, and req items to fish. to fish karambwanji start near the fishing spot for karambwanji(ring code : ckr)", discord = "FORVENTA TTBloons#4174", servers = { "Zenyte" })


public class ZulrahMain extends TaskScript {
public static int zkc;
public static int rares;
public static boolean started;
public static int killsh;

public ZGUI zgui;
private long startTime = System.currentTimeMillis();
    private List<Task> tasks = new ArrayList<Task>();

    private String formatTime(final long ms) {
        long s = ms / 1000, m = s / 60, h = m / 60;
        s %= 60;
        m %= 60;
        h %= 24;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
    
    @Override
    public void paint(Graphics g) {
    	killsh = (int)(zkc / ((System.currentTimeMillis() - startTime) / 3600000.0D));
    	long runTime = System.currentTimeMillis() - startTime;
    	g.setColor(Color.pink);
    	g.drawRect(8, 74, 101, 61);
    	g.setColor(new Color(0, 0, 0));
    	g.fillRect(9, 75, 100, 60);
    	g.setColor(new Color(255, 255, 255));
		g.drawString("TTBloons Zulrah.", 12, 90);
		g.drawString("Kills: " + zkc, 12, 105);
		g.drawString("kills Hour: " + killsh , 12, 120);
		g.drawString("Time ran: " + formatTime(runTime) ,12, 135); 
        
    }

    @Override
    public boolean prioritizeTasks() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public List<Task> tasks() {
        // TODO Auto-generated method stub
        return tasks;
    }

    @Override
    public void onChatMessage(ChatMessage m) {

    }

    @Override
    public void onExecute() {
    	zkc = 0;
    	rares = 0;
    	started = false;
    	Util.startbool = true;
    	
    	zgui = new ZGUI(this);
    	zgui.setVisible(true);
    	
    	Util.food = "Shark";
    	System.out.println("Food:" + Util.food);
    	System.out.println("Hptoeat: "+Util.hptoeat);
    	System.out.println("Praytopot: "+Util.praytopot);
    	System.out.println("Rpot:"+Util.rpot);
    	
    	
        tasks.addAll(Arrays.asList(new StartTask(ctx), new StandOnTile(ctx), new RangingPot(ctx), new PrayRestore(ctx), new MoreAttack(ctx), new TeleportHome(ctx), new BankTask(ctx), new TeleportWizard(ctx), new EnterBoat(ctx), new Eat(ctx), new Prayer(ctx), new Attack(ctx), new Recoil(ctx), new Looting(ctx)));
        
    }

    @Override
    public void onTerminate() {
        // TODO Auto-generated method stub
        
    }

}