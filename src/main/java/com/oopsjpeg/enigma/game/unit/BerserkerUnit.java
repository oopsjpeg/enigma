package com.oopsjpeg.enigma.game.unit;

import com.oopsjpeg.enigma.game.Game;
import com.oopsjpeg.enigma.game.Stats;
import com.oopsjpeg.enigma.game.unit.util.Unit;
import com.oopsjpeg.enigma.util.Emote;

import java.awt.*;

public class BerserkerUnit implements Unit {
	public static final String NAME = "Berserker";
	public static final String DESC = "Being attacked and defending builds up to **6** stacks of **Rage**."
			+ "\nUsing `>rage` consumes stacks (min. 2) to increase energy for a turn (**25** per **2** stacks)."
			+ "\nUsing `>rage` at full capacity grants a bonus **50** energy.";
	public static final Color COLOR = Color.RED;
	public static final Stats STATS = new Stats();
	public static final Stats PER_TURN = new Stats();

	static {
		STATS.energy = 75;

		STATS.maxHp = 610;
		STATS.damage = 28;

		PER_TURN.hp = 15;
		PER_TURN.gold = 75;
	}

	private int rage = 0;

	public int getRage() {
		return rage;
	}

	public void setRage(int rage) {
		this.rage = Math.max(0, Math.min(6, rage));
	}

	public int rage() {
		setRage(rage + 1);
		return rage;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public String getDesc() {
		return DESC;
	}

	@Override
	public Color getColor() {
		return COLOR;
	}

	@Override
	public Stats getStats() {
		return STATS;
	}

	@Override
	public Stats getPerTurn() {
		return PER_TURN;
	}

	@Override
	public String onDefend(Game.Member member) {
		if (rage() == 6)
			return Emote.RAGE + "**Rage** is at maximum capacity.";
		return "";
	}
}