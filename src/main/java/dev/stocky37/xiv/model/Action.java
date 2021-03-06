package dev.stocky37.xiv.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import dev.stocky37.xiv.api.json.Views;
import dev.stocky37.xiv.util.Util;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface Action {
	@JsonProperty
	@JsonView(Views.Limited.class)
	Type actionType();

	@JsonView(Views.Standard.class)
	Boolean onGCD();

	@JsonFormat(pattern = "MILLIS")
	@JsonView({Views.Standard.class, Views.Rotation.class})
	default Duration cast() {
		return Duration.ZERO;
	}

	@JsonFormat(pattern = "MILLIS")
	@JsonView(Views.Standard.class)
	default Duration recast() {
		return Duration.ZERO;
	}

	@JsonView(Views.Standard.class)
	default List<Status> statusEffects() {
		return Collections.emptyList();
	}

	@JsonProperty
	@JsonView(Views.Rotation.class)
	default Optional<Duration> animationLock() {
		return Optional.empty();
	}

	@JsonProperty
	@JsonView(Views.Standard.class)
	default Set<String> cooldownGroups() {
		return Collections.emptySet();
	}

	@JsonProperty
	@JsonView(Views.Standard.class)
	Integer potency();

	enum Type {
		ABILITY, ITEM, DELAY;

		@Override
		public String toString() {
			return Util.slugify(name());
		}
	}
}
