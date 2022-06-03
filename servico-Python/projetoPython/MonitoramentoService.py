from ctypes.wintypes import PINT
import subprocess
import json
import requests
from RaspMonitoramento import RaspMonitoramento 
from MonitoramentoUtil import MonitoramentoUtil 
import schedule
import time


URL = "http://192.168.1.111:8080/webserviceMonitoramento/service/ws/info/post"
headers={'Content-type':'application/json'}

#Montamos a requisição para enviarmos o put para o webservice
raspMon = MonitoramentoUtil.executeCommandPreencheObject()
jsonRequest = raspMon.toJSON()
request = requests.put(URL, json=jsonRequest, headers=headers, timeout=10)
print(request.content)
   
