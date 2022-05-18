from RaspMonitoramento import RaspMonitoramento 
import subprocess
import sys

class MonitoramentoUtil:

    @staticmethod
    def executeCommandPreencheObject():
        #Comandos a serem executados no cmd 
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

        #Informações recuperadas do cmd após execução dos comandos
        monInfoCpuDisp = subprocess.check_output(cmdCpuDisp).decode(sys.stdout.encoding)
        monInfoCpuUtilizada = subprocess.check_output(cmdCpuDispUtilizada).decode(sys.stdout.encoding)
        monInfoRamDisp = subprocess.check_output(cmdRamDisp).decode(sys.stdout.encoding)
        monInfoRamUtilizada = subprocess.check_output(cmdRamUtilizada).decode(sys.stdout.encoding)
        monInfoDiscoDisp = subprocess.check_output(cmdRamDisp).decode(sys.stdout.encoding)
        monInfoDiscoUtilizado = subprocess.check_output(cmdRamDisp).decode(sys.stdout.encoding)
        monInfoTemperatura = subprocess.check_output(cmdTemperatura).decode(sys.stdout.encoding)
        monInfoQntdProcessos = subprocess.check_output(cmdQntdProcessos).decode(sys.stdout.encoding)
        monInfoConRede = True
        monCodRasp = codRasp

        #Criamos o objeto a partir das informações recuperadas do cmd
        raspMon = RaspMonitoramento(monInfoCpuDisp, monInfoCpuUtilizada, monInfoRamDisp, monInfoRamUtilizada, monInfoDiscoDisp, monInfoDiscoUtilizado, monInfoTemperatura, monInfoQntdProcessos, monInfoConRede, monCodRasp)

        #Recuperamos apenas o primeiro número recuperado do cmd, que diz respeito a informação solicitada
        raspMon.monInfoCpuDisp = raspMon.removerCaracteresEspeciais(raspMon.monInfoCpuDisp)[1]
        raspMon.monInfoCpuUtilizada = raspMon.removerCaracteresEspeciais(raspMon.monInfoCpuUtilizada)[1]
        raspMon.monInfoRamDisp = raspMon.removerCaracteresEspeciais(raspMon.monInfoRamDisp)[1]
        raspMon.monInfoRamUtilizada = raspMon.removerCaracteresEspeciais(raspMon.monInfoRamUtilizada)[1]
        raspMon.monInfoDiscoDisp = raspMon.removerCaracteresEspeciais(raspMon.monInfoDiscoDisp)[1]
        raspMon.monInfoDiscoUtilizado = raspMon.removerCaracteresEspeciais(raspMon.monInfoDiscoUtilizado)[1]
        raspMon.monInfoTemperatura = raspMon.removerCaracteresEspeciais(raspMon.monInfoTemperatura)[1]
        raspMon.monInfoQntdProcessos = raspMon.removerCaracteresEspeciais(raspMon.monInfoQntdProcessos)[1]

        return raspMon
