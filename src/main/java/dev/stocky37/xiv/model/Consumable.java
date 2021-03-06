package dev.stocky37.xiv.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import java.time.Duration;
import java.util.List;

public record Consumable(
	//  ApiObject
	String id,
	String name,
	URI icon,
	URI hdIcon,

	// Action
	Duration recast,
	List<Status> statusEffects

	// Ability
) implements Action, Item {

	public record Bonus(Attribute attribute, int value, int max) {
	}

	@Override
	public Kind kind() {
		return Kind.CONSUMABLE;
	}

	@JsonProperty
	public Boolean onGCD() {
		return false;
	}

	@Override
	public Duration cast() {
		return Duration.ZERO;
	}

	@Override
	public Type actionType() {
		return Type.ITEM;
	}

	@Override
	public Integer potency() {
		return 0;
	}
}
