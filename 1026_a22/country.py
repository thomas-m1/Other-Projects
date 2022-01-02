# Thomas Michalski
# computer science CS1026
# Assignment 4 - Country Classes
# December 5th, 2018
# holds the information about a single country

class country:

    def __init__(self,name,population,area,continent):
        self.name = name
        self.population = population
        self.area = area
        self.continent = continent

#getter methods
    def getname(self):
        getname = self.name
        return getname

    def getpopulation(self):
        getpopulation = self.population
        return getpopulation

    def getare(self):
        getarea = self.area
        return getarea

    def getcontinent(self):
        getcontinent = self.continent
        return getcontinent

#setter methods
    def setpopulation(self, population):
        self.setpopulation = population

    def setarea(self, area):
        self.setarea = area

    def setcontinent(self, continent):
        self.setcontinent = continent

#calculation for population density
    def getPopDensity(self):
        return round(self.population/self.area, 2)

    def __repr__(self):
        return str(format(self.name) + "(Pop: " + format(self.population) + ", size: " + format(self.area) + ") in " + format(self.continent) + "\n")


