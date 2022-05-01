from ctypes.wintypes import PINT
import subprocess
import json
from urllib import request
from RaspMonitoramento import RaspMonitoramento 

#comandos
cmdCpuDisp = ['wmic', 'memorychip', 'get', 'speed']
cmdCpuDispUtilizada = ['wmic', 'memorychip', 'get', 'speed']

cmdRamDisp = ['wmic', 'memorychip', 'get', 'speed']
cmdRamUtilizada = ['wmic', 'memorychip', 'get', 'speed']

cmdDiscoDisp =  ['wmic', 'memorychip', 'get', 'speed']
cmdDiscoUtilizado = ['wmic', 'memorychip', 'get', 'speed']

cmdTemperatura =  ['wmic', 'memorychip', 'get', 'speed']
cmdQntdProcessos = ['wmic', 'memorychip', 'get', 'speed']

cmdConRede = ['wmic', 'memorychip', 'get', 'speed']
codRasp = 1 

#info
monInfoCpuDisp = subprocess.run(cmdCpuDisp)
monInfoCpuUtilizada = subprocess.run(cmdCpuDispUtilizada)

monInfoRamDisp = subprocess.run(cmdRamDisp)
monInfoRamUtilizada = subprocess.run(cmdRamUtilizada)

monInfoTemperatura = subprocess.run(cmdTemperatura)
monInfoQntdProcessos = subprocess.run(cmdQntdProcessos)

monInfoConRede = True
monInfoCodRasp = codRasp

raspMon = RaspMonitoramento(monInfoCpuDisp, monInfoCpuUtilizada, monInfoRamDisp, monInfoRamUtilizada, monInfoTemperatura, monInfoQntdProcessos, monInfoConRede, monInfoCodRasp)

jsonRaspMon = json.dumps(raspMon, default=vars) 

print(jsonRaspMon)