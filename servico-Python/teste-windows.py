import subprocess

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
cmdCodRasp = [1]

#info
monInfoCpuDisp = subprocess.run(cmdCpuDisp)
monInfoCpuUtilizada = subprocess.run(cmdCpuDispUtilizada)

monInfoRamDisp = subprocess.run(cmdRamDisp)
monInfoRamUtilizada = subprocess.run(cmdRamUtilizada)

monInfoTemperatura = subprocess.run(cmdTemperatura)
monInfoQntdProcessos = subprocess.run(cmdQntdProcessos)

monInfoConRede = True
monInfoCodRasp = cmdCodRasp


print (monInfoRamUtilizada) 
