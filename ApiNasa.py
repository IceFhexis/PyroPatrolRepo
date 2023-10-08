import requests
from geopy.distance import geodesic
from geopy.distance import Point
import geocoder

def getFireData(cordenadas, range): #Does a get request for the FIRMS API to get the fire data based on the user location 
    link = f"https://firms.modaps.eosdis.nasa.gov/api/area/csv/223b623369521490f33e1714d1772aba/VIIRS_SNPP_NRT/{cordenadas}/{range}"
    rec = requests.get(link)
    ljson = rec.content.decode('utf-8') 
    return ljson


def encontrarNovoPonto(lat, lon, distancia_km, graus): #Get the distance from the center point 
    ponto = geodesic(kilometers=distancia_km).destination((lat, lon), graus)
    return ponto

def organize(p1, p2): #Organize the data
    point_list = [p2[0], p2[1], p1[0], p1[1]]
    return ",".join(map(str, point_list))

def getPotencialDeRisco(data): #Get the potential risc
    data_list = data.split('\n')
    viirs_info = None
    dataList = []
    
    for i in range(1, len(data_list)):
        x = data_list[i].split(",")
        y = 0
        if x[9] == "l":
            y = 1
        if x[9] == "n":
            y = 2
        if x[9] == "h":
            y = 3
               
        dataList.append(y)
    
    if not dataList:
        m = max(dataList, default=0)
    i = "Você está fora de uma área de risco!"
    match(m):
        case 1:
            i = "Você está em uma área de baixo risco!"
        case 2:
            i = "Você está em uma área de médio risco!"
        case 3:
            i = "Você está em uma área de alto risco!"
    return i

def getCurrentLocation(): #Gets the current location based on ip
    location = geocoder.ip('me')
    if location.ok:
        return location.latlng
    else:
        return None

def results(): #Calculate the results
    current_location = getCurrentLocation()
    pontoDeReferencia = current_location
    distancia_km = 1000

    point_central = Point(pontoDeReferencia[0], pontoDeReferencia[1])

    point1 = encontrarNovoPonto(pontoDeReferencia[0], pontoDeReferencia[1], distancia_km, 45)
    point2 = encontrarNovoPonto(pontoDeReferencia[0], pontoDeReferencia[1], distancia_km, 225)

    data = getFireData(organize(point1,point2), 1)
    result = getPotencialDeRisco(data)

    return result

if(__name__ == "__main__"):
    print(results())