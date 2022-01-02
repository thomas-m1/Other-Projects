# Thomas Michalski
# computer science CS1026
# Assignment 4 - Country Classes
# December 5th, 2018
# This class will use two files to build the data structures to hold the information about countries and continents

from country import *

#defines new class
class CountryCatalogue:
    def __init__(self, firstFile, secondFile):
        self.countryCat = {}
        self.cDictionary = {}


#creates cDictionary and countryCat from files
        try:
            with open(secondFile, "r") as countryContinents:#opens file
                holder = 0
                for line in countryContinents:
                    if holder > 0:
                        line = line.rstrip()
                        line = line.split(",")
                        self.cDictionary[line[0]] = line[1]
                    holder += 1


            with open(str(firstFile), "r") as countryInfo:#opens file
                holder1 = 0
                for line in countryInfo:
                    if holder1 > 0:
                        line = line.rstrip()
                        line = line.replace(",", "").split("|")
                        self.countryCat[line[0]] = country(line[0], int(line[1]), float(line[2]), self.cDictionary[line[0]])
                    holder1 += 1

        except IOError:
            print("Error: File was not found.")
            exit()

#determines if a country is in catalogue and returns
    def findCountry(self, name):
        if name in self.countryCat:
            return self.countryCat[name]
        else:
            return None

#sets a new population for country.
    def setPopulationOfCountry(self, name, population):
        if name in self.countryCat:
            newcountry = self.countryCat[name]
            newcountry.setPopulation(population)
            return True
        else:
            return False

#sets a new area for a country
    def setAreaOfCountry(self, name, newArea):
        if name in self.countryCat:
            newCountry = self.countryCat[name]
            newCountry.setArea(newArea)
            return True
        else:
            return False

#adds new country
    def addCountry(self, name, population, area, continent):
        if name not in self.countryCat:
            self.cDictionary[name] = continent
            self.countryCat[name] = country(name, population, area, continent)
            return True
        else:
            return False

#This method deletes a country from both data structures
    def deleteCountry(self, country):
        if country in self.countryCat:
            self.countryCat.pop(country)
            self.cDictionary.pop(country)
        else:
            pass

#prints catalogue
    def printCountryCatalogue(self):
        print(self.countryCat)

#returns countries with continents
    def getCountriesByContinent(self, continent):
        countryByContinents = []
        for key, value in self.cDictionary.items():
            if continent == value:
                countryByContinents.append(key)
        return countryByContinents

#returns all countries with continent in descending order by population
    def getCountriesByPopulation(self, continent=""):
        countryByPopulations = [] #list
        if continent in self.cDictionary.values():
            for value in self.countryCat.values():
                if continent == value.getContinent():
                    countryPopulation = (value.getName(), value.getPopulation())
                    countryByPopulations.append(countryPopulation)
        elif continent == "":
            for value in self.countryCat.values():
                countryPopulation = (value.getName(), value.getPopulation())
                countryByPopulations.append(countryPopulation)
        else:
            return []

        def getKey(item):
                return item[1]
        return sorted(countryByPopulations, key=getKey, reverse=True)

#returns countries with continent in descending order by area
    def getCountriesByArea(self, continent = ""):
        countryByArea = [] #list
        if continent in self.cDictionary.values():
            for value in self.countryCat.values():
                if continent == value.getContinent():
                    countryArea = (value.getName(), value.getArea())
                    countryByArea.append(countryArea)
        elif continent == "":
            for value in self.countryCat.values():
                countryArea = (value.getName(), value.getArea())
                countryByArea.append(countryArea)
        else:
            return []

        def getKey(item):
            return item[1]
        return sorted(countryByArea, key=getKey, reverse=True)

#return the name of the continent with the most number of people living in it  and the number of people living in the continent
    def findMostPopulousContinent(self):
        continentList = []
        continentSum = []
        sum = 0
        continentPopulation = {}
        largestSum = 0
        largestContinent = 0


#creates list containing all continents
        for value in self.countryCat.values():
            if value.getContinent() not in continentList:
                continentList.append(value.getContinent())

#creates list holding all sums
        for n in range(len(continentList)):
            continentSum.append(0)

        for i in range(len(continentList)):
            for continent in self.countryCat.values():
                if continent.getContinent() == continentList[i]:
                    sum = sum + continent.getPopulation()
            continentSum[i] = sum
            continentPopulation[continentList[i]] = continentSum[i]

        for key in continentPopulation:
            if continentPopulation[key] > largestSum:
                largestContinent = key
                largestSum = continentPopulation[key]
            else:
                pass

        Tuple = (largestContinent, largestSum)
        return Tuple

#returns countries that are within population range set by the user.
    def filterCountriesByPopDensity(self, lower, upper):
        smaller = int(lower)
        larger = int(upper)
        countryBypopulationDensity = []


        for value in self.countryCat.values():
            if smaller <= value.getPopDensity() <= larger:
                countrypopulationDensity = (value.getName(), value.getPopDensity())
                countryBypopulationDensity.append(countrypopulationDensity)

        def getKey(item):
            return item[1]
        return sorted(countryBypopulationDensity, key=getKey, reverse=True)

#saves the catalogue alphabetically to new file
    def saveCountryCatalogue(self, file):
        try:
            with open(file, "w") as file:#write the file
                for i in sorted(self.countryCat):
                    values = self.countryCat[i]
                    string = f"{values.getName()}|{values.getContinent()}|{values.getPopulation()}|{values.getArea()}|{values.getPopDensity()}"
                    file.write(string)
        except IOError:
            return -1
