/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mapeamento;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Segatti
 */
@Entity
@Table(name = "RASP_MONITORAMENTO")
public class RaspMonitoramento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MON_ID")
    private Integer monId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MON_DATA_INFO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date monDataInfo;
    @Size(max = 100)
    @Column(name = "MON_INFO_RAM_DISP")
    private String monInfoRamDisp;
    @Size(max = 100)
    @Column(name = "MON_INFO_RAM_UTILIZADA")
    private String monInfoRamUtilizada;
    @Size(max = 100)
    @Column(name = "MON_INFO_DISCO_DISP")
    private String monInfoDiscoDisp;
    @Size(max = 100)
    @Column(name = "MON_INFO_DISCO_UTILIZADO")
    private String monInfoDiscoUtilizado;
    @Size(max = 15)
    @Column(name = "MON_INFO_TEMPERATURA")
    private String monInfoTemperatura;
    @Size(max = 15)
    @Column(name = "MON_INFO_QNTD_PROCESSOS")
    private String monInfoQntdProcessos;
    @Column(name = "MON_INFO_CON_REDE")
    private Boolean monInfoConRede;
    @JoinColumn(name = "MON_COD_RASP", referencedColumnName = "EQP_ID")
    @ManyToOne(optional = false)
    private RaspEquipamento monCodRasp;

    public RaspMonitoramento() {
    }

    public RaspMonitoramento(Integer monId) {
        this.monId = monId;
    }

    public RaspMonitoramento(Integer monId, Date monDataInfo) {
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

    public RaspEquipamento getMonCodRasp() {
        return monCodRasp;
    }

    public void setMonCodRasp(RaspEquipamento monCodRasp) {
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
        if (!(object instanceof RaspMonitoramento)) {
            return false;
        }
        RaspMonitoramento other = (RaspMonitoramento) object;
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
