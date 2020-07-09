/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.controllers;

import apn.gob.pe.secajur.beans.*;
import apn.gob.pe.secajur.service.*;
import apn.gob.pe.secajur.utiles.Constantes;
import apn.gob.pe.secajur.utiles.DateUtil;
import apn.gob.pe.secajur.utiles.GestSesion;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Desarrollo
 */
@ManagedBean(name = "mbcaso")
@SessionScoped
@ViewScoped
public class MBCaso implements Serializable {

    private static final Logger console = Logger.getLogger(MBCaso.class.getName());
    private CasoService casoService = new CasoServiceImpl();
    private CatalologoService catalologoService = new CatalologoServiceImpl();
    private LogService logService = new LogServiceImpl();
    private AppCaso objCaso;
    private AppCasoIncidencia appCasoIncidencia;
    private AppCasoIncidencia appCasoIncidencia_select;
    private Date fechaSys;
    private String fechaSysedit;
    private String diffdias;
    private AppCaso appCasoTemporal;
    private AppCaso appCasoDetalle_View = new AppCaso();
    
    private String appCasoDetalle_View_Code;
    private UploadedFile file;
    private UploadedFile file2;
    private UploadedFile file3;
    private StreamedContent fileDownload;
    private StreamedContent fileDownload2;
    private StreamedContent fileDownload3;

    public StreamedContent getFileDownload2() {
        return fileDownload2;
    }

    public void setFileDownload2(StreamedContent fileDownload2) {
        this.fileDownload2 = fileDownload2;
    }

    public StreamedContent getFileDownload3() {
        return fileDownload3;
    }

    public void setFileDownload3(StreamedContent fileDownload3) {
        this.fileDownload3 = fileDownload3;
    }

    public StreamedContent getFileDownload() {
        return fileDownload;
    }

    public void setFileDownload(StreamedContent fileDownload) {
        this.fileDownload = fileDownload;
    }
    
    public UploadedFile getFile2() {
        return file2;
    }

    public void setFile2(UploadedFile file2) {
        this.file2 = file2;
    }

    public UploadedFile getFile3() {
        return file3;
    }

    public void setFile3(UploadedFile file3) {
        this.file3 = file3;
    }
    private List<String> abogados;
    private String abogado;
    private List<String> demandantes;
    private String demandante;
    private List<String> demandados;
    private String demandado;

    public String getAbogado() {
        return abogado;
    }

    public void setAbogado(String abogado) {
        this.abogado = abogado;
    }
    
    public List<String> getAbogados() { 
        if (abogados == null)
            abogados = new ArrayList<>();
        return abogados;
    }

    public void setAbogados(List<String> abogados) {
        this.abogados = abogados;
    }
    
    public void agregarAbogados(){
        if (abogado.length()>0){
        this.getAbogados().add(abogado);
        }
        abogado = "";
    }
    
    public void eliminarAbogado(String nombre, String op){
        if (op.equals("I")){
            String resultado = this.getAbogados().stream().filter(e -> nombre.equals(e)).findAny().orElse(null);
            if (Optional.ofNullable(resultado).isPresent()) {
                this.getAbogados().remove(resultado);
            }
        }
        else{
            AppCasoAbogado res2 = appCasoDetalle_View.getAppCasoAbogadoList().stream().filter(i -> i.getAppCasoAbogadoPK().getCasoAbogado().equals(nombre)).findAny().orElse(null);
            if (Optional.ofNullable(res2).isPresent()) {
                appCasoDetalle_View.getAppCasoAbogadoList().remove(res2);
                String lstAbogados = this.getAbogados().stream().filter(i -> i.equals(nombre)).findAny().orElse(null);
                this.getAbogados().remove(lstAbogados);
            }    
        }
    }

    public String getDemandante() {
        return demandante;
    }

    public void setDemandante(String demandante) {
        this.demandante = demandante;
    }

