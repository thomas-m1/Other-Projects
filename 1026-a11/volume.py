# Thomas Michalski
# computer science CS1026
# Assignment 2 - volume calculator
# October 24th, 2018
# computing volumes and prompting for dimensions
# this is the module used for main file

import math#imports math file to use pi calculation
pi = math.pi

#defining each module so it can be specified and used in main program
def cube_calculation():
    length = float(input("Please enter the side lengths of the cube: "))
    volume = length**3#calculation for volume of cube
    print("The volume of a cube with the side lengths of " + str(length) + " is: " + str(volume))
    return volume#returns answers from calculations

def pyramid_calculation():
    base = float(input("Please enter the length of the pyramid: "))
    height = float(input("Please enter the length of the pyramid: "))
    volume = (1/3) * (base**2) * height#calculation for volume of pyramid
    print("The volume of a pyramid with a length of " + str(base) + " and a height of " + str(height) + " is: " + str(volume))
    return volume

def ellipsoid_calculation():
    radius1 = float(input("Please enter the the first radius of the ellipsoid: "))
    radius2 = float(input("Please enter the the second radius of the ellipsoid: "))
    radius3 = float(input("Please enter the the third radius of the ellipsoid: "))
    volume = (4/3) * pi * radius1 * radius2 * radius3#calculation for volume of ellipsoid
    print("The volume of an ellipsoid with the radius' of " + str(radius1) + ", " + str(radius2) + " and " + str(radius3) + " is: " + str(volume))
    return volume
