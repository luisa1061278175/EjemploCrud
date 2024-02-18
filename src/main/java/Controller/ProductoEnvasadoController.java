package Controller;

import Model.PersonaJuridica;
import Model.PersonaNatural;
import Model.ProductoPerecedero;
import Model.ProductosEnvasados;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductoEnvasadoController implements Initializable {


    @FXML
    private Button btnAgregar;

    @FXML
    private TableColumn colCantidadExistente;

    @FXML
    private TableColumn colCodigo;

    @FXML
    private TableColumn colFechaEnvasado;
    @FXML
    private TableColumn colPesoEnvase;

    @FXML
    private TableColumn colDescripcion;

    @FXML
    private TableColumn colNombre;

    @FXML
    private TableColumn colValorUnitario;

    @FXML
    private TableView<ProductosEnvasados> tabla;

    @FXML
    private TextField txtCantidadExistente;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtFechaEnvasado;

    @FXML
    private TextField txtPesoEnvase;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtValorUnitario;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnModificar;
    @FXML
    private Button btnRegresar;




    private ObservableList<ProductosEnvasados> productosEnvasado;


    public void initialize(URL url, ResourceBundle resourceBundle) {

        productosEnvasado = FXCollections.observableArrayList();

        this.colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        this.colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        this.colCantidadExistente.setCellValueFactory(new PropertyValueFactory<>("cantidadExistente"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colFechaEnvasado.setCellValueFactory(new PropertyValueFactory<>("fechaEnvasado"));
        this.colValorUnitario.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        this.colPesoEnvase.setCellValueFactory(new PropertyValueFactory<>("pesoEnvase"));



    }



    @FXML
    private void agregarProducto(ActionEvent event){

        String nombre= txtNombre.getText();
        int codigo= Integer.parseInt(txtCodigo.getText());
        int cantidadExistente = Integer.parseInt(txtCantidadExistente.getText());
        int valorU= Integer.parseInt(txtValorUnitario.getText());
        int pesoEnvasado= Integer.parseInt(txtPesoEnvase.getText());
        String fechaEnvasado= txtFechaEnvasado.getText();
        String descripcion=txtDescripcion.getText();


        txtPesoEnvase.setText("");
        txtCodigo.setText("");
        txtDescripcion.setText("");
        txtNombre.setText("");
        txtFechaEnvasado.setText("");
        txtValorUnitario.setText("");
        txtCantidadExistente.setText("");


        ProductosEnvasados p= new ProductosEnvasados(codigo,nombre,descripcion,valorU,cantidadExistente,fechaEnvasado,pesoEnvasado);

        this.productosEnvasado.add(p);
        this.tabla.setItems(productosEnvasado);


    }

    @FXML
    private void regresar(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Cierra la ventana
        stage.close();
    }


    @FXML
    private void seleccionar(MouseEvent event) {

        ProductosEnvasados p = this.tabla.getSelectionModel().getSelectedItem();

    }

    @FXML
    private void eliminar() {

        ProductosEnvasados p = this.tabla.getSelectionModel().getSelectedItem();


        this.productosEnvasado.remove(p);
        this.tabla.refresh();


    }

    @FXML
    private void modificar() {

        ProductosEnvasados p = this.tabla.getSelectionModel().getSelectedItem();

        String nombre = txtNombre.getText();
        int codigo = Integer.parseInt(txtCodigo.getText());
        int cantidadExistente = Integer.parseInt(txtCantidadExistente.getText());
        int valorU = Integer.parseInt(txtValorUnitario.getText());
        int pesoEnvasado = Integer.parseInt(txtPesoEnvase.getText());
        String fechaEnvasado = txtFechaEnvasado.getText();
        String descripcion = txtDescripcion.getText();

        ProductosEnvasados aux = new ProductosEnvasados(codigo, nombre, descripcion, valorU, cantidadExistente, fechaEnvasado, pesoEnvasado);


        p.setNombre(aux.getNombre());
        p.setCodigo(aux.getCodigo());
        p.setCantidadExistente(aux.getCantidadExistente());
        p.setValorUnitario(aux.getValorUnitario());
        p.setPesoEnvase(aux.getPesoEnvase());
        p.setFechaEnvasado(aux.getFechaEnvasado());
        p.setDescripcion(aux.getDescripcion());

        this.tabla.refresh();


    }


}








