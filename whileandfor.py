from random import randrange

import funktionen

y = randrange(10)

if y < 5:
    a="nice"
    b="ja"
    c="nein"

if y > 5:
    a="nicht nice"
    b="nein"
    c="ja"

x = [a, b, c]

for w in x:
    print(w)

print("Die Zahl y ist " + str(y))
print("FERTIG!")

funktionen.schreiben("moin dehaaa")