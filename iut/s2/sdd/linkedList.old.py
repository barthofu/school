class LCListe:
    
    class Maillon:
        
        def __init__ (self, valeur):
            
            self._valeur = valeur
            self._suiv = None
        
        
        
    def __init__(self):
        
        self._premier = None
        self._dernier = None
        self._nbElem = 0
        
        
        
    def ajouter (self, valeur, index = None):
    
        if index == None:
            index = self._nbElem
        
        nvMaillon = self.Maillon(valeur)
        
        if self._nbElem == 0:
            self._premier, self._dernier = nvMaillon, nvMaillon
        else:
            if index == 0:
                nvMaillon._suiv = self._premier
                self._premier = nvMaillon
            else:
                currMaillon = self.retournerMaillon(index - 1)
                if not currMaillon:
                    return "invalid position"
                
                nvMaillon._suiv = currMaillon._suiv
                currMaillon._suiv = nvMaillon

        self._nbElem += 1
        
        return nvMaillon
        
        
        
    def retournerPos (self, valeur):
        
        currMaillon = self._premier
        iterator = 0
        
        while (currMaillon._valeur != valeur):
            currNode = currMaillon._suiv
            iterator += 1
        
        return iterator
        
        
        
    def retournerMaillon (self, index):
        
        if (index > self._nbElem - 1):
            return None
        
        currMaillon = self._premier
        
        for i in range (1, index+1):
            currMaillon = currMaillon._suiv
            
        return currMaillon
    
    
    
    def retournerLongueur (self):
        return self._nbElem
    
    
    
    def afficherTableau (self):
        
        currMaillon = self._premier
        
        for i in range (0, self._nbElem):
            print(currMaillon._valeur)
            currMaillon = currMaillon._suiv
            
            
            
    def suppr (self, index):
        
        if index == 0:
            removedMaillon = self._premier
            self._premier = self._premier._suiv
        else:
            currMaillon = self.retournerMaillon(index - 1)
            if not currMaillon:
                return "invalid position"
            
            removedMaillon = currMaillon._suiv
            currMaillon._suiv = currMaillon._suiv._suiv
        
        self._nbElem -= 1
        
        return removedMaillon
                
                
                
    def set (self, valeur, index):
        
        currMaillon = self.retournerMaillon(index)
        if not currMaillon:
            return "invalid position"
        
        currMaillon._valeur = valeur
        
        return currMaillon
    
    
# ================ TESTS ====================== #
    
class LCListeTest:
    
    def __init__(self):
        self._arr = LCListe()
        
    
    def run (self):
         
        self._arr.ajouter(2)
        self._arr.ajouter(1, 0)
        self._arr.ajouter(3)
        self._arr.ajouter(4)

        self._arr.afficherTableau()
        print("======================")

        self._arr.set("a", 2)
        self._arr.suppr(3)

        self._arr.afficherTableau()

        print("======================")

        print(self._arr.retournerLongueur())



LCListeTest().run()