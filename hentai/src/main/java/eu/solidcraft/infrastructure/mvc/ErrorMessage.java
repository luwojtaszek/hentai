package eu.solidcraft.infrastructure.mvc;

import lombok.Value;

@Value
public class ErrorMessage {
    private String message;
    private String details;

    public ErrorMessage(String message) {
        this.message = message;
        this.details = null;
    }
}
