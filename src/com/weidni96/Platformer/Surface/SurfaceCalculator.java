package com.weidni96.Platformer.Surface;

import java.awt.Color;
import java.awt.Font;

import com.weidni96.Platformer.Game;
import com.weidni96.Platformer.graphics.Sprite;

public class SurfaceCalculator {
	
	private static int midX = Game.width/2;
	
	public static int frontSlotBGs_x[] = {
			Game.width/2-1-Sprite.handSlot.getWidth(),
			Game.width/2+1,
			Game.width/2+2 + Sprite.handSlot.getWidth(),
			Game.width/2+3 + Sprite.handSlot.getWidth() + Sprite.extraSlot.getWidth(),
			Game.width/2+4 + Sprite.handSlot.getWidth() + 2*Sprite.extraSlot.getWidth(),
			Game.width/2 - 2 - Sprite.handSlot.getWidth() - Sprite.extraSlot.getWidth(),
			Game.width/2 - 3 - Sprite.handSlot.getWidth() - 2*Sprite.extraSlot.getWidth(),
			Game.width/2 - 4 - Sprite.handSlot.getWidth() - 3*Sprite.extraSlot.getWidth()
	};
	
	public static int frontSlotsJK_x[] = {
			midX - 1 - Sprite.handSlot.getWidth(),
			midX + 1
	};
	
	public static int smallSlots_x[] = {
			midX - 4 - Sprite.handSlot.getWidth() - 3*Sprite.extraSlot.getWidth()+2,
			midX - 3 - Sprite.handSlot.getWidth() - 2*Sprite.extraSlot.getWidth()+2,
			midX - 2 - Sprite.handSlot.getWidth() - Sprite.extraSlot.getWidth()+2,
			midX + 2 + Sprite.handSlot.getWidth()+2,
			midX + 3 + Sprite.handSlot.getWidth() + Sprite.extraSlot.getWidth()+2,
			midX + 4 + Sprite.handSlot.getWidth() + 2*Sprite.extraSlot.getWidth()+2
	};
	
	public static int mobStatus_x[] = {
			Game.width/2 - Sprite.mobStatus.getWidth()/2,
			(Game.width/2 - Sprite.mobStatus.getWidth()/2)*Game.scale + 12
	};
	public static int mobStatus_y[] = {
			Sprite.handSlot.getHeight() + 2,
			(Sprite.handSlot.getHeight() + 2)*Game.scale + 18
	};
	
	public static int graphics_x[] = {
			(Game.width * Game.scale / 2) - 42,
			(Game.width * Game.scale / 2) + 13,
			(Game.width * Game.scale / 2) - 161,
			(Game.width * Game.scale / 2) - 121,
			(Game.width * Game.scale / 2) - 81,
			(Game.width * Game.scale / 2) + 64,
			(Game.width * Game.scale / 2) + 104,
			(Game.width * Game.scale / 2) + 144
	};
	
	public static int showTimer_x = (Game.width*Game.scale - Sprite.showStatusBar.getWidth()*Game.scale) + 45;
	public static int showTimer_y = 15*Game.scale + 42;
}
