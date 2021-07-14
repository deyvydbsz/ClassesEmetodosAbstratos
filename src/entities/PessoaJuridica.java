package entities;

public class PessoaJuridica extends Contribuinte{
	
	private Integer employeeNumber;

	public PessoaJuridica() {
		super();
	}
	
	public PessoaJuridica(String name, Double rendaAnual, Integer employeeNumber) {
		super(name, rendaAnual);
		this.employeeNumber = employeeNumber;
	}
	
	
	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	@Override
	public double taxa() {
		double finalTaxa = 0;
		if (employeeNumber > 10) {
			finalTaxa = getRendaAnual() * 0.14;			
		}
		
		else {
			finalTaxa = getRendaAnual() * 0.16;
		}
		return finalTaxa;
		
		
	}
	
	

}
