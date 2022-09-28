package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fis)
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        // Exceldeki tüm tabloyu yazdirin
        /*for (int i = 0; i <= sonSatir; i++) {
                System.out.println(
                          workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString() + ","
                        + workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ","
                        + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ","
                        + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString());
        }*/
        for (int i = 0; i <sonSatir ; i++) {
            for (int j = 0; j <4 ; j++) {
                System.out.print(workbook.getSheet("Sayfa1").getRow(i).getCell(j)+", ");
            }
            System.out.println("");
        }
    }
}
