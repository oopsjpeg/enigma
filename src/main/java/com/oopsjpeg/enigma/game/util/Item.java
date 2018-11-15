package com.oopsjpeg.enigma.game.util;

import com.oopsjpeg.enigma.game.Game;
import com.oopsjpeg.enigma.game.item.*;

import java.lang.reflect.InvocationTargetException;

public abstract class Item {
	private static final Item[] values = {
			new AuroralMask(),
			new BloodlustBlade(),
			new BronzeCutlass(),
			new Crystal(),
			new Hatchet(),
			new IronScimitar(),
			new Knife(),
			new MidnightDagger(),
			new MythicalTriblade(),
			new Potion(),
			new Soulstealer()
	};

	public static Item[] values() {
		return values;
	}

	public static Item fromName(String name) {
		for (Item i : values)
			if (name.equalsIgnoreCase(i.getName()) || (name.length() >= 3
					&& i.getName().toLowerCase().startsWith(name.toLowerCase()))) {
				try {
					return i.getClass().getConstructor().newInstance();
				} catch (IllegalAccessException | InstantiationException
						| NoSuchMethodException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		return null;
	}

	public abstract String getName();

	public String getDesc() {
		return "";
	}

	public abstract int getCost();

	public Item[] getBuild() {
		return new Item[0];
	}

	public Effect[] getEffects() {
		return new Effect[0];
	}

	public Stats getStats() {
		return new Stats();
	}

	public Stats getPerTurn() {
		return new Stats();
	}

	public boolean canUse() {
		return false;
	}

	public boolean removeOnUse() {
		return true;
	}

	public String onUse(Game.Member user) {
		return "";
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj.getClass().equals(getClass());
	}

	@Override
	public String toString() {
		return getName();
	}
}