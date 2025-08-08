package com.kshrd.jpa_hibernate_homework.model;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pagination {
    private Integer totalElements;
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalPages;
}
