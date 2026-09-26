package com.example.websiteDemoBackend.eventsApi.infraestructure.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_type_id", nullable = false)
    private EventTypeEntity eventType;

    @Column(name = "event_code", nullable = false, unique = true)
    private String eventCode;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private LocalDateTime registrationStartDate;
    private LocalDateTime registrationEndDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Integer maxParticipants;

    private String requirements;

    @Column(name = "requires_payment")
    private Boolean requiresPayment;

    private BigDecimal price;

    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
    private WorkshopEntity workshop;

    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
    private BookClubEntity bookClubEntity;

    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
    private BookReadingEntity bookReadingEntity;
}
