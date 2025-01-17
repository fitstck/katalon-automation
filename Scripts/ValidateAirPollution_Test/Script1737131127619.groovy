import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

// Send API request
def response = WS.sendRequest(findTestObject('GetAirPollution_JakartaSelatan'))

// Assert coordinates
WS.verifyElementPropertyValue(response, 'coord.lon', 106.8106)
WS.verifyElementPropertyValue(response, 'coord.lat', -6.2615)

// Assert AQI
WS.verifyElementPropertyValue(response, 'list[0].main.aqi', 2)

// Assert pollution components
WS.verifyElementPropertyValue(response, 'list[0].components.co', 1482.01)
WS.verifyElementPropertyValue(response, 'list[0].components.no', 9.16)
WS.verifyElementPropertyValue(response, 'list[0].components.no2', 27.08)
WS.verifyElementPropertyValue(response, 'list[0].components.o3', 0.51)
WS.verifyElementPropertyValue(response, 'list[0].components.so2', 11.21)
WS.verifyElementPropertyValue(response, 'list[0].components.pm2_5', 23.68)
WS.verifyElementPropertyValue(response, 'list[0].components.pm10', 37.9)
WS.verifyElementPropertyValue(response, 'list[0].components.nh3', 4.37)
