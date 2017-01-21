package br.com.nuvemapp.exemplostellaboletofx.jfilehelpers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.coury.jfilehelpers.engines.FileHelperEngine;
import org.coury.jfilehelpers.masterdetail.MasterDetailEngine;
import org.coury.jfilehelpers.masterdetail.MasterDetailSelector;
import org.coury.jfilehelpers.masterdetail.MasterDetails;
import org.coury.jfilehelpers.masterdetail.RecordAction;

public class LerRetornoBradescoJfilehelpers {

	public Linha0RetornoBradesco lerLinha0() throws IOException {
		FileHelperEngine<Linha0RetornoBradesco> engineLinha0 = new FileHelperEngine<>(Linha0RetornoBradesco.class);
		return engineLinha0.readFile("ArquivoRetorno/Bradesco/CB071000.RET").get(0);
	}

	public List<Linha1RetornoBradesco> lerLinha1() throws IOException {

		FileHelperEngine<Linha1RetornoBradesco> engineLinha1 = new FileHelperEngine<>(Linha1RetornoBradesco.class);

		List<Linha1RetornoBradesco> listaLinha1RetornoBradesco = new ArrayList<>();

		List<Linha1RetornoBradesco> listaLinha1RetornoBradescoTemporaria = engineLinha1.readFile("ArquivoRetorno/Bradesco/CB071000.RET");
		for (Linha1RetornoBradesco linha1RetornoBradescoFor : listaLinha1RetornoBradescoTemporaria) {
			if (linha1RetornoBradescoFor.getIDReg().equals("1")) {
				listaLinha1RetornoBradesco.add(linha1RetornoBradescoFor);
			}
		}
		return listaLinha1RetornoBradesco;
	}

	public Linha9RetornoBradesco lerLinha9() throws IOException {
		FileHelperEngine<Linha9RetornoBradesco> engineLinha9 = new FileHelperEngine<>(Linha9RetornoBradesco.class);
		List<Linha9RetornoBradesco> lista = engineLinha9.readFile("ArquivoRetorno/Bradesco/CB071000.RET");
		return lista.get(lista.size());
	}

	public void lerRetornoBradescoMasterDetail() throws IOException {

		MasterDetailSelector masterDetailSelector = new MasterDetailSelector() {
			@Override
			public RecordAction getRecordAction(String recordString) {
				if (recordString.startsWith("0")) {
					return RecordAction.Master;
				}
				if (recordString.startsWith("1")) {
					return RecordAction.Detail;
				} else {
					return RecordAction.Skip;
				}
			}
		};

		MasterDetailEngine<Linha0RetornoBradesco, Linha1RetornoBradesco> masterDetailEngine = new MasterDetailEngine<Linha0RetornoBradesco, Linha1RetornoBradesco>(
				Linha0RetornoBradesco.class, Linha1RetornoBradesco.class, masterDetailSelector);

		List<MasterDetails<Linha0RetornoBradesco, Linha1RetornoBradesco>> readFile = masterDetailEngine
				.readFile("ArquivoRetorno/Bradesco/CB071000.RET");

		for (MasterDetails<Linha0RetornoBradesco, Linha1RetornoBradesco> masterDetails : readFile) {
			Linha0RetornoBradesco master = masterDetails.getMaster();
			System.out.println("Tipo : " + master.getLiteralRetorno());
			System.out.println("Data : " + master.getDataDoCredito());
			System.out.println("---------------------------------------------");
			System.out.println("---------------------------------------------");
			for (Linha1RetornoBradesco item : masterDetails.getDetails()) {
				System.out.println("Nosso Numero    : " + item.getNossoNumeroComDigito());
				System.out.println("Data Ocorrencia : " + item.getDataDaOcorrencia());
				System.out.println("Valor           : " + item.getValor());
				System.out.println("---------------------------------------------");
			}

		}

	}

}
