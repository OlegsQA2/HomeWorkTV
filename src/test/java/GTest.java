import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GTest {

    OpenPage openPage = new OpenPage();

    private final String HOME_PAGE = "rus.delfi.lv";
    private final String CONTENT ="Отчаянные домохозяйки";

    @Test
    public void checkArticleTitle() throws InterruptedException {
        openPage.openPage(HOME_PAGE);
        String href = null;
        WebElement tvPrograma = openPage.getElement(By.xpath(".//a[@title = 'ТВ программа']"));
        href = tvPrograma.getAttribute("href");
        tvPrograma.click();
        System.out.println(href);

        List<WebElement> daysMenu = openPage.getElements(By.xpath("//ul[@class = 'menu days-menu']/li"));
        List<String> dates = new ArrayList<String>();
        for(WebElement li : daysMenu) {
            dates.add(li.findElement(By.xpath(".//a")).getAttribute("data-date"));
        }

        for(String date : dates){
            if(date != null) {
                System.out.println(date);
                openPage.openPage(href + "#/guide/" + date);
                Assert.assertTrue(checkContentExist());
            }

        }
        openPage.close();
    }

    private boolean checkContentExist() throws InterruptedException {
        System.out.println("//*[text()='"+ CONTENT +"']/..");
        WebElement content = openPage.getElement(By.xpath("//*[text()='"+ CONTENT +"']/.."));
        if(content == null){
            return false;
        } else return true;
    }

}


