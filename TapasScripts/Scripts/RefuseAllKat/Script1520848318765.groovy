import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//This call selects the first option when clicking on the Mandant selector, its result will change based on which Mandants are unlocked for the User!!!
//currently for User "bot": 0 = Experteer; 1 = Jobware
WebUI.selectOptionByValue(findTestObject('Page_TapasHome/select_Mandant'), '0', false)

WebUI.mouseOver(findTestObject('Page_TapasHome/span_Produktion (Solr)'))

WebUI.click(findTestObject('Page_TapasHome/DropDown_ProduktionSOLR/span_Kategorisierung'))
//WebUI.verifyElementPresent(findTestObject('Page_KatSOLR/span_FirstEntry'), 10)
while (temp) {
	try {
		WebUI.verifyElementPresent(findTestObject('Page_KatSOLR/td_AreaAroundFirstEntry'), 10)
		WebUI.clickOffset(findTestObject('Page_KatSOLR/td_AreaAroundFirstEntry'), 15, 20)
		WebUI.delay(1)
		WebUI.click(findTestObject('Page_KatSOLR/EntrySelected/input_bearbeiten'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Page_ObjektKategorisierenSOLR/Buttons_Basic/button_Zurckweisen'))
		//1 = Edi; 0 = Dispo
		WebUI.selectOptionByValue(findTestObject("Page_ObjektKategorisierenSOLR/Page_VorgangZurueckweisen/select_Postfach"), '1', false)

		WebUI.setText(findTestObject('Page_ObjektKategorisierenSOLR/Page_VorgangZurueckweisen/textarea_text'), 'Automated Process')

		WebUI.click(findTestObject('Page_ObjektKategorisierenSOLR/Page_VorgangZurueckweisen/button_OK'))
	} catch (Exception e) {
		temp=false;
	}
}

