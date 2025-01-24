package PagesObjectModels;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.UseableMethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SuccessFullyAppliedPage extends BecomeABusinessCustomerPage {
    private static final Logger logger= LoggerFactory.getLogger(SuccessFullyAppliedPage.class);

    @FindBy(xpath = "//*[contains(text(),'Teşekkürler, ön başvurunuz tarafımıza ulaşmıştır.')]")
    private WebElement successfully_message;
    @FindBy(xpath = "//a[@class='style_reference___1Gx7']")
    private WebElement reference_number;
    String baseUrl = "https://www.paytr.com/uye-isyeri-olun/basarili";

    public SuccessFullyAppliedPage(WebDriver driver) {
        super(driver);
    }

    public void seeSuccessAndSaveReferenceNumber() throws InterruptedException, IOException {
        Thread.sleep(5000);

        useableMethods.element_presenceInseconds(successfully_message);
        String basvuru_no = reference_number.getText();
        String reference_no = useableMethods.extractReferenceNumber(basvuru_no);
        System.out.println(reference_no);
        String datasPath = "C:\\Users\\EXCALIBUR\\IdeaProjects\\Pay_TR\\src\\test\\resources\\UserInformations\\Informations.xlsx";
        try (FileInputStream file = new FileInputStream(datasPath)) {
            Workbook companyInformations = WorkbookFactory.create(file);
            Sheet sheet = companyInformations.getSheetAt(0);
            Row row = sheet.getRow(1);

            Cell basvuruNumarasiCell = row.getCell(9);
            if (basvuruNumarasiCell != null) {
                basvuruNumarasiCell.setBlank();
            } else {
                basvuruNumarasiCell = row.createCell(9);
            }

            basvuruNumarasiCell.setCellValue(reference_no);
            try (FileOutputStream fileOutputStream = new FileOutputStream(datasPath)) {
                companyInformations.write(fileOutputStream);
            }
            companyInformations.close();
        }

logger.info(reference_no);
    }
}
