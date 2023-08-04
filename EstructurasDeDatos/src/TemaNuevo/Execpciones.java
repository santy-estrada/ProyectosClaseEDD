package TemaNuevo;

class EvalorNegativo extends Exception{
	public EvalorNegativo( String s) {
		super(s);
	}
}

class EvalorMayorSaldo extends Exception{
	public EvalorMayorSaldo() {
		super("El valor solicitado excede el saldo");
	}
}

class Cuenta{
	private float saldo;
	
	public Cuenta(float saldoinicial) {
		saldo = saldoinicial;
	}
	
	public void depositar(float v) throws EvalorNegativo{
		if(v>0) {
			saldo += v;
		}else {
			throw new EvalorNegativo("El saldo a depositar debe ser mayor que cero");
		}
		
	}
	
	public void extraer(float v) throws EvalorNegativo, EvalorMayorSaldo{
		if(v>0) {
			if(v <= saldo) {
				saldo -=v;
			}else {
				throw new EvalorMayorSaldo();
			}
		
		}else {
			throw new EvalorNegativo("El saldo a extraer debe ser mayor que cero");
		}
	}
	
	public float getSaldo() {
		return saldo;
	}
	
}

public class Execpciones {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float saldo = (float) 200;
		Cuenta c = new Cuenta(saldo);
		
		try {
			c.depositar(-200);
			System.out.println("El saldo es: "+ c.getSaldo());
			c.extraer(300);
			System.out.println("El saldo es: "+ c.getSaldo());
			c.extraer(500);
			System.out.println("El saldo es: "+ c.getSaldo());

		}
		catch (EvalorNegativo e) {
			System.out.println(e.getMessage());

		}
		catch(EvalorMayorSaldo e){
			System.out.println(e.getMessage());
		}
		
	
		
	}

}
