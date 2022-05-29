from ctypes.wintypes import PINT
import subprocess
import json
import requests
from RaspMonitoramento import RaspMonitoramento 
from MonitoramentoUtil import MonitoramentoUtil 
import schedule
import time

def req():
#Montamos a requisição para enviarmos o put para o webservice
    URL = "http://localhost:8080/webserviceMonitoramento/service/ws/info/post"
    headers={'Content-type':'application/json'}
    cont = 0
    while cont < 10:
        raspMon = MonitoramentoUtil.executeCommandPreencheObject()
        jsonRequest = raspMon.toJSON()
        cont = cont + 1
        request = requests.put(URL, json=jsonRequest, headers=headers)
        print(request.content)
    
    schedule.every(1).minutes.do(req)

    while True:
        schedule.run_pending()
        time.sleep(1)
