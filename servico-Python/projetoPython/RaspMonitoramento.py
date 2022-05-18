import json
import string
import re


class RaspMonitoramento:

    def __init__(self, monInfoCpuDisp, monInfoCpuUtilizada, monInfoRamDisp, monInfoRamUtilizada, monInfoDiscoDisp, monInfoDiscoUtilizado, monInfoTemperatura, monInfoQntdProcessos, monInfoConRede, monCodRasp):
        self.monInfoCpuDisp = monInfoCpuDisp
        self.monInfoCpuUtilizada = monInfoCpuUtilizada
        self.monInfoRamDisp = monInfoRamDisp
        self.monInfoRamUtilizada = monInfoRamUtilizada
        self.monInfoDiscoDisp = monInfoDiscoDisp
        self.monInfoDiscoUtilizado = monInfoDiscoUtilizado
        self.monInfoTemperatura = monInfoTemperatura
        self.monInfoQntdProcessos = monInfoQntdProcessos
        self.monInfoConRede = monInfoConRede
        self.monCodRasp = monCodRasp
        
    def toJSON(self):
        return {"monInfoCpuDisp":self.monInfoCpuDisp,"monInfoCpuUtilizada":self.monInfoCpuUtilizada,"monInfoRamDisp":self.monInfoRamDisp,"monInfoRamUtilizada":self.monInfoRamUtilizada,"monInfoDiscoDisp":self.monInfoDiscoDisp,"monInfoDiscoUtilizado":self.monInfoDiscoUtilizado,"monInfoTemperatura":self.monInfoTemperatura,"monInfoQntdProcessos":self.monInfoQntdProcessos,"monInfoConRede":True,"monCodRasp":1}


    def removerCaracteresEspeciais(self, text):
        return re.findall(r'\d+', text) 
