package uia.com.compras;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class SolicitudOrdenCompra extends InfoComprasUIA {

    private int cantidad;
    private String unidad = "";
    private String codigo = "";

    @JsonCreator
    public SolicitudOrdenCompra(@JsonProperty("id") int id, @JsonProperty("name") String name,
                                @JsonProperty("cantidad") int cantidad, @JsonProperty("unidad") String unidad,
                                @JsonProperty("codigo") String codigo) {
        super(id, name);
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.codigo = codigo;
        //this.setType(tipo);
    }

    public SolicitudOrdenCompra() {

    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public SolicitudOrdenCompra(int id, String name, String descripcion, String pza, int pedidoProveedor, String tipo) {
        super(-1, "");
    }

    public void agregaItems(PeticionOrdenCompra miSolicitudOC) {
        SolicitudOrdenCompra nodo;
        for (int i = 0; i < miSolicitudOC.getItems().size(); i++) {

            InfoComprasUIA miNodo = miSolicitudOC.getItems().get(i);
            List<InfoComprasUIA> miLista;
            if (miNodo.getPedidoProveedor() > 0) {
                nodo = new SolicitudOrdenCompra(miNodo.getId(), miNodo.getName(), miNodo.getDescripcion(),
                        "PZA", miNodo.getPedidoProveedor(), "itemsSOC");
                if (this.getItems() == null) {
                    miLista = new ArrayList<InfoComprasUIA>();
                    this.setItems((List<InfoComprasUIA>) miLista);
                }
                this.getItems().add(nodo);
            }
            miNodo.print();
        }

    }

    public void validauso(PeticionOrdenCompra miSolicitudOC) {
        SolicitudOrdenCompra nodo;
        for (int i = 0; i < miSolicitudOC.getItems().size(); i++) {
            InfoComprasUIA miNodo = miSolicitudOC.getItems().get(i);
            List<InfoComprasUIA> miLista;
            if (miNodo.getId() > 0){
                System.out.println("Item invalido, favor de revisar");

            }
        }
    }

    public void validaexistencia(PeticionOrdenCompra miSolicitudOC) {
        SolicitudOrdenCompra nodo;
        for (int i = 0; i < miSolicitudOC.getItems().size(); i++) {
            InfoComprasUIA miNodo = miSolicitudOC.getItems().get(i);
            List<InfoComprasUIA> miLista;
            if (miNodo.getItems().isEmpty()){
                System.out.println("Revisar existencia");
            }
        }
    }
}
