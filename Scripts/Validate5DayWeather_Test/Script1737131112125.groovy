import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

// Send API request
def response = WS.sendRequest(findTestObject('Get5DayWeather_JakartaSelatan'))

// Assert status code
WS.verifyResponseStatusCode(response, 200)

// Validate response structure and key fields
WS.verifyElementPropertyValue(response, 'cod', '200')
WS.verifyElementPropertyValue(response, 'city.name', 'Rawa Barat')
WS.verifyElementPropertyValue(response, 'city.country', 'ID')

// Validate weather details for the first forecast
WS.verifyElementPropertyValue(response, 'list[0].main.temp', 300.1)
WS.verifyElementPropertyValue(response, 'list[0].main.humidity', 75)
WS.verifyElementPropertyValue(response, 'list[0].weather[0].main', 'Rain')
WS.verifyElementPropertyValue(response, 'list[0].weather[0].description', 'light rain')
WS.verifyElementPropertyValue(response, 'list[0].dt_txt', '2025-01-17 18:00:00')

// Validate additional fields
WS.verifyElementPropertyValue(response, 'list[0].wind.speed', 5.45)
WS.verifyElementPropertyValue(response, 'list[0].visibility', 10000)
WS.verifyElementPropertyValue(response, 'list[0].clouds.all', 100)
