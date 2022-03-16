package pl.clockworkjava.gnomix.controllers.dto;

import java.util.List;

public record UpdateRoomDTO(long id, String number, String bedsDesc, String description, List<String> photosUrls) {
}
