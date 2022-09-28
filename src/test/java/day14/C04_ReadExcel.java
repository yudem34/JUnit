package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fis)
        Workbook workbook = WorkbookFactory.create(fis);
        //- Sheet objesi olusturun workbook.getSheetAt(index) ve getSheet("SayfaAdı")
        //- Row objesi olusturun sheet.getRow(index)
        //- Cell objesi olusturun row.getCell(index)
        //-Turkce baskentler sutununu yazdiralim
        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i <=sonSatir ; i++) {
            System.out.println(workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString());
        }
    }
}
