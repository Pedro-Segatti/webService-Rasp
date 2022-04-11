/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Utils;

import br.com.mapeamento.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Segatti
 */
public class RaspMonitoramentoAux {

    private Integer monId;
    private Date monDataInfo;
    private String monInfoCpuDisp;
    private String monInfoCpuUtilizada;
    private String monInfoRamDisp;
    private String monInfoRamUtilizada;
    private String monInfoDiscoDisp;
    private String monInfoDiscoUtilizado;
    private String monInfoTemperatura;
    private String monInfoQntdProcessos;
    private Boolean monInfoConRede;
    private Integer monCodRasp;

    public RaspMonitoramentoAux() {
    }

    public RaspMonitoramentoAux(Integer monId) {
        this.monId = monId;
    }

    public RaspMonitoramentoAux(Integer monId, Date monDataInfo) {
        this.monId = monId;
        this.monDataInfo = monDataInfo;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Date getMonDataInfo() {
        return monDataInfo;
    }

    public void setMonDataInfo(Date monDataInfo) {
        this.monDataInfo = monDataInfo;
    }

    public String getMonInfoCpuDisp() {
        return monInfoCpuDisp;
    }

    public void setMonInfoCpuDisp(String monInfoCpuDisp) {
        this.monInfoCpuDisp = monInfoCpuDisp;
    }

    public String getMonInfoCpuUtilizada() {
        return monInfoCpuUtilizada;
    }

    public void setMonInfoCpuUtilizada(String monInfoCpuUtilizada) {
        this.monInfoCpuUtilizada = monInfoCpuUtilizada;
    }

    public String getMonInfoRamDisp() {
        return monInfoRamDisp;
    }

    public void setMonInfoRamDisp(String monInfoRamDisp) {
        this.monInfoRamDisp = monInfoRamDisp;
    }

    public String getMonInfoRamUtilizada() {
        return monInfoRamUtilizada;
    }

    public void setMonInfoRamUtilizada(String monInfoRamUtilizada) {
        this.monInfoRamUtilizada = monInfoRamUtilizada;
    }

    public String getMonInfoDiscoDisp() {
        return monInfoDiscoDisp;
    }

    public void setMonInfoDiscoDisp(String monInfoDiscoDisp) {
        this.monInfoDiscoDisp = monInfoDiscoDisp;
    }

    public String getMonInfoDiscoUtilizado() {
        return monInfoDiscoUtilizado;
    }

    public void setMonInfoDiscoUtilizado(String monInfoDiscoUtilizado) {
        this.monInfoDiscoUtilizado = monInfoDiscoUtilizado;
    }

    public String getMonInfoTemperatura() {
        return monInfoTemperatura;
    }

    public void setMonInfoTemperatura(String monInfoTemperatura) {
        this.monInfoTemperatura = monInfoTemperatura;
    }

    public String getMonInfoQntdProcessos() {
        return monInfoQntdProcessos;
    }

    public void setMonInfoQntdProcessos(String monInfoQntdProcessos) {
        this.monInfoQntdProcessos = monInfoQntdProcessos;
    }

    public Boolean getMonInfoConRede() {
        return monInfoConRede;
    }

    public void setMonInfoConRede(Boolean monInfoConRede) {
        this.monInfoConRede = monInfoConRede;
    }

    public Integer getMonCodRasp() {
        return monCodRasp;
    }

    public void setMonCodRasp(Integer monCodRasp) {
        this.monCodRasp = monCodRasp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (monId != null ? monId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RaspMonitoramentoAux)) {
            return false;
        }
        RaspMonitoramentoAux other = (RaspMonitoramentoAux) object;
        if ((this.monId == null && other.monId != null) || (this.monId != null && !this.monId.equals(other.monId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.mapeamento.RaspMonitoramento[ monId=" + monId + " ]";
    }

}
