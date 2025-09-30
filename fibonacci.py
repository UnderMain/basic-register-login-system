def fib(n):
    if n < 2:
        return n
    else:
        return fib(n-1)+fib(n-2)


i = fib(10)
print(i)
