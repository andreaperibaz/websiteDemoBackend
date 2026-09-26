package com.example.websiteDemoBackend.eventsApi.infraestructure;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.websiteDemoBackend.eventsApi.domain.model.BookClub;
import com.example.websiteDemoBackend.eventsApi.domain.model.BookReading;
import com.example.websiteDemoBackend.eventsApi.domain.model.Event;
import com.example.websiteDemoBackend.eventsApi.domain.model.Workshop;
import com.example.websiteDemoBackend.eventsApi.infraestructure.entities.BookClubEntity;
import com.example.websiteDemoBackend.eventsApi.infraestructure.entities.BookReadingEntity;
import com.example.websiteDemoBackend.eventsApi.infraestructure.entities.EventEntity;
import com.example.websiteDemoBackend.eventsApi.infraestructure.entities.WorkshopEntity;

@Mapper(componentModel = "spring")
public interface EventsEntityMapper {

    @Mapping(target = "eventTypeCode", source = "eventCode")
    Event toEvent(EventEntity eventEntity);

    List<Event> toEventList(List<EventEntity> eventEntities);

    EventEntity toEventEntity(Event event);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "eventCode", source = "event.eventCode")
    @Mapping(target = "name", source = "event.name")
    @Mapping(target = "description", source = "event.description")
    @Mapping(target = "registrationStartDate", source = "event.registrationStartDate")
    @Mapping(target = "registrationEndDate", source = "event.registrationEndDate")
    @Mapping(target = "startDate", source = "event.startDate")
    @Mapping(target = "endDate", source = "event.endDate")
    @Mapping(target = "maxParticipants", source = "event.maxParticipants")
    @Mapping(target = "requirements", source = "event.requirements")
    @Mapping(target = "requiresPayment", source = "event.requiresPayment")
    @Mapping(target = "price", source = "event.price")
    @Mapping(target = "materials", source = "materials")
    @Mapping(target = "eventType", source = "event.eventType")
    @Mapping(target = "eventTypeCode", source = "event.eventType.code")
    Workshop toWorkshop(WorkshopEntity workshopEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "eventCode", source = "event.eventCode")
    @Mapping(target = "name", source = "event.name")
    @Mapping(target = "description", source = "event.description")
    @Mapping(target = "registrationStartDate", source = "event.registrationStartDate")
    @Mapping(target = "registrationEndDate", source = "event.registrationEndDate")
    @Mapping(target = "startDate", source = "event.startDate")
    @Mapping(target = "endDate", source = "event.endDate")
    @Mapping(target = "maxParticipants", source = "event.maxParticipants")
    @Mapping(target = "requirements", source = "event.requirements")
    @Mapping(target = "requiresPayment", source = "event.requiresPayment")
    @Mapping(target = "price", source = "event.price")
    @Mapping(target = "selectedBook", source = "selectedBook")
    @Mapping(target = "eventType", source = "event.eventType")
    @Mapping(target = "eventTypeCode", source = "event.eventType.code")
    BookClub toBookClub(BookClubEntity bookClubEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "eventCode", source = "event.eventCode")
    @Mapping(target = "name", source = "event.name")
    @Mapping(target = "description", source = "event.description")
    @Mapping(target = "registrationStartDate", source = "event.registrationStartDate")
    @Mapping(target = "registrationEndDate", source = "event.registrationEndDate")
    @Mapping(target = "startDate", source = "event.startDate")
    @Mapping(target = "endDate", source = "event.endDate")
    @Mapping(target = "maxParticipants", source = "event.maxParticipants")
    @Mapping(target = "requirements", source = "event.requirements")
    @Mapping(target = "requiresPayment", source = "event.requiresPayment")
    @Mapping(target = "price", source = "event.price")
    @Mapping(target = "guestAuthor", source = "guestAuthor")
    @Mapping(target = "eventType", source = "event.eventType")
    @Mapping(target = "eventTypeCode", source = "event.eventType.code")
    BookReading toBookReading(BookReadingEntity bookReadingEntity);

    List<Workshop> toWorkshopList(List<WorkshopEntity> workshopEntitiesList);

    @Mapping(target = "event.id", source = "id")
    @Mapping(target = "event.eventCode", source = "eventCode")
    @Mapping(target = "event.name", source = "name")
    @Mapping(target = "event.description", source = "description")
    @Mapping(target = "event.registrationStartDate", source = "registrationStartDate")
    @Mapping(target = "event.registrationEndDate", source = "registrationEndDate")
    @Mapping(target = "event.startDate", source = "startDate")
    @Mapping(target = "event.endDate", source = "endDate")
    @Mapping(target = "event.maxParticipants", source = "maxParticipants")
    @Mapping(target = "event.requirements", source = "requirements")
    @Mapping(target = "event.requiresPayment", source = "requiresPayment")
    @Mapping(target = "event.price", source = "price")
    @Mapping(target = "materials", source = "materials")
    @Mapping(target = "event.eventType", source = "eventType")
    WorkshopEntity toWorkshopEntity(Workshop workshop);

    default OffsetDateTime map(LocalDateTime value) {
        return value != null ? value.atOffset(ZoneOffset.UTC) : null;
    }

    default LocalDateTime map(OffsetDateTime value) {
        return value != null ? value.toLocalDateTime() : null;
    }

    default List<String> map(String value) {
        if (value == null || value.isBlank())
            return List.of();
        return Arrays.asList(value.split(","));
    }

    default String map(List<String> list) {
        if (list == null || list.isEmpty())
            return null;
        return String.join(",", list);
    }
}
