package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import utilities.TestBaseBeforAfter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel extends TestBaseBeforAfter {
    @Test
    public void test1() throws IOException {
        // 1)Yeni bir Class olusturalim WriteExcel
        // 2) Yeni bir test method olusturalim writeExcelTest()
        // 3) Adimlari takip ederek 1.satira kadar gidelim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        // 4) 4.hucreye yeni bir cell olusturalim
        // 5) Olusturdugumuz hucreye “Nufus” yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        // 6) 2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1.500.000");
        // 7) 10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250.000");
        // 8) 15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("54.000");
        // 9)Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        // 10)Dosyayi kapatalim
        fos.close();
        fis.close();

        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i <sonSatir ; i++) {
            for (int j = 0; j <4 ; j++) {
                System.out.print(workbook.getSheet("Sayfa1").getRow(i).getCell(j)+",");
            }
            System.out.println("");
        }
    }
}
