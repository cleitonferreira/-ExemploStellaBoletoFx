package br.com.nuvemapp.exemplostellaboletofx.util;


/**
 * Retorna o(s) qtdDig Dígitos de Controle Módulo 11 do dado, limitando o
 * Valor de Multiplicação em limMult:
 *
 * Números Comuns: NumDig LimMult CPF 2 12 CNPJ 2 9 PIS,C/C,Age 1 9
 *
 * @param dado String contendo o número dado
 * @param qtdDig Quantidade de dígitos
 * @param limMult Limite de Multiplicação
 * @return Dígitos calculados
 */



public class CalculoDigitoModulo11 {

	// private static String nossoNumero = "21551296910";
	private static int qtdDig = 1;
	private static int limMult = 9;

	public static String calcularDigitoNossoNumero(String nossoNumero) {

		int mult, soma, i, n;

		for (n = 1; n <= qtdDig; n++) {
			soma = 0;
			mult = 2;
			for (i = nossoNumero.length() - 1; i >= 0; i--) {
				soma += (mult * Integer.parseInt(nossoNumero
						.substring(i, i + 1)));
				if (++mult > limMult)
					mult = 2;
			}
			nossoNumero += String.valueOf(((soma * 10) % 11) % 10);
		}

		int variavel = Integer.parseInt(nossoNumero.substring(
				nossoNumero.length() - qtdDig, nossoNumero.length()));

		Object resultado = new Object();

		if (variavel > 9) {
			resultado = "X";
		} else {
			resultado = variavel;
		}

		return resultado.toString();
	}

}
