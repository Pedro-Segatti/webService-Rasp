/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.monitoramento;

import br.com.mapeamento.RaspEquipamento;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Date;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Segatti
 */
@Path("ws")
@RequestScoped
public class RaspMonitoramento {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RaspMonitoramento
     */
    public RaspMonitoramento() {
    }

    /**
     * Retrieves representation of an instance of br.com.monitoramento.RaspMonitoramento
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("info/get")
    public String getJson() {
        RaspEquipamento re = new RaspEquipamento();
        re.setEqpCliente(1);
        re.setEqpDescricao("fdsfds");
        re.setEqpId(1);
        re.setEqpIp("192.168.0.3");
        re.setEqpModelo("");

        Gson g = new Gson();
        return g.toJson(re);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("info/get/teste")
    public String teste() {
        br.com.mapeamento.RaspMonitoramento rpm = new br.com.mapeamento.RaspMonitoramento();
        rpm.setMonCodRasp(new RaspEquipamento());
        rpm.setMonDataInfo(new Date());
        rpm.setMonId(1);
        rpm.setMonInfoConRede(true);
        rpm.setMonInfoDiscoDisp("1");
        rpm.setMonInfoDiscoUtilizado("12");
        rpm.setMonInfoQntdProcessos("232");
        rpm.setMonInfoRamDisp("23");
        rpm.setMonInfoRamUtilizada("213");
        rpm.setMonInfoTemperatura("3");

        Gson g = new Gson();
        return g.toJson(rpm);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("info/post")
    public String postJson(JsonObject json) {

        Gson gson = new Gson();

        br.com.mapeamento.RaspMonitoramento infosMonitoramento = gson.fromJson(json, br.com.mapeamento.RaspMonitoramento.class);
        System.out.println(infosMonitoramento.getMonInfoRamUtilizada());
        return "infosMonitoramento";
    }

}
