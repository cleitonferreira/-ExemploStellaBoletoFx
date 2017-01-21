package br.com.nuvemapp.exemplostellaboletofx.jfilehelpers;

import java.util.Date;
import java.util.Objects;

import org.coury.jfilehelpers.annotations.FieldAlign;
import org.coury.jfilehelpers.annotations.FieldConverter;
import org.coury.jfilehelpers.annotations.FieldFixedLength;
import org.coury.jfilehelpers.annotations.FixedLengthRecord;
import org.coury.jfilehelpers.enums.AlignMode;
import org.coury.jfilehelpers.enums.ConverterKind;

@FixedLengthRecord()
public class Linha0RetornoBradesco {

	@FieldFixedLength(1)
    private String IDReg;
    @FieldFixedLength(1)
    private String IdentificacaoRetorno;
    @FieldFixedLength(7)
    private String LiteralRetorno;
    @FieldFixedLength(2)
    private String CodigoDeServico;
    @FieldFixedLength(15)
    private String LiteralServico;
    @FieldAlign(alignMode = AlignMode.Left, alignChar = '0')
    @FieldFixedLength(20)
    private String CodigoDaEmpresa;
    @FieldFixedLength(30)
    private String NomeDaEmpresa;
    @FieldFixedLength(3)
    private String CodigoCompensacao;
    @FieldFixedLength(15)
    private String NomeBanco;
    @FieldConverter(converter = ConverterKind.Date, format = "ddMMyy")
    @FieldFixedLength(6)
    private Date DataGravacaoArquivo;
    @FieldFixedLength(8)
    private String Filler1;
    @FieldFixedLength(5)
    private String NumeroDoAvisoBancario;
    @FieldFixedLength(266)
    private String Filler2;
    @FieldConverter(converter = ConverterKind.Date, format = "ddMMyy")
    @FieldFixedLength(6)
    private Date DataDoCredito;
    @FieldFixedLength(9)
    private String Filler3;
    @FieldAlign(alignMode = AlignMode.Left, alignChar = '0')
    @FieldFixedLength(6)
    private String NumeroSequencialRegistro;

    public String getIDReg() {
        return IDReg;
    }

    public void setIDReg(String IDReg) {
        this.IDReg = IDReg;
    }

    public String getIdentificacaoRetorno() {
        return IdentificacaoRetorno;
    }

    public void setIdentificacaoRetorno(String IdentificacaoRetorno) {
        this.IdentificacaoRetorno = IdentificacaoRetorno;
    }

    public String getLiteralRetorno() {
        return LiteralRetorno;
    }

    public void setLiteralRetorno(String LiteralRetorno) {
        this.LiteralRetorno = LiteralRetorno;
    }

    public String getCodigoDeServico() {
        return CodigoDeServico;
    }

    public void setCodigoDeServico(String CodigoDeServico) {
        this.CodigoDeServico = CodigoDeServico;
    }

    public String getLiteralServico() {
        return LiteralServico;
    }

    public void setLiteralServico(String LiteralServico) {
        this.LiteralServico = LiteralServico;
    }

    public String getCodigoDaEmpresa() {
        return CodigoDaEmpresa;
    }

    public void setCodigoDaEmpresa(String CodigoDaEmpresa) {
        this.CodigoDaEmpresa = CodigoDaEmpresa;
    }

    public String getNomeDaEmpresa() {
        return NomeDaEmpresa;
    }

    public void setNomeDaEmpresa(String NomeDaEmpresa) {
        this.NomeDaEmpresa = NomeDaEmpresa;
    }

    public String getCodigoCompensacao() {
        return CodigoCompensacao;
    }

    public void setCodigoCompensacao(String CodigoCompensacao) {
        this.CodigoCompensacao = CodigoCompensacao;
    }

    public String getNomeBanco() {
        return NomeBanco;
    }

    public void setNomeBanco(String NomeBanco) {
        this.NomeBanco = NomeBanco;
    }

    public Date getDataGravacaoArquivo() {
        return DataGravacaoArquivo;
    }

    public void setDataGravacaoArquivo(Date DataGravacaoArquivo) {
        this.DataGravacaoArquivo = DataGravacaoArquivo;
    }

    public String getFiller1() {
        return Filler1;
    }

    public void setFiller1(String Filler1) {
        this.Filler1 = Filler1;
    }

    public String getNumeroDoAvisoBancario() {
        return NumeroDoAvisoBancario;
    }

    public void setNumeroDoAvisoBancario(String NumeroDoAvisoBancario) {
        this.NumeroDoAvisoBancario = NumeroDoAvisoBancario;
    }

    public String getFiller2() {
        return Filler2;
    }

    public void setFiller2(String Filler2) {
        this.Filler2 = Filler2;
    }

    public Date getDataDoCredito() {
        return DataDoCredito;
    }

    public void setDataDoCredito(Date DataDoCredito) {
        this.DataDoCredito = DataDoCredito;
    }

    public String getFiller3() {
        return Filler3;
    }

    public void setFiller3(String Filler3) {
        this.Filler3 = Filler3;
    }

    public String getNumeroSequencialRegistro() {
        return NumeroSequencialRegistro;
    }

    public void setNumeroSequencialRegistro(String NumeroSequencialRegistro) {
        this.NumeroSequencialRegistro = NumeroSequencialRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.IDReg);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Linha0RetornoBradesco other = (Linha0RetornoBradesco) obj;
        if (!Objects.equals(this.IDReg, other.IDReg)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Linha0RetornoBradesco{" + "IDReg=" + IDReg + '}';
    }
       
}