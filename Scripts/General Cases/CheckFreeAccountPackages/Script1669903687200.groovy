import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

//Get Selver values
Mobile.tap(findTestObject('Packages_UpdateAccount/SelverPackage'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Packages_UpdateAccount/3M_SelverValue'), 5, FailureHandling.STOP_ON_FAILURE)
def SliverPackage_3MValue = Mobile.getText(findTestObject('Packages_UpdateAccount/3M_SelverValue'), 5, FailureHandling.STOP_ON_FAILURE)
def SliverPackage_6MValue = Mobile.getText(findTestObject('Packages_UpdateAccount/6M_SelverValue'), 5, FailureHandling.STOP_ON_FAILURE)
def SliverPackage_12MValue = Mobile.getText(findTestObject('Packages_UpdateAccount/12M_SelverValue'), 5, FailureHandling.STOP_ON_FAILURE)

//Get Gold values
Mobile.tap(findTestObject('Packages_UpdateAccount/GoldPackages'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Packages_UpdateAccount/GoldCell'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Packages_UpdateAccount/3M_GoldValue'), 5, FailureHandling.STOP_ON_FAILURE)

def GoldPackage_3MValue = Mobile.getText(findTestObject('Packages_UpdateAccount/3M_GoldValue'), 5, FailureHandling.STOP_ON_FAILURE)
def GoldPackage_6MValue = Mobile.getText(findTestObject('Packages_UpdateAccount/6M_GoldValue'), 5, FailureHandling.STOP_ON_FAILURE)
def GoldPackage_12MValue = Mobile.getText(findTestObject('Packages_UpdateAccount/12M_GoldValue'), 5, FailureHandling.STOP_ON_FAILURE)

//Get Shop values
Mobile.tap(findTestObject('Packages_UpdateAccount/ShopPackages'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Packages_UpdateAccount/ShopCell'), 5, FailureHandling.STOP_ON_FAILURE)
def ShopPackage_3MValue = Mobile.getText(findTestObject('Packages_UpdateAccount/3M_ShopValue'), 5, FailureHandling.STOP_ON_FAILURE)
def ShopPackage_6MValue = Mobile.getText(findTestObject('Packages_UpdateAccount/6M_ShopValue'), 5, FailureHandling.STOP_ON_FAILURE)
def ShopPackage_12MValue = Mobile.getText(findTestObject('Packages_UpdateAccount/12M_ShopValue'), 5, FailureHandling.STOP_ON_FAILURE)


//Convert selver values to string
SliverPackage_3MValue=SliverPackage_3MValue.toString()
SliverPackage_6MValue=SliverPackage_6MValue.toString()
SliverPackage_12MValue=SliverPackage_12MValue.toString()

//Convert gold values to string
GoldPackage_3MValue=GoldPackage_3MValue.toString()
GoldPackage_6MValue=GoldPackage_6MValue.toString()
GoldPackage_12MValue=GoldPackage_12MValue.toString()

//Convert shop values to string
ShopPackage_3MValue=ShopPackage_3MValue.toString()
ShopPackage_6MValue=ShopPackage_6MValue.toString()
ShopPackage_12MValue=ShopPackage_12MValue.toString()




// Get Paid Ads from API
ActiveAdsValue = WS.sendRequest(findTestObject('GetUpdateAccountPackages_Free'))

def slurper = new JsonSlurper()
def result = slurper.parseText(ActiveAdsValue.getResponseBodyContent())

//Get Selver values API

def SliverPackage_3MValue_API = result.result.data[0].variations[0].countryUnitPrice
def SliverPackage_6MValue_API = result.result.data[0].variations[1].countryUnitPrice
def SliverPackage_12MValue_API = result.result.data[0].variations[2].countryUnitPrice

//Get Gold values API

def GoldPackage_3MValue_API = result.result.data[1].variations[0].countryUnitPrice
def GoldPackage_6MValue_API = result.result.data[1].variations[1].countryUnitPrice
def GoldPackage_12MValue_API = result.result.data[1].variations[2].countryUnitPrice

//Get Shop values API

def ShopPackage_3MValue_API = result.result.data[2].variations[0].countryUnitPrice
def ShopPackage_6MValue_API = result.result.data[2].variations[1].countryUnitPrice
def ShopPackage_12MValue_API = result.result.data[2].variations[2].countryUnitPrice

//Convert to string

//Selver
SliverPackage_3MValue_API=SliverPackage_3MValue_API.toString()
SliverPackage_6MValue_API=SliverPackage_6MValue_API.toString()
SliverPackage_12MValue_API=SliverPackage_12MValue_API.toString()


//Gold
GoldPackage_3MValue_API=GoldPackage_3MValue_API.toString()
GoldPackage_6MValue_API=GoldPackage_6MValue_API.toString()
GoldPackage_12MValue_API=GoldPackage_12MValue_API.toString()

//Shop
ShopPackage_3MValue_API=ShopPackage_3MValue_API.toString()
ShopPackage_6MValue_API=ShopPackage_6MValue_API.toString()
ShopPackage_12MValue_API=ShopPackage_12MValue_API.toString()

//Check value from Selver Apps == API value

if (SliverPackage_3MValue.contains(SliverPackage_3MValue_API)) {
	println((('Correct >> Value for selver 3 months ' + SliverPackage_3MValue) + ' Equal API value') + SliverPackage_3MValue_API)
} else {
	throw new Exception((('Not Correct >> Value for selver 3 months' + SliverPackage_3MValue) + ' Not equal') + SliverPackage_3MValue_API)
}


if (SliverPackage_6MValue.contains(SliverPackage_6MValue_API)) {
	println((('Correct >> Value for selver 6 months ' + SliverPackage_6MValue) + ' Equal API value') + SliverPackage_6MValue_API)
} else {
	throw new Exception((('Not Correct >> Value for selver 6 months' + SliverPackage_6MValue) + ' Not equal') + SliverPackage_6MValue_API)
}

if (SliverPackage_12MValue.contains(SliverPackage_12MValue_API)) {
	println((('Correct >> Value for selver 12 months ' + SliverPackage_12MValue) + ' Equal API value') + SliverPackage_12MValue_API)
} else {
	throw new Exception((('Not Correct >> Value for selver 12 months' + SliverPackage_12MValue) + ' Not equal') + SliverPackage_12MValue_API)
}

//Check value from Gold Apps == API value

if (GoldPackage_3MValue.contains(GoldPackage_3MValue_API)) {
	println((('Correct >> Value for Gold 3 months ' + GoldPackage_3MValue) + ' Equal API value') + GoldPackage_3MValue_API)
} else {
	throw new Exception((('Not Correct >> Value for Gold 3 months' + GoldPackage_3MValue) + ' Not equal') + GoldPackage_3MValue_API)
}


if (GoldPackage_6MValue.contains(GoldPackage_6MValue_API)) {
	println((('Correct >> Value for Gold 6 months ' + GoldPackage_6MValue) + ' Equal API value') + GoldPackage_6MValue_API)
} else {
	throw new Exception((('Not Correct >> Value for Gold 6 months' + GoldPackage_6MValue) + ' Not equal') + GoldPackage_6MValue_API)
}

if (GoldPackage_12MValue.contains(GoldPackage_12MValue_API)) {
	println((('Correct >> Value for Gold 12 months ' + GoldPackage_12MValue) + ' Equal API value') + GoldPackage_12MValue_API)
} else {
	throw new Exception((('Not Correct >> Value for Gold 12 months' + GoldPackage_12MValue) + ' Not equal') + GoldPackage_12MValue_API)
}

//Check value from Shop Apps == API value

if (ShopPackage_3MValue.contains(ShopPackage_3MValue_API)) {
	println((('Correct >> Value for Shop 3 months ' + ShopPackage_3MValue) + ' Equal API value') + ShopPackage_3MValue_API)
} else {
	throw new Exception((('Not Correct >> Value for Shop 3 months' + ShopPackage_3MValue) + ' Not equal') + ShopPackage_3MValue_API)
}


if (ShopPackage_6MValue.contains(ShopPackage_6MValue_API)) {
	println((('Correct >> Value for Shop 6 months ' + ShopPackage_6MValue) + ' Equal API value') + ShopPackage_6MValue_API)
} else {
	throw new Exception((('Not Correct >> Value for Shop 6 months' + ShopPackage_6MValue) + ' Not equal') + ShopPackage_6MValue_API)
}

if (ShopPackage_12MValue.contains(ShopPackage_12MValue_API)) {
	println((('Correct >> Value for Shop 12 months ' + ShopPackage_12MValue) + ' Equal API value') + ShopPackage_12MValue_API)
} else {
	throw new Exception((('Not Correct >> Value for Shop 12 months' + ShopPackage_12MValue) + ' Not equal') + ShopPackage_12MValue_API)
}

