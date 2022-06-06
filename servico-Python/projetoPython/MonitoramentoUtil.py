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
        cmdDiscoDisp =  ['df', '-h']
        cmdDiscoUtilizado = ['df', '-h']
        cmdTemperatura =  ['dstat', '-c', '1', '1']
        cmdQntdProcessos = ['ps', '-e', '|', 'wc', '-l']
        codRasp = 1 

        try:
            #Informações recuperadas do cmd após execução dos comandos
            monInfoCpuDisp = subprocess.check_output(cmdCpuDisp).decode(sys.stdout.encoding)
            monInfoCpuUtilizada = subprocess.check_output(cmdCpuDispUtilizada).decode(sys.stdout.encoding)
            monInfoRamDisp = subprocess.check_output(cmdRamDisp).decode(sys.stdout.encoding)
            monInfoRamUtilizada = subprocess.check_output(cmdRamUtilizada).decode(sys.stdout.encoding)
            monInfoDiscoDisp = subprocess.check_output(cmdDiscoDisp).decode(sys.stdout.encoding)
            monInfoDiscoUtilizado = subprocess.check_output(cmdDiscoUtilizado).decode(sys.stdout.encoding)
            monInfoTemperatura = subprocess.check_output(cmdTemperatura).decode(sys.stdout.encoding)
            monInfoQntdProcessos = subprocess.check_output(cmdQntdProcessos).decode(sys.stdout.encoding)
            monInfoConRede = True
            monCodRasp = codRasp
        except Exception as e:
            print('Os comandos solicitados não foram executados da forma correta, gerando erros no console: ' + e)

        #Criamos o objeto a partir das informações recuperadas do cmd
        raspMon = RaspMonitoramento(monInfoCpuDisp, monInfoCpuUtilizada, monInfoRamDisp, monInfoRamUtilizada, monInfoDiscoDisp, monInfoDiscoUtilizado, monInfoTemperatura, monInfoQntdProcessos, monInfoConRede, monCodRasp)
        
        try:
            #Recuperamos apenas o primeiro número recuperado do cmd, que diz respeito a informação solicitada
            raspMon.monInfoCpuDisp = raspMon.removerCaracteresEspeciais(raspMon.monInfoCpuDisp)[2]
            raspMon.monInfoCpuUtilizada = str(int(raspMon.removerCaracteresEspeciais(raspMon.monInfoCpuUtilizada)[0]) + int(raspMon.removerCaracteresEspeciais(raspMon.monInfoCpuUtilizada)[1]))
            raspMon.monInfoRamDisp = raspMon.removerCaracteresEspeciais(raspMon.monInfoRamDisp)[1]
            raspMon.monInfoRamUtilizada = raspMon.removerCaracteresEspeciais(raspMon.monInfoRamUtilizada)[0] 
            raspMon.monInfoDiscoDisp = raspMon.removerCaracteresEspeciais(raspMon.monInfoDiscoDisp)[2]
            raspMon.monInfoDiscoUtilizado = raspMon.removerCaracteresEspeciais(raspMon.monInfoDiscoUtilizado)[1]
            raspMon.monInfoTemperatura = raspMon.removerCaracteresEspeciais(raspMon.monInfoTemperatura)[1] + ". " + raspMon.removerCaracteresEspeciais(raspMon.monInfoCpuUtilizada)[2]
            raspMon.monInfoQntdProcessos = raspMon.removerCaracteresEspeciais(raspMon.monInfoQntdProcessos)[0]
        except Exception as e:
            print('A leituta dos comandos e extração das informações pertinentes geraram uma exceção: ' + e)

        return raspMon

