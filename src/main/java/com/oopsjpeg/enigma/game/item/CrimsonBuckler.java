package com.oopsjpeg.enigma.game.item;

import com.oopsjpeg.enigma.game.Stats;
import com.oopsjpeg.enigma.game.Tree;
import com.oopsjpeg.enigma.game.effect.Brawn;
import com.oopsjpeg.enigma.game.effect.Divinity;
import com.oopsjpeg.enigma.game.object.Effect;
import com.oopsjpeg.enigma.game.object.Item;

public class CrimsonBuckler extends Item {
    public CrimsonBuckler() {
        super("Crimson Buckler", Tree.HEALTH, "Damage from bonus health", 1050,
                new Item[]{new DivinePlatemail(), new Knife()},
                new Effect[]{new Divinity(0.4f), new Brawn(0.15f)},
                new Stats()
                        .put(Stats.MAX_HEALTH, 100)
                        .put(Stats.RESIST, 0.12f));
    }
}
