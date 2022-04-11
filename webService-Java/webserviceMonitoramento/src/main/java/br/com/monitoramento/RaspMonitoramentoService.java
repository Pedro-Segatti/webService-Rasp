/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.monitoramento;

import br.com.ConexaoBD.CrudService;
import br.com.Utils.JsonUtil;
import br.com.Utils.RaspMonitoramentoAux;
import br.com.mapeamento.RaspEquipamento;
import br.com.mapeamento.RaspMonitoramento;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.json.JsonObject;
import javax.json.JsonValue;
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
public class RaspMonitoramentoService {

    private static final Gson gson = new Gson();
    
    @EJB
    private CrudService crudService;

    public RaspMonitoramentoService() {
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("info/post")
    public String postJson(JsonObject json) {
        boolean isJsonValido = JsonUtil.validaEstruturaJson(json.toString());
        if (!isJsonValido) {
            return "Estrutura Json Inválida, revise a formatação do Json";
        }
        isJsonValido = JsonUtil.validaEstruturaJson(getJsonSchema(), json.toString());
        if (!isJsonValido) {
            return "Json com informações inválidas!";
        }

        JsonValue codigoRasp = json.get("monCodRasp");
        
        RaspEquipamento raspberry = crudService.procurar(RaspEquipamento.class, Integer.valueOf(codigoRasp.toString()));

        RaspMonitoramentoAux infosMonitoramento = gson.fromJson(json.toString(), RaspMonitoramentoAux.class);
        RaspMonitoramento raspMon = convertObject(infosMonitoramento);
        raspMon.setMonCodRasp(raspberry);
        crudService.salvar(raspMon);
        
        System.out.println(infosMonitoramento.getMonInfoRamUtilizada());
        return "ds";
    }

    private String getJsonSchema() {
        try {
            InputStream inputStream = RaspMonitoramentoService.class.getClassLoader().getResourceAsStream("/json/schemaJson.json");
            String schema = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            return schema;
        } catch (IOException ex) {
            Logger.getLogger(RaspMonitoramentoService.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
    
    private RaspMonitoramento convertObject(RaspMonitoramentoAux objAux){
        RaspMonitoramento raspMon = new RaspMonitoramento();
        raspMon.setMonDataInfo(new Date());
        raspMon.setMonInfoConRede(objAux.getMonInfoConRede());
        raspMon.setMonInfoCpuDisp(objAux.getMonInfoCpuDisp());
        raspMon.setMonInfoCpuUtilizada(objAux.getMonInfoCpuUtilizada());
        raspMon.setMonInfoDiscoDisp(objAux.getMonInfoDiscoDisp());
        raspMon.setMonInfoDiscoUtilizado(objAux.getMonInfoDiscoUtilizado());
        raspMon.setMonInfoQntdProcessos(objAux.getMonInfoQntdProcessos());
        raspMon.setMonInfoRamDisp(objAux.getMonInfoRamDisp());
        raspMon.setMonInfoRamUtilizada(objAux.getMonInfoRamUtilizada());
        raspMon.setMonInfoTemperatura(objAux.getMonInfoTemperatura());
        
        return raspMon;
    }
}
