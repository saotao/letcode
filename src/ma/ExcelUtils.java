package ma;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static org.apache.poi.ss.usermodel.CellType.STRING;
import static org.apache.poi.ss.usermodel.CellType._NONE;


/**
 * 从EXCEL导入到数据库
 * 创建人：FH Q313596790
 * 创建时间：2014年12月23日
 */
public class ExcelUtils {

    /**
     * @param filepath //文件路径
     * @param startrow //开始行号
     * @param startcol //开始列号
     * @param sheetnum //sheet
     * @return list
     */
    public static List<Map<String, String>> readExcel(String filepath, int startrow, int startcol, int sheetnum) throws IOException {
        List<Map<String, String>> varList = new ArrayList<>();

        Workbook wb = getWorkbook(filepath);
        //sheet 从0开始
        Sheet sheet = wb.getSheetAt(sheetnum);
        int rowNum = sheet.getPhysicalNumberOfRows();

        //行循环开始
        for (int i = startrow; i < rowNum; i++) {
            Map<String, String> data = new HashMap<>(rowNum);
            //行
            Row row = sheet.getRow(i);
            //列循环开始
            for (int j = startcol; j < row.getPhysicalNumberOfCells(); j++) {
                Cell cell = row.getCell(j);
                String cellValue = null;
                if (null != cell) {
                    // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            //强转成字符串
                            cellValue = String.valueOf(cell.getNumericCellValue());
                            break;
                        case STRING:
                            cellValue = cell.getStringCellValue();
                            break;
                        case FORMULA:
                            cellValue = NumberToTextConverter.toText(cell.getNumericCellValue());
                            break;
                        case BLANK:
                            cellValue = "";
                            break;
                        case BOOLEAN:
                            cellValue = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case ERROR:
                            cellValue = String.valueOf(cell.getErrorCellValue());
                            break;
                        default:
                            break;
                    }
                } else {
                    cellValue = "";
                }

                data.put("var" + j, cellValue);

            }
            varList.add(data);
        }

        return varList;
    }

    /**
     * xls/xlsx都使用的Workbook
     *
     * @param fileName
     * @return
     * @author 吕小布  2018年10月26日
     */
    public static Workbook getWorkbook(String fileName) throws IOException {
        Workbook wb = null;
        if (fileName == null) {
            return null;
        }
        String extString = fileName.substring(fileName.lastIndexOf("."));
        InputStream is = null;
        is = new FileInputStream(fileName);
        if (".xls".equals(extString)) {
            wb = new HSSFWorkbook(is);
        } else if (".xlsx".equals(extString)) {
            wb = new XSSFWorkbook(is);
        }
        return wb;
    }

    public static void main(String[] args) {
        String path = "/Users/shentao/letcode/src/ma/不上架车源盘点原因排序.xlsx";
        try {
            List<Map<String, String>> maps = readExcel(path,0, 0, 0);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

