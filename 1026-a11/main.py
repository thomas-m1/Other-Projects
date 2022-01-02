# Thomas Michalski
# computer science CS1026
# Assignment 2 - volume calculator
# October 24th, 2018
# handles prompting and input for the different shapes and the output

s=1 #placeholder

#imports for the calculations in volume file
from volume import cube_calculation
from volume import pyramid_calculation
from volume import ellipsoid_calculation

#making the list for each shape
listCube = []
listPyramid = []
listEllipsoid = []

#introduction for user
print("Hello! Welcome to Thomas' volume calculator.")
print("In this program you will be able to calculate the volume of a cube, pyramid, or ellipsoid.")#explanation
print("Please enter the full name of the shape or just the first letter. To quit the program, enter ''quit or 'q'.")

while s != 0:
    shape = str(input("Would you like to calculate the volume of a cube, pyramid, or ellipsoid?: "))
    shape = shape.upper()#allows user to type in any combination of upper and lowercase letters
    if shape == "CUBE" or shape == "C":
        s = 1
        answer = cube_calculation()#calls volume calculation file for the cube and stores the answer as "answer"
        listCube.append(answer)#adds answer to the list
        shape = "cube"
    elif shape == "PYRAMID" or shape == "P":
        s = 1
        answer = pyramid_calculation()#calls volume calculation file for the pyramid and stores the answer as "answer"
        listPyramid.append(answer)#adds answer to the list
        shape = "pyramid"
    elif shape == "ELLIPSOID" or shape == "E":
        s = 1
        answer = ellipsoid_calculation()#calls volume calculation file for the ellipsoid and stores the answer as "answer"
        listEllipsoid.append(answer)#adds answer to the list
        shape = "ellipsoid"
    elif shape == "QUIT" or shape == "Q":#finishes loop
        s = 0
        print("you have reached the end of your session.")
    else:
        print("Invalid response. Please try again.")#if user enters a non valid input this will run

#sorts the calculations from smallest to largest number
listCube.sort()
listPyramid.sort()
listEllipsoid.sort()


#if user doesnt enter any values, the program will finish
if len(listCube) == len(listPyramid) == len(listEllipsoid) == 0:
   print("you did not perform any volume calculations")
   exit()#exits program if true

#checks if you made a calculation for each shape and displays list, if nothing is entered, tells user
if len(listCube) == 0:
    print("Cube: you did not perform any volume calculations")
else:
    print("Cube: ", end="")
    print(*listCube, sep=", ")#gets rid of brackets
if len(listPyramid) == 0:
    print("Pyramid: you did not perform any volume calculations")
else:
    print("Pyramid: ", end="")
    print(*listPyramid, sep=", ")
if len(listEllipsoid) == 0:
    print("Ellipsoid: You did not perform any volume calculations")
else:
    print("Ellipsoid: ", end="")
    print(*listEllipsoid, sep=", ")

exit() #exits program
