arr=[]
n=int(input("Enter the 1st array "))

for i in range(0,n):
    #print("arr[",i,"]=",i+1)
    m=int(input())
    arr.append(m)
print("1st array:",arr)

def add(n):
    return n + n

#numbers = arr

print(list(map(add,arr)))
