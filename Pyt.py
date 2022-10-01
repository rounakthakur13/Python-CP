arr=[]
n=int(input("Enter the 1st array "))

for i in range(0,n):
    m=int(input())
    arr.append(m)
print("1st array:",arr)


arr1=[]
a=int(input("Enter the 2nd array "))

for i in range(0,a):
    b=int(input())
    arr1.append(b)
print("2nd array:",arr1)

arr2=arr+arr1
print(arr2)

for i in range(len(arr2)):
  for j in range(i+1,len(arr2)):
    if arr2[i]>arr2[j]:
      arr2[i],arr2[j]=arr2[j],arr2[i]
print(arr2)

x=int(input("Enter the Element:"))
print("Enter the index at which position the element should be added:")



