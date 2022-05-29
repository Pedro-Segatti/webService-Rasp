from RaspMonitoramento import RaspMonitoramento 
import subprocess
import sys

class MonitoramentoUtil:

    @staticmethod
    def executeCommandPreencheObject():
        #Comandos a serem executados no cmd 
        cmdCpuDisp = ['dstat', '-c', '1', '1']
        cmdCpuDispUtilizada = ['dstat', '-c', '1', '1']
        cmdRamDisp = ['dstat', '-m', '1', '1']
        cmdRamUtilizada = ['dstat', '-m', '1', '1']
        cmdDiscoDisp =  ['dstat', '-d', '1', '1']
        cmdDiscoUtilizado = ['dstat', '-d', '1', '1']
        cmdTemperatura =  ['dstat', '-c', '1', '1']
        cmdQntdProcessos = ['dstat', '-c', '1', '1']
        cmdConRede = ['ifconfig']
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
        raspMon.monInfoCpuDisp = raspMon.removerCaracteresEspeciais(raspMon.monInfoCpuDisp)[0]
        raspMon.monInfoCpuUtilizada = raspMon.removerCaracteresEspeciais(raspMon.monInfoCpuUtilizada)[0]
        raspMon.monInfoRamDisp = raspMon.removerCaracteresEspeciais(raspMon.monInfoRamDisp)[0]
        raspMon.monInfoRamUtilizada = raspMon.removerCaracteresEspeciais(raspMon.monInfoRamUtilizada)[0]
        raspMon.monInfoDiscoDisp = raspMon.removerCaracteresEspeciais(raspMon.monInfoDiscoDisp)[0]
        raspMon.monInfoDiscoUtilizado = raspMon.removerCaracteresEspeciais(raspMon.monInfoDiscoUtilizado)[0]
        raspMon.monInfoTemperatura = raspMon.removerCaracteresEspeciais(raspMon.monInfoTemperatura)[0]
        raspMon.monInfoQntdProcessos = raspMon.removerCaracteresEspeciais(raspMon.monInfoQntdProcessos)[0]

        return raspMon

