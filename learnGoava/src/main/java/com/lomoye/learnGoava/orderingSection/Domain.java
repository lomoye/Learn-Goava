package com.lomoye.learnGoava.orderingSection;

import javafx.util.Builder;

/**
 * Created by lomoye on 2017/8/2.
 *
 */
public class Domain {
    private Long id;

    private Long level;

    private Domain(DomainBuilder builder) {
        this.id = builder.id;
        this.level = builder.level;
    }

    public Domain() {

    }



    public static class DomainBuilder implements Builder<Domain> {

        private Long id;

        private Long level;

        public DomainBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public DomainBuilder setLevel(Long level) {
            this.level = level;
            return this;
        }


        public Domain build() {
            return new Domain(this);
        }
    }


    public Long getId() {
        return id;
    }

    public Long getLevel() {
        return level;
    }
}
