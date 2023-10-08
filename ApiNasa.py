import requests
from geopy.distance import geodesic
from geopy.distance import Point
import geocoder

def getFireData(cordenadas, range): #Does a get request for the FIRMS API to get the fire data based on the user location 
    link = f"https://firms.modaps.eosdis.nasa.gov/api/area/csv/223b623369521490f33e1714d1772aba/VIIRS_SNPP_NRT/{cordenadas}/{range}"
    request = requests.get(link)
    linkContent = request.content.decode('utf-8') 
    return linkContent

def getNewPoint(lat, lon, distance_km, degrees): #Get the distance from the center point 
    point = geodesic(kilometers=distance_km).destination((lat, lon), degrees)
    return point

def organize(p1, p2): #Organize the data
    pointList = [p2[0], p2[1], p1[0], p1[1]]
    return ",".join(map(str, pointList))

def getRiskPotential(fireData): #Get the potential risc
    dataList = fireData.split('\n')
    newDataList = []
    
    for i in range(1, len(dataList)):
        value = dataList[i].split(",")
        priority = 0
        if value[9] == "l":
            priority = 1
        if value[9] == "n":
            priority = 2
        if value[9] == "h":
            priority = 3
               
        newDataList.append(y)

    returnText = "You are not in a danger zone!"
    
    maxValue = max(newDataList, default=0)
    match(maxValue):
        case 1:
            returnText = "You are in a low risk danger zone!"
        case 2:
            returnText = "You are in a medium risk danger zone!"
        case 3:
            returnText = "You are in a high risk danger zone!"
            
    return returnText

def getCurrentLocation(): #Gets the current location based on ip
    location = geocoder.ip('me')
    if location.ok:
        return location.latlng
    else:
        return None

def results(): #Calculate the results
    currentLocation = getCurrentLocation()
    referencePoint = current_location
    
    distanceRadiusKm = 1000

    degreeFromCenter1 = 45
    degreeFromCenter2 = 225
    
    point1 = getNewPoint(referencePoint[0], referencePoint[1], distanceRadiusKm, degreeFromCenter1)
    point2 = getNewPoint(referencePoint[0], referencePoint[1], distanceRadiusKm, degreeFromCenter2)
    
    daysToAnalyze = 1

    fireData = getFireData(organize(point1,point2), daysToAnalyze)
    
    result = getRiskPotential(fireData)

    return result

if(__name__ == "__main__"):
    print(results())
