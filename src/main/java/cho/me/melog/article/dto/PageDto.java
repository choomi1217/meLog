package cho.me.melog.article.dto;

import org.springframework.data.domain.Page;

import java.util.Collection;

public record PageDto<T>(
        int page, //currentPage
        int size, //pagePerCount
        long totalElements, //totalCount
        int totalPages, //totalPage
        Collection<T> content
) {
    public static <T> PageDto<T> fromPage(Page<T> page) {
        return new PageDto<>(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.getContent()
        );
    }

}
