package entities;

public class PessoaFisica extends Contribuinte {
	
	private Double gastoSaude;

	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String name, Double rendaAnual, Double gastoSaude) {
		super(name, rendaAnual);
		this.gastoSaude = gastoSaude;
	}
	
	public Double getGastoSaude() {
		return gastoSaude;
	}

	public void setGastoSaude(Double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}

	@Override
	public double taxa() {
		double finalTaxa = 0;
		if (getRendaAnual() > 20000.00) {
			finalTaxa = getRendaAnual() * 0.25;
		}
		else{
			finalTaxa = getRendaAnual() * 0.15;				
		}
		if (gastoSaude > 0.00) {
			finalTaxa -= gastoSaude * 0.5; 
		}
		return finalTaxa;
	}
}
