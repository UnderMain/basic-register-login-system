

zahl1 = input("Erste Zahl :")
zahl2 = input("Zweite Zahl :")
operator = raw_input("Operator: ")


def math(e, z, o):
    if type(e) == int:
        if type(z) == int:
            if o == 'plus':
                x = e + z
                return x
            else:
                print("Keinen Operator angegeben")
            if o == "minus":
                x = e - z
                return x
            else:
                print("Keinen Operator angegeben")
            if o == "mal":
                x = e * z
                return x
            else:
                print("Keinen Operator angegeben")
            if o == "geteilt":
                x = e / z
                return x
            else:
                print("Keinen Operator angegeben")
        else:
            print("Zahl Zwei ist keine Zahl!")
    else:
        print("Zahl Eins ist keine Zahl!!")


math(zahl1, zahl2, operator)

