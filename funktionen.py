def funk(e, f):
    for i in range(e, f):
        print(i)
    print("fertig")

def schreiben(x):
    print(x)

def mathe(g, k, l):

    if l == '+':
        schreiben(g + k)
    elif l == '-':
        schreiben(g - k)
    elif l == '*':
        schreiben(g * k)
    elif l == '/':
        schreiben(g / k)


g = input("1. Zahl zum Multiplizieren: ")
k = input("2. Zahl zum Multiplizieren: ")


schreiben('Plus-Funktion')
mathe(g, k, '+')
schreiben('Minus-Funktion')
mathe(g, k, '-')
schreiben('Mal-Funktion')
mathe(g, k, '*')
schreiben('Geteilt-Funktion')
mathe(g, k, '/')
