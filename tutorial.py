import random


for i in range(10):
    zahl = 100
    sequence = [i for i in range(int(zahl))]
    random = random.choice(sequence)
    print(random)
