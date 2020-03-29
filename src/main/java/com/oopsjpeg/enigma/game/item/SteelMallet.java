package com.oopsjpeg.enigma.game.item;

import com.oopsjpeg.enigma.game.Stats;
import com.oopsjpeg.enigma.game.effect.DawnShield;
import com.oopsjpeg.enigma.game.obj.Effect;
import com.oopsjpeg.enigma.game.obj.Item;

public class SteelMallet extends Item {
    public static final String NAME = "Steel Mallet";
    public static final Tree TREE = Tree.HEALTH;
    public static final String TIP = "shields";
    public static final int COST = 625;
    public static final Item[] BUILD = new Item[]{new Ring(), new Crystal()};
    public static final Effect[] EFFECTS = new Effect[]{new DawnShield(50)};
    public static final Stats STATS = new Stats()
            .put(Stats.ABILITY_POWER, 15)
            .put(Stats.MAX_HEALTH, 60);

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Tree getTree() {
        return TREE;
    }

    @Override
    public String getTip() {
        return TIP;
    }

    @Override
    public int getCost() {
        return COST;
    }

    @Override
    public Item[] getBuild() {
        return BUILD;
    }

    @Override
    public Effect[] getEffects() {
        return EFFECTS;
    }

    @Override
    public Stats getStats() {
        return STATS;
    }
}
