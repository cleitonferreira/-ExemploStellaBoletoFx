package br.com.nuvemapp.exemplostellaboletofx.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import br.com.nuvemapp.exemplostellaboletofx.util.CalculoDigitoModulo11;
import br.com.nuvemapp.exemplostellaboletofx.util.VisualizarPDF;

public class BoletoService {

	Calendar dataEmissao = Calendar.getInstance();

	public void emitirBoletoService(br.com.nuvemapp.exemplostellaboletofx.model.Boleto b, String bandeira) throws FileNotFoundException, IOException {
		

	    Datas datas = Datas.novasDatas()
	            .comDocumento(dataEmissao.get(Calendar.DAY_OF_MONTH), dataEmissao.get(Calendar.MONTH) + 1, dataEmissao.get(Calendar.YEAR))
	            .comProcessamento(dataEmissao.get(Calendar.DAY_OF_MONTH), dataEmissao.get(Calendar.MONTH) + 1, dataEmissao.get(Calendar.YEAR))
	            .comVencimento(b.getDiaVencimento(), b.getMesVencimento(), b.getAnoVencimento());

	    Endereco enderecoBeneficiario = Endereco.novoEndereco()
	            .comLogradouro("Rua Bandeirantes, 1010")
	            .comBairro("Centro")
	            .comCep("10100-000")
	            .comCidade("Belo Horizonte")
	            .comUf("MG");
	    
	    
	    String nossoNumero = "9000206";
	    
	    //Quem emite o boleto
	    Beneficiario beneficiario = Beneficiario.novoBeneficiario()
	            .comNomeBeneficiario("Teste e Serviços Ltda")
	            .comDocumento("10.687.566/0001-97")
	            .comAgencia("1824").comDigitoAgencia("4")
	            .comCodigoBeneficiario("76000")
	            .comDigitoCodigoBeneficiario("5")
	            .comNumeroConvenio("1207113")
	            .comCarteira("18")
	            .comEndereco(enderecoBeneficiario)
	            .comNossoNumero(nossoNumero)
                .comDigitoNossoNumero(CalculoDigitoModulo11.calcularDigitoNossoNumero(nossoNumero));
	    
	    
	    
	    Endereco enderecoPagador = Endereco.novoEndereco()
	            .comLogradouro(b.getLogradouroPagador())
	            .comBairro(b.getBairroPagador())
	            .comCep(b.getCepPagador())
	            .comCidade(b.getCidadePagador())
	            .comUf(b.getUfPagador());

	    //Quem paga o boleto
	    Pagador pagador = Pagador.novoPagador()
	            .comNome(b.getNomePagador())
	            .comDocumento(b.getDocumentoPagador())
	            .comEndereco(enderecoPagador);
	    
	    
	    Banco banco = null;
	    
	    if(bandeira == "BANCO_DO_BRASIL") {
	    	
	        banco = new br.com.caelum.stella.boleto.bancos.BancoDoBrasil();
	    	
	    } else if(bandeira == "BANCO_ITAU") {
			
	    	banco = new br.com.caelum.stella.boleto.bancos.Itau();
	    	
		} else if(bandeira == "BANCO_BRADESCO") {
			
			banco = new br.com.caelum.stella.boleto.bancos.Bradesco();
		}
	    

        Boleto boleto = Boleto.novoBoleto()
                .comBanco(banco)
                .comDatas(datas)
                .comBeneficiario(beneficiario)
                .comPagador(pagador)
                .comValorBoleto(b.getValorBoleto())
                .comNumeroDoDocumento("101010")
                .comInstrucoes("Após o vencimento, aplicar multa de 2,00% e juros de 1,00% ao mês", "instrucao 2")
                .comLocaisDePagamento("Pagar preferencialmente no banco de destino ou em uma casa lotérica");

        GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);

        byte[] geraPDF = gerador.geraPDF();

        SimpleDateFormat horaFormatada = new SimpleDateFormat("HHmmss");

        File file = new File("boleto_" + bandeira.toLowerCase() + b.getDocumentoPagador() + "_GeradoAs_" + horaFormatada.format(new Date()) + ".pdf");
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(geraPDF);
        outputStream.flush();
        outputStream.close();
        
        VisualizarPDF.mostrarNaTela(file);
        
        System.err.println("Terminou a gravação do arquivo");
        
    }
	
}
