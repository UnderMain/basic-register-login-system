from tkinter import *
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
def color(a, b, c, d):
        labelX = Label(master=Window, bg=a, text=mainText)
        labelX.place(x=0, y=0, width=500, height=200)
        labelX1 = Label(master=Window, bg=b, text=mainText)
        labelX1.place(x=0, y=200, width=500, height=200)
        labelX2 = Label(master=Window, bg=c, text=mainText)
        labelX2.place(x=0, y=400, width=500, height=200)
        labelX3 = Label(master=Window, bg=d, text=mainText)
        labelX3.place(x=0, y=600, width=500, height=200)
        Window.mainloop()


space()
print("Window Creator by UnderMain")
print("")


while True:
    name = input("Name of the Window? : ")
    mainText = ""

    mainText2 = ""

    mainText3 = ""
    try:
        if name != "":
            if name == "blue":
                Window = Tk()
                Window.title(name)
                Window.geometry('500x800')
                color("#4876FF", "#436EEE", "#3A5FCD", "#27408B")
                color("#4876FF", "#436EEE", "#3A5FCD", "#27408B")
                color("#4876FF", "#436EEE", "#3A5FCD", "#27408B")
                color("#4876FF", "#436EEE", "#3A5FCD", "#27408B")


                break
            else:
                print("type blue amk")
                continue
        else:
            print("JUST TYPE ANYTHING")
            continue

    except:
        break
