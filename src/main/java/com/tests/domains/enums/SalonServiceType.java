package com.tests.domains.enums;

public enum SalonServiceType {
    SPA {
        @Override
        public String toString() {
            return "spas";
        }
    }
}
