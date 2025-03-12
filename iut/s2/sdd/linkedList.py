class LCListe:
    
    class Maillon:
        
        def __init__ (self, valeur):
            
            self._valeur = valeur
            self._suiv = None
        
        
        
    def __init__(self):
        
        self._tete = self.Maillon(None)
        self._dernier = self._tete
        self._nbElem = 0
        
        
        
    def ajouter (self, valeur):
        
        nouvMaillon = self.Maillon(valeur)
        
        self._dernier._suiv = nouvMaillon
        self._dernier = nouvMaillon
        self._nbElem += 1    
        
        
    def retournerPos (self, valeur):
        
        currMaillon = self._tete
        index = -1
        trouve = False
        
        while (currMaillon._suiv != None and currMaillon._valeur != valeur):
            currMaillon = currMaillon._suiv
            if currMaillon._valeur == valeur:
                trouve = True
            index += 1
        
        return index if trouve else -1
        
        
        
    def retournerMaillon (self, index):
        
        if (index > self._nbElem - 1 or index < 0):
            raise Exception("index out of range")
        
        currMaillon = self._tete._suiv
        
        for i in range (1, index+1):
            currMaillon = currMaillon._suiv
            
        return currMaillon
    
    
    
    def retournerLongueur (self):
        return self._nbElem
    
    
    
    def afficherTableau (self):
        
        currMaillon = self._tete._suiv
        text = "["
        
        for i in range (0, self._nbElem):
            text += str(currMaillon._valeur) + (", " if i < self._nbElem - 1 else "")
            currMaillon = currMaillon._suiv
            
        print(text + "]")            
            
       
            
    def suppr (self, index):
        
        if index == 0:
            removedMaillon = self._tete._suiv
            self._tete._suiv = self._tete._suiv._suiv
        else:
            currMaillon = self.retournerMaillon(index - 1)
            if not currMaillon:
                raise Exception("index out of range")
            
            removedMaillon = currMaillon._suiv
            currMaillon._suiv = currMaillon._suiv._suiv
        
        self._nbElem -= 1
        
        return removedMaillon
                
                
                
    def set (self, valeur, index):
        
        currMaillon = self.retournerMaillon(index)
        if not currMaillon:
            raise Exception("index out of range")
        
        currMaillon._valeur = valeur
        
        return currMaillon
    
    
# ================ TESTS ====================== #
    
class LCListeTest:
    
    def __init__(self):
        self._arr = LCListe()
        
    
    def run (self):
         
        self._arr.ajouter(2)
        self._arr.ajouter(1)
        self._arr.ajouter(3)
        self._arr.ajouter(4)

        self._arr.afficherTableau()
        print("======================")

        self._arr.set("a", 2)
        print(self._arr.retournerPos(1))
        self._arr.suppr(3)

        self._arr.afficherTableau()

        print("======================")

        print(self._arr.retournerLongueur())



LCListeTest().run()