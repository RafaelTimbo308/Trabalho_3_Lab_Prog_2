import socket
from PPTLS import PPTLS

HOST = 'localhost'
PORT = 5000

socket = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
socket.connect((HOST,PORT))

data = socket.recv(1024)
print("Status: " + data.decode())

info=0

jogo = PPTLS()

while(info < 15):
    msg = jogo.jogada()
    msg = msg+"\n"
    socket.sendall(str.encode(msg))
    data = socket.recv(1024)
    info = (int) (data.decode())

data = socket.recv(1024)
info = data.decode()
print(info)
print("Status: Conexão Encerrada")
socket.close()