from random import *
versuche = 40
treffer = []
richtige = []
falsche = []
def uber(f):
    o = 0;
    for i in f:
        if i<85:
            o = o+1
    return o




for i in range(1, 6):
    x = randint(1, 100)
    treffer.append(x)

if uber(treffer) < 4:
    print("Nein")
else:
    print("Ja")

print(treffer )
