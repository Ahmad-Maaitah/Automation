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
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

// Make sure the returned value from API = Returned value in my account details
Mobile.callTestCase(findTestCase('Login/MyAccount_Login'), [:], FailureHandling.STOP_ON_FAILURE)
Thread.sleep(10)

Mobile.tap(findTestObject('AcountDetails/AccountDetails_Button'), 5, FailureHandling.STOP_ON_FAILURE)

def AdsLimitText = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/LimitOfAds_Text'), 5, FailureHandling.STOP_ON_FAILURE)

if (AdsLimitText.contains('الحد للإعلانات الفعالة')) {
    println('')
} else {
    throw new Exception('Text of ads limit not exist')
}

def AutosCategory_Limit = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/AutosLimit_Value'), 5, FailureHandling.STOP_ON_FAILURE)

def MotorcycleCategory_Limit = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/Motorcycle_Limit'), 5, FailureHandling.STOP_ON_FAILURE)

def MobileTabletCategory_Limit = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/Mobile_Limit'), 5, FailureHandling.STOP_ON_FAILURE)

def GamingCategory_Limit = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/Games_Limit'), 5, FailureHandling.STOP_ON_FAILURE)

def LaptopCategory_Limit = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/Laptop_Limit'), 5, FailureHandling.STOP_ON_FAILURE)

Mobile.scrollToText('الكترونيات')

def ElectronicsCategory_Limit = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/Electronics_Limit'), 5, FailureHandling.STOP_ON_FAILURE)

def REForSaleCategory_Limit = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/REForSale_Limit'), 5, FailureHandling.STOP_ON_FAILURE)

Mobile.scrollToText('المنزل')

def REForRentCategory_Limit = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/REForRent_Limit'), 5, FailureHandling.STOP_ON_FAILURE)

def HomeGardenCategory_Limit = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/Home_Limit'), 5, FailureHandling.STOP_ON_FAILURE)

def WomenFashionCategory_Limit = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/WomenFashion_Limit'), 5, 
    FailureHandling.STOP_ON_FAILURE)

def MenFashionCategory_Limit = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/MenFashion_Limit'), 5, FailureHandling.STOP_ON_FAILURE)

def BabyKidsCategory_Limit = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/BabyKids_Limit'), 5, FailureHandling.STOP_ON_FAILURE)

def FoodCategory_Limit = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/Food_Limit'), 5, FailureHandling.STOP_ON_FAILURE)

def EducationCategory_Limit = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/Education_Limit'), 5, FailureHandling.STOP_ON_FAILURE)

def ServicesCategory_Limit = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/Services_Limit'), 5, FailureHandling.STOP_ON_FAILURE)

def JobsCategory_Limit = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/Jobs_Limit'), 5, FailureHandling.STOP_ON_FAILURE)

def PetsCategory_Limit = Mobile.getText(findTestObject('AccountDetails_CategoriesLimit/Pets_Limit'), 5, FailureHandling.STOP_ON_FAILURE)

//Convert values from My accout to string 
AutosCategory_Limit = AutosCategory_Limit.toString()

MotorcycleCategory_Limit = MotorcycleCategory_Limit.toString()

MobileTabletCategory_Limit = MobileTabletCategory_Limit.toString()

GamingCategory_Limit = GamingCategory_Limit.toString()

LaptopCategory_Limit = LaptopCategory_Limit.toString()

ElectronicsCategory_Limit = ElectronicsCategory_Limit.toString()

REForSaleCategory_Limit = REForSaleCategory_Limit.toString()

REForRentCategory_Limit = REForRentCategory_Limit.toString()

HomeGardenCategory_Limit = HomeGardenCategory_Limit.toString()

WomenFashionCategory_Limit = WomenFashionCategory_Limit.toString()

MenFashionCategory_Limit = MenFashionCategory_Limit.toString()

BabyKidsCategory_Limit = BabyKidsCategory_Limit.toString()

FoodCategory_Limit = FoodCategory_Limit.toString()

EducationCategory_Limit = EducationCategory_Limit.toString()

ServicesCategory_Limit = ServicesCategory_Limit.toString()

JobsCategory_Limit = JobsCategory_Limit.toString()

PetsCategory_Limit = PetsCategory_Limit.toString()

// Get Paid Ads from API
Thread.sleep(200)

ActiveAdsValue = WS.sendRequest(findTestObject('GetCategoriesLimit_FreeAccount'))

def slurper = new JsonSlurper()

def result = slurper.parseText(ActiveAdsValue.getResponseBodyContent())

//Get values from API
def API_AutosLimit = result.result.data.items[0].posts_limit

