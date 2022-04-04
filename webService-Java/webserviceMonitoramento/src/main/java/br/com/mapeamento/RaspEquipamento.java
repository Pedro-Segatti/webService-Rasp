/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mapeamento;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Segatti
 */
@Entity
@Table(name = "RASP_EQUIPAMENTO")
public class RaspEquipamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EQP_ID")
    private Integer eqpId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EQP_DESCRICAO")
    private String eqpDescricao;
    @Size(max = 100)
    @Column(name = "EQP_MODELO")
    private String eqpModelo;
    @Column(name = "EQP_CLIENTE")
    private Integer eqpCliente;
    @Size(max = 20)
    @Column(name = "EQP_IP")
    private String eqpIp;
    @Size(max = 100)
    @Column(name = "EQP_MAC")
    private String eqpMac;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monCodRasp")
    private List<RaspMonitoramento> raspMonitoramentoList;

    public RaspEquipamento() {
    }

    public RaspEquipamento(Integer eqpId) {
        this.eqpId = eqpId;
    }

    public RaspEquipamento(Integer eqpId, String eqpDescricao) {
        this.eqpId = eqpId;
        this.eqpDescricao = eqpDescricao;
    }

    public Integer getEqpId() {
        return eqpId;
    }

    public void setEqpId(Integer eqpId) {
        this.eqpId = eqpId;
    }

    public String getEqpDescricao() {
        return eqpDescricao;
    }

    public void setEqpDescricao(String eqpDescricao) {
        this.eqpDescricao = eqpDescricao;
    }

    public String getEqpModelo() {
        return eqpModelo;
    }

    public void setEqpModelo(String eqpModelo) {
        this.eqpModelo = eqpModelo;
    }

    public Integer getEqpCliente() {
        return eqpCliente;
    }

    public void setEqpCliente(Integer eqpCliente) {
        this.eqpCliente = eqpCliente;
    }

    public String getEqpIp() {
        return eqpIp;
    }

    public void setEqpIp(String eqpIp) {
        this.eqpIp = eqpIp;
    }

    public String getEqpMac() {
        return eqpMac;
    }

    public void setEqpMac(String eqpMac) {
        this.eqpMac = eqpMac;
    }

    public List<RaspMonitoramento> getRaspMonitoramentoList() {
        return raspMonitoramentoList;
    }

    public void setRaspMonitoramentoList(List<RaspMonitoramento> raspMonitoramentoList) {
        this.raspMonitoramentoList = raspMonitoramentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqpId != null ? eqpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RaspEquipamento)) {
            return false;
        }
        RaspEquipamento other = (RaspEquipamento) object;
        if ((this.eqpId == null && other.eqpId != null) || (this.eqpId != null && !this.eqpId.equals(other.eqpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.mapeamento.RaspEquipamento[ eqpId=" + eqpId + " ]";
    }
    
}
