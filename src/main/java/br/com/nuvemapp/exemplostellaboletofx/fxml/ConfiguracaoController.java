package br.com.nuvemapp.exemplostellaboletofx.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.nuvemapp.exemplostellaboletofx.jfilehelpers.LerRetornoBradescoJfilehelpers;
import br.com.nuvemapp.exemplostellaboletofx.jfilehelpers.Linha1RetornoBradesco;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConfiguracaoController implements Initializable {

    @FXML
    private TableView<Linha1RetornoBradesco> tabela;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@FXML
    private void botaoImportar(ActionEvent event) throws IOException {
        LerRetornoBradescoJfilehelpers retornoBradesco = new LerRetornoBradescoJfilehelpers();
        List<Linha1RetornoBradesco> Lista = retornoBradesco.lerLinha1();
        
        TableColumn colunaNossoNumeroComDigito = new TableColumn<>("Nosso Numero Com Digito");
        TableColumn colunaDataDaOcorrencia = new TableColumn<>("Data Da Ocorrencia");
        TableColumn colunaValor = new TableColumn<>("Valor");
        colunaValor.setStyle("-fx-alignment: CENTER-RIGHT;");
        
        colunaNossoNumeroComDigito.setCellValueFactory(new PropertyValueFactory<>("NossoNumeroComDigito"));
        colunaDataDaOcorrencia.setCellValueFactory(new PropertyValueFactory<>("DataDaOcorrencia"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
        
        tabela.setItems(FXCollections.observableArrayList(Lista));
        tabela.getColumns().addAll(colunaNossoNumeroComDigito, colunaDataDaOcorrencia, colunaValor);
    }

}
