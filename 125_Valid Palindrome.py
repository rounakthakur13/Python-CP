str = "Abb a"
l = 0
r = len(str) - 1

def pali(str,l,r):
    while l<r:
   
        while not str[l].isalnum():
            l+=1
        while not str[r].isalnum():
            r-=1
        # print(str[l],str[r])
        if str[l].lower() != str[r].lower():
            return False
        l+=1
        r-=1
    return True
pali(str,l,r)
