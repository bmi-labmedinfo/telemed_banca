public interface Conto {

	double getSaldo();

	/**
	 * 
	 * @param amount
	 */
	boolean operazione(double amount);

}