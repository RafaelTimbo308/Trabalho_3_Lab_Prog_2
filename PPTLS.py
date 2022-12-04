import random

class PPTLS:
    
    def __init__(self) -> None:
        contador = 0 
        self.contador = contador
    
    def jogada(self):
        jog = ["pedra" , "papel", "tesoura","lagarto","spock"]
        jogar = jog[self.contador]
        self.contador = (self.contador+1)%5
        return jogar
