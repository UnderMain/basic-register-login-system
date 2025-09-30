import random

def space():
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")
    print("")

space()
print("Wilkommen bei der magischen Miesmuschel!")
print("")
print('Das muss eine ja / nein Frage sein!')
print("")
frage = input("Wie lautet deine Frage? :")
print("")
zahl = 100
print("")
zahl2 = 1000

sequence = [i for i in range(int(zahl))]
random = random.choice(sequence)


faktor1 = int(zahl) - int(random)

if faktor1 <= 43:
    print("JA")
if faktor1 >= 57:
    print("NEIN")
