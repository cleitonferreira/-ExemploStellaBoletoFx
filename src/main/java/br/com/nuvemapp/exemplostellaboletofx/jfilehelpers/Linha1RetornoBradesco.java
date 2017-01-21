package br.com.nuvemapp.exemplostellaboletofx.jfilehelpers;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.coury.jfilehelpers.annotations.FieldFixedLength;
import org.coury.jfilehelpers.annotations.FixedLengthRecord;
import org.coury.jfilehelpers.enums.FixedMode;

@FixedLengthRecord(fixedMode = FixedMode.AllowMoreChars)
public class Linha1RetornoBradesco {

	@FieldFixedLength(1)
    private String IDReg;
    @FieldFixedLength(36)
    private String DadosIgnorados1;
    @FieldFixedLength(25)
    private String NumeroControleDoParticipante;
    @FieldFixedLength(8)
    private String Filler1;
    @FieldFixedLength(12)
    private String NossoNumeroComDigito;
    @FieldFixedLength(25)
    private String DadosIgnorados2;
    @FieldFixedLength(1)
    private String Carteira;
    @FieldFixedLength(2)
    private String CodigoDeOcorrencia;
    //@FieldConverter(converter = ConverterKind.Date, format = "ddMMyy")
    @FieldFixedLength(6)
    private String DataDaOcorrencia;
    @FieldFixedLength(10)
    private String NumeroDoDocumento;
    @FieldFixedLength(20)
    private String NossoNumeroComDigitoRepetido;
    //@FieldConverter(converter = ConverterKind.Date, format = "ddMMyy")
    @FieldFixedLength(6)
    private String Vencimento;
    @FieldFixedLength(13)
    private String Valor;
    @FieldFixedLength(3)
    private String CodigoCompensacaoBancoRecebedor;
    @FieldFixedLength(5)
    private String PrefixoDaAgenciaRecebedora;
    @FieldFixedLength(2)
    private String EspecieDeTitulo;

    public String getIDReg() {
        return IDReg;
    }

    public void setIDReg(String IDReg) {
        this.IDReg = IDReg;
    }

    public String getDadosIgnorados1() {
        return DadosIgnorados1;
    }

    public void setDadosIgnorados1(String DadosIgnorados1) {
        this.DadosIgnorados1 = DadosIgnorados1;
    }

    public String getNumeroControleDoParticipante() {
        return NumeroControleDoParticipante;
    }

    public void setNumeroControleDoParticipante(String NumeroControleDoParticipante) {
        this.NumeroControleDoParticipante = NumeroControleDoParticipante;
    }

    public String getFiller1() {
        return Filler1;
    }

    public void setFiller1(String Filler1) {
        this.Filler1 = Filler1;
    }

    public String getNossoNumeroComDigito() {
        return NossoNumeroComDigito;
    }

    public void setNossoNumeroComDigito(String NossoNumeroComDigito) {
        this.NossoNumeroComDigito = NossoNumeroComDigito;
    }

    public String getDadosIgnorados2() {
        return DadosIgnorados2;
    }

    public void setDadosIgnorados2(String DadosIgnorados2) {
        this.DadosIgnorados2 = DadosIgnorados2;
    }

    public String getCarteira() {
        return Carteira;
    }

    public void setCarteira(String Carteira) {
        this.Carteira = Carteira;
    }

    public String getCodigoDeOcorrencia() {
        return CodigoDeOcorrencia;
    }

    public void setCodigoDeOcorrencia(String CodigoDeOcorrencia) {
        this.CodigoDeOcorrencia = CodigoDeOcorrencia;
    }

    public String getDataDaOcorrencia() {
        DateFormat formatter1 = new SimpleDateFormat("ddMMyy");
        Date date = null;
        try {
            date = (Date) formatter1.parse(DataDaOcorrencia);
        } catch (ParseException ex) {
            Logger.getLogger(Linha1RetornoBradesco.class.getName()).log(Level.SEVERE, null, ex);
        }
        DateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
        String format = formatter2.format(date);
        return format;
    }

    public void setDataDaOcorrencia(String DataDaOcorrencia) {
        this.DataDaOcorrencia = DataDaOcorrencia;
    }

    public String getNumeroDoDocumento() {
        return NumeroDoDocumento;
    }

    public void setNumeroDoDocumento(String NumeroDoDocumento) {
        this.NumeroDoDocumento = NumeroDoDocumento;
    }

    public String getNossoNumeroComDigitoRepetido() {
        return NossoNumeroComDigitoRepetido;
    }

    public void setNossoNumeroComDigitoRepetido(String NossoNumeroComDigitoRepetido) {
        this.NossoNumeroComDigitoRepetido = NossoNumeroComDigitoRepetido;
    }

    public String getVencimento() {
        return Vencimento;
    }

    public void setVencimento(String Vencimento) {
        this.Vencimento = Vencimento;
    }

    public String getValor() {
        BigDecimal bigDecimal = new BigDecimal(Valor).divide(BigDecimal.valueOf(100));
        DecimalFormat formato = new DecimalFormat("R$ ###,###.00");
        String format = formato.format(bigDecimal);
        return format;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public String getCodigoCompensacaoBancoRecebedor() {
        return CodigoCompensacaoBancoRecebedor;
    }

    public void setCodigoCompensacaoBancoRecebedor(String CodigoCompensacaoBancoRecebedor) {
        this.CodigoCompensacaoBancoRecebedor = CodigoCompensacaoBancoRecebedor;
    }

    public String getPrefixoDaAgenciaRecebedora() {
        return PrefixoDaAgenciaRecebedora;
    }

    public void setPrefixoDaAgenciaRecebedora(String PrefixoDaAgenciaRecebedora) {
        this.PrefixoDaAgenciaRecebedora = PrefixoDaAgenciaRecebedora;
    }

    public String getEspecieDeTitulo() {
        return EspecieDeTitulo;
    }

    public void setEspecieDeTitulo(String EspecieDeTitulo) {
        this.EspecieDeTitulo = EspecieDeTitulo;
    }

}
