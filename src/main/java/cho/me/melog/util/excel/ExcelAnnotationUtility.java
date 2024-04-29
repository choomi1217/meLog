package cho.me.melog.util.excel;

import cho.me.melog.annotation.ExcelColumn;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ExcelAnnotationUtility {

    public List<String> getHeaderName(Class<?> type) {
        List<String> excelHeaderNameList = Arrays.stream(type.getDeclaredFields())
                .filter(s -> s.isAnnotationPresent(ExcelColumn.class))
                .map(s -> s.getAnnotation(ExcelColumn.class).headerName())
                .collect(Collectors.toCollection(LinkedList::new));

        if (CollectionUtils.isEmpty(excelHeaderNameList)) {
            throw new IllegalStateException("ExcelColumn annotation is not found.");
        }

        return excelHeaderNameList;
    }

    public Class<?> getClass(String excelName) {
        try {
            return Class.forName(excelName);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Class Not Found Exception");
        }
    }
}
