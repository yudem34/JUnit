package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {
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
        //int sonSutun=workbook.getSheet("Sayfa2").
        //-sayfa 2'ye gidip satir sayisinin 6, kullanilan sutun sayisinin ise 3 oldugunu test edin
        int sonSatirIndex=workbook.getSheet("Sayfa2").getLastRowNum();
        System.out.println("Son Satir Sayisi : "+(sonSatirIndex+1));
        int expectedSatirSayisi=6;
        Assert.assertEquals(expectedSatirSayisi,sonSatirIndex+1);
        int kullanılanSatirSayisi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        System.out.println("Kullanilan Satir Sayisi : "+kullanılanSatirSayisi);
        int expectedKullanilanSatirSayisi=3;
        Assert.assertEquals(expectedKullanilanSatirSayisi,kullanılanSatirSayisi);




    }
}
