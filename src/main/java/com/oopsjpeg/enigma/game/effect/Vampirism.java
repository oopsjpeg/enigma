package com.oopsjpeg.enigma.game.effect;

import com.oopsjpeg.enigma.game.Stats;
import com.oopsjpeg.enigma.game.effect.util.Effect;

public class Vampirism implements Effect {
	public static final String NAME = "Vampirism";
	private final Stats stats = new Stats();
	private final float power;

	public Vampirism(float power) {
		this.power = power;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public float getPower() {
		return power;
	}

	@Override
	public Stats getStats() {
		stats.lifeSteal = power;
		return stats;
	}
}