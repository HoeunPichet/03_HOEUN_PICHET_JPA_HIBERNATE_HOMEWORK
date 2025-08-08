package com.kshrd.jpa_hibernate_homework.model;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pagination {
    private Long totalElements;
    private Long currentPage;
    private Long pageSize;
    private Long totalPages;
}
