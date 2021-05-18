package com.example.veterinary.domain.dto.user;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class UserStaffDto extends StaffDto {
    private String email;
    private UserRole userRole;

    public UserStaffDto(UUID id, String name, String surname, String position, String experience,
                        String email, UserRole userRole) {
        super(id, name, surname, position, experience);
        this.email = email;
        this.userRole = userRole;
    }
}
