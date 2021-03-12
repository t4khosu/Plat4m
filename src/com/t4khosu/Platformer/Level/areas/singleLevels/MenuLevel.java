package com.t4khosu.Platformer.Level.areas.singleLevels;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.Level.LoadLevel;
import com.t4khosu.Platformer.entities.player.Player;

public class MenuLevel extends LoadLevel {

    public MenuLevel(Player player) {
        super(player,
                null,
                "/level/menuLevel.png",
                "/level/menuLevel_back.png",
                Level.levelType.NATURE,
                null,
                0,
                0
        );
    }

    @Override
    protected void initMobs() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void initNPCs() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void initSurroundings() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void individualUpdate() {
        // TODO Auto-generated method stub

    }

    @Override
    public void individualSaveFileLoad(String input) {
        // TODO Auto-generated method stub

    }

    @Override
    public String individualSave() {
        // TODO Auto-generated method stub
        return null;
    }

}
