package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforAfter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class C06_Odev2 extends TestBaseBeforAfter {
    @Test
    public void test1() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        // 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString());
        // 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String actualData = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(actualData);
        // 2.satir 4.cell'in afganistan'in baskenti oldugunu test edelim
        Assert.assertEquals("Kabil", workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString());
        // Satir sayisini bulalim
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum() + 1;
        System.out.println("Satir Sayisi : " + sonSatir);
        // Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("Fiziki olarak kullanilan satir sayisi : " + (workbook.getSheet("Sayfa1")).getPhysicalNumberOfRows());
        // Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String, String> mapList = new LinkedHashMap<>();
        Sheet sheet = workbook.getSheet("Sayfa1");
        int rowCount = sheet.getLastRowNum();
        for (int i = 0; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            Cell keyCell = row.getCell(0);
            String key = keyCell.getStringCellValue();
            Cell valuCell = row.getCell(1);
            String value = valuCell.getStringCellValue();
            mapList.put(key, value);
        }
        //alt alta yazdirmak icin
        Set<Map.Entry<String, String>> entryList = mapList.entrySet();
        entryList.forEach(System.out::println);
    }
}
