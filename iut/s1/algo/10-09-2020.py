def plusPetitNombre(a=0, b=0, c=0):
    return a if a<b and a<c else b if b<a and b<c else c if c<b and c<a else "ERROR"

print(plusPetitNombre(int(input("a=")), int(input("b=")), int(input("c="))))























''' ARCHIVES


import random
res = random.randint(0,100)
guess = -1
while guess != res:
    guess = int(input("Tapez un nombre entier entre 0 et 100 : "))
    print("C'est moins" if guess > res else "C'est plus" if guess < res else "Bravo !")

mois = int(input("Donnez un mois de l'année (en chiffre) : "))
if mois == 2:
    jours = 28
elif mois in [4,6,9,11]:
    jours = 30
else:
    jours = 31
print(jours)

print( len( str( input( "Indiquez un nombre : " ) ) ) )

text = input("Indiquez votre chaine de caractères : ")
reversedText =""
for i in text:
    reversedText = i + reversedText
print(reversedText)

n = int(input("Nombre : "))
r = 1
for i in range (2,n+1):
    print(i)
    r+=r*(n)
print("=======\n",r)

'''