package de.ait.ksdemo.dto;

import de.ait.ksdemo.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 05.11.2023
 * ks-demo
 *
 * @author Tatjana Dumler
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "User", description = "Angaben über den Benutzer")
public class UserDto  {
    @Schema(description = "Benutzer-ID", example = "1")
    private Long id;

    @Schema(description = "Vorname des Benutzers", example = "Marsel")
    private String firstName;

    @Schema(description = "Name des Schülers ", example = "Sidikov")
    private String lastName;

    @Schema(description = "Straße", example = "Dresdener Straße.1")
    private String street;
    @Schema(description = "Wohnort", example = "Berlin")
    private String city;
    @Schema(description = "Postleitzahl", example = "10115")
    private String postcode;
    @Schema(description = "Mobile", example = "0049 123456789")
    private String mobile;
    @Schema(description = "Telefon", example = "0049 123456789")
    private String phone;
    @Schema(description = "Email  ", example = "user@mail.com")
    private String email;

    @Schema(description = "Benutzer-Bezeichnung ", example = "Schüler")
    private String role;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
             .firstName(user.getFirstName())
             .lastName(user.getLastName())
             .street(user.getStreet())
             .city(user.getCity())
             .postcode(user.getPostcode())
             .mobile(user.getMobile())
             .phone(user.getPhone())
                .email(user.getEmail())
                .role(user.getRole().toString())
                .build();
    }
    public static List<UserDto> from(Collection<User> users) {
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