    public List<String> getDemandantes() {
        if (demandantes == null)
            demandantes = new ArrayList<>();
        return demandantes;
    }

    public void setDemandantes(List<String> demandantes) {
        this.demandantes = demandantes;
    }

    public void agregarDemandantes(){
        if (demandante.length()>0){
        this.getDemandantes().add(demandante);
        }
        demandante = "";
    }
    
    
    public void eliminarDemandante(String nombre, String op){
        if (op.equals("I")){
            String resultado = this.getDemandantes().stream().filter(e -> nombre.equals(e)).findAny().orElse(null);
            if (Optional.ofNullable(resultado).isPresent()) {
                this.getDemandantes().remove(resultado);
            }    
        }
        else{
            AppCasoDemandante res3 = appCasoDetalle_View.getAppCasoDemandanteList().stream().filter(i -> i.getAppCasoDemandantePK().getCasoDemandante().equals(nombre)).findAny().orElse(null);
            if (Optional.ofNullable(res3).isPresent()) {
                appCasoDetalle_View.getAppCasoDemandanteList().remove(res3);
                String lstDemandantes = this.getDemandantes().stream().filter(i -> i.equals(nombre)).findAny().orElse(null);
                this.getDemandantes().remove(lstDemandantes);
            }
        }      
    }
    
    public String getDemandado() {
        return demandado;
    }

    public void setDemandado(String demandado) {
        this.demandado = demandado;
    }

    public List<String> getDemandados() {
        if (demandados == null)
            demandados = new ArrayList<>();
        return demandados;
    }

    public void setDemandados(List<String> demandados) {
        this.demandados = demandados;
    }

    public void agregarDemandados(){
        if (demandado.length()>0){
        this.getDemandados().add(demandado);
        }
        demandado = "";
    }
    
    public void eliminarDemandado(String nombre, String op){   
        if (op.equals("I")){
            String resultado = this.getDemandados().stream().filter(e -> nombre.equals(e)).findAny().orElse(null);
            if (Optional.ofNullable(resultado).isPresent()) {
                this.getDemandados().remove(resultado);
            }
        }
        else{
            AppCasoDemandado res4 = appCasoDetalle_View.getAppCasoDemandadoList().stream().filter(i -> i.getAppCasoDemandadoPK().getCasoDemandado().equals(nombre)).findAny().orElse(null);
            if (Optional.ofNullable(res4).isPresent()) {
                appCasoDetalle_View.getAppCasoDemandadoList().remove(res4);
                String lstDemandados = this.getDemandados().stream().filter(i -> i.equals(nombre)).findAny().orElse(null);
                this.getDemandados().remove(lstDemandados);
            }
        }
    }
    
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    private String gui = UUID.randomUUID().toString().toUpperCase();
    private String ajax_formato_exp;
    private GestSesion sesionusuario = new GestSesion();
    private AppCatdata cat_tipoExpediente;

    public int getAleatorio(){
        Random rnd = new Random();
        return  rnd.nextInt(30);
    }
    public MBCaso() {
        objCaso = new AppCaso();
        appCasoIncidencia = new AppCasoIncidencia();
        appCasoIncidencia_select = new AppCasoIncidencia();
        appCasoTemporal = new AppCaso();
        fechaSysedit = Constantes.DATE_FECHA_FORMATO_TEXTO;
        fechaSys = Constantes.DATE_FECHA_FORMATO_DATE;
        appCasoIncidencia.setIncAlrtDat1(fechaSys);
        cat_tipoExpediente = new AppCatdata();
    }

    public AppCasoIncidencia getAppCasoIncidencia_select() {
        return appCasoIncidencia_select;
    }

    public void setAppCasoIncidencia_select(AppCasoIncidencia appCasoIncidencia_select) {
        this.appCasoIncidencia_select = appCasoIncidencia_select;
    }

