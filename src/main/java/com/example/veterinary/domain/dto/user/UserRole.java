package com.example.veterinary.domain.dto.user;

public enum UserRole {
    ADMIN,
    MEDICAL_STAFF,
    DOCTOR,
    RECEPTIONIST,
    CLIENT;

    public String getAuthority(){
        return "ROLE_" + this.toString();
    }

    public String getRole(){
        return this.toString();
    }
}
