package cho.me.melog.excel.dto;

import cho.me.melog.excel.repository.domain.Excel;

public class ExcelDto {
    private Long id;
    private String title;

    public ExcelDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public ExcelDto(Excel excel) {
        this.id = excel.getId();
        this.title = excel.getTitle();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
