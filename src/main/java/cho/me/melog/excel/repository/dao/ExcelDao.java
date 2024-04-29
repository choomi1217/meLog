package cho.me.melog.excel.repository.dao;

import cho.me.melog.excel.repository.domain.Excel;
import cho.me.melog.excel.repository.domain.ExcelRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExcelDao {
    private final ExcelRepository excelRepository;

    public ExcelDao(ExcelRepository excelRepository) {
        this.excelRepository = excelRepository;
    }

    public List<Excel> findAllExcel() {
        return excelRepository.findAll();
    }

    public Excel findById(Long id) {
        return excelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당하는 엑셀 파일이 없습니다."));
    }
}