def API_MotorcycleLimit = result.result.data.items[1].posts_limit

def API_MobileTabletleLimit = result.result.data.items[2].posts_limit

def API_GamingleLimit = result.result.data.items[3].posts_limit

def API_LaptopLimit = result.result.data.items[4].posts_limit

def API_ElectronicsLimit = result.result.data.items[5].posts_limit

def API_REForSaleLimit = result.result.data.items[6].posts_limit

def API_REForRentLimit = result.result.data.items[7].posts_limit

def API_HomeGardenLimit = result.result.data.items[8].posts_limit

def API_WomenFashionLimit = result.result.data.items[9].posts_limit

def API_MenFashionLimit = result.result.data.items[10].posts_limit

def API_BabyKidsLimit = result.result.data.items[11].posts_limit

def API_FoodLimit = result.result.data.items[12].posts_limit

def API_EducationLimit = result.result.data.items[13].posts_limit

def API_ServicesLimit = result.result.data.items[14].posts_limit

def API_JobsLimit = result.result.data.items[15].posts_limit

def API_PetsLimit = result.result.data.items[16].posts_limit

API_AutosLimit = API_AutosLimit.toString()

API_MotorcycleLimit = API_MotorcycleLimit.toString()

API_MobileTabletleLimit = API_MobileTabletleLimit.toString()

API_GamingleLimit = API_GamingleLimit.toString()

API_LaptopLimit = API_LaptopLimit.toString()

API_ElectronicsLimit = API_ElectronicsLimit.toString()

API_REForSaleLimit = API_REForSaleLimit.toString()

API_REForRentLimit = API_REForRentLimit.toString()

API_HomeGardenLimit = API_HomeGardenLimit.toString()

API_WomenFashionLimit = API_WomenFashionLimit.toString()

API_MenFashionLimit = API_MenFashionLimit.toString()

API_BabyKidsLimit = API_BabyKidsLimit.toString()

API_FoodLimit = API_FoodLimit.toString()

API_EducationLimit = API_EducationLimit.toString()

API_ServicesLimit = API_ServicesLimit.toString()

API_JobsLimit = API_JobsLimit.toString()

API_PetsLimit = API_PetsLimit.toString()

//Check value from My account details == API value
//Autos
if (AutosCategory_Limit.contains(API_AutosLimit)) {
    println((('Correct >> My Account value for Autos' + AutosCategory_Limit) + ' Equal API value') + API_AutosLimit)
} else {
    throw new Exception((('Not Correct >> My Account value for Autos' + AutosCategory_Limit) + ' Not equal') + API_AutosLimit)
}

//Motorcycle
if (MotorcycleCategory_Limit.contains(API_MotorcycleLimit)) {
    println((('Correct >> My Account value for Motorcycle' + MotorcycleCategory_Limit) + ' Equal API value') + API_MotorcycleLimit)
} else {
    throw new Exception((('Not Correct >> My Account value for Motorcycle' + MotorcycleCategory_Limit) + ' Not equal') + 
    API_MotorcycleLimit)
}

//MobileTablet
if (MobileTabletCategory_Limit.contains(API_MobileTabletleLimit)) {
    println((('Correct >> My Account value for MobileTablet' + MobileTabletCategory_Limit) + ' Equal API value') + API_MobileTabletleLimit)
} else {
    throw new Exception((('Not Correct >> My Account value for MobileTablet' + MobileTabletCategory_Limit) + ' Not equal') + 
    API_MobileTabletleLimit)
}

//Gaming
if (GamingCategory_Limit.contains(API_GamingleLimit)) {
    println((('Correct >> My Account value for Gaming' + GamingCategory_Limit) + ' Equal API value') + API_GamingleLimit)
} else {
    throw new Exception((('Not Correct >> My Account value for Gaming' + GamingCategory_Limit) + ' Not equal') + API_GamingleLimit)
}

//Laptop
if (LaptopCategory_Limit.contains(API_LaptopLimit)) {
    println((('Correct >> My Account value for Laptop' + LaptopCategory_Limit) + ' Equal API value') + API_LaptopLimit)
} else {
    throw new Exception((('Not Correct >> My Account value for Laptop' + LaptopCategory_Limit) + ' Not equal') + API_LaptopLimit)
}

//Electronics
if (ElectronicsCategory_Limit.contains(API_ElectronicsLimit)) {
    println((('Correct >> My Account value for Electronics' + ElectronicsCategory_Limit) + ' Equal API value') + API_ElectronicsLimit)
} else {
    throw new Exception((('Not Correct >> My Account value for Electronics' + ElectronicsCategory_Limit) + ' Not equal') + 
    API_ElectronicsLimit)
}

