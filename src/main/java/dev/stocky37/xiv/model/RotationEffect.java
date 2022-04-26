package dev.stocky37.xiv.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.time.Duration;

public record RotationEffect(@JsonUnwrapped StatusEffect effect, Duration start, Duration end) {

}