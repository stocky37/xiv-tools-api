package dev.stocky37.xiv.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.Duration;

public record Stats(
	// primary baseStats
	int strength,
	int dexterity,
	int vitality,
	int intelligence,
	int mind,

	// secondary baseStats
	int crit,
	int determination,
	int directHit,
	int skillSpeed,
	int spellSpeed,

	// role specific baseStats
	int tenacity,
	int piety,

	// weapon baseStats
	int physicalDamage,
	int magicalDamage,
	double delay,
	int autoAttack
) {

	@JsonIgnore
	public Duration delayDuration() {
		return Duration.ofMillis((long) (delay * 1000));
	}

	public static Builder builder() {
		return new Builder();
	}

	public static Builder builder(Stats stats) {
		return new Builder(stats);
	}

	public static class Builder {
		private int strength;
		private int dexterity;
		private int vitality;
		private int intelligence;
		private int mind;
		private int crit;
		private int determination;
		private int directHit;
		private int skillSpeed;
		private int spellSpeed;
		private int tenacity;
		private int piety;
		private int physicalDamage;
		private int magicalDamage;
		private double delay;
		private int autoAttack;

		public Builder() {}

		public Builder(Stats stats) {
			this.strength = stats.strength;
			this.dexterity = stats.dexterity;
			this.vitality = stats.vitality;
			this.intelligence = stats.intelligence;
			this.mind = stats.mind;
			this.crit = stats.crit;
			this.determination = stats.determination;
			this.directHit = stats.directHit;
			this.skillSpeed = stats.skillSpeed;
			this.spellSpeed = stats.spellSpeed;
			this.tenacity = stats.tenacity;
			this.piety = stats.piety;
			this.physicalDamage = stats.physicalDamage;
			this.magicalDamage = stats.magicalDamage;
			this.delay = stats.delay;
			this.autoAttack = stats.autoAttack;
		}

		public Builder strength(int strength) {
			this.strength = strength;
			return this;
		}

		public Builder dexterity(int dexterity) {
			this.dexterity = dexterity;
			return this;
		}

		public Builder vitality(int vitality) {
			this.vitality = vitality;
			return this;
		}

		public Builder intelligence(int intelligence) {
			this.intelligence = intelligence;
			return this;
		}

		public Builder mind(int mind) {
			this.mind = mind;
			return this;
		}

		public Builder crit(int crit) {
			this.crit = crit;
			return this;
		}

		public Builder determination(int determination) {
			this.determination = determination;
			return this;
		}

		public Builder directHit(int directHit) {
			this.directHit = directHit;
			return this;
		}

		public Builder skillSpeed(int skillSpeed) {
			this.skillSpeed = skillSpeed;
			return this;
		}

		public Builder spellSpeed(int spellSpeed) {
			this.spellSpeed = spellSpeed;
			return this;
		}

		public Builder tenacity(int tenacity) {
			this.tenacity = tenacity;
			return this;
		}

		public Builder piety(int piety) {
			this.piety = piety;
			return this;
		}

		public Builder physicalDamage(int physicalDamage) {
			this.physicalDamage = physicalDamage;
			return this;
		}

		public Builder magicalDamage(int magicalDamage) {
			this.magicalDamage = magicalDamage;
			return this;
		}

		public Builder delay(double delay) {
			this.delay = delay;
			return this;
		}

		public Builder autoAttack(int autoAttack) {
			this.autoAttack = autoAttack;
			return this;
		}

		public Stats build() {
			return new Stats(
				strength,
				dexterity,
				vitality,
				intelligence,
				mind,
				crit,
				determination,
				directHit,
				skillSpeed,
				spellSpeed,
				tenacity,
				piety,
				physicalDamage,
				magicalDamage,
				delay,
				autoAttack
			);
		}
	}


}