//RE for Sale
if (REForSaleCategory_Limit.contains(API_REForSaleLimit)) {
    println((('Correct >> My Account value for RE for Sale' + REForSaleCategory_Limit) + ' Equal API value') + API_REForSaleLimit)
} else {
    throw new Exception((('Not Correct >> My Account value for RE for Sale' + REForSaleCategory_Limit) + ' Not equal') + 
    API_REForSaleLimit)
}
//RE for Rent
if (REForRentCategory_Limit.contains(API_REForRentLimit)) {
    println((('Correct >> My Account value for RE for Rent' + REForRentCategory_Limit) + ' Equal API value') + API_REForRentLimit)
} else {
    throw new Exception((('Not Correct >> My Account value for RE for Rent' + REForRentCategory_Limit) + ' Not equal') + 
    API_REForRentLimit)
}

//Home & Garden
if (HomeGardenCategory_Limit.contains(API_HomeGardenLimit)) {
    println((('Correct >> My Account value for Home & Garden' + HomeGardenCategory_Limit) + ' Equal API value') + API_HomeGardenLimit)
} else {
    throw new Exception((('Not Correct >> My Account value for Home & Garden' + HomeGardenCategory_Limit) + ' Not equal') + 
    API_HomeGardenLimit)
}

//Women Fashion
if (WomenFashionCategory_Limit.contains(API_WomenFashionLimit)) {
    println((('Correct >> My Account value for Women Fashion' + WomenFashionCategory_Limit) + ' Equal API value') + API_WomenFashionLimit)
} else {
    throw new Exception((('Not Correct >> My Account value for Women Fashion' + WomenFashionCategory_Limit) + ' Not equal') + 
    API_WomenFashionLimit)
}

//Men Fashion
if (MenFashionCategory_Limit.contains(API_MenFashionLimit)) {
    println((('Correct >> My Account value for Men Fashion' + MenFashionCategory_Limit) + ' Equal API value') + API_MenFashionLimit)
} else {
    throw new Exception((('Not Correct >> My Account value for Men Fashion' + MenFashionCategory_Limit) + ' Not equal') + 
    API_MenFashionLimit)
}

//Baby Kids
if (BabyKidsCategory_Limit.contains(API_BabyKidsLimit)) {
    println((('Correct >> My Account value for Baby Kids' + BabyKidsCategory_Limit) + ' Equal API value') + API_BabyKidsLimit)
} else {
    throw new Exception((('Not Correct >> My Account value for Baby Kids' + BabyKidsCategory_Limit) + ' Not equal') + API_BabyKidsLimit)
}

//Food
if (FoodCategory_Limit.contains(API_FoodLimit)) {
    println((('Correct >> My Account value for Food' + FoodCategory_Limit) + ' Equal API value') + API_FoodLimit)
} else {
    throw new Exception((('Not Correct >> My Account value for Food' + FoodCategory_Limit) + ' Not equal') + API_FoodLimit)
}

//Education
if (EducationCategory_Limit.contains(API_EducationLimit)) {
    println((('Correct >> My Account value for Education' + EducationCategory_Limit) + ' Equal API value') + API_EducationLimit)
} else {
    throw new Exception((('Not Correct >> My Account value for Education' + EducationCategory_Limit) + ' Not equal') + API_EducationLimit)
}

//Services
if (ServicesCategory_Limit.contains(API_ServicesLimit)) {
    println((('Correct >> My Account value for Services' + ServicesCategory_Limit) + ' Equal API value') + API_ServicesLimit)
} else {
    throw new Exception((('Not Correct >> My Account value for Services' + ServicesCategory_Limit) + ' Not equal') + API_ServicesLimit)
}

//Jobs
if (JobsCategory_Limit.contains(API_JobsLimit)) {
    println((('Correct >> My Account value for Jobs' + JobsCategory_Limit) + ' Equal API value') + API_JobsLimit)
} else {
    throw new Exception((('Not Correct >> My Account value for Jobs' + JobsCategory_Limit) + ' Not equal') + API_JobsLimit)
}

//Pets
if (PetsCategory_Limit.contains(API_PetsLimit)) {
    println((('Correct >> My Account value for Pets' + PetsCategory_Limit) + ' Equal API value') + API_PetsLimit)
} else {
    throw new Exception((('Not Correct >> My Account value for Pets' + PetsCategory_Limit) + ' Not equal') + API_PetsLimit)
}

Mobile.closeApplication()

