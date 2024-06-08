package POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dnt.douglas.util.WebActionUtil;

public class Login_Page {
	public WebDriver driver;
	public WebActionUtil actionUtil;
	public long ETO;

	public Login_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* Cookie button */
	@FindBy(xpath = "//button[@type='button' and @class='button button__primary uc-list-button__accept-all']")
	private WebElement btnCookie;

	/* Perfume link */
	@FindBy(xpath = "//li[@data-uid='FragrancesNavNode_DE']")
	private WebElement lnkPerfume;

	/* Headline text */
	@FindBy(xpath = "//h1[@class='headline-bold product-overview__headline']")
	private WebElement txtHeadLine;

	/* Drop down values */
	@FindBy(xpath = "//div[@class='facet-wrapper col-sm-12 col-lg-3']")
	private List<WebElement> list_all_dropdown;

	/* Drop Down value list */
	@FindBy(xpath = "//div[@class='facet-option__checkbox--rating-stars']")
	private List<WebElement> dropdown_options_ele_list;

	/* cart button */
	@FindBy(xpath = "//button[@class=\"button button__primary facet__close-button\"]")
	private WebElement btnCart;

	/* Sale Product list */
	@FindBy(xpath = "//div[@class='product-tile product-tile--is-pop-tile']//div[text()='Sale']")
	private List<WebElement> filter_product_list;

	/* Next page arrow icon */
	@FindBy(xpath = "//a[@data-testid='pagination-arrow-right']")
	private WebElement icnNextPageArrow;

	public synchronized void clkOnCookieButton() {
		try {
			actionUtil.waitForElement(btnCookie, "cookie button");
			actionUtil.scrollToElement(btnCookie, "cookie button");
			actionUtil.clickOnElement(btnCookie, "cookie button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click on cookie button");
			Assert.fail("Unable to click on cookie button");
		}
	}

	public synchronized void clkOnPerfumeLink() {
		try {
			WebActionUtil.poll(2000);
			actionUtil.clickOnElement(lnkPerfume, "Perfume icon");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click  on Perfume icon");
			Assert.fail("Unable to click  on Perfume icon");
		}
	}

	public synchronized void scrollToHeadline() {
		try {
			actionUtil.scrollToElement(txtHeadLine, "HeadLine text");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to scroll to HeadLine text");
			Assert.fail("Unable to scroll to HeadLine text");
		}
	}

	public synchronized void selectDDValue(String drop_down_name) {
		try {

			List<String> dropdown_option_list = new ArrayList<>();
			for (int i = 0; i < list_all_dropdown.size(); i++) {
				System.out.println(list_all_dropdown.get(i).getText());
				dropdown_option_list.add(list_all_dropdown.get(i).getText());
			}

			System.out.println(dropdown_option_list);

			for (int i = 0; i < dropdown_option_list.size(); i++) {
				System.out.println(drop_down_name.toLowerCase().strip() + " = "
						+ dropdown_option_list.get(i).toLowerCase().strip());
				if (drop_down_name.toLowerCase().strip()
						.equalsIgnoreCase(dropdown_option_list.get(i).toLowerCase().strip())) {
					actionUtil.clickOnElement(list_all_dropdown.get(i), "");
				}
			}
			String dropdown_select = "Sale";
			List<String> dropdown_option_list1 = new ArrayList<>();
			for (int i = 0; i < dropdown_options_ele_list.size(); i++) {
				actionUtil.waitForVisibilityOfElement(dropdown_options_ele_list.get(i), "");
				System.out.println(dropdown_option_list1.add(dropdown_options_ele_list.get(i).getText()));
			}

			System.out.println("dropdown_option_list >>> " + dropdown_option_list1);

			for (int i = 0; i < dropdown_option_list1.size(); i++) {
				if (dropdown_option_list1.get(i).equalsIgnoreCase(dropdown_select)) {
					actionUtil.waitForElement(dropdown_options_ele_list.get(i), "");
					actionUtil.clickOnElement(dropdown_options_ele_list.get(i), "");
				}
			}
			WebActionUtil.poll(4000);
			int filter_product_act_number = Integer.parseInt(actionUtil.getText(btnCart, "").split(" ")[0]);
			WebActionUtil.poll(4000);
			actionUtil.clickOnElement(btnCart, "click on element");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to click  on cart  button");
			Assert.fail("Unable to click  on cart  button");
		}
	}

	public synchronized void validateProductCount() {
		try {
			filter_product_list.size();
			Assert.assertEquals(filter_product_list.size(), 45);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.fail("Unable to validate Related story section text");
			Assert.fail("Unable to validate Related story section text");
		}
	}
}