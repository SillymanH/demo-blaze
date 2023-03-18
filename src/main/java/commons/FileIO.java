package commons;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.*;

public class FileIO {

    private static final String dataFilePath = System.getProperty("user.dir") + "/src/main/resources/Data.xlsx";
    private static XSSFSheet sheet;

    public static void loadExcel() throws Exception {

        File file = new File(dataFilePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheetAt(0);
        fileInputStream.close();
    }

    public static Map<String, String> getDataMap() throws Exception {

        if (sheet == null)
            loadExcel();

        Map<String, String> dataMap = new HashMap<>();
        for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
            XSSFRow row = sheet.getRow(i);
            String key = row.getCell(0).getStringCellValue();
            if (key.equals("KEY") || key.isEmpty() || StringUtils.containsWhitespace(key))
                continue;

            int columnNumber = row.getLastCellNum();
            for (int j = 1; j < columnNumber; j++) {
                String value = row.getCell(j).getStringCellValue();
                dataMap.put(key, value);
            }
        }
        return dataMap;
    }

    public static String getData(String key) throws Exception {
        if (getDataMap().get(key) == null)
            throw new Exception("Could not find key " + key);

        return getDataMap().get(key);
    }
}