    public void restarfechas(SelectEvent event) {
        int eval = appCasoIncidencia.getIncAlrtDat1().compareTo(appCasoIncidencia.getIncAlrtDat2());
        if (eval == 0) {
            diffdias = "Las fechas no deben ser iguales";
        } else if (eval > 0) {
            diffdias = "La fecha de inicio debe ser menor a la final";
        } else {
            diffdias = DateUtil.diferenciaendiasdefechasTexto(appCasoIncidencia.getIncAlrtDat1(), appCasoIncidencia.getIncAlrtDat2()) * -1 + " días, en intervalo de :";
        }
    }

    public void alertaOk(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void alertaError(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void grabarCasoPrint(String opcion) {
        try {
                console.log(Level.SEVERE, "appCasoDetalle_View:>>>>>>>>" + appCasoDetalle_View.toString());
                console.log(Level.SEVERE, "appCasoDetalle_View - List:>>>>>>>>" + appCasoDetalle_View.getAppCasoDemandadoList());
                int idtmp=appCasoDetalle_View.getCasoCod();
                List<AppCasoAbogado> appCasoAbogadoList = new ArrayList<>();
                abogados.forEach(e->{
                    AppCasoAbogado appabogado = new AppCasoAbogado();
                    AppCasoAbogadoPK appCasoAbogadoPK = new AppCasoAbogadoPK();
                    appCasoAbogadoPK.setCasoAbogado(e);
                    appCasoAbogadoPK.setCasoCod(idtmp);
                    appabogado.setAppCasoAbogadoPK(appCasoAbogadoPK);
                    appCasoAbogadoList.add(appabogado);
                });
                
                List<AppCasoDemandante> appCasoDemandanteList = new ArrayList<>();
                demandantes.forEach(e->{
                    AppCasoDemandante appdemandante = new AppCasoDemandante();
                    AppCasoDemandantePK appCasoDemandantePK = new AppCasoDemandantePK();
                    appCasoDemandantePK.setCasoDemandante(e);
                    appCasoDemandantePK.setCasoCod(idtmp);
                    appdemandante.setAppCasoDemandantePK(appCasoDemandantePK);
                    appCasoDemandanteList.add(appdemandante);
                });
                 
                List<AppCasoDemandado> appCasoDemandadoList = new ArrayList<>();
                demandados.forEach(e->{
                    AppCasoDemandado appdemandado = new AppCasoDemandado();
                    AppCasoDemandadoPK appCasoDemandadoPK = new AppCasoDemandadoPK();
                    appCasoDemandadoPK.setCasoDemandado(e);
                    appCasoDemandadoPK.setCasoCod(idtmp);
                    appdemandado.setAppCasoDemandadoPK(appCasoDemandadoPK);
                    appCasoDemandadoList.add(appdemandado);
                });
                
                appCasoDetalle_View.setAppCasoAbogadoList(appCasoAbogadoList);
                appCasoDetalle_View.setAppCasoDemandadoList(appCasoDemandadoList);
                appCasoDetalle_View.setAppCasoDemandanteList(appCasoDemandanteList);  
                console.log(Level.SEVERE, "Demandados: " + appCasoDetalle_View.getAppCasoDemandadoList());
            AppCaso casoTemp = casoService.obtenerCaso(Integer.parseInt(appCasoDetalle_View_Code.replace(" ","")));    
            
            if (file != null && file.getContents().length>0){
                appCasoDetalle_View.setCasoArchivo1(file.getContents());
            }else{
                appCasoDetalle_View.setCasoArchivo1(casoTemp.getCasoArchivo1());
            }
            
            if (file2 != null && file2.getContents().length>0){
                appCasoDetalle_View.setCasoArchivo2(file2.getContents());
            }else{
                appCasoDetalle_View.setCasoArchivo2(casoTemp.getCasoArchivo2());
            }
            
            if (file3 != null && file3.getContents().length>0){
                appCasoDetalle_View.setCasoArchivo3(file3.getContents());
            }else{
                appCasoDetalle_View.setCasoArchivo3(casoTemp.getCasoArchivo3());
            }
            casoService.grabarCaso(appCasoDetalle_View, opcion);
            alertaOk("Caso actualizado correctamente");

            logService.grabarLogUser("Caso", "Actualización de caso de Legajo:" + appCasoDetalle_View.getCasoLegajo(), sesionusuario.obtenerUsuarioSesion());
        } catch (Exception e) {
            alertaError("Ocurrió un error en el sistema");
            e.printStackTrace();
        }
    }

    public void grabarCaso(String opcion) {
        Date date = new Date();
        objCaso.setCasoFechareg(date);
                
        if (objCaso.getCasoTipoproceso() == -100) {
            alertaError("Seleccione el tipo de proceso");
        } else if (objCaso.getCasoExped().length() <= 0) {
            alertaError("Ingrese N° de Expediente");
        } else if (objCaso.getCasoLegajo().length() <= 0) {
            alertaError("Ingrese N° de Legajo");
        } else if (objCaso.getCasoMateria() == -100) {
            alertaError("Seleccione la materia");
        } else if (objCaso.getCasoEstado() <= 0) {
            alertaError("Seleccione el estado del caso legal");
        } else if (objCaso.getCasoDependencia().length() <= 0) {
            alertaError("Ingrese la dependencia");
        } else {
            try {
                try {
                    objCaso.setCasoUsuario(sesionusuario.obtenerUsuarioSesion().getUsrId() + "");
                } catch (Exception e) {
                }                
                
                objCaso.setCasoExped(objCaso.getCasoExped().toUpperCase());
                objCaso.setCasoLegajo(objCaso.getCasoLegajo().toUpperCase());
                objCaso.setCasoJuzgado(objCaso.getCasoJuzgado().toUpperCase());
                int idtmp=casoService.obtenerIdCaso();
                               
                List<AppCasoAbogado> appCasoAbogadoList = new ArrayList<>();
                abogados.forEach(e->{
                    AppCasoAbogado appabogado = new AppCasoAbogado();
                    AppCasoAbogadoPK appCasoAbogadoPK = new AppCasoAbogadoPK();
                    appCasoAbogadoPK.setCasoAbogado(e);
                    appCasoAbogadoPK.setCasoCod(idtmp);
                    appabogado.setAppCasoAbogadoPK(appCasoAbogadoPK);
                    appCasoAbogadoList.add(appabogado);
                });
                
                List<AppCasoDemandante> appCasoDemandanteList = new ArrayList<>();
                demandantes.forEach(e->{
                    AppCasoDemandante appdemandante = new AppCasoDemandante();
                    AppCasoDemandantePK appCasoDemandantePK = new AppCasoDemandantePK();
                    appCasoDemandantePK.setCasoDemandante(e);
                    appCasoDemandantePK.setCasoCod(idtmp);
                    appdemandante.setAppCasoDemandantePK(appCasoDemandantePK);
                    appCasoDemandanteList.add(appdemandante);
                });
                 
                List<AppCasoDemandado> appCasoDemandadoList = new ArrayList<>();
                demandados.forEach(e->{
                    AppCasoDemandado appdemandado = new AppCasoDemandado();
                    AppCasoDemandadoPK appCasoDemandadoPK = new AppCasoDemandadoPK();
                    appCasoDemandadoPK.setCasoDemandado(e);
                    appCasoDemandadoPK.setCasoCod(idtmp);
                    appdemandado.setAppCasoDemandadoPK(appCasoDemandadoPK);
                    appCasoDemandadoList.add(appdemandado);
                });
                
                objCaso.setCasoArchivo1(file.getContents());
                objCaso.setCasoArchivo2(file2.getContents());
                objCaso.setCasoArchivo3(file3.getContents());
                objCaso.setAppCasoAbogadoList(appCasoAbogadoList);
                objCaso.setAppCasoDemandanteList(appCasoDemandanteList);
                objCaso.setAppCasoDemandadoList(appCasoDemandadoList);
                objCaso.setCasoCod(idtmp);
                String msg = casoService.grabarCaso(objCaso, opcion);
                console.log(Level.INFO, "Se grabó el caso exitosamente: " + objCaso.getCasoEstado());
                alertaOk("Mensaje del sistema: " + msg);
                logService.grabarLogUser("Caso", "Registro de Caso - Legajo:" + objCaso.getCasoLegajo(), sesionusuario.obtenerUsuarioSesion());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                objCaso = null;
                objCaso = new AppCaso();
            }

        }
    }

    public int getAjax_estado() {
        return ajax_estado;
    }

    public void setAjax_estado(int ajax_estado) {
        this.ajax_estado = ajax_estado;
    }

    int ajax_estado;
    static int vartemp;

    public void ajax_actualiza_caso(AppCaso s) {
        s.setCasoEstado(ajax_estado);
        vartemp = ajax_estado;
        appCasoTemporal = s;
    }

    public void ajax_get_formato(int tipoajax) {
        switch (objCaso.getCasoTipoproceso()) {
            case -100: //-100 CODIGO SI NO SELECCIO NADA
                break;
            default:
                switch (tipoajax) {
                            case 0:
                                ajax_formato_exp = catalologoService.obtenerSubCatalogo(objCaso.getCasoTipoproceso()).getCatDetaformato();
                                break;
            }
        }
    }

    public String obtenerIncidencia(int id) {
        return "listarcasos";
    }

    public void grabarCasoIncidencia(AppCaso obj) {
        appCasoIncidencia.setIncFlag(1);
        Date date = new Date();
        appCasoIncidencia.setIncFec(date);        
        if (appCasoIncidencia.getIncDes().isEmpty()) {
            console.log(Level.SEVERE, "No se puede registrar una incidencia vacía");
            alertaError("No se puede registrar una incidencia vacía");

        } else {
            try {
                appCasoIncidencia.setInc_Para(sesionusuario.obtenerUsuarioSesion().getAppPersona().getPerEmail());
                String[] lineas = appCasoIncidencia.getInc_Copias().split("\n");

                appCasoIncidencia.setInc_Copias("");
                for (int i = 0; i < lineas.length; i++) {
                    appCasoIncidencia.setInc_Copias(appCasoIncidencia.getInc_Copias() + lineas[i].replace(" ", "") + ";");
                }
                
                if (appCasoIncidencia.getInc_Copias().replace(" ","") .startsWith(";"))
                {
                   appCasoIncidencia.setInc_Copias("");
                }
                
                casoService.registrarIncidencia(obj.getCasoCod(), appCasoIncidencia, "I");
                appCasoIncidencia = null;
                appCasoIncidencia = new AppCasoIncidencia();

                alertaOk("Incidencia registrada");
                logService.grabarLogUser("Caso", "Nueva incidencia registrada para el caso: " + obj.getCasoCod(), sesionusuario.obtenerUsuarioSesion());
            } catch (Exception e) {
                console.log(Level.SEVERE, "Error de registro: " + e.getMessage());
                alertaError("Error de registro: " + e.getMessage());
            }
        }
    }

    public void actualizarCasoIncidencia(AppCaso obj) {

        obj = appCasoIncidencia_select.getAppCaso();
        if (appCasoIncidencia_select.getIncDes().isEmpty() ) {
            console.log(Level.SEVERE, "No se puede registrar una incidencia vacía");
            alertaError("No se puede registrar una incidencia vacía");
        } else {
            try {
                String[] lineas = (appCasoIncidencia_select.getInc_Copias()).replace(";","").split("\n");
                appCasoIncidencia_select.setInc_Copias("");
                for (int i = 0; i < lineas.length; i++) {
                      appCasoIncidencia_select.setInc_Copias(appCasoIncidencia_select.getInc_Copias() + lineas[i].replace(" ", "") + ";");                    
                }
                if (appCasoIncidencia_select.getInc_Copias().replace(" ","") .startsWith(";"))
                {
                   appCasoIncidencia_select.setInc_Copias("");
                }
                
                casoService.registrarIncidencia(obj.getCasoCod(), appCasoIncidencia_select, "U");

                appCasoIncidencia_select = null;
                appCasoIncidencia_select = new AppCasoIncidencia();

                alertaOk("Incidencia actualizada");
                logService.grabarLogUser("Caso", "Actualizacion de incidencia de caso: " + obj.getCasoCod(), sesionusuario.obtenerUsuarioSesion());
            } catch (Exception e) {
                console.log(Level.SEVERE, "Error de actualizacion: " + e.getMessage());
                alertaError("Error de actualizacion: " + e.getMessage());
            }
        }
    }

    public CasoService getCasoService() {
        return casoService;
    }

    public void setCasoService(CasoService casoService) {
        this.casoService = casoService;
    }

    public AppCaso getObjCaso() {
        return objCaso;
    }

    public void setObjCaso(AppCaso objCaso) {
        this.objCaso = objCaso;
    }

    public Date getFechaSys() {
        return fechaSys;
    }

    public void setFechaSys(Date fechaSys) {
        this.fechaSys = fechaSys;
    }

    public List<AppCaso> obtenerCasos() {
        return casoService.listarCasos();
    }

    public String getFechaSysedit() {
        return fechaSysedit;
    }

    public void setFechaSysedit(String fechaSysedit) {
        this.fechaSysedit = fechaSysedit;
    }

    public AppCasoIncidencia getAppCasoIncidencia() {
        return appCasoIncidencia;
    }

    public void setAppCasoIncidencia(AppCasoIncidencia appCasoIncidencia) {
        this.appCasoIncidencia = appCasoIncidencia;
    }

    public String getDiffdias() {
        return diffdias;
    }

    public void setDiffdias(String diffdias) {
        this.diffdias = diffdias;
    }

     public AppCaso getAppCasoDetalle_View() {
        return appCasoDetalle_View;
    }

    public void setAppCasoDetalle_View(AppCaso appCasoDetalle_View) {
        this.appCasoDetalle_View = appCasoDetalle_View;
    }
    
    private String obtenerIP()  throws Exception{
        //is client behind something?

    //    HttpServletRequest request = null;
    //    String ipAddress = request.getHeader("X-FORWARDED-FOR");
    //    if (ipAddress == null) {
    //        ipAddress = request.getRemoteAddr();
    //    }
    //    return ipAddress;
    
    InetAddress address = InetAddress.getLocalHost();
        String ar = address.getHostAddress();
            return ar;
    }
    public String obtenerCaso() {
        
        try {
            
        console.log(Level.SEVERE,"IMPRIMIR ANTES DE QUITAR GUID"); 
        String tmp=appCasoDetalle_View_Code;
        appCasoDetalle_View_Code=  (tmp.substring(0,tmp.length()-36)); 
        appCasoDetalle_View = casoService.obtenerCaso(Integer.parseInt(appCasoDetalle_View_Code.replace(" ","")));
        
         appCasoDetalle_View.getAppCasoDemandadoList().forEach(d->{
         this.getDemandados().add(d.getAppCasoDemandadoPK().getCasoDemandado());
        }) ;
     
          appCasoDetalle_View.getAppCasoDemandanteList().forEach(d->{
         this.getDemandantes().add(d.getAppCasoDemandantePK().getCasoDemandante());
        }) ;
          
           appCasoDetalle_View.getAppCasoAbogadoList().forEach(d->{
         this.getAbogados().add(d.getAppCasoAbogadoPK().getCasoAbogado());
        }) ;
                   
        logService.grabarLogUser("Caso", "Impresión de caso, expediente:" + appCasoDetalle_View.getCasoExped(), sesionusuario.obtenerUsuarioSesion());
        return "";
         } catch (Exception e) {
             alertaError("Consulta incorrecta");
             return "error500";
             
        }

    }
    
     public String obtenerCasoExterno() {
        
        try {
            
           console.log(Level.SEVERE,"IMPRIMIR ANTES DE QUITAR GUID"); 
         String tmp=appCasoDetalle_View_Code;
      appCasoDetalle_View_Code=  (tmp.substring(0,tmp.length()-36)); 
        appCasoDetalle_View = casoService.obtenerCaso(Integer.parseInt(appCasoDetalle_View_Code.replace(" ","")));
        
        appCasoDetalle_View.getAppCasoDemandadoList().forEach(d->{
         this.getDemandados().add(d.getAppCasoDemandadoPK().getCasoDemandado());
        }) ;
     
          appCasoDetalle_View.getAppCasoDemandanteList().forEach(d->{
         this.getDemandantes().add(d.getAppCasoDemandantePK().getCasoDemandante());
        }) ;
          
           appCasoDetalle_View.getAppCasoAbogadoList().forEach(d->{
         this.getAbogados().add(d.getAppCasoAbogadoPK().getCasoAbogado());
        }) ;

        console.log(Level.SEVERE, "appCasoDetalle_View:>>>>>>>>" + appCasoDetalle_View.getCasoCod());
        logService.grabarLogUser("Caso", "Impresión de Caso enviado por Email, IP: " + obtenerIP() + ", expediente : " + appCasoDetalle_View.getCasoExped(), sesionusuario.obtenerUsuarioSesion());
        return "";
         } catch (Exception e) {
             alertaError("Consulta incorrecta");
             return "error500";
             
        }

    }
     
    public void descargarFile(String numeroDocumento) throws Exception {
        
        if (this.getAppCasoDetalle_View().getCasoArchivo1() != null) {
            InputStream is = new ByteArrayInputStream(this.getAppCasoDetalle_View().getCasoArchivo1());
            fileDownload = new DefaultStreamedContent(is, "application/pdf", "caso_archivo.pdf");
        }
    }
    
    public void descargarFile2(String numeroDocumento) {
        if (this.getAppCasoDetalle_View().getCasoArchivo2() != null) {
            InputStream is = new ByteArrayInputStream(this.getAppCasoDetalle_View().getCasoArchivo2());
            fileDownload2 = new DefaultStreamedContent(is, "application/pdf", "caso_archivo2.pdf");
        }
    }
    
    public void descargarFile3(String numeroDocumento) {
                
        if (this.getAppCasoDetalle_View().getCasoArchivo3() != null) {
            InputStream is = new ByteArrayInputStream(this.getAppCasoDetalle_View().getCasoArchivo3());
            fileDownload3 = new DefaultStreamedContent(is, "application/pdf", "caso_archivo3.pdf");
        }
    }

    public String getAppCasoDetalle_View_Code() {
//appCasoDetalle_View_Code=appCasoDetalle_View_Code+getAleatorio();
        return appCasoDetalle_View_Code;
    }

    public void setAppCasoDetalle_View_Code(String appCasoDetalle_View_Code) {
        this.appCasoDetalle_View_Code = appCasoDetalle_View_Code;
    }

    public String getAjax_formato_exp() {
        return ajax_formato_exp;
    }

    public void setAjax_formato_exp(String ajax_formato_exp) {
        this.ajax_formato_exp = ajax_formato_exp;
    }

    public AppCatdata getCat_tipoExpediente() {
        return cat_tipoExpediente;
    }

    public void setCat_tipoExpediente(AppCatdata cat_tipoExpediente) {
        this.cat_tipoExpediente = cat_tipoExpediente;
    }

    public String getGui() {
        return gui;
    }

    public void setGui(String gui) {
        this.gui = gui;
    }
    

}
