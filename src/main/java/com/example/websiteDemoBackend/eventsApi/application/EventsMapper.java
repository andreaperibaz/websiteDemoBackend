package com.example.websiteDemoBackend.eventsApi.application;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.openapi.eventsapi.model.BookClubDto;
import com.example.openapi.eventsapi.model.BookReadingDto;
import com.example.openapi.eventsapi.model.EventDto;
import com.example.openapi.eventsapi.model.WorkshopDto;
import com.example.websiteDemoBackend.eventsApi.domain.model.BookClub;
import com.example.websiteDemoBackend.eventsApi.domain.model.BookReading;
import com.example.websiteDemoBackend.eventsApi.domain.model.Event;
import com.example.websiteDemoBackend.eventsApi.domain.model.EventType;
import com.example.websiteDemoBackend.eventsApi.domain.model.Workshop;

@Mapper(componentModel = "spring")
public interface EventsMapper {

    @Mapping(target = "eventType", source = "eventType")
    @Mapping(target = "availableSpots", ignore = true)
    WorkshopDto toWorkshopDto(Workshop workshop);

    @Mapping(target = "eventType", source = "eventType")
    @Mapping(target = "availableSpots", ignore = true)
    BookClubDto toBookClubDto(BookClub bookClub);

    @Mapping(target = "eventType", source = "eventType")
    @Mapping(target = "availableSpots", ignore = true)
    BookReadingDto toBookReadingDto(BookReading bookReading);

    List<WorkshopDto> toWorkshopDtoList(List<Workshop> workshops);

    @Mapping(target = "eventType", source = "eventType")
    @Mapping(target = "availableSpots", ignore = true)
    EventDto toEventDto(Event event);

    List<EventDto> toEventDtoList(List<Event> events);

    default BookClubDto.EventTypeEnum mapBookClub(EventType eventType) {
        if (eventType == null)
            return null;
        return BookClubDto.EventTypeEnum.valueOf(eventType.getCode().toUpperCase());
    }

    default BookReadingDto.EventTypeEnum mapBookReading(EventType eventType) {
        if (eventType == null)
            return null;
        return BookReadingDto.EventTypeEnum.valueOf(eventType.getCode().toUpperCase());
    }

    default WorkshopDto.EventTypeEnum mapWorkshop(EventType eventType) {
        if (eventType == null)
            return null;
        return WorkshopDto.EventTypeEnum.valueOf(eventType.getCode().toUpperCase());
    }

    default EventDto.EventTypeEnum mapEventType(EventType eventType) {
        if (eventType == null)
            return null;
        return EventDto.EventTypeEnum.valueOf(eventType.getCode().toUpperCase());
    }

    default List<String> map(String value) {
        if (value == null || value.isBlank())
            return Collections.emptyList();
        return Arrays.stream(value.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    default String map(List<String> value) {
        if (value == null || value.isEmpty())
            return null;
        return String.join(",", value);
    }

    default OffsetDateTime map(LocalDateTime value) {
        return value != null ? value.atOffset(ZoneOffset.UTC) : null;
    }

    default LocalDateTime map(OffsetDateTime value) {
        return value != null ? value.toLocalDateTime() : null;
    }
}
