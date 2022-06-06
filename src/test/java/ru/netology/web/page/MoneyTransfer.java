package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataHelper;
import static com.codeborne.selenide.Selenide.$;

public class MoneyTransfer {
    private SelenideElement amount = $("[type='text']");
    private SelenideElement from = $("[data-test-id='from'] input");
    private SelenideElement buttonTransfer = $("[data-test-id='action-transfer']");
    private SelenideElement buttonCancel = $("[data-test-id='action-cancel']");

    public MoneyTransfer() {
    }

    public DashboardPage transferMoney(int amountTransfer, DataHelper.CardInfo cardInfo) {
        from.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        amount.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        amount.setValue(String.valueOf(amountTransfer));
        from.setValue(cardInfo.getNumber());
        buttonTransfer.click();
        return new DashboardPage();
    }
}
