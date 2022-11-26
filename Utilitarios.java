package banco;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utilitarios {
		static NumberFormat numberFormat = new DecimalFormat("R$#,###");
		public static String doubleString(Double valor) { 
				return numberFormat.format(valor);
			
}}
