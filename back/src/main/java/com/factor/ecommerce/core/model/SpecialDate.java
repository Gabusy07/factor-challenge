package com.factor.ecommerce.core.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "special_date")
public class SpecialDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    private SpecialDate() {}

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public static class Builder {
        private Integer id;
        private LocalDate date;

        public Builder() {}

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public SpecialDate build() {
            SpecialDate specialDate = new SpecialDate();
            specialDate.id = this.id;
            specialDate.date = this.date;
            return specialDate;
        }
    }

}
