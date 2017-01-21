package br.com.nuvemapp.exemplostellaboletofx.fxml;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.nuvemapp.exemplostellaboletofx.model.Boleto;
import br.com.nuvemapp.exemplostellaboletofx.service.BoletoService;
import br.com.nuvemapp.exemplostellaboletofx.util.MaskTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PrincipalController implements Initializable {

	private static final String BANDEIRA_BANCO_DO_BRASIL = "BANCO_DO_BRASIL";
	private static final String BANDEIRA_BANCO_ITAU = "BANCO_ITAU";
	private static final String BANDEIRA_BANCO_BRADESCO = "BANCO_BRADESCO";
	
	private Boleto boletoBean;
	
	@FXML
    private TextField nome;

    @FXML
    private MaskTextField documento;

    @FXML
    private MaskTextField valor;

    @FXML
    private TextField logradouro;

    @FXML
    private TextField bairro;

    @FXML
    private MaskTextField cep;

    @FXML
    private TextField cidade;

    @FXML
    private ComboBox<String> uf;

    @FXML
    private DatePicker vencimento;

    @FXML
    private CheckBox itau;

    @FXML
    private CheckBox brasil;

    @FXML
    private CheckBox bradesco;

    @FXML
    private Text status;

    @FXML
    private void botaoEmitir(ActionEvent event) throws FileNotFoundException, IOException {

        BoletoService boletoService = new BoletoService();

        String opcao = "";

        if (vencimento.getValue() == null) {
            opcao = "0";
        }

        if (!itau.isSelected() && !brasil.isSelected() && !bradesco.isSelected()) {
            opcao = "1";
        }

        if (nome.getText().isEmpty() || documento.getText().isEmpty() || valor.getText().isEmpty()
                || logradouro.getText().isEmpty() || bairro.getText().isEmpty()
                || cep.getText().isEmpty() || cidade.getText().isEmpty() || uf.getSelectionModel().getSelectedItem().toString().isEmpty()) {
            opcao = "2";
        }

        switch (opcao) {

            case "0":
                status.setText("Nenhum Data Selecionada");
                break;

            case "1":
                status.setText("Nenhum Banco Selecionado");
                break;

            case "2":
                status.setText("Existe campo sem dados");
                break;

            default:
            	
            	boletoBean = new Boleto();
            	
            	boletoBean.setNomePagador(nome.getText());
            	boletoBean.setDocumentoPagador(documento.getText());
            	boletoBean.setLogradouroPagador(logradouro.getText());
            	boletoBean.setBairroPagador(bairro.getText());
            	boletoBean.setCepPagador(cep.getText());
            	boletoBean.setCidadePagador(cidade.getText());
            	boletoBean.setUfPagador(uf.getSelectionModel().getSelectedItem().toString());
            	boletoBean.setValorBoleto(valor.getText());
            	boletoBean.setDiaVencimento(vencimento.getValue().getDayOfMonth());
            	boletoBean.setMesVencimento(vencimento.getValue().getMonthValue());
            	boletoBean.setAnoVencimento(vencimento.getValue().getYear());
            	
            	
            	
            	
                if (itau.isSelected()) {                	
                	boletoService.emitirBoletoService(boletoBean, BANDEIRA_BANCO_ITAU);
                    status.setText("Boleto Banco Itau Emitido");
                    System.err.println("Terminou a execução do metodo Boleto do Banco Itaú");

                }
                if (brasil.isSelected()) {
                	boletoService.emitirBoletoService(boletoBean, BANDEIRA_BANCO_DO_BRASIL);
                    status.setText("Boleto Banco do Brasil Emitido");
                    System.err.println("Terminou a execução do metodo Boleto do Banco do Brasil");
                }

                if (bradesco.isSelected()) {
                	boletoService.emitirBoletoService(boletoBean, BANDEIRA_BANCO_BRADESCO);
                    status.setText("Boleto Banco do Bradesco Emitido");
                    System.err.println("Terminou a execução do metodo Boleto do Banco Bradesco");
                }

        }

    }

    @FXML
    private void menuSair(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void menuConfiguracao(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Configuracao.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Arquivo Retorno Bradesco");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        valor.setMask("N!.NN");
        cep.setMask("NNNNNNNN");
        documento.setMask("N!");

        ObservableList<String> items = uf.getItems();
        items.add("AC");
        items.add("AL");
        items.add("AP");
        items.add("AM");
        items.add("BA");
        items.add("CE");
        items.add("ES");
        items.add("GO");
        items.add("MA");
        items.add("MT");
        items.add("MS");
        items.add("MG");
        items.add("PR");
        items.add("PB");
        items.add("PA");
        items.add("PE");
        items.add("PI");
        items.add("RJ");
        items.add("RN");
        items.add("RS");
        items.add("RO");
        items.add("RR");
        items.add("SC");
        items.add("SE");
        items.add("SP");
        items.add("TO");
        uf.setItems(items);

    }

}
