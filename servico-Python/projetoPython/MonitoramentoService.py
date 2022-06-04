from ctypes.wintypes import PINT
import subprocess
import json
import requests
import schedule
import time
from RaspMonitoramento import RaspMonitoramento 
from MonitoramentoUtil import MonitoramentoUtil 


URL = "http://192.168.1.111:8080/webserviceMonitoramento/service/ws/info/post"
headers={'Content-type':'application/json'}

def req():
    try:
        #Montamos a requisição para enviarmos o put para o webservice
        raspMon = MonitoramentoUtil.executeCommandPreencheObject()
        jsonRequest = raspMon.toJSON()
        request = requests.put(URL, json=jsonRequest, headers=headers, timeout=10)
        print(request.content)

    except requests.exceptions.Timeout as e:
        print('Servidor fora do ar ' + e)

schedule.every(15).seconds.do(req)

while True:
    schedule.run_pending()
    time.sleep(1)
