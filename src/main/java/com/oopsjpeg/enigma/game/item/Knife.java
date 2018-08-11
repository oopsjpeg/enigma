package com.oopsjpeg.enigma.game.item;

import com.oopsjpeg.enigma.game.Stats;
import com.oopsjpeg.enigma.game.item.util.Item;

public class Knife implements Item {
	public static final String NAME = "Knife";
	public static final int COST = 250;
	public static final Stats STATS = new Stats();

	static {
		STATS.damage = 6;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public int getCost() {
		return COST;
	}

	@Override
	public Stats getStats() {
		return STATS;
	}
}