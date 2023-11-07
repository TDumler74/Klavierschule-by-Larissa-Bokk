package de.ait.ksdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
public class UsersPage {

    private List<UserDto> users;

    private Integer totalPages;
}
